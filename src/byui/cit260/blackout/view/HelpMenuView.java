
package byui.cit260.blackout.view;

//import java.util.Scanner;

/**
 *
 * @author Team Blackout
 */
public class HelpMenuView extends View{
    
    
    public HelpMenuView() {
       super ("\n"
                + "\n----------------------------------------------------------"
                + "\n | Help Menu"
                + "\n----------------------------------------------------------"
                + "\nG - Goal of game"
                + "\nF - Finding clues"
                + "\nH - How to move"
                + "\nQ - Quit Game"
                + "\n-----------------------------------------------------------");
    }

    @Override
    public boolean doAction(String choice) {

            choice = choice.toUpperCase(); //convert choice to upper case
            
            switch (choice) {
                case "G" : //display goal of game
                    this.displayGoal();
                    break;
                case "H" : // display how to move
                    this.displayMoveOptions();
                    break;
                case "F" : // display clues
                    this.displayClues();
                    break;
                
                default :
                    this.console.println("\n*** Invalid selection, try again");
                    break;
            }
            return false;
    }

    private void displayGoal() {
        this.console.println("\n*** Figure out who you are and how much antidote you need to survive ***"
                + "\nIn order to win you need to find all of the items randomly placed around the map."
                + "\nOnce you find all of the items and complete the challenges your memories will come back and"
                + "\nYou will live happily ever after.  Mess up and you die!");
    }

    private void displayMoveOptions() {
       this.console.println("\n*** Input your x and y coordinates.  Inputs should be from 0 to 4 ***");
    }

    private void displayClues() {
        this.console.println("\n*** Some items will give you clues to finish the game ***");
    }

    

    
}
