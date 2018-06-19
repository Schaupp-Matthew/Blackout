
package byui.cit260.blackout.control;

import byui.cit260.blackout.view.*;

/**
 *
 * @author Brian
 */
public class LocationControl {
    
    
    //this is where we make an instance of each sence
    
    public static PharmacyViewOne pharmacyViewOne = new PharmacyViewOne();
    public static  PharmacyViewTwo pharmacyViewTwo = new PharmacyViewTwo();
    public static PharmacyViewThree pharmacyViewThree = new PharmacyViewThree();
    public static PharmacyViewFour pharmacyViewFour = new PharmacyViewFour();
    public static PharmacyViewFive pharmacyViewFive = new PharmacyViewFive();
    
    
    public static void showpharmacyViewOne(){
        pharmacyViewOne.displayMapSymbol();
        pharmacyViewOne.display();
    }
    
    public static void showpharmacyViewTwo(){
        pharmacyViewTwo.displayMapSymbol();
        pharmacyViewTwo.display();
    }
    
    public static void showpharmacyViewThree(){
        pharmacyViewThree.displayMapSymbol();
        pharmacyViewThree.display();
    }
    
    public static void showpharmacyViewFour(){
        pharmacyViewFour.displayMapSymbol();
        pharmacyViewFour.display();
    }
    
    public static void showpharmacyViewFive(){
        pharmacyViewFive.displayMapSymbol();
        pharmacyViewFive.display();
    }

    
    
    
}



