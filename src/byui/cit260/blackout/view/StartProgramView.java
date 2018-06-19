
package byui.cit260.blackout.view;

import blackout.Blackout;
import byui.cit260.blackout.control.GameControl;
import byui.cit260.blackout.model.Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Team Blackout
 */
public class StartProgramView {
    
    private String promptMessage;
    
    protected final BufferedReader keyboard = Blackout.getInFile();
    protected final PrintWriter console = Blackout.getOutFile();
    
    public StartProgramView() {
            
            //promptMessage = "Please enter your name"            
            this.promptMessage = "\nPlease enter your name:"; 
            
            //display the banner when view is created
            this.displayBanner(); 
            
    
    }

    private void displayBanner() {
        this.console.println(
                  "\n************************************************************"
                + "\n*                                                          *"
                + "\n* Blackout is a text-based role playing mystery game,      *"
                + "\n* you will be taking on the role of a person who has       *"
                + "\n* woken up with dissociative amnesia. At the start of      *"
                + "\n* he game, your character will wake up in a crowded        *"
                + "\n* subway train with no memory of who you are or how you    *"
                + "\n* got there. Your nose is broken and your wallet is        *"
                + "\n* missing. You have no coat and, despite it being          *"
                + "\n *winter, seems to be sun burnt. After a brief             *"
                + "\n* exploration, you discover that you have been poisoned.   *"
                + "\n* You have a limited amount of time to solve your          *"
                + "\n* mystery and take the antidote beofre it is too late.     *"
                + "\n*                                                          *"
                + "\n* Everything that you need to solve the mystery is found   *"
                + "\n* in your city within the locations on your map. Your      *"
                + "\n* task is to explore the environment and talk to           *"
                + "\n* non-player charachters to obtain clues. You can keep     *"
                + "\n* track of your clues in your backpack. You must collect   *"
                + "\n* all of the clues in order to fully recover your          *"
                + "\n* memory and obtain the antidote. If you do not find all   *"
                + "\n* of the clues in time, your charachter will sucumb to     *"
                + "\n* the poison and will die.                                 *"
                + "\n*                                                          *"
                + "\n* The game begins as you wake up in the subway car.        *"
                + "\n* During the game, you will need to explore the            *"
                + "\n* locations on your map, find and collect physical         *"
                + "\n* clues, speak to other characters to gain information,    *"
                + "\n* keep a log of your clues and solve the mystery.          *"
                + "\n* You have 50 moves to find everything you need,           *"
                + "\n* take the correct amount of antidote or you die and       *"
                + "\n* the game is over.  You have successfully completed       *"
                + "\n* the game after you have found the magic door and         *"
                + "\n* the four items randomly placed throughout the map.       *"
                + "\n*                                                          *"
                + "\n************************************************************");
                
        
    }


// displays the start program view
    
    public void displayStartProgramView() {
        //System.out.println("\n*** displayStartProgram() function called ***");
        
        boolean done = false; // set flag to not done
        do {
                // prompt for and get players name
                String playersName = this.getPlayersName();
                if (playersName.toUpperCase().equals("Q"))  //user wants to quit
                    return; // exit the game
                    
                    // do the requested action and display the next view
                   done = this.doAction(playersName);
                   
                   
        } while (!done);
        
        
    }

    private String getPlayersName() {
        
        //Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        String value = ""; //value to be returned
        boolean valid = false; // intialize to not valid
        
        while (!valid) { // loop while an invalid va;lue is entered
            this.console.println("\n" + this.promptMessage);
            
            try {
                value = keyboard.readLine(); // get next line typed on keyboard
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Error Reading input: " +ex.getMessage());
                //System.out.println("\n Error Reading Input: " + ex.getMessage());
                //Logger.getLogger(StartProgramView.class.getName()).log(Level.SEVERE, null, ex);
            }
            value = value.trim(); // trim off leading and trailing blanks
            
            if (value.length() < 1) { // value is blank
                
                this.console.println("\nInvalid value: value can not be blank");
                continue;
            }
            
            break;  // end then loop
        
        }      
        
        return value;  // return the value entered
        }
        
        //System.out.println("\n*** getPlayerName() called ***");
        //return "Joe";
    

    private boolean doAction(String playersName) {
        
        if (playersName.length() < 2) {
            this.console.println("\nInvalid player name: " 
            + "The name must be greater than one charachter in length");
            return false;          
            
        }
        
        // call createPlayer() control function
        Player player = GameControl.createPlayer(playersName);
        
        if (player == null) { // if unsuccessful
            this.console.println("\nError creating the player.");
            return false;
            
        }

      
        this.displayNextView(player);
                
                return true; //success
    }

    private void displayNextView(Player player) {
        this.console.println("\n===================="
        + "\n Welcome to the game " + player.getName()
        + "\n We hope you have a lot of fun!");
        
        // create MainMenuView object
        MainMenuView mainMenuView = new MainMenuView();
        
        // display the main menu view
        mainMenuView.display();
        
    }


}
    

