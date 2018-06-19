
package byui.cit260.blackout.model;

//Author MGallup

import java.io.Serializable;
import java.util.Objects;


public class Map implements Serializable{
    
        // class instance variables
        private int rowCount;
        private int columnCount;
        private int currentRow;
        private int currentColumn;
        private String currentScene;
        private Location[][] locations;
        private Location currentLocation;

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
        

    public Map(int row, int column) {
        if (row < 1 || column < 1) {
            System.out.println("Number of rows and columns must be > 0");
            return;
        }
        
    this.rowCount = row;
    this.columnCount = column;
    
    this.locations = new Location[row][column];
    
    for (int i = 0; i < row; i++) {
        for(int ii = 0; ii < column; ii++) {
            Location location = new Location();
            location.setColumn(ii);
            location.setRow(i);
            location.setVisited(false);
            
            locations[i][ii] = location;
        }
    }
}
        
        
    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }

    public String getCurrentScene() {
        return currentScene;
    }

    public void setCurrentScene(String currentScene) {
        this.currentScene = currentScene;
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }
    
   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.rowCount;
        hash = 73 * hash + this.columnCount;
        hash = 73 * hash + Objects.hashCode(this.currentRow);
        hash = 73 * hash + this.currentColumn;
        hash = 73 * hash + Objects.hashCode(this.currentScene);
        return hash;
    }

    @Override
    public String toString() {
        return "Map{" + "rowCount=" + rowCount + ", columnCount=" + columnCount + ", currentRow=" + currentRow + ", currentColumn=" + currentColumn + ", currentScene=" + currentScene + '}';
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
        final Map other = (Map) obj;
        if (this.rowCount != other.rowCount) {
            return false;
        }
        if (this.columnCount != other.columnCount) {
            return false;
        }
        if (this.currentColumn != other.currentColumn) {
            return false;
        }
        if (!Objects.equals(this.currentRow, other.currentRow)) {
            return false;
        }
        if (!Objects.equals(this.currentScene, other.currentScene)) {
            return false;
        }
        return true;
    }
    
    
        
        
    
}
