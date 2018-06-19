
package byui.cit260.blackout.exceptions;

/**
 *
 * @author mgallup
 */
public class DoorControlException extends Exception {

    public DoorControlException() {
    }

    public DoorControlException(String message) {
        super(message);
    }

    public DoorControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public DoorControlException(Throwable cause) {
        super(cause);
    }

    public DoorControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
    
}
