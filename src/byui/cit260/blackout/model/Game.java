
package byui.cit260.blackout.model;

import java.io.Serializable;

//Author MGallup
public class Game implements Serializable{
    
    
    //class instance variables
    private double totalTime;
    private double startTime;
    private Map map;
    
    private Item[] item;
    private Backpack backpack;
    private Phone phone;
    private Player player; 
    
    private boolean foundDoor;
    private boolean foundPhone;
    private boolean foundWallet;
    private boolean foundCoat;
    private boolean foundAntidote;
    private boolean unlockedPhone;
    private boolean unlockedDoor;
    private boolean foundLoveNote;
    
    private int NumberMovesLeft;
    
    private String gameMenu;

    public boolean isFoundLoveNote() {
        return foundLoveNote;
    }

    public void setFoundLoveNote(boolean foundLoveNote) {
        this.foundLoveNote = foundLoveNote;
    }

    
    
    public String getGameMenu() {
        return gameMenu;
    }

    public void setGameMenu(String gameMenu) {
        this.gameMenu = gameMenu;
    }
    
    

    public boolean isUnlockedDoor() {
        return unlockedDoor;
    }

    public void setUnlockedDoor(boolean unlockedDoor) {
        this.unlockedDoor = unlockedDoor;
    }

    public boolean isUnlockedPhone() {
        return unlockedPhone;
    }

    public void setUnlockedPhone(boolean unlockedPhone) {
        this.unlockedPhone = unlockedPhone;
    }

    public boolean isFoundPhone() {
        return foundPhone;
    }

    public void setFoundPhone(boolean foundPhone) {
        this.foundPhone = foundPhone;
    }

    public boolean isFoundWallet() {
        return foundWallet;
    }

    public void setFoundWallet(boolean foundWallet) {
        this.foundWallet = foundWallet;
    }

    public boolean isFoundCoat() {
        return foundCoat;
    }

    public void setFoundCoat(boolean foundCoat) {
        this.foundCoat = foundCoat;
    }

    public boolean isFoundAntidote() {
        return foundAntidote;
    }

    public void setFoundAntidote(boolean foundAntidote) {
        this.foundAntidote = foundAntidote;
    }

    
    
    public boolean isFoundDoor() {
        return foundDoor;
    }

    public void setFoundDoor(boolean foundDoor) {
        this.foundDoor = foundDoor;
    }

    public int getNumberMovesLeft() {
        return NumberMovesLeft;
    }

    public void setNumberMovesLeft(int NumberMovesLeft) {
        this.NumberMovesLeft = NumberMovesLeft;
    }

    
    
    public Game() {
    }
    
    

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public Item[] getItem() {
        return item;
    }

    public void setItem(Item[] item) {
        this.item = item;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Map getMap() {
        return map;
    }

    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.totalTime) ^ (Double.doubleToLongBits(this.totalTime) >>> 32));
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.startTime) ^ (Double.doubleToLongBits(this.startTime) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Game{" + "totalTime=" + totalTime + ", startTime=" + startTime + '}';
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
        final Game other = (Game) obj;
        if (Double.doubleToLongBits(this.totalTime) != Double.doubleToLongBits(other.totalTime)) {
            return false;
        }
        if (Double.doubleToLongBits(this.startTime) != Double.doubleToLongBits(other.startTime)) {
            return false;
        }
        return true;
    }

    public void setPlayer(Player player) {
        this.player = player;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setMap(Map map) {
        this.map = map;
    }
    
    
    
    
}
