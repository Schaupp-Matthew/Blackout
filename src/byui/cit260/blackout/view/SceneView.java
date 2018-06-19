
package byui.cit260.blackout.view;

/**
 *
 * @author Brian
 */
public class SceneView extends View {
    public String description;
    public String mapSymbol;
    public int numItems;
    public String nonPlayers;
    
    
    
    public SceneView() {
        
        
        super( "\n"
                + "\n----------------------------------------------------------"
                + "\n | Locations Menu"
                + "\n----------------------------------------------------------"
                + "\nI - View Number of Items"
                + "\nN - View non Players"
                + "\nD - View Location Description"
                + "\nF - View Door"
                + "\nQ - Return to Locations Menu"
                + "\n-----------------------------------------------------------");
        
        
    }
    
    
     public SceneView(String menu){
         super(menu); 
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMapSymbol() {
        return mapSymbol;
    }

    public void setMapSymbol(String mapSymbol) {
        this.mapSymbol = mapSymbol;
    }

    public int getNumItems() {
        return numItems;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    public String getNonPlayers() {
        return nonPlayers;
    }

    public void setNonPlayers(String nonPlayers) {
        this.nonPlayers = nonPlayers;
    }
    
    public void displayMapSymbol(){
        this.console.println(getMapSymbol());
        
    }
    
    public void displayNumbersOfItems(){
        
          
        this.console.println(getNumItems());
    }
    
    public void displayNonPlayers(){
        
        this.console.println(getNonPlayers());
        
    }
    @Override    
public boolean doAction(String choice) {

            choice = choice.toUpperCase(); //convert choice to upper case
            
            switch (choice) {
                case "I" : //item list
                    showItemNumber();
                    break;
                case "N" : //non players
                    showNonPlayers();
                    break;
                case "D" : //Des of SceneView
                    showDescription();
                case "F" : //View Door
                    showDoor();
                    break;
                
                
                default :
                    
                    ErrorView.display(this.getClass().getName(), "*** Invalid selection, try again");
               
                    //System.out.println("\n*** Invalid selection, try again");
                    break;
            }
            return false;
    }

    private void showItemNumber(){
         this.console.println("\n"
                + "\n----------------------------------------------------------"
                + "\n | Number of Items"
                + "\n----------------------------------------------------------"); 
        this.console.println(getNumItems());
        
       // System.out.println(menu);
        
    }
    
    private void showNonPlayers(){
        
        
        this.console.println("\n"
                + "\n----------------------------------------------------------"
                + "\n |Non Player"
                + "\n----------------------------------------------------------");
        this.console.println(getNonPlayers());
         //System.out.println(menu);
    }
    
    private void showDescription(){
        
        this.console.println("\n"
                + "\n----------------------------------------------------------"
                + "\n |Lcoation Description"
                + "\n----------------------------------------------------------");
        this.console.println(getDescription());
         //System.out.println(menu);
        
    }

    private void showDoor() {
        DoorView doorView = new DoorView();
        doorView.display();
        
        
    }
}
    