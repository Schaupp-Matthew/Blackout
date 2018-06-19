
package byui.cit260.blackout.view;

import byui.cit260.blackout.control.BackPackControl;
import java.util.Scanner;
import java.util.Stack;
import byui.cit260.blackout.control.LocationControl;



/**
 *
 * @author Brian
 */
public class LocationMenuView extends View {
    
    //private String promptMessage = "";
    //private String menu = "";
    
    //private Stack itemList = BackPackControl
    
    public LocationMenuView(){
        super( "\n"
                + "\n----------------------------------------------------------"
                + "\n | Locaitons Menu"
                + "\n----------------------------------------------------------"
                + "\nW - Pharmacy Room 1"
                + "\nE - Pharmacy Room 2"
                + "\nR - Pharmacy Room 3"
                + "\nT - Pharmacy Room 4"
                + "\nY - Pharmacy Room 5"
                + "\nS - Street Menu"
                + "\nQ - Return to Game Menu"
                + "\n-----------------------------------------------------------");
    }
        
   
        
    @Override    
    public boolean doAction(String choice) {

            choice = choice.toUpperCase(); //convert choice to upper case
            
            switch (choice) {
                case "W" : //show Room 1 of Pharmacy
                    showPharmacyRoom1();
                    break;
                case "E" : //show Room 2 of Pharmacy
                    showPharmacyRoom2();
                    break;
                case "R" : //show Room 3 of Pharmacy
                    showPharmacyRoom3();
                    break;
                case "T" : //show Room 4 of Pharmacy
                    showPharmacyRoom4();
                    break;
                    case "Y" : //show Room 5 of Pharmacy
                    showPharmacyRoom5();
                    break;
                    case "S" : //show Street Menu
                    showStreetMenu();
                    break;
                
                default :
                   
                    this.console.println("\n*** Invalid selection, try again");
                    break;
            }
            return false;
    }
        
        
    private void showPharmacyRoom1(){
         
        PharmacyViewOne pharmacyViewOne = new PharmacyViewOne();
        pharmacyViewOne.displayMapSymbol();
        pharmacyViewOne.display();
        
    }
    
    private void showPharmacyRoom2(){
        PharmacyViewTwo pharmacyViewTwo = new PharmacyViewTwo();
        pharmacyViewTwo.displayMapSymbol();
        pharmacyViewTwo.display();
        
    }
    
    private void showPharmacyRoom3(){
        PharmacyViewThree pharmacyViewThree = new PharmacyViewThree();
        pharmacyViewThree.displayMapSymbol();
        pharmacyViewThree.display();
       
    }

    private void showPharmacyRoom4() {
        PharmacyViewFour pharmacyViewFour = new PharmacyViewFour();
        pharmacyViewFour.displayMapSymbol();
        pharmacyViewFour.display();  
    }

    private void showPharmacyRoom5() {
        PharmacyViewFive pharmacyViewFive = new PharmacyViewFive();
        pharmacyViewFive.displayMapSymbol();
        pharmacyViewFive.display();  
    }

    private void showStreetMenu() {
       //StreetMenuControl.showstreetMenu(); 
        StreetMenuView streetMenu = new StreetMenuView();
        streetMenu.display();
    }

    
    
}
