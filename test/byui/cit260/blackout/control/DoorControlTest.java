
package byui.cit260.blackout.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Team Blackout
 */
public class DoorControlTest {
    
    public DoorControlTest() {
    }

    /**
     * Test of breakDoorOpen method, of class DoorControl.
     */
    @Test
    public void testBreakDoorOpen() {
        
        //Test case 1
        System.out.println("breakDoorOpen Test case 1");
        
        // input values for test case 1
        double playerWeight = 175;
        double playerForce = 20;
        double doorWeight = 7;
        double doorWidth = 4;
        double doorHeight = 3;
        
        DoorControl instance = new DoorControl();
        
        double expResult = 1;
        double result = instance.breakDoorOpen(playerWeight, playerForce, doorWeight, doorWidth, doorHeight);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        //Test case 2
        System.out.println("breakDoorOpen Test case 2");
        
        // input values for test case 2
        playerWeight = 175;
        playerForce = -5;
        doorWeight = 100;
        doorWidth = 3;
        doorHeight = 5;
        
        //DoorControl instance = new DoorControl();
        
        expResult = -3;
        result = instance.breakDoorOpen(playerWeight, playerForce, doorWeight, doorWidth, doorHeight);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        //Test case 3
        System.out.println("breakDoorOpen Test case 3");
        
        // input values for test case 3
        playerWeight = 175;
        playerForce = 4;
        doorWeight = 7;
        doorWidth = 4;
        doorHeight = -5;
        
        //DoorControl instance = new DoorControl();
        
        expResult = -1;
        result = instance.breakDoorOpen(playerWeight, playerForce, doorWeight, doorWidth, doorHeight);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        //Test case 4
        System.out.println("breakDoorOpen Test case 4");
        
        // input values for test case 4
        playerWeight = 175;
        playerForce = 5;
        doorWeight = 7;
        doorWidth = -4;
        doorHeight = 4;
        
        //DoorControl instance = new DoorControl();
        
        expResult = -5;
        result = instance.breakDoorOpen(playerWeight, playerForce, doorWeight, doorWidth, doorHeight);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
