/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.blackout.view;

import blackout.Blackout;
import java.io.PrintWriter;

/**
 *
 * @author Brian
 */
public class ErrorView {
    
    private static final PrintWriter errorFile = Blackout.getOutFile();
    private static final PrintWriter logFile = Blackout.getLogFile();
    
    public static void display(String className, String errorMessage){
        
        errorFile.println(
                "_______________________________________________________"
                + "\n- ERROR - " + errorMessage
                + "\n_____________________________________________________");
        
        //log error
        logFile.println(className + " - " + errorMessage);

    }
    
}
