package byui.cit260.blackout.view;

import blackout.Blackout;
import static blackout.Blackout.outFile;
import byui.cit260.blackout.control.BackPackControl;
import byui.cit260.blackout.control.GameControl;
import byui.cit260.blackout.model.Map;
import byui.cit260.blackout.control.MapControl;
import byui.cit260.blackout.control.PhoneControl;
import byui.cit260.blackout.exceptions.AntidoteControlException;
import byui.cit260.blackout.exceptions.GameControlExceptions;
import byui.cit260.blackout.model.Game;
import byui.cit260.blackout.model.Item;
import byui.cit260.blackout.model.ItemList;
import byui.cit260.blackout.model.Location;
import byui.cit260.blackout.model.PhoneMessage;
import byui.cit260.blackout.model.Player;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mgallup
 */
public class GameMenuView extends View {

    //private final String promptMessage = "\nPlease enter an option:";
    //private final String menu;
    public GameMenuView() {
            
        super(Blackout.getCurrentGame().getGameMenu());
        
//        super("\n"
//                + "\n----------------------------------------------------------"
//                + "\n | Game Menu"
//                + "\n----------------------------------------------------------"
//                + "\nM - Move to New Location"
//                + "\nV - View Map"
//                + "\nF - Save Map Report"
//                + "\nS - Status"
//                + "\nB - Backpack Menu"
//                //+ "\nE - Examine"
//                + "\nT - Talk"
//                //+ "\nA - Antidote Amount Needed"
//                //+ "\nP - Phone"
//                //+ "\nC - Phone Message Report"
//                //+ "\nD - Door Menu"  hide  menu unless found door
//                + "\nQ - Back to Main Menu"
//                + "\n-----------------------------------------------------------");
    }

