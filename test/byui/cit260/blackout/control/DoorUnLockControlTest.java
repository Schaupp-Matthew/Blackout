/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.blackout.control;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Brian
 */
public class DoorUnLockControlTest {
    
    public DoorUnLockControlTest() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of unLockDoorWithCode method, of class DoorUnLockControl.
     */
    @Test
    public void testUnLockDoorWithCode() {
        System.out.println("DoorUnLock Test Case 1");
        int keyCode = 5;
        double playLbs = 175;
        int doorNo = 1;
        DoorUnLockControl instance = new DoorUnLockControl();
        double expResult = 1;
        double result = instance.unLockDoorWithCode(keyCode, playLbs, doorNo);
        assertEquals(expResult, result, 0.0);
        
        System.out.println("DoorUnLock Test Case 2");
        keyCode = 7;
        playLbs = 49;
        doorNo = 11;
        //DoorUnLockControl instance = new DoorUnLockControl();
        expResult = -1;
        result = instance.unLockDoorWithCode(keyCode, playLbs, doorNo);
        assertEquals(expResult, result, 0.0);
        //fail("The test case is a prototype.");
        
        System.out.println("DoorUnLock Test Case 3");
        keyCode = 11;
        playLbs = 175;
        doorNo = 25;
        //DoorUnLockControl instance = new DoorUnLockControl();
        expResult = -2;
        result = instance.unLockDoorWithCode(keyCode, playLbs, doorNo);
        assertEquals(expResult, result, 0.0);
        //fail("The test case is a prototype.");
        
        System.out.println("DoorUnLock Test Case 4");
        keyCode = 7;
        playLbs = 175;
        doorNo = 27;
        //DoorUnLockControl instance = new DoorUnLockControl();
        expResult = -3;
        result = instance.unLockDoorWithCode(keyCode, playLbs, doorNo);
        assertEquals(expResult, result, 0.0);
        //fail("The test case is a prototype.");
        
        System.out.println("DoorUnLock Test Case 5");
        keyCode = 9;
        playLbs = -55;
        doorNo = 25;
        //DoorUnLockControl instance = new DoorUnLockControl();
        expResult = -1;
        result = instance.unLockDoorWithCode(keyCode, playLbs, doorNo);
        assertEquals(expResult, result, 0.0);
        //fail("The test case is a prototype.");
    }
    
}
