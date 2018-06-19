
package byui.cit260.blackout.view;


import blackout.Blackout;
import byui.cit260.blackout.control.BackPackControl;
import byui.cit260.blackout.model.Backpack;
import byui.cit260.blackout.model.Item;
//import java.io.IOException;
//import java.util.Scanner;
//import java.util.Stack;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author Brian
 */
public class BackpackMenuView extends View {
    
    //private String promptMessage = "";
    //private String menu = "";
    
    //private Stack itemList = BackPackControl
    
    public BackpackMenuView(){
        super( "\n"
                + "\n----------------------------------------------------------"
                + "\n | Backpack Menu"
                + "\n----------------------------------------------------------"
                + "\nS - Show List of Items"
                //+ "\nC - Show Clue List"
                //+ "\nA - Add Item to Backpack"
               // + "\nD - Add Clue to Clue List"
                + "\nP - Print report of items added to Backpack to .txt  file" //added by Mark 3-24-17
                + "\nQ - Return to Game Menu"
                + "\n-----------------------------------------------------------");
    }
        
    
        
    @Override    
    public boolean doAction(String choice) {

            choice = choice.toUpperCase(); //convert choice to upper case
            
            switch (choice) {
                case "S" : //display list of items
                    
                    showListOfItems(Blackout.getCurrentGame().getBackpack());
                    break;
//                case "C" : // display clues
//                    showListOfClues();
//                    break;
//                case "A" : //add item to backpack
//                    addItemToBackPack();
//                    break;
//                case "D" : //add clue to list
//                    addClueToBackPack(itemInputValue());
//                    break;
                   //added by Mark 3-24-17
                    case "P" : //Print a report to file
                    printTofFile(Blackout.getCurrentGame().getBackpack());
                    break;
                    
                
                default :
                    //this.console.println("\n*** Invalid selection, try again");
                    ErrorView.display(this.getClass().getName(), "Invalid input. Invalid selection, try again" );
                
                    break;
            }
            return false;
    }
        
        
        private void showListOfItems(Backpack backPack){
            
            
            //checks the number of items in item list
           
           
           //int sz = BackPackControl.getItemList().size();
           int sz = backPack.getItemList().size();
           //int sz = Blackout.getCurrentGame().getBackpack().getItems().length();
           
           
            //int sz = itemList.size();
            
            String displayMessage =  "\n"
                + "\n----------------------------------------------------------"
                + "\n | Item List"
                + "\n----------------------------------------------------------";
            
            if(sz == 0){   
                displayMessage += "\n No Items In List";
            } else {
                
                //Blackout.getCurrentGame().getBackpack()
                
                Object[] theItems = backPack.getItemList().toArray();
                
                for(int i =0; i < sz; i++){
                    
                    displayMessage += "\n " + (i + 1)  + " ";
                    displayMessage += theItems[i].toString();
                   
                }
                
            }
            //this displays the item lists
            //System.out.println(itemList);
            
            this.console.println(displayMessage);

        }
        
//         private void showListOfClues(){
//            
//            
//            //checks the number of items in item list
//           // int sz = BackPackControl.
//           
//           int sz = BackPackControl.getClueList().size();
//           
//           
//            //int sz = itemList.size();
//            
//            String displayMessage =  "\n"
//                + "\n----------------------------------------------------------"
//                + "\n | Clue List"
//                + "\n----------------------------------------------------------";
//            
//            if(sz == 0){   
//                displayMessage += "\n No Clues In List";
//            } else {
//                
//                Object[] theItems = BackPackControl.getClueList().toArray();
//                
//                
//                for(int i =0; i < sz; i++){
//                    
//                    displayMessage += "\n " + (i + 1)  + " ";
//                    displayMessage += theItems[i].toString();
//                   
//                }
//                
//            }
//            //this displays the item lists
//            //System.out.println(itemList);
//            
//            this.console.println(displayMessage);
//
//        }
        
        private String itemInputValue(){
            //Scanner keyboard = new Scanner(System.in); // get infile for keyboard
            String value = ""; //value to be returned
            boolean valid = false; // intialize to not valid
        
            String displayMessage =  "\n"
                + "\n----------------------------------------------------------"
                + "\n | Please enter the Name of the Item You want to Add to the BackPack"
                + "\n----------------------------------------------------------";
            
            while (!valid) { // loop while an invalid va;lue is entered
                this.console.println("\n" + displayMessage);
            
                try {
                    value = keyboard.readLine(); // get next line typed on keyboard
                } catch (IOException ex) {
                    //System.out.println("\n Error Reading Input: " + ex.getMessage());
                    ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
                
                    //Logger.getLogger(BackpackMenuView.class.getName()).log(Level.SEVERE, null, ex);
                }
                value = value.trim(); // trim off leading and trailing blanks
            
                if (value.length() < 1) { // only one charachter
                    //System.out.println("\nInvalid Item Name Please enter Longer Item Name");
                    ErrorView.display(this.getClass().getName(), "Invalid Item Name Please enter Longer Item Name ");
                
                    continue;
                }
            
                break;  // end then loop
            }
            return value;
            
        }
    
        
        private void addItemToBackPack(Item item, Backpack backPack){
            
            backPack.getItemList().push(item);
            this.console.println("\n Added item "  + item.getDescription() + " to item List");
            
            
        }
        
//        private void addClueToBackPack(String clueName){
//            
//            BackPackControl.getClueList().push(clueName);
//            this.console.println("\n Added item "  + clueName + " to item List");
//            
//            
//        }

    // added by Mark on 3-24-84
        private void printTofFile(Backpack backPack) {
        PrintWriter output = null;
        this.console.println("Enter the file path as a .txt file");
        
        try {
            String path = keyboard.readLine();
            output = new PrintWriter(path);
            Object[] items = backPack.getItemList().toArray();
            String newLine = System.getProperty("line.separator"); //from my tutor instead of using \n
            String header = "----- List of Backpack Items you added ------" + newLine + "Name" + newLine;
                    
            for (int i=0; i<items.length; i++) {
                 header += items[i].toString() + newLine;
                
            }
            output.println(header);
            this.console.println("Your file was saved successfully as: " + path);
            
            output.close();
            
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), "Error generating report: " + ex.getMessage());
        
        }
        
    }
    
    
}
