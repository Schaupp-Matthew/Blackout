
package byui.cit260.blackout.view;

/**
 *
 * @author Brian
 */
public class PharmacyViewOne extends PharmacyScene {

    public PharmacyViewOne(){
     

        
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
                +"\n ( # ) ( 1 )"
                +"\n  \\_/   \\_/");
        
        super.setDescription(" Pharmacy Room 1");
        super.setNumItems(3);
        super.setNonPlayers("Customer Joe");
        
        
    }

    

}
