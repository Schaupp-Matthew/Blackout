
package byui.cit260.blackout.view;

/**
 *
 * @author mgallup
 */
public class StreetViewOne extends SceneView {
    
    //private boolean menu;
    
    public StreetViewOne(String menu){
   
        super(menu);
    }

    StreetViewOne() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public void display() {
        boolean done = false; // set flag to not done
        this.console.println(super.menu);
        do {
                // prompt for and get players name
                String value = this.getInput();
                if (value.toUpperCase().equals("Q"))  //user wants to quit
                    break; // exit this area
                    
                    // do the requested action and display the next view
                   done = this.doAction(value);
                   
        } while (!done);

    }
    
    @Override    
    public boolean doAction(String choice) {

            choice = choice.toUpperCase(); //convert choice to upper case
            
            switch (choice) {
                case "1" : //show street 1
                    
                    showStreetViewOne();
                    break;
                case "2" : // show street 2
                    showStreetViewTwo();
                    break;
                case "3" : //show street 3
                    showStreetViewThree();
                    break;
                case "4" : //show street 4
                     showStreetViewFour();
                    break;
                
                case "5" : //show street 5
                    showStreetViewFive();
                    break;    
                    
                default :
                    this.console.println("\n*** Invalid selection, try again");
                    break;
            }
            return false;
    }
    
    
    private void showStreetViewOne(){
        
        
    }
    
    private void showStreetViewTwo(){
        
        
    }
    
    private void showStreetViewThree(){
        
        
    }
    
    private void showStreetViewFour(){
        
        
    }
    
    private void showStreetViewFive(){
        
        
    }
    
//}
    
}
