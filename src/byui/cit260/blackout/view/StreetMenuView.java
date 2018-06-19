package byui.cit260.blackout.view;

/**
 *
 * @author mgallup
 */
public class StreetMenuView extends View {

    public StreetMenuView() {

        super("\n"
                + "\n----------------------------------------------------------"
                + "\n | Street Menu"
                + "\n----------------------------------------------------------"
                + "\n1 - Move to Street 1"
                + "\n2 - Move to Street 2"
                + "\n3 - Move to Street 3"
                + "\n4 - Move to Street 4"
                + "\n5 - Move to Street 5"
                + "\nQ - Back to Main Menu"
                + "\n-----------------------------------------------------------");
    }

    @Override
    public boolean doAction(String choice) {

        choice = choice.toUpperCase(); //convert choice to upper case

        switch (choice) {
            case "1": //Move to Street 1
                this.streetOne();
                break;
            case "2": // Move to Street 2
                this.streetTwo();
                break;
            case "3": // Move to Street 3
                this.streetThree();
                break;
            case "4": //Move to Street 4
                this.streetFour();
                break;
            case "5": //Move to Street 5
                this.streetFive();
                break;
            default:
                this.console.println("\n*** Invalid selection, try again");
                break;
        }
        return false;
    }

    private void streetOne() {
        StreetViewOne streetViewOne = new StreetViewOne();
        streetViewOne.display();
        // System.out.println("\n*** This takes you to Street One ***");
    }

    private void streetTwo() {
        this.console.println("\n*** This takes you to Street Two ***");
    }

    private void streetThree() {
        this.console.println("\n*** This takes you to Street Three ***");
    }

    private void streetFour() {
        this.console.println("\n*** This takes you to Street Four ***");
    }

    private void streetFive() {
        this.console.println("\n*** This takes you to Street Five ***");
    }

}
