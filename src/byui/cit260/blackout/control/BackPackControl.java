
 

package byui.cit260.blackout.control;

import byui.cit260.blackout.model.Backpack;
import byui.cit260.blackout.model.Item;
import java.util.Stack;



public class BackPackControl {
    
    //private static Stack itemList = new Stack();
    //private static Stack clueList = new Stack();
    
    
    
    public static void addItemToList(Item item, Backpack backPack){
        
       Stack itemList = backPack.getItemList();
       itemList.push(item);
       
       backPack.setItemList(itemList);
        
        
        
    }
    
    
    
//    
//    public static void clearBackpack(){
//        itemList = new Stack();
//        clueList = new Stack();
//    }
    
    
}
