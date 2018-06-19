package byui.cit260.blackout.control;

import byui.cit260.blackout.exceptions.DoorControlException;
import byui.cit260.blackout.model.Door;

/**
 *
 * @author Team Blackout
 */
public class DoorControl {

    public static int breakDoorOpen(double playerWeight, double playerForce, double doorWeight, double doorWidth, double doorHeight)
            throws DoorControlException {

        if (doorHeight <= 0) { //doorHeight is negative?
            //return -1;
            throw new DoorControlException("Door height can not be less than zero ");
        }
        if (playerWeight <= 0) { //playerWeight is negative?
            // return -2;
            throw new DoorControlException("Player weight can not be less than zero ");
        }
        if (playerForce <= 0) { //playerForce is negative?
            //return -3;
            throw new DoorControlException("Player force can not be less than zero ");
        }
        if (doorWeight <= 0) { //doorWeight is negative?
            //return -4;
            throw new DoorControlException("Door weight can not be less than zero ");
        }
        if (doorWidth <= 0) { //doorWidth is negative?
            // return -5;
            throw new DoorControlException("Door width can not be less than zero ");
        }

        double force = (playerForce * playerWeight) / 20;
        double doorMass = doorHeight * doorWidth * doorWeight;

        if (force <= 0) {
            //return -6;
            throw new DoorControlException("force can not be less than zero ");
        }

        if (force >= doorMass) {
            Door.setOpen(true);
            //System.out.println("Door is broken open.  Way to go!");
            return 1;
        } else {
            Door.setOpen(false);
            //System.out.println("Nice try you big sissy!");
            return 0;
        }

    }

}
