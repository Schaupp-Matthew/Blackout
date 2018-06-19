
package byui.cit260.blackout.view;

/**
 *
 * @author Brian
 */
public class PharmacyViewTwo extends PharmacyScene {
 
     public PharmacyViewTwo(){
     

        
        super.setMapSymbol("\n"
                + "\n        (_)"
                + "\n _______//"
                + "\n(________)"
                + "\n \\      /"
                + "\n  |    |"
                + "\n /______\\"
                + "\n(________)"
                +"\n   _     _"  
                +"\n  / \\   / \\" 
                +"\n ( # ) ( 2 )"
                +"\n  \\_/   \\_/");
        
        super.setDescription(" Pharmacy Room 2");
        super.setNumItems(2);
        super.setNonPlayers("Customer Bob");
        
       
        
        
    }

//    public void displayMapSymbol() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
}
