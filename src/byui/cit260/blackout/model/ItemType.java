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
public class ItemType implements Serializable{
    
    //Class instance variables or attributes
    private String antidote;
    private String phone;
    private String soda;
    private String money;
    private String coat;
    private String wallet;
    private String candy;

    public ItemType() {
    }
    
    

    public String getAntidote() {
        return antidote;
    }

    public void setAntidote(String antidote) {
        this.antidote = antidote;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSoda() {
        return soda;
    }

    public void setSoda(String soda) {
        this.soda = soda;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getCoat() {
        return coat;
    }

    public void setCoat(String coat) {
        this.coat = coat;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public String getCandy() {
        return candy;
    }

    public void setCandy(String candy) {
        this.candy = candy;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.antidote);
        hash = 89 * hash + Objects.hashCode(this.phone);
        hash = 89 * hash + Objects.hashCode(this.soda);
        hash = 89 * hash + Objects.hashCode(this.money);
        hash = 89 * hash + Objects.hashCode(this.coat);
        hash = 89 * hash + Objects.hashCode(this.wallet);
        hash = 89 * hash + Objects.hashCode(this.candy);
        return hash;
    }

    @Override
    public String toString() {
        return "ItemType{" + "antidote=" + antidote + ", phone=" + phone + ", soda=" + soda + ", money=" + money + ", coat=" + coat + ", wallet=" + wallet + ", candy=" + candy + '}';
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
        final ItemType other = (ItemType) obj;
        if (!Objects.equals(this.antidote, other.antidote)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.soda, other.soda)) {
            return false;
        }
        if (!Objects.equals(this.money, other.money)) {
            return false;
        }
        if (!Objects.equals(this.coat, other.coat)) {
            return false;
        }
        if (!Objects.equals(this.wallet, other.wallet)) {
            return false;
        }
        if (!Objects.equals(this.candy, other.candy)) {
            return false;
        }
        return true;
    }
    
    
    
}
