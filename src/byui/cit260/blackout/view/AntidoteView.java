package byui.cit260.blackout.view;

import blackout.Blackout;
import byui.cit260.blackout.control.AntidoteControl;
import byui.cit260.blackout.exceptions.AntidoteControlException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AntidoteView extends View{
    
    private final String promptMessage = "\nPlease enter your weight in pounds";
    private final String promptMessage2 = "\nPlease enter the number of pills to ingest (Medican Amount is kilogram Rounding Then  / 10";
    private final String promptMessage3 = "\nYou took the correct amount of antidote!  You have now won the game!!!"
            + "\nCongratulations!  Your memory comes back and you live a long happy life!"
            + "\n"
            + "\n             .#############. \n" +
"          .###################. \n" +
"       .####%####################.,::;;;;;;;;;;, \n" +
"      .####%###############%######:::;;;;;;;;;;;;;, \n" +
"      ####%%################%######:::;;;;;;;;@;;;;;;, \n" +
"      ####%%################%%#####:::;;;;;;;;;@;;;;;;, \n" +
"      ####%%################%%#####:::;;;;;;;;;@@;;;;;; \n" +
"      `####%################%#####:::;;;;;;;;;;@@;;;;;; \n" +
"        `###%##############%####:::;;;;;;;;;;;;@@;;;;;; \n" +
"           `#################'::%%%%%%%%%%%%;;;@;;;;;;' \n" +
"             `#############'.%%%%%%%%%%%%%%%%%%;;;;;' \n" +
"               `#########'%%%%#%%%%%%%%%%%%%%%%%%%, \n" +
"                 `#####'.%%%%#%%%%%%%%%%%%%%#%%%%%%, \n" +
"                   `##' %%%%##%%%%%%%%%%%%%%%##%%%%% \n" +
"                   ###  %%%%##%%%%%%%%%%%%%%%##%%%%% \n" +
"                    '   %%%%##%%%%%%%%%%%%%%%##%%%%% \n" +
"                   '    `%%%%#%%%%%%%%%%%%%%%#%%%%%' \n" +
"                  '       `%%%#%%%%%%%%%%%%%#%%%%' \n" +
"                  `         `%%%%%%%%%%%%%%%%%%' \n" +
"                   `          `%%%%%%%%%%%%%%' \n" +
"                    `           `%%%%%%%%%%'  ' \n" +
"                     '            `%%%%%%'   ' \n" +
"                    '              `%%%'    ' \n" +
"                   '               .%%      ` \n" +
"                  `                %%%       ' \n" +
"                   `                '       ' \n" +
"                    `              '      ' \n" +
"                    '            '      ' \n" +
"                   '           '       ` \n" +
"                  '           '        ' \n" +
"                              `       ' \n" +
"                               ' \n" +
"                              ' \n" +
"                             ' \n" +
"\n" +
"\n" +
"a@@@@@@@@a  a@@@@@@a  a@@@@@@@a a@@@@@@@@a a@@a.  .a@@a  a@@a \n" +
"@@@@  @@@@ @@@@  @@@@ @@@@  @@@ @@@@@@@@@@ @@@@a  a@@@@  @@@@ \n" +
"@@@@  @@@@ @@@@  @@@@ @@@@  @@@    @@@@    `@@@@  @@@@'  @@@@ \n" +
"@@@@@@@@@@ @@@@@@@@@@ @@@@@@@@'    @@@@      `@@@@@@'    @@@@ \n" +
"@@@@@@@@@' @@@@@@@@@@ @@@@@@@@a    @@@@        @@@@      `@@' \n" +
"@@@@       @@@@  @@@@ @@@@ @@@@    @@@@        @@@@ \n" +
"@@@@       @@@@  @@@@ @@@@ @@@@    @@@@        @@@@       @@";
    private final String promptMessage4 = "\nYou took too many pills. You are dead! Game Over! ";
    private final String promptMessage5 = "\nYou took the wrong amount of pills.  You are dead! Game over. "
            + "\n"
            + "                  _  /)\n" +
"                 mo / )\n" +
"                 |/)\\)\n" +
"                  /\\_\n" +
"                  \\__|=\n" +
"                 (    )\n" +
"                 __)(__\n" +
"           _____/      \\\\_____\n" +
"          |  _     ___   _   ||\n" +
"          | | \\     |   | \\  ||\n" +
"          | |  |    |   |  | ||\n" +
"          | |_/     |   |_/  ||\n" +
"          | | \\     |   |    ||\n" +
"          | |  \\    |   |    ||\n" +
"          | |   \\. _|_. | .  ||\n" +
"          |                  ||\n" +
"          |    GAME OVER     ||\n" +
"          |                  ||\n" +
"  *       | *   **    * **   |**      **\n" +
"   \\))ejm97/.,(//,,..,,\\||(,,.,\\\\,.((//";

    
    
    protected final BufferedReader keyboard = Blackout.getInFile();
    protected final PrintWriter console = Blackout.getOutFile();
    
    //these should be in the 
    double weightInPounds = 0;
    double medicineAmount = 0;
    double numberOfPills = 0;
    boolean doILive;
    
    
        AntidoteView() {
        
            //this will call the superclass contructor to display the string in the argument
            super("");

        }

        
     @Override
    public void display() {
        
        this.console.println(this.displayBanner());
        
        boolean done = false; // set flag to not done
        do {
            
            // prompt for and get players name
            
            done = this.doAction();

        } while (!done);

    }

    private String displayBanner() {
        String answer = (
                "\n***********************************************************"
                + "\n* Would you like to administer the Antidote?"
                + "\n"
                + "\n* The antidote comes in 50mg  tablets."
                + "\n"
                + "\n* You must take 5mg per kilogram of your weight.*"
                + "\n"
                + "\n* Enter your weight in pounds and the game will*"
                + "\n* calculate your weight into kilograms.  And then*"
                + "\n* divide it by 5mg."
                + "\n"
                + "\n* It is then up to you to decide how many pills to take."
                + "\n* If you do not take enough, your life ends."
                + "\n"
                + "\n************************************************************");
        return answer;

    }   
    
    
    public boolean doAction() {
        //double weightinKilo = AntidoteControl.calcMedAmount(weightInPounds);
        boolean done = false;
        while (!done) {
            
            try {
                
                weightInPounds = getWeightInPounds();
                medicineAmount = AntidoteControl.calcMedAmount(weightInPounds);
                //this.console.println(medicineAmount);
                numberOfPills = numberOfPills();
                done = true;
            } catch (AntidoteControlException ex) {
                
                ErrorView.display(this.getClass().getName(), "Error reading input: " + ex.getMessage());
               
            }
            
            catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Error reading input: " + ex.getMessage());

            }
          
        }

        try {    
            doILive = AntidoteControl.testAntidote(medicineAmount, numberOfPills);
        } catch (AntidoteControlException ex) {
            //Logger.getLogger(AntidoteView.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (doILive == true) {
            this.console.println(promptMessage3);
            System.exit(0);

               
        } else {
            this.console.println(promptMessage5);
            
             // added by Mark 3/29/17
            try {
               String answer = this.keyboard.readLine(); 
               if (answer == "Y") {
                MainMenuView mainMenuView = new MainMenuView();
                mainMenuView.restartGame();
                mainMenuView.display();
                    }
               else {
                   System.exit(0);
               }
            }
            catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Error reading input: " + ex.getMessage());

            }
           
        }
        
        return done;
    }
    
    private double getWeightInPounds()  {
        //Scanner keyboard = new Scanner(System.in);
        
        int number = 0;
        boolean valid = false;

        while (!valid) {
            
            
            //this.console.println("\n" + this.promptMessage);
            
            //value = keyboard
            //String value = getInput(this.promptMessage);
            String value = getInput("Please enter your weight in pounds:");

            try {
                number = parseInt(value);
                valid = true;
            } catch (NumberFormatException nf) {
                //System.out.println("\nInvalid input. Please enter a valid weight:");
                ErrorView.display(this.getClass().getName(), "Invalid input. Please enter a valid weight: " + nf.getMessage());
                //continue;
            }

            if (number < 0 || number > 500) {
                //System.out.println("\nInvalid value: Choose a correct value");
                
                ErrorView.display(this.getClass().getName(), "Invalid value: Choose a correct value");
                
                //continue;
            }
            break;
        }
        return number;
    }
    
     private double numberOfPills() throws AntidoteControlException, IOException {
       // Scanner keyboard = new Scanner(System.in);
        String value;
        int number = 0;
        boolean valid = false;

        while (!valid) {
            //this.console.println("\n" + this.promptMessage2);

            //value = this.keyboard.readLine();
                value = getInput(this.promptMessage2);
                //value = "100";
            
            try {
                number = parseInt(value);
                valid = true;
                
            } catch (NumberFormatException nf) {
                //System.out.println("\nInvalid input. Please enter a valid number:");
                ErrorView.display(this.getClass().getName(), "Invalid input. Please enter a valid number: " + nf.getMessage());
                //continue;
            }

            if (number <= 0 || number > 500) {
                //System.out.println("\nInvalid value: Choose a correct value");
                 ErrorView.display(this.getClass().getName(), "Invalid input. Invalid value: Choose a correct value: ");
                
                //continue;
            }
            break;
        }
        return number;
    }

    @Override
    public boolean doAction(String value) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return true;
    }
    
    

    
    
}



