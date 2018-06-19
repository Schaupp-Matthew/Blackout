package byui.cit260.blackout.view;

import blackout.Blackout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Team Blackout
 */
public abstract class View implements ViewInterface {

    //protected String displayMessage;
    protected String promptMessage = "\nPlease enter an option:";
    protected String menu;
    
    protected final BufferedReader keyboard = Blackout.getInFile();
    protected final PrintWriter console = Blackout.getOutFile();

    public View(String theMenu) {
        this.menu = theMenu;

    }

    @Override
    public void display() {
        boolean done = false; // set flag to not done
        do {
            // prompt for and get players name
            String value = this.getInput();
            if (value.toUpperCase().equals("Q")) //user wants to quit
            {
                break; // exit the game
            }
            
//               if (value.toUpperCase().equals("R")) //user wants to restart game 
//            {
//                   //MainMenuView mainMenu = new MainMenuView();
//                   // mainMenu.display();
//                //break; // exit the game
//            }
            // do the requested action and display the next view
            done = this.doAction(value);

        } while (!done);

    }

    @Override
    public String getInput() {

       // Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        String value = ""; //value to be returned
        boolean valid = false; // intialize to not valid

        while (!valid) { // loop while an invalid va;lue is entered
            this.console.println(menu);
            this.console.println("\n" + this.promptMessage);

            try {
                value = this.keyboard.readLine();
            } catch (IOException ex) {
                 ErrorView.display(this.getClass().getName(), "Error Reading input: " +ex.getMessage());
               
                //System.out.println("\n Error Reading Input: " + ex.getMessage());
                //Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
            //value = keyboard.nextLine(); // get next line typed on keyboard
            value = value.trim(); // trim off leading and trailing blanks

            if (value.length() > 1) { // only one charachter
                this.console.println("\nInvalid value: choose a correct value");
                continue;
            }

            break;  // end the loop
        }
        return value;
    }
    
    
    public String getInput(String message) {

        //Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        String value = ""; //value to be returned
        boolean valid = false; // intialize to not valid

        while (!valid) { // loop while an invalid va;lue is entered
            this.console.println(message);
            //System.out.println("\n" + this.promptMessage);
            try {
                value = keyboard.readLine(); // get next line typed on keyboard
            } catch (IOException ex) {
                 ErrorView.display(this.getClass().getName(), "Error Reading input: " +ex.getMessage());
               
                //System.out.println("\n Error Reading Input: " + ex.getMessage());
                //Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
            value = value.trim(); // trim off leading and trailing blanks

            if (value.length() < 1) { // only one charachter
                 
                this.console.println("\nInvalid value: choose a correct value");
                continue;
            }

            break;  // end the loop
        }
        return value;
    }
    
    public int getInput(String message, int minVal, int maxVal) {

        //Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        int value = 0; //value to be returned
        boolean valid = false; // intialize to not valid

        while (!valid) { // loop while an invalid va;lue is entered
            this.console.println(message);
            //System.out.println("\n" + this.promptMessage);
            try {
                value = parseInt(keyboard.readLine()); // get next line typed on keyboard
                
            } catch (IOException ex) {
                 ErrorView.display(this.getClass().getName(), "Error Reading input: " +ex.getMessage());
               
                //System.out.println("\n Error Reading Input: " + ex.getMessage());
                //Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException nf) {
                //System.out.println("You must enter a valid number ");
                //ErrorView.display(this.getClass().getName(), "*** Invalid selection, try again " + nf.getMessage());
                
          }
            //value = value.trim(); // trim off leading and trailing blanks
            
            
            if (value < minVal || value > maxVal) { //
                 
                 ErrorView.display(this.getClass().getName(), "*** Invalid selection, try again ");
                //continue;
            } else {

                break;  // end the loop
            }
        }
        return value;
    }

}
