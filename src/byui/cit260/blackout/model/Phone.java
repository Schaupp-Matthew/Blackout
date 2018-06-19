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
public class Phone implements Serializable{
    
    //Class instance variables or attributes
    private int password;
    private String contactList;
    private String pictures;

    public Phone() {
        this.contactList = "Mama";
        this.password = 123;
        this.pictures = "; )";
        
    
    }
    
    

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getContactList() {
        return contactList;
    }

    public void setContactList(String contactList) {
        this.contactList = contactList;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.password);
        hash = 67 * hash + Objects.hashCode(this.contactList);
        hash = 67 * hash + Objects.hashCode(this.pictures);
        return hash;
    }

    @Override
    public String toString() {
        return "Phone{" + "password=" + password + ", contactList=" + contactList + ", pictures=" + pictures + '}';
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
        final Phone other = (Phone) obj;
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.contactList, other.contactList)) {
            return false;
        }
        if (!Objects.equals(this.pictures, other.pictures)) {
            return false;
        }
        return true;
    }
    
    
    
}
