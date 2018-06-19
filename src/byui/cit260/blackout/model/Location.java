
package byui.cit260.blackout.model;

// Author MGallup

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


public class Location implements Serializable{
    
    private int row;
    private int column;
    private String description;
    private Scene scene;
    private boolean visited;
    private ArrayList<NonPlayer> nonPlayer;

    public Location() {
    }
    
    

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
   

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.row);
        hash = 19 * hash + this.column;
        hash = 19 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public String toString() {
        return "Location{" + "row=" + row + ", column=" + column + ", description=" + description + '}';
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
        final Location other = (Location) obj;
        if (this.column != other.column) {
            return false;
        }
        if (!Objects.equals(this.row, other.row)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    public void setScene(Scene scene) {
        
        this.scene = scene;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Scene getScene(){
        return this.scene;
        
    }
    
    
    
    
}
