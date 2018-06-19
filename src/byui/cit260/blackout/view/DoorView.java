package byui.cit260.blackout.view;

import byui.cit260.blackout.control.DoorControl;
import byui.cit260.blackout.control.DoorUnLockControl;
import byui.cit260.blackout.exceptions.DoorControlException;
import byui.cit260.blackout.exceptions.DoorUnLockControlException;
import byui.cit260.blackout.model.Player;
import java.io.IOException;
import static java.lang.Integer.parseInt;
//import java.text.ParseException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import blackout.Blackout;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author Team Blackout
 */
public class DoorView extends View {

    public DoorView() {
        super("\n"
                + "\n----------------------------------------------------------"
                + "\n | Door Menu"
                + "\n----------------------------------------------------------"
                + "\nK - Kick Door Open"
                //+ "\nU - Unlock Door"
                + "\nQ - Quit Menu"
                + "\n-----------------------------------------------------------");
    }

    @Override
    public boolean doAction(String choice) {

        choice = choice.toUpperCase(); //convert choice to upper case

        switch (choice) {
            case "K": {
                try {
                    //display Kick
                    this.displayKick();
                } catch (DoorControlException ex) {
                    //Logger.getLogger(DoorView.class.getName()).log(Level.SEVERE, null, ex);
                    //System.out.println("\nYou must enter a valid number. Try again or enter Q to quit.");
                    ErrorView.display(this.getClass().getName(), "You must enter a valid number. Try again or enter Q to quit. : " + ex.getMessage());
                
                }
            }
            break;
//            case "U": {
            //            try {
            //                // display Unlock
            //                this.displayUnlock();
            //            } catch (DoorUnLockControlException e) {
            //                
            //                ErrorView.display(this.getClass().getName(), "You must enter a valid number. Try again or enter Q to quit. : " + e.getMessage());
            //                
            //                //System.out.println(ex);
            //                
            //                //Logger.getLogger(DoorView.class.getName()).log(Level.SEVERE, null, ex);
            //            }
            //        }
            //                break;

            default:
                
                //System.out.println("\n*** Invalid selection, try again");
                ErrorView.display(this.getClass().getName(), "*** Invalid selection, try again " );
                
                break;
        }
        return false;

    }

    private void displayKick() throws DoorControlException {

        //double playerWeight = Player.getWeight();
        //double playerForce = Player.getForce();
        //System.out.println("Enter player weight");
        kickDoorInput();
        //DoorControl.breakDoorOpen(playerWeight, playerForce, 5, 3, 7);

    }

    private void displayUnlock() throws DoorUnLockControlException {
        
        //unLockDoorWithCode(int keyCode, double playLbs, int doorNo)
        int keyCode = -1;
        double playLbs = -1;
        int doorNo = -1;
        
        try {
            keyCode = parseInt(getInput("Enter Keycode"));
            
         } catch (NumberFormatException nf) {
                //System.out.println("You must enter a valid number ");
                ErrorView.display(this.getClass().getName(), "*** Invalid selection, try again " + nf.getMessage());
                
         }
         try {
                playLbs = Double.parseDouble(getInput("Enter Player lbs"));
         } catch (NumberFormatException e){
             
             //System.out.println("You must enter a valid number ");
             ErrorView.display(this.getClass().getName(), "*** Invalid selection, try again " + e.getMessage());
                
         }
         
         try {
              doorNo = parseInt(getInput("Enter Door Number"));
         } catch (NumberFormatException e2) {
             //System.out.println("You must enter a valid number ");
             ErrorView.display(this.getClass().getName(), "*** Invalid selection, try again " + e2.getMessage());
                
         }
         
         double unlock = DoorUnLockControl.unLockDoorWithCode(keyCode, playLbs, doorNo);
         if(unlock == 0){
             this.console.println("You Did Not Unlock the door");
         } else {
             this.console.println("You Unlocked the Door");
             Blackout.getCurrentGame().setUnlockedDoor(true);
         }
        
       
        //System.out.println("\n*** displayUnlock stub function called ***");
    }

    public void kickDoorInput() throws DoorControlException {

        
        //Scanner keyboard = new Scanner(System.in); // get infile for keyboard
        double value = 0; //value to be returned
        boolean valid = false; // intialize to not valid
        String inputValue = "";

        while (!valid) { // loop while an invalid value is entered
            this.console.println("Enter player weight in pounds:");
            //System.out.println("\n" + this.promptMessage);
            try {
                inputValue = keyboard.readLine(); // get next line typed on keyboard
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
                
                //System.out.println("\n Error Reading Input: " + ex.getMessage());
                //Logger.getLogger(DoorView.class.getName()).log(Level.SEVERE, null, ex);
            }
            inputValue = inputValue.trim(); // trim off leading and trailing blanks

            try {
                value = Double.parseDouble(inputValue);
                if (value >= 0) {
                    valid = true;
                    break;  // end the loop
                }
            } catch (NumberFormatException nf) {
                ErrorView.display(this.getClass().getName(), "You must enter a valid number dork " );
                
               // System.out.println("You must enter a valid number dork");
            }

        }
        Player.setWeight(value);
        this.console.println("Enter player force");
        inputValue = "";
        valid = false;
        while (!valid) { try {
            // loop while an invalid va;lue is entered
            //System.out.println(menu);
            //System.out.println("\n" + this.promptMessage);

            inputValue = keyboard.readLine(); // get next line typed on keyboard
            } catch (IOException ex) {
                
                ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
                //System.out.println("\n Error Reading Input: " + ex.getMessage());
                //Logger.getLogger(DoorView.class.getName()).log(Level.SEVERE, null, ex);
            }
            inputValue = inputValue.trim(); // trim off leading and trailing blanks

            try {
                value = Double.parseDouble(inputValue);
                if (value >= 0) {
                    valid = true;
                    break;  // end the loop
                }

            } catch (NumberFormatException nf) {
                //System.out.println("You must enter a valid number dork");
                ErrorView.display(this.getClass().getName(), "You must enter a valid number dork " + nf.getMessage());
            }

        }
        Player.setForce(value);
        
        if(DoorControl.breakDoorOpen(Player.getWeight(), Player.getForce(), 5, 3, 7) == 1){
            this.console.println("Door is broken open.  Way to go \nYou can now take the Antidote ");
            Blackout.getCurrentGame().setUnlockedDoor(true);
        }
        if(DoorControl.breakDoorOpen(Player.getWeight(), Player.getForce(), 5, 3, 7) == 0){
            this.console.println("Nice try you big sissy! ");
            
        }
        
    }

}
