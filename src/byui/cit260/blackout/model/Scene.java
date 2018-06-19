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
 * @author Brian
 */
public class Scene implements Serializable{
    
        private String description;
        private String mapSymbol;
        private int numberItems;
        private NonPlayer nonPlayer;
        private String artForScreen;
        private boolean hasItem;

    public boolean isHasItem() {
        return hasItem;
    }

    public void setHasItem(boolean hasItem) {
        this.hasItem = hasItem;
    }

    public String getArtForScreen() {
        return artForScreen;
    }

    public void setArtForScreen(String artForScreen) {
        this.artForScreen = artForScreen;
    }
        

    

        
        
    /**
     * Get the value of nonPlayer
     *
     * @return the value of nonPlayer
     */
    public NonPlayer getNonPlayer() {
        return nonPlayer;
    }

    /**
     * Set the value of nonPlayer
     *
     * @param nonPlayer new value of nonPlayer
     */
    public void setNonPlayer(NonPlayer nonPlayer) {
        this.nonPlayer = nonPlayer;
    }


    /**
     * Get the value of numberItems
     *
     * @return the value of numberItems
     */
    public int getNumberItems() {
        return numberItems;
    }

    /**
     * Set the value of numberItems
     *
     * @param numberItems new value of numberItems
     */
    public void setNumberItems(int numberItems) {
        this.numberItems = numberItems;
    }


    /**
     * Get the value of mapSymbol
     *
     * @return the value of mapSymbol
     */
    public String getMapSymbol() {
        return mapSymbol;
    }

    /**
     * Set the value of mapSymbol
     *
     * @param mapSymbol new value of mapSymbol
     */
    public void setMapSymbol(String mapSymbol) {
        this.mapSymbol = mapSymbol;
    }

        
    /**
     * Get the value of description
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the value of description
     *
     * @param description new value of description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + Objects.hashCode(this.mapSymbol);
        hash = 29 * hash + this.numberItems;
        hash = 29 * hash + Objects.hashCode(this.nonPlayer);
        return hash;
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
        final Scene other = (Scene) obj;
        if (this.numberItems != other.numberItems) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.mapSymbol, other.mapSymbol)) {
            return false;
        }
        if (!Objects.equals(this.nonPlayer, other.nonPlayer)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Scene{" + "description=" + description + ", mapSymbol=" + mapSymbol + ", numberItems=" + numberItems + ", nonPlayer=" + '}'; //nonplayer missing
    }

   

 
    
}
