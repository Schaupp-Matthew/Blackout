/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.blackout.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Brian
 */
public enum NonPlayer implements Serializable{
    
    Thug1("Subway thug", "The color is red"),
    Thug2("Apartment thug", "Not this room"),
    Thug3("Street thug", "Give me your money"),
    PoliceManJoe("The guy in blue", "Assume the position");
    //class vars 
    
//    private final String name;
//    private final int level;
    private final String clue;
    private final String description;
    private final Point coordinates;
    
    

//    NonPlayer(){
//        //basic constroctor  
//        
//    }

    NonPlayer(String description, String clue) {
        this.description = description;
        coordinates = new Point(1,1);
        this.clue = clue;
}
    
    /**
     * Get the value of clue
     *
     * @return the value of clue
     */
    public String getClue() {
        return this.clue;
    }

    public String getDescription() {
        return description;
    }

    public Point getCoordinates() {
        return coordinates;
    }
    
    
//
//    /**
//     * Set the value of clue
//     *
//     * @param clue new value of clue
//     */
//    public void setClue(String clue) {
//        this.clue = clue;
//    }


    /**
     * Get the value of level
     *
     * @return the value of level
     */
//    public int getLevel() {
//        return level;
//    }
//
//    /**
//     * Set the value of level
//     *
//     * @param level new value of level
//     */
//    public void setLevel(int level) {
//        this.level = level;
//    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
//    public String getName() {
//        return name;
//    }
//
//    /**
//     * Set the value of name
//     *
//     * @param name new value of name
//     */
//    public void setName(String name) {
//        this.name = name;
//    }

//    @Override
//    public String toString() {
//        return "NonPlayer{" + "name=" + name + ", level=" + level + ", clue=" + clue + '}';
//    }

//    @Override
//    public int hashCode() {
//        int hash = 5;
//        hash = 59 * hash + Objects.hashCode(this.name);
//        hash = 59 * hash + this.level;
//        hash = 59 * hash + Objects.hashCode(this.clue);
//        return hash;
//    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final NonPlayer other = (NonPlayer) obj;
//        if (this.level != other.level) {
//            return false;
//        }
//        if (!Objects.equals(this.name, other.name)) {
//            return false;
//        }
//        return true;
//    }

    

    
}
