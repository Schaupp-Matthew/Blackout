/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.blackout.control;

import byui.cit260.blackout.model.Speaking;

/**
 *
 * @author Brian
 */
public class TalkControl {
    
    public int caculateAverageMoodofDay(int[] moodSwings){
        
       
        
        int sumTmp = 0;
        int sz = moodSwings.length;
        
        
        for(int i = 0; i < sz; i++){
            if(moodSwingValueCheck(moodSwings[i])){
                sumTmp += moodSwings[i];
            } else {
                System.out.println("MoodSwing Value of " + moodSwings[i] + " is invalid");
            }
            
        }
        
        int answer = sumTmp / sz;
        
        return answer;
        
        
    }
    
    private boolean moodSwingValueCheck(int val){
        
        boolean answer = false;
        
        if(val > 10 || val < 0){
            return false;
        } else {
            return true;
            
        }
       
        
    }
    
    public String getMessageBaseOnAverageMood(int[] moodSwings){
           int averageMood = caculateAverageMoodofDay(moodSwings);
           String[] answer  = Speaking.getValMessageBaseOnMood();
           
           return answer[averageMood]; 
   }
    
    
    
}