/*
import blackout.Blackout;
import byui.cit260.blackout.control.AntidoteControl;
import byui.cit260.blackout.exceptions.AntidoteControlException;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author mgallup
 */

/*
public class AntidoteView {

    private final String promptMessage = "\nPlease enter your weight in pounds";
    private final String promptMessage2 = "\nPlease enter the number of pills to ingest";
    private final String promptMessage3 = "\nYou took the correct amount of antidote, Continue the game";
    private final String promptMessage4 = "\nYou took too many pills. You are dead! Game Over!";
    
    protected final BufferedReader keyboard = Blackout.getInFile();
    protected final PrintWriter console = Blackout.getOutFile();

    double weightInPounds = 0;
    double medicineAmount = 0;
    double numberOfPills = 0;

    public AntidoteView() throws AntidoteControlException {

        //display the banner when view is created
        this.displayBanner();

        //double weightinKilo = AntidoteControl.calcMedAmount(weightInPounds);
        boolean done = false;
        while (!done) {
            try {
                weightInPounds = getWeightInPounds();
                medicineAmount = AntidoteControl.calcMedAmount(weightInPounds);
                numberOfPills = numberOfPills();
                done = true;
            } catch (AntidoteControlException ex) {
                //System.out.println(ex.getMessage());
                ErrorView.display(this.getClass().getName(), "Error reading input: " + ex.getMessage());

            } catch (IOException ex) {
                //System.out.println("\n Error Reading Input: " + ex.getMessage());
                ErrorView.display(this.getClass().getName(), "Error reading input: " + ex.getMessage());
               // Logger.getLogger(AntidoteView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        boolean doILive = AntidoteControl.testAntidote(medicineAmount, numberOfPills);
        if (doILive) {
            this.console.println(promptMessage3);

        } else {
            this.console.println(promptMessage4);

            MainMenuView mainMenuView = new MainMenuView();
            mainMenuView.display();
        }

    }

    private void displayBanner() {
        this.console.println(
                "\n***********************************************************"
                + "\n* Would you like to administer the Antidote?"
                + "\n"
                + "\n* The antidote comes in 500mg  tablets."
                + "\n"
                + "\n* You must take 5mg per kilogram of your weight.*"
                + "\n"
                + "\n* Enter your weight in pounds and the game will*"
                + "\n* calculate your weight into kilograms.  And then*"
                + "\n* mulitiply it by 5mg."
                + "\n"
                + "\n* It is then up to you to decide how many pills to take."
                + "\n* If you do not take enough, your life ends."
                + "\n"
                + "\n************************************************************");

    }

    public void displayAntidoteView() {

    }

    private double getWeightInPounds() throws AntidoteControlException {
        //Scanner keyboard = new Scanner(System.in);
        String value = null;
        int number = 0;
        boolean valid = false;

        while (!valid) {
            this.console.println("\n" + this.promptMessage);

            //value = keyboard

            try {
                number = parseInt(value);
            } catch (NumberFormatException nf) {
                //System.out.println("\nInvalid input. Please enter a valid weight:");
                ErrorView.display(this.getClass().getName(), "Invalid input. Please enter a valid weight: " + nf.getMessage());
                continue;
            }

            if (number < 0 || number > 500) {
                //System.out.println("\nInvalid value: Choose a correct value");
                
                ErrorView.display(this.getClass().getName(), "Invalid value: Choose a correct value");
                
                continue;
            }
            break;
        }
        return number;
    }

    private double numberOfPills() throws AntidoteControlException, IOException {
       // Scanner keyboard = new Scanner(System.in);
        String value;
        int number = 0;
        boolean valid = false;

        while (!valid) {
            this.console.println("\n" + this.promptMessage2);

            value = this.keyboard.readLine();

            try {
                number = parseInt(value);
            } catch (NumberFormatException nf) {
                //System.out.println("\nInvalid input. Please enter a valid number:");
                ErrorView.display(this.getClass().getName(), "Invalid input. Please enter a valid number: " + nf.getMessage());
                
                continue;
            }

            if (number <= 0 || number > 500) {
                //System.out.println("\nInvalid value: Choose a correct value");
                 ErrorView.display(this.getClass().getName(), "Invalid input. Invalid value: Choose a correct value: ");
                
                continue;
            }
            break;
        }
        return number;
    }

}

*/
