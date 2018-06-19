/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.blackout.view;

import blackout.Blackout;
import byui.cit260.blackout.control.ExamControl;
import byui.cit260.blackout.model.Item;
import static java.lang.Integer.parseInt;
//import java.util.Scanner;

/**
 *
 * @author Brian
 */
public class ExamMenu extends View{
   
   //private String menu;
    //private String promptMessage = "\nPlease enter an option:";
    
    public ExamMenu() {
        super ("\n"
                + "\n------------------------------------------"
                + "\n |Exam Menu"
                + "\n------------------------------------------"
                + "\nI - Look At Item In Location"
                + "\nU - Look Up"
                + "\nD - Look Down"
                + "\nL - Look Left"
                + "\nR - Look Right"
                + "\nQ - Quit Menu"
                + "\n------------------------------------------");
            //System.out.println(menu);
    }
    
  /*  public void displayExamMenuView() {
        boolean done = false;
        do {
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q")) {//user want to exit menu
                    //GameMenuView gameMenu = new GameMenuView();
                    //gameMenu.displayGameMenuView();
                    //break;
                    return;
            }
            
            done = this.doAction(menuOption);
            
        }  while (!done);   
        
         System.out.println(menu);
    }

    private String getMenuOption() {
        Scanner keyboard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        
        while (!valid) {
            System.out.println("\n" + this.promptMessage);
            
            value = keyboard.nextLine();
            value = value.trim();
            
            if (value.length() > 1) {
                System.out.println("\nInvalid value: Choose a correct value");
                continue;
            }
            break;
        }
        return value;
    }*/
    
    @Override
    public boolean doAction (String choice) {
        choice = choice.toUpperCase();
        
        switch (choice) {
            case "I" :
                this.lookAtItem();
                break;
            case "U" :
                this.lookUp();
                break;
            case "D" :
                this.lookDown();
                break;
            case "W" :
                this.lookLeft();
                break;
           
            default :
                ErrorView.display(this.getClass().getName(), "*** Invalid selection. Please try again.***");
                //System.out.println("\n*** Invalid selection. Please try again.***");
                break;
        }
        return false;
    }

    private void lookAtItem() {
        //System.out.println("\n*** lookAtItem()function called ***");
        //Blackout.getCurrentGame().getItem()
        
        int itemIndex  = -1;
        try {
            itemIndex = parseInt(getInput("Enter Item List Number"));
       } catch(NumberFormatException e){
           ErrorView.display(this.getClass().getName(), "Invalid Value Entered");
                
           //System.out.println("Invalid Value Entered");
       }
        
        if(itemIndex >= 0){
            
           Item[] items = Blackout.getCurrentGame().getItem();
           ExamControl.examItem(items[itemIndex]);
           
        }
    }   

    private void lookUp() {
        this.console.println("\n*** lookUp() function called ***");
    }

    private void lookLeft() {
        this.console.println("\n*** lookLeft() function called ***");
    }

    private void lookRight() {
        this.console.println("\n*** lookRight() function called ***");
    }

    private void lookDown() {
        this.console.println("\n*** lookDown() function called ***");
    } 
    
}

