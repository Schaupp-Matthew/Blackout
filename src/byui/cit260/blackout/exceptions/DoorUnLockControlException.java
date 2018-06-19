/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.blackout.exceptions;

/**
 *
 * @author Brian
 */
public class DoorUnLockControlException extends Exception {
    
    public DoorUnLockControlException() {
    }

    public DoorUnLockControlException(String message) {
        super(message);
    }

    public DoorUnLockControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoorUnLockControlException(Throwable cause) {
        super(cause);
    }

    public DoorUnLockControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