    @Override
    public boolean doAction(String choice) {

        choice = choice.toUpperCase(); //convert choice to upper case

        switch (choice) {
            case "M": //create start new game
                this.moveLocation();
                break;
            case "V": // create save game
                this.viewMap();
                break;
            case "S": // Load game
                this.viewStatus();
                break;
//            case "E": //view examine
//                this.viewExamine();
//                break;
            case "D": //view door
                if(Blackout.getCurrentGame().isFoundDoor()){
                   this.viewDoor(Blackout.getCurrentGame());
                   break;
                } else {
                    this.console.println("\n*** Invalid selection, try again");
                    break;
                }
                
            case "H" : //Help Menu
                this.helpMenu();
                break;
                
                
            case "F": {
            try {
                    //map report list
                    this.runMapReport();
                 } catch (GameControlExceptions ex) {
                    Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;
//            case "T": //view briantalk
//                this.talk();
//                break;
//            //updated by Mark 3/18/17
            case "A": {
                //only show Ant menu if you found it
                if(Blackout.getCurrentGame().isFoundAntidote()){
                   try {
                        //Amount of Antidote
                        this.viewAntidoteAmount(Blackout.getCurrentGame());
                    } catch (AntidoteControlException ex) {
                       //System.out.println("\nInvalid input. Please enter a valid letter");
                       ErrorView.display(this.getClass().getName(), "Invalid Value Entered" + ex.getMessage());
                    }
                } else {
                    this.console.println("\n*** Invalid selection, try again");
                    
                }
                    
                }
                break;
            case "B": //View Backpack contents
                
                this.viewBackPack();
                break;
            case "P": //PhonePasswordView
                if(Blackout.getCurrentGame().isFoundPhone()){
                    this.viewPhonePassword(Blackout.getCurrentGame());
                } else {
                    this.console.println("\n*** Invalid selection, try again");
                }
                break;
            case "C": {
            try {
                //Phone message report
                this.phoneMessageReport();
            } catch (GameControlExceptions ex) {
                ErrorView.display(this.getClass().getName(), "Error creating report" + ex.getMessage());
            }
        }
                break;
            default:
                //ErrorView.display(this.getClass().getName(), "*** Invalid selection, try again");
                this.console.println("\n*** Invalid selection, try again");
                break;
        }
        return false;
    }

    private void viewBackPack() {
        BackpackMenuView backpack = new BackpackMenuView();
        backpack.display();
        //System.out.println(menu);

    }
    
    private void helpMenu() {
       // display help menu
       HelpMenuView helpMenu = new HelpMenuView();
       helpMenu.display();
    }


    private void moveLocation() {

        //LocationMenuView locationMenuView = new LocationMenuView();
        //locationMenuView.display();
        //System.out.println(menu);
        
        //use the getInput with Min, Max value
       int x = getInput("Enter X value on Map between 0 and 4 (No Value Defaults to 0)", 0, 4); 
       int y = getInput("Enter Y value on Map between 0 and 4 (No Value Defaults to 0)", 0, 4); 

       if(x >= 0 && y >= 0  && x < 5 && y < 5){
            MapControl.movePlayer(Blackout.getCurrentGame().getMap(), x, y);
            this.console.println("\nYou have " + Blackout.getCurrentGame().getNumberMovesLeft() + " Moves Left!");
            
            //this will show the art for the scene
            this.console.println(Blackout.getCurrentGame().getMap().getCurrentLocation().getScene().getArtForScreen());
            //give des of location
            this.console.println(Blackout.getCurrentGame().getMap().getCurrentLocation().getScene().getDescription());
            //check if an item is at location
            boolean foundItem = false;
            
            for(int i = 0; i < 6; i++){
               
                
                //this is a code to convert locations of XY into 25 locaitons
//                int locationNumber = 1;
//                if(x == 0){
//                    locationNumber = x + y + 1;
//                } else if(x == 1){
//                    locationNumber = (5 + y + 1);
//                } else if (x == 2){
//                    locationNumber = (10 + y + 1);  
//                } else if (x == 3){
//                    locationNumber = (15 + y + 1);
//                } else if ( x == 4){
//                    locationNumber = (20 + y + 1);
//                }
                
               
                //checks if the locaiton is set
                if(Blackout.getCurrentGame().getItem()[i].getLocationX() == x && Blackout.getCurrentGame().getItem()[i].getLocationY() == y){
                    this.console.println("You Found: " + Blackout.getCurrentGame().getItem()[i].getDescription());
                    this.console.println(Blackout.getCurrentGame().getItem()[i].getItemArt());
                    foundItem = true;
                    
                    //add item to backpack if not already in there
                    if(Blackout.getCurrentGame().getItem()[i].isAlreadyFound() == false){
                        BackPackControl.addItemToList(Blackout.getCurrentGame().getItem()[i], Blackout.getCurrentGame().getBackpack());
                        Blackout.getCurrentGame().getItem()[i].setAlreadyFound(true);
                    }
                    
                    
                    
                    //once you find the magic door you have have access to door menu
                    if(Blackout.getCurrentGame().getItem()[i].getDescription() == "The Magic Door"){
                        this.console.println("You have Found the Magic Door\n You can Now access the door functions from the menu. ");
                        Blackout.getCurrentGame().setFoundDoor(true);
                        foudItemsForHiddenDoor(Blackout.getCurrentGame());
                        
                    }
                    
                    //found antidote
                    if(Blackout.getCurrentGame().getItem()[i].getDescription() == "The antidote needed to live!"){
                        Blackout.getCurrentGame().setFoundAntidote(true); 
                        foudItemsForHiddenDoor(Blackout.getCurrentGame());
                    }
                    
                    //found cell phone
                    if(Blackout.getCurrentGame().getItem()[i].getDescription() == "Your cell phone"){
                        Blackout.getCurrentGame().setFoundPhone(true);
                        foudItemsForHiddenDoor(Blackout.getCurrentGame());
                    }
                    
                    //found wallet
                    if(Blackout.getCurrentGame().getItem()[i].getDescription() == "Your wallet"){
                        Blackout.getCurrentGame().setFoundWallet(true);
                    }
                    
                    //found coat
                    if(Blackout.getCurrentGame().getItem()[i].getDescription() == "Your coat"){
                        Blackout.getCurrentGame().setFoundCoat(true);
                    }
                    
                    if(Blackout.getCurrentGame().getItem()[i].getDescription() == "The Love Note"){
                        Blackout.getCurrentGame().setFoundLoveNote(true);
                    }
                    
                }  
                
            }
            
            if(foundItem == false){
                this.console.println("No Items At this location");
            }
            
       } else {
           
           this.console.println("Cannot Move to invalid location");
       }
    }
    
    private void foudItemsForHiddenDoor(Game game){
        
        String displayMenu ="\n"
                + "\n----------------------------------------------------------"
                + "\n | Game Menu"
                + "\n----------------------------------------------------------"
                + "\nM - Move to New Location"
                + "\nV - View Map"
                + "\nF - Save Map Report"
                + "\nS - Status"
                + "\nB - Backpack Menu"
                + "\nH - Help Menu";
                //+ "\nT - Talk";
        
                if(game.isFoundAntidote()){
                      displayMenu = displayMenu +  "\nA - Antidote Amount Needed";
                }
                
                if(game.isFoundPhone()){
                    displayMenu = displayMenu +  "\nP - Phone"
                                + "\nC - Phone Message Report";
                }

                if(game.isFoundDoor()){
                    displayMenu = displayMenu + "\nD - Door Menu";
                }
                
                displayMenu = displayMenu + ""
                + "\nQ - Back to Main Menu"
                + "\n----------------------------------------------------------";
        
        this.menu = displayMenu;  
        Blackout.getCurrentGame().setGameMenu(displayMenu);
       // game.setFoundDoor(true);
        
        
    }
  
    private void viewMap() {

        Location[][] locations = Blackout.getCurrentGame().getMap().getLocations();
        

        //Map map = new Map(5, 5);
        String title = "    The Map, I'm the Map! \n";
        String rowDivider = "---------------------------";
        String columnDivider = "|";
        this.console.println("" + title);

        String linePrintout = "  ";
        for (int i = 0; i < 5; i++) {

            linePrintout = linePrintout + " " + (i) + "   ";

        }

        this.console.println(linePrintout);
        this.console.println(rowDivider);

        for (int i = 0; i < 5; i++) {

            linePrintout = (i) + columnDivider;

            for (int ii = 0; ii < 5; ii++) {

                //shows if the location has been visited or not
                if (locations[i][ii].isVisited()) {
                    linePrintout = linePrintout + " ";
                    linePrintout = linePrintout + locations[i][ii].getScene().getMapSymbol() + " ";

                } else {

                    linePrintout = linePrintout + " ?? ";
                }
                linePrintout = linePrintout + columnDivider;

                // System.out.println(linePrintout);
            }

            this.console.println(linePrintout);
            this.console.println(rowDivider);
            //System.out.println("\n");
        }
    }

    private void viewStatus() {
        StatsView statsView = new StatsView();
        statsView.display();
        //System.out.println(menu);
    }

    private void viewExamine() {
        //System.out.println("\n*** viewExamine() function called ***");
        ExamMenu examMenu = new ExamMenu();
        examMenu.display();
        //System.out.println(menu);

    }

    private void talk() {
        //System.out.println("\n*** viewTalk() function called ***");

        //Added by Matt
        TalkMenuView talkMenu = new TalkMenuView();
        talkMenu.display();
        //System.out.println(menu);

    }

    //private void mainMenu() {
    //  System.out.println("\n*** mainMenu() function called ***");
    //  }
    private void viewAntidoteAmount(Game game) throws AntidoteControlException {
        
//        boolean hasPhone = false;
//        boolean hasWallet = false;
//        boolean hasCoat = false;
//        boolean hasDoor = false;
//        boolean hasAntidote = false;
//        
//        Item[] itemList = GameControl.createItemList();
//        
//        for(Item door: itemList) {
//            hasDoor = door.isHasItem();
//        }
//        for(Item wallet: itemList) {
//            hasWallet = wallet.isHasItem();
//        }
//        for(Item coat: itemList) {
//            hasCoat = coat.isHasItem();
//        }
//        for(Item phone: itemList) {
//            hasPhone = phone.isHasItem();
//        }
//        for(Item antidote: itemList) {
//            hasAntidote = antidote.isHasItem();
//        }
        
        if(game.isUnlockedDoor()){
        //if(hasDoor == true && hasCoat == true && hasWallet == true && hasPhone == true && hasAntidote == true) {
            
            AntidoteView antidoteView = new AntidoteView();
            antidoteView.display();
            //System.out.println(menu);
        } else {
                if(game.isFoundDoor()){
                    this.console.println("\n*** You must open the door before you can take the antidote");
                } else {
                    this.console.println("You must find the door and open it before you can take the antidote");
                }
                //this.console.println("\n***You must have all items and have been through the door to access this.*** ");

        }
        //antidoteView.displayAntidoteView();
        //this.console.println(menu);

        //System.out.println("\n*** viewAntidoteAmount() function called ***");
    }

    private void viewPhonePassword(Game game) {
        
        boolean hasPhone = false;
        
        if(Blackout.getCurrentGame().isFoundLoveNote()){
        
            Item[] itemList = GameControl.createItemList();

            for(Item phone: itemList) {
               // hasPhone = phone.isHasItem();
            }

            if(game.isFoundPhone()) {
                this.console.println("\n***View the Love note from the BackPack Menu to view the equation to unlock your phone");
                PhonePasswordView phonepassword = new PhonePasswordView();
                phonepassword.displayPhonePasswordView();
                //System.out.println(menu);
            } else {
                    this.console.println("\n***You do not have the phone.*** "
                    + "\n***You must have the phone before you can access this.***");

            }
        } else {
            this.console.println("\n**You Must Find love note To unlock Phone");
        }
}

    private void viewDoor(Game game) {
        
        //have you finded the dooreth YES?
        if(game.isFoundDoor()){
        
//            boolean hasPhone = game.isFoundPhone();
//            boolean hasWallet = game.isFoundWallet();
//            boolean hasCoat = game.isFoundCoat();
//            boolean hasDoor = game.isFoundDoor();
//            boolean hasAntidote = game.isFoundAntidote();
//
//            Item[] itemList = GameControl.createItemList();
//
//            for(Item door: itemList) {
//                hasDoor = door.isHasItem();
//            }
//            for(Item wallet: itemList) {
//                hasWallet = wallet.isHasItem();
//            }
//            for(Item coat: itemList) {
//                hasCoat = coat.isHasItem();
//            }
//            for(Item phone: itemList) {
//                hasPhone = phone.isHasItem();
//            }
//            for(Item antidote: itemList) {
//                hasAntidote = antidote.isHasItem();
//            }

            if(game.isFoundAntidote() && game.isFoundCoat() && game.isFoundDoor() && game.isFoundPhone() && game.isFoundWallet()  && game.isUnlockedPhone()){
            //if(hasDoor == true && hasCoat == true && hasWallet == true && hasPhone == true && hasAntidote == true) {
                DoorView doorView = new DoorView();
                doorView.display();
                //System.out.println(menu);
            } else {
                    //this.console.println("\n***You are not at the Door.*** "
                    this.console.println(""
                    + "\n***You must have all of the items and unlocked your phone before you can access this.***");
                    
                    
                    //lists all items not found
                    if(!game.isFoundAntidote()){
                        this.console.println("You have not found the Antidote");
                    }
                    if(!game.isFoundCoat()){
                        this.console.println("You have not found your Coat");
                    }
                    if(!game.isFoundWallet()){
                        this.console.println("You have not found your Wallet");
                    }
                    if(!game.isFoundPhone()){
                        this.console.println("You have not found your Phone");
                    }
                    if(!game.isUnlockedPhone()){
                        this.console.println("You have not unlocked your Phone, Access the Phone option to unlock your phone");
                    }
            }



            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        else {
            
            this.console.println("NO Cheating You haven't found the door yet. Keep looking");
            
        }
    }
        private void phoneMessageReport() throws GameControlExceptions {


    //        this.console.println("\nPlease enter a file name to save your report:");

            String filePath = this.getInput("\n\nEnter the file you want to save the report to: ");
            PhoneMessage[] messageList = PhoneControl.createMessageList();


            try (PrintWriter out = new PrintWriter(filePath)) {

                out.println("\n\n                             Phone Messages                       ");
                out.printf("%n%-10s%30s", "From", "Message");
                out.printf("%n%-10s%30s", "----", "-------");

                for(PhoneMessage message: messageList) {

                    out.printf("%n%-10s%30s", message.getFrom()
                                            , message.getMessage());
                }
    //            GameControl.saveGame(Blackout.getCurrentGame(), filePath);
            } catch(IOException ex){
                ErrorView.display(this.getClass().getName(), "Error generating report: " + ex.getMessage());
    //        } finally {
    //            if (out != null) {
    //                try {
    //                    out.close();
    //                } catch (IOException ex2) {
    //                    ErrorView.display(this.getClass().getName(), "Error closing report: " + ex2.getMessage());
    //                }
                }
            this.console.println("Your " + filePath + " report was successfully generated!");
        
        }
        
        

    private void runMapReport() throws GameControlExceptions {
        
        
//        this.console.println("\nPlease enter a file name to save your report:");

        String filePath = this.getInput("\n\nEnter the file name for the report: ");
   
        
        try (PrintWriter out = new PrintWriter(filePath)) {
            
            int noVisited = 0;
            Calendar cal = Calendar.getInstance();
            Location[][] locations = Blackout.getCurrentGame().getMap().getLocations();
            
           out.printf("\nMap information List ");
           out.printf("\n");
           out.printf("%tc", cal);
           out.printf("\n******************************************************************************************");
           out.printf("\n%-1s%49s%7s%14s%9s","Description", "x", "y", "Map Symbol", "Visited");
            
            //go through each locaiton on the map and get the info
            for(int i = 0; i < 5; i++) {
                for(int ii = 0; ii < 5; ii++){
   
                    String hasVisited = "No";
                    if(locations[i][ii].isVisited()){
                        hasVisited = "Yes";
                        noVisited++;
                    }
                    out.printf("\n");
                    out.printf("%-1s" ,locations[i][ii].getScene().getDescription());
                    //get the width o the description
                    
                    int w = locations[i][ii].getScene().getDescription().length();
                    int space = 60 - w;
                    
                    out.printf("%" + space + "s" + "%7s%7s%12s", i, ii, locations[i][ii].getScene().getMapSymbol(),hasVisited);
                    
                   // out.printf("%1s%3s%6s%11s", i, i,  locations[i][ii].getScene().getMapSymbol(), hasVisited);

                }
                  
            }
            out.printf("\n******************************************************************************************");
           
            out.printf("\n");
            out.printf("%-1s%5s%5s", "You have Visited :", String.valueOf(noVisited), " Locations");
            
                this.console.println("Good Job, Your " + filePath + " report was generated!");
//              
//            GameControl.saveGame(Blackout.getCurrentGame(), filePath);
            } catch(IOException ex){
                ErrorView.display(this.getClass().getName(), "Error generating report: " + ex.getMessage());
//      
            }
        
        
        }

        
    }
        

