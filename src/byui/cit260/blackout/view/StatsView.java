/*
 * After the player inputs the stats key from the Game Menu the program will display
 * the percentage of clues found, the total number of locations visited, and the time
 * remaining to find the antidote. Then it will redisplay the Game Menu.
 */
package byui.cit260.blackout.view;

import blackout.Blackout;
import byui.cit260.blackout.model.Location;

/**
 *
 * @author Matt
 */
public class StatsView extends View {

    public StatsView() {
        super("\n"
                + "\n----------------------------------------------------------"
                + "\nCURRENT STATS"
                + "\n"
                + "\nPress S to View Stats"
                + "\nPress Q at anytime to return to the Game Menu"
                + "\n----------------------------------------------------------");
    }
 
    
    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase();
        
        switch(value) {
            case "S":
                this.statistics();
                break;
            case "Q":
                this.display();
                break;
            default:
                this.console.println("\n*** Invalid selection, try again");
                    break;
        }
        
/*        System.out.println("\nPercentage of Clues Found"
                            + "\n-------------------------");
        int percentOfClues = this.percentageOfClues();
        System.out.println(percentOfClues);
        
        
        System.out.println("\nNumber of Locations Visited"
                            + "\n---------------------------");
        int numLocationsVisited = this.numLocationsVisited();
        System.out.println(numLocationsVisited);
        
        
        System.out.println("\nTime Remaining to Find Antidote"
                            + "\n-------------------------------");
        int timeRemaining = this.timeRemaining();
        System.out.println(timeRemaining);*/
        
        
        return false; //temporary
    }
    
    private void statistics() {
        
//        this.console.println("\nPercentage of Clues Found"
//                           + "\n-------------------------");
//        int percentOfClues = this.percentageOfClues();
//        this.console.println(percentOfClues);
        
        
        this.console.println("\nNumber of Locations Visited"
                           + "\n---------------------------");
        
        Location[][] locations = Blackout.getCurrentGame().getMap().getLocations();
        int numLocationsVisited = 0;
        for(int i = 0; i < 5; i++){
            for(int ii = 0; ii < 5; ii++){
                if(locations[i][ii].isVisited()){
                        numLocationsVisited++;   
                    }
            }
        }
        
        this.console.println(numLocationsVisited);
        
        
        this.console.println("\nMoves Remaining to Finish Game \n---------------------------");
        int movesRemaining = Blackout.getCurrentGame().getNumberMovesLeft();
        this.console.println(movesRemaining);
        
        //see if found all the items
        this.console.println("\nItems Needed to find to finish Game \n--------------------------- ");
        int cntItmsNeeded = 0;
        
        if(!Blackout.getCurrentGame().isFoundDoor()){
            this.console.println("The Magic Door");
            cntItmsNeeded++;
        }
        
        if(!Blackout.getCurrentGame().isFoundAntidote()){
            this.console.println("The Antidote");
            cntItmsNeeded++;
        }
        if(!Blackout.getCurrentGame().isFoundCoat()){
            this.console.println("Your Coat");
            cntItmsNeeded++;
        }
        if(!Blackout.getCurrentGame().isFoundWallet()){
            this.console.println("Your Wallet");
            cntItmsNeeded++;
        }
        if(!Blackout.getCurrentGame().isFoundPhone()){
            this.console.println("Your Phone");
            cntItmsNeeded++;
        }
       
        
        if(cntItmsNeeded == 0){
            this.console.println("You Have Found All the Items!!");
        }
        
    }

    private int percentageOfClues() {
        this.console.println("***percentageOfClues method called***");
         return 1;
    }
    
    private int numLocationsVisited() {
         this.console.println("***numLocationsVisited method called***");
         return 1;
    }

    private int timeRemaining() {
         this.console.println("***timeRemaining method called***");
         return 1;
    }

    
    
}
