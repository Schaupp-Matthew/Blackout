package byui.cit260.blackout.model;

import java.io.Serializable;
import java.util.Objects;

// Author MGallup
public class Player implements Serializable {

    // class instance variables
    private String name;
    private int strength;
    private String talk;
    private int startStrength;
    private static double weight;
    private static double force;

    public static double getForce() {
        return force;
    }

    public static void setForce(double force) {
        Player.force = force;
    }

    public static double getWeight() {
        return weight;
    }

    public static void setWeight(double weight) {
        Player.weight = weight;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrenghth(int strength) {
        this.strength = strength;
    }

    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }

    public double getStartStrength() {
        return startStrength;
    }

    public void setStartStrength(int startStrength) {
        this.startStrength = startStrength;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", strength=" + strength + ", talk=" + talk + ", startStrength=" + startStrength + '}';
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
        final Player other = (Player) obj;
        if (this.strength != other.strength) {
            return false;
        }
        if (Double.doubleToLongBits(this.startStrength) != Double.doubleToLongBits(other.startStrength)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.talk, other.talk)) {
            return false;
        }
        return true;
    }

}
