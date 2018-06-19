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
public class Antidote extends Item implements Serializable {
    
        //class vars 
        private double weightInPounds;
        private double weighInKilo;
        
        public Antidote(){
            
            
        }

    /**
     * Get the value of weighInKilo
     *
     * @return the value of weighInKilo
     */
    public Double getWeighInKilo() {
        return weighInKilo;
    }

    /**
     * Set the value of weighInKilo
     *
     * @param weighInKilo new value of weighInKilo
     */
    public void setWeighInKilo(Double weighInKilo) {
        this.weighInKilo = weighInKilo;
    }


    /**
     * Get the value of weightInPounds
     *
     * @return the value of weightInPounds
     */
    public double getWeightInPounds() {
        return weightInPounds;
    }

    /**
     * Set the value of weightInPounds
     *
     * @param weightInPounds new value of weightInPounds
     */
    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.weightInPounds) ^ (Double.doubleToLongBits(this.weightInPounds) >>> 32));
        hash = 23 * hash + Objects.hashCode(this.weighInKilo);
        
        
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
        final Antidote other = (Antidote) obj;
        if (Double.doubleToLongBits(this.weightInPounds) != Double.doubleToLongBits(other.weightInPounds)) {
            return false;
        }
        if (!Objects.equals(this.weighInKilo, other.weighInKilo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        
        return "Antidote{" +  super.toString() + "weightInPounds=" + weightInPounds + ", weighInKilo=" + weighInKilo + '}';
    
    }

    
    
}
