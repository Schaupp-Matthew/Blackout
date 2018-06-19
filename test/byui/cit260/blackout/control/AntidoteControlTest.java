package byui.cit260.blackout.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mgallup
 */
public class AntidoteControlTest {
    
    public AntidoteControlTest() {
    }

    /**
     * Test of calcMedAmount method, of class AntidoteControl.
     */
    @Test
    public void testCalcMedAmount() {
        
        //Test case 1
        
        System.out.println("calcMedAmount Test Case 1 - Dose is correct");
        
        //Input Values for Test Case 1
        
        double weightInPounds = 100;
        double numberOfPills = 1;
        
        AntidoteControl instance = new AntidoteControl();
        
        double expResult = 227;
        double result = AntidoteControl.calcMedAmount(weightInPounds);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        
        //Test case 2
        
        System.out.println("calcMedAmount Test Case 2 Invalid weight");
        
        //Input Values for Test Case 2
        
        weightInPounds = 0;
        numberOfPills = 1;
        
        // AntidoteControl instance = new AntidoteControl();
        
        expResult = -1;
        result = AntidoteControl.calcMedAmount(weightInPounds);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        
        //Test case 3
        
        System.out.println("calcMedAmount Test Case 3 Underdose");
        
        //Input Values for Test Case 3
        
        weightInPounds = 10001;
        numberOfPills = 0;
        
        // AntidoteControl instance = new AntidoteControl();
        
        expResult = -2;
        result = AntidoteControl.calcMedAmount(weightInPounds);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        
        //Test case 4
        
        System.out.println("calcMedAmount Test Case 4 Overdose");
        
        //Input Values for Test Case 4
        
        weightInPounds = 100;
        numberOfPills = 4;
        
        // AntidoteControl instance = new AntidoteControl();
        
        expResult = 227;
        result = AntidoteControl.calcMedAmount(weightInPounds);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
