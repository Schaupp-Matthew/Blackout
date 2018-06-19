
package byui.cit260.blackout.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author mgallup
 */
public class AntidoteMessage implements Serializable {

    public static String messageBanner;
    
    private String message;
    private String from;

    public AntidoteMessage() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.message);
        hash = 23 * hash + Objects.hashCode(this.from);
        return hash;
    }

    @Override
    public String toString() {
        return "AntidoteMessage{" + "message=" + message + ", from=" + from + '}';
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AntidoteMessage other = (AntidoteMessage) obj;
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (!Objects.equals(this.from, other.from)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
