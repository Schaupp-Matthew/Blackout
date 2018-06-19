/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.blackout.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Matthew
 */
public class Door implements Serializable{
    
    //Class instance variables or attributes
    private boolean locked;
    private boolean unlocked;
    private boolean window;
    private String keyType;
    private boolean haveKey;
    private static boolean open;

    public Door() {
    }

    public static boolean isOpen() {
        return open;
    }

    public static void setOpen(boolean open) {
        Door.open = open;
    }
    
    

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    public boolean isWindow() {
        return window;
    }

    public void setWindow(boolean window) {
        this.window = window;
    }

    public String getKeyType() {
        return keyType;
    }

    public void setKeyType(String keyType) {
        this.keyType = keyType;
    }

    public boolean isHaveKey() {
        return haveKey;
    }

    public void setHaveKey(boolean haveKey) {
        this.haveKey = haveKey;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (this.locked ? 1 : 0);
        hash = 71 * hash + (this.unlocked ? 1 : 0);
        hash = 71 * hash + (this.window ? 1 : 0);
        hash = 71 * hash + Objects.hashCode(this.keyType);
        hash = 71 * hash + (this.haveKey ? 1 : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Door{" + "locked=" + locked + ", unlocked=" + unlocked + ", window=" + window + ", keyType=" + keyType + ", haveKey=" + haveKey + '}';
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
        final Door other = (Door) obj;
        if (this.locked != other.locked) {
            return false;
        }
        if (this.unlocked != other.unlocked) {
            return false;
        }
        if (this.window != other.window) {
            return false;
        }
        if (this.haveKey != other.haveKey) {
            return false;
        }
        if (!Objects.equals(this.keyType, other.keyType)) {
            return false;
        }
        return true;
    }
    
    

    
    
    
}
