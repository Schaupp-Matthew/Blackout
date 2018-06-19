/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.blackout.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Brian
 */
public class Speaking {
    
    private static String[] messageBasedOnMood = new String[10];  //0 is sad  10 is angry
    
    
    Speaking(){
        
        
        setValMessageBaseOnMood();
        
    }
    
    
    //added by brian
    public static void setValMessageBaseOnMood(){
        
        //0 is sad 10 is angry
        
        Speaking.messageBasedOnMood[0] = "Speak very sad";
        Speaking.messageBasedOnMood[0] = "Speak sad";        
        Speaking.messageBasedOnMood[2] = "Speak little sad";
        Speaking.messageBasedOnMood[3] = "Speak omewhat happy";
        Speaking.messageBasedOnMood[4] = "Speak happy";
        Speaking.messageBasedOnMood[5] = "Speak very happy";
        Speaking.messageBasedOnMood[6] = "Speak scary happy";
        Speaking.messageBasedOnMood[7] = "Speak little angry";
        Speaking.messageBasedOnMood[8] = "Speak angry";
        Speaking.messageBasedOnMood[9] = "Speak very angry";
        
    }
    
    public static String[] getValMessageBaseOnMood(){
        
        return Speaking.messageBasedOnMood;
        
    }
 
    
    @Override
    public int hashCode() {
        int hash = 7;
      
        return hash;
    }

    @Override
    public String toString() {
        
        return "abc";
       // return "Location{" + "row=" + row + ", column=" + column + ", description=" + description + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        
        return true;
    }

}
