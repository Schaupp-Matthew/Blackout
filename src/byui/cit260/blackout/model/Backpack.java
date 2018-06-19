/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.blackout.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Stack;

/**
 *
 * @author Matthew
 */
public class Backpack implements Serializable {
    
    //Class instance variables or attributes
    
    private String items;
    
    private  Stack itemList = new Stack();
    private  Stack clueList = new Stack();
    
    
    //default constructor
    public Backpack() {
    }

    public Stack getItemList() {
        return itemList;
    }

    public  void setItemList(Stack itemList) {
        this.itemList = itemList;
    }

    public  Stack getClueList() {
        return clueList;
    }

    public  void setClueList(Stack clueList) {
        this.clueList = clueList;
    }

    
    
    //getters and setters
    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    //hashes
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.items);
        return hash;
    }

    //String
    @Override
    public String toString() {
        return "Backpack{" + "items=" + items + '}';
    }

    //
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
        final Backpack other = (Backpack) obj;
        if (!Objects.equals(this.items, other.items)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
