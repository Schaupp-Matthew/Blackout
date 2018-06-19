/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.blackout.exceptions;

/**
 *
 * @author Matthew
 */
public class PhoneControlException extends Exception {

    public PhoneControlException() {
    }

    public PhoneControlException(String message) {
        super(message);
    }

    public PhoneControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public PhoneControlException(Throwable cause) {
        super(cause);
    }

//    public PhoneControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
//        super(message, cause, enableSuppression, writableStackTrace);
//    }
    
}
