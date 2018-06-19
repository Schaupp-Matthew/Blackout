/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.blackout.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mattn
 */
public class PhoneControlTest {
    
    public PhoneControlTest() {
    }

    /**
     * Test of callPassword method, of class PhoneControl.
     */
    @Test
    public void testCallPassword() {
        
        System.out.println("callPassword");
        
        //Test 1
        System.out.println("\tTest 1");
        int firstLetter = 9;
        int secondLetter = 5;
        int thirdLetter = 3;
        int fourthLetter = 8;
        PhoneControl instance = new PhoneControl();
        int expResult = 29;
        int result = instance.callPassword(firstLetter, secondLetter, thirdLetter, fourthLetter);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        
        //Test 2
        System.out.println("\tTest 2");
        firstLetter = -4;
        secondLetter = 0;
        thirdLetter = 5;
        fourthLetter = 3;
        expResult = -1;
        result = instance.callPassword(firstLetter, secondLetter, thirdLetter, fourthLetter);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        
        //Test 3
        System.out.println("\tTest 3");
        firstLetter = 9;
        secondLetter = 7;
        thirdLetter = 4;
        fourthLetter = -5; //Changed this from decimal value because a decimal value is not possible
        expResult = -1;
        result = instance.callPassword(firstLetter, secondLetter, thirdLetter, fourthLetter);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        
        //Test 4
        System.out.println("\tTest 4");
        firstLetter = 5;
        secondLetter = 15;
        thirdLetter = 7;
        fourthLetter = 2;
        expResult = -1;
        result = instance.callPassword(firstLetter, secondLetter, thirdLetter, fourthLetter);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
