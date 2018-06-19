
package byui.cit260.blackout.view;

import blackout.Blackout;
import byui.cit260.blackout.control.BackPackControl;
import byui.cit260.blackout.control.GameControl;
import java.util.Scanner;

/**
 *
 * @author Team Blackout
 */
public class MainMenuView extends View {
    
    //private final String promptMessage = "\nPlease enter an option:";
   // private final String menu;
    
    public MainMenuView() {
        super( "\n"
                + "\n----------------------------------------------------------"
                + "\n | Main Menu"
                + "\n----------------------------------------------------------"
                + "\nN - New Game"
                + "\nS - Save Game"
                + "\nL - Load Saved Game"
//                + "\nH - Help Menu"
                + "\nR - Restart Game "
                + "\nQ - Quit Game"
                + "\n-----------------------------------------------------------");
    }

 

    @Override
    public boolean doAction(String value) {

            value = value.toUpperCase(); //convert choice to upper case
            
            switch (value) {
                case "N" : //create start new game
                    this.startNewGame();
                    break;
                case "S" : // create save game
                    this.saveGame();
                    break;
                case "L" : // Load game
                    this.loadGame();
                    break;
//                case "H" : //Help Menu
//                    this.helpMenu();
//                    break;
                case "R" ://Restart Game
                    this.restartGame();
                    break;
//                case "Q" : //quit game
//                    this.quitGame();
//                    break;
                default :
                    //this.console.println("\n*** Invalid selection, try again");
                    ErrorView.display(this.getClass().getName(), "Invalid input. Invalid selection, try again" );
                    break;
            }
            return false;
    }

    private void startNewGame() {
        // create new game
        GameControl.createNewGame(Blackout.getPlayer());
        
        //display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
        //System.out.println(menu);
    }

    private void saveGame() {
        //this.console.println("\n\nEnter the file path for file where the game is to be saved.");
        //this.console.println("\n*** saveGame() function called ***");
        String filePath = this.getInput("\n\nEnter the file path for file where the game is to be saved.");
        try{
            GameControl.saveGame(Blackout.getCurrentGame(), filePath);
        } catch(Exception ex){
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        
    }

    private void loadGame() {
        
        //this.console.println("\n\nEnter the file path for the file where the game was saved.");
        //this.console.println("\n*** loadGame() function called ***");
        String filePath = this.getInput("\n\nEnter the file path for the file where the game was saved.");
        
        try {
            
            GameControl.getSavedGame(filePath);
        } catch (Exception ex){
            ErrorView.display("MainMenuView", ex.getMessage());
        }
        
        
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

//    private void helpMenu() {
//       // display help menu
//       HelpMenuView helpMenu = new HelpMenuView();
//       helpMenu.display();
//    }

//    private void quitGame() {
//        this.console.println("\n*** quitMenu() function called ***");
//    }

    public void restartGame() {
        
        this.console.println("\n Game has been restarted");
        GameControl.createNewGame(Blackout.getPlayer());
        this.display();
        //this.startNewGame();
        //BackPackControl.clearBackpack();
        


    }
    
}
