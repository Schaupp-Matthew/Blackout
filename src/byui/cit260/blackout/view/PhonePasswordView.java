/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.blackout.view;

import blackout.Blackout;
import byui.cit260.blackout.control.PhoneControl;
import byui.cit260.blackout.exceptions.PhoneControlException;
import byui.cit260.blackout.model.PhoneMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
//import java.util.Scanner;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author Matt
 */
public class PhonePasswordView {

    private final String banner;
    private final String promptMessage = "Please enter the password:";
    private final String promptMessage2 = "Please enter a value from 0 to 9:";
    private final String promptMessage3 = "Please enter another value from 0 to 9:";
    private int password;
    private int phonePassword;
    private static String messageBanner;
    private static final int NUM_MESSAGES = PhoneControl.createMessageList().length;
    private PhoneMessage[] messageList;
    
    protected final BufferedReader keyboard = Blackout.getInFile();
    protected final PrintWriter console = Blackout.getOutFile();
    
    
//    private String messageBanner;
//    private final int numMessages = PhoneControl.createMessageList().length;
//    private PhoneMessage[] messageList;
    
    
    

    public PhonePasswordView() {
        this.banner = "\n"
                + "\n------------------------------------------"
                + "\nYou will now have an opportunity to unlock your phone."
                + "\nPlease pay close attention to the following"
                + "\nAnd input what you are asked for and nothing else."
                + "\n------------------------------------------";
        this.console.println(banner);
    }

    public void displayPhonePasswordView() {

        int firstLetter;
        try {
            firstLetter = this.getFirstLetter();
        } catch (PhoneControlException ex) {
            ErrorView.display(this.getClass().getName(), "*** Invalid Value Entered" + ex.getMessage());
            //System.out.println(ex.getMessage());
            return;
        } catch (Throwable te) {
            //System.out.println(te.getMessage());
            ErrorView.display(this.getClass().getName(), "*** Invalid Value Entered" + te.getMessage());
            
            return;
        }

        int secondLetter;
        try {
            secondLetter = this.getSecondLetter();
        } catch (PhoneControlException ex) {
            //System.out.println(ex.getMessage());
            ErrorView.display(this.getClass().getName(), "*** Invalid Value Entered" + ex.getMessage());
            return;
        } catch (Throwable te) {
            ErrorView.display(this.getClass().getName(), "*** Invalid Value Entered" + te.getMessage());
            
           // System.out.println(te.getMessage());
            return;
        }

        int thirdLetter;
        try {
            thirdLetter = this.getThirdLetter();
        } catch (PhoneControlException ex) {
           // System.out.println(ex.getMessage());
            ErrorView.display(this.getClass().getName(), "*** Invalid Value Entered" + ex.getMessage());
            
            return;
        } catch (Throwable te) {
            //System.out.println(te.getMessage());
            ErrorView.display(this.getClass().getName(), "*** Invalid Value Entered" + te.getMessage());
            
            return;
        }

        int fourthLetter;
        try {
            fourthLetter = this.getFourthLetter();
        } catch (PhoneControlException ex) {
            //System.out.println(ex.getMessage());
            ErrorView.display(this.getClass().getName(), "*** Invalid Value Entered" + ex.getMessage());
            
            return;
        } catch (Throwable te) {
            //System.out.println(te.getMessage());
            ErrorView.display(this.getClass().getName(), "*** Invalid Value Entered" + te.getMessage());
            
            return;
        }

        try {
            password = PhoneControl.callPassword(firstLetter, secondLetter, thirdLetter, fourthLetter);
        } catch (PhoneControlException ex) {
            //System.out.println(ex.getMessage());
            ErrorView.display(this.getClass().getName(), "*** Invalid Value Entered" + ex.getMessage());
            
            return;
        } catch (Throwable te) {
            //System.out.println(te.getMessage());
            ErrorView.display(this.getClass().getName(), "*** Invalid Value Entered" + te.getMessage());
            
            te.printStackTrace();
            return;
        }

        try {
            phonePassword = this.getPhonePassword();
        } catch (PhoneControlException ex) {
            //System.out.println(ex.getMessage());
            ErrorView.display(this.getClass().getName(), "*** Invalid Value Entered" + ex.getMessage());
            
            return;
        } catch (Throwable te) {
            //System.out.println(te.getMessage());
            ErrorView.display(this.getClass().getName(), "*** Invalid Value Entered" + te.getMessage());
            
            return;
        }

        this.checkPassword();

        if (password == phonePassword) {
            messageList = PhoneControl.createMessageList();
        }

    }

    private int getPhonePassword() throws PhoneControlException {
        //Scanner keyboard = new Scanner(System.in);
        String value = null;
        int number = 0;
        boolean valid = false;

        while (!valid) {
            this.console.println("\n" + this.promptMessage);

            try {
                value = keyboard.readLine();
            } catch (IOException ex) {
                //System.out.println("\n Error Reading Input: " + ex.getMessage());
                ErrorView.display(this.getClass().getName(), "Error Reading Input: " + ex.getMessage());
            
                
                
                //Logger.getLogger(PhonePasswordView.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                number = parseInt(value);
            } catch (NumberFormatException nf) {
                //System.out.println("\nInvalid input. Please enter a number between 0 and 9 inclusive:");
                ErrorView.display(this.getClass().getName(), "Please enter a number between 0 and 9 inclusive: " + nf.getMessage());
            
                continue;
            }

            if (number < 0) {
                ErrorView.display(this.getClass().getName(), "Invalid value: Choose a correct value ");
            
                //System.out.println("\nInvalid value: Choose a correct value");
                continue;
            }
            break;
        }
        return number;
    }

//    {
//        Scanner keyboard = new Scanner(System.in);
//        int value = 0;
//        boolean valid = false;
//        
//        while (!valid) {
//            System.out.println("\n" + this.promptMessage);
//            
//            value = keyboard.nextInt();
//            
//            if (value < 0) {
//                System.out.println("\nInvalid value: Choose a correct value");
//                continue;
//            }
//            break;
//        }
//        return value;
//    }
    private int getFirstLetter() throws PhoneControlException {
        //Scanner keyboard = new Scanner(System.in);
        String value = null;
        int number = 0;
        boolean valid = false;

        while (!valid) {
            this.console.println("\n" + this.promptMessage2);

            try {
                value = keyboard.readLine();
            } catch (IOException ex) {
                //System.out.println("\n Error Reading Input: " + ex.getMessage());
                ErrorView.display(this.getClass().getName(), "\n Error Reading Input: " + ex.getMessage());
                //Logger.getLogger(PhonePasswordView.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                number = parseInt(value);
            } catch (NumberFormatException nf) {
                ErrorView.display(this.getClass().getName(), "Invalid input. Please enter a number between 0 and 9 inclusive " + nf.getMessage());
            
                //System.out.println("\nInvalid input. Please enter a number between 0 and 9 inclusive:");
                continue;
            }

            if (number < 0 || number > 9) {
                 ErrorView.display(this.getClass().getName(), "Invalid value: Choose a correct value");
            
                //System.out.println("\nInvalid value: Choose a correct value");
                continue;
            }
            break;
        }
        return number;
    }

    private int getSecondLetter() throws PhoneControlException {
        //Scanner keyboard = new Scanner(System.in);
        String value = null;
        int number = 0;
        boolean valid = false;

        while (!valid) {
            this.console.println("\n" + this.promptMessage3);

            try {
                value = keyboard.readLine();
            } catch (IOException ex) {
                
                //System.out.println("\n Error Reading input: " + ex.getMessage());
                ErrorView.display(this.getClass().getName(), "Error Reading input: " + ex.getMessage());
            
                //Logger.getLogger(PhonePasswordView.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                number = parseInt(value);
            } catch (NumberFormatException nf) {
                ErrorView.display(this.getClass().getName(), "nvalid input. Please enter a number between 0 and 9 inclusive: " + nf.getMessage());
            
                //System.out.println("\nInvalid input. Please enter a number between 0 and 9 inclusive:");
                continue;
            }

            if (number < 0 || number > 9) {
                 ErrorView.display(this.getClass().getName(), "Invalid value: Choose a correct value");
            
                //System.out.println("\nInvalid value: Choose a correct value");
                continue;
            }
            break;
        }
        return number;
    }

    private int getThirdLetter() throws PhoneControlException {
        //Scanner keyboard = new Scanner(System.in);
        String value = null;
        int number = 0;
        boolean valid = false;

        while (!valid) {
            this.console.println("\n" + this.promptMessage3);

            try {
                value = keyboard.readLine();
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Error Reading input: " + ex.getMessage());
            
                //System.out.println("\n Error Reading input: " + ex.getMessage());
                //Logger.getLogger(PhonePasswordView.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                number = parseInt(value);
            } catch (NumberFormatException nf) {
                 ErrorView.display(this.getClass().getName(), "Invalid input. Please enter a number between 0 and 9 inclusive: " + nf.getMessage());
            
                //System.out.println("\nInvalid input. Please enter a number between 0 and 9 inclusive:");
                continue;
            }

            if (number < 0 || number > 9) {
                ErrorView.display(this.getClass().getName(), "Invalid value: Choose a correct value");
            
                //System.out.println("\nInvalid value: Choose a correct value");
                continue;
            }
            break;
        }
        return number;
    }

    private int getFourthLetter() throws PhoneControlException {
        //Scanner keyboard = new Scanner(System.in);
        String value = null;
        int number = 0;
        boolean valid = false;

        while (!valid) {
            
            
            this.console.println("\n" + this.promptMessage3);

            try {
                value = keyboard.readLine();
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "Error Reading input: " +ex.getMessage());
               //System.o ut.println("\n Error Reading input: " + ex.getMessage());
                //Logger.getLogger(PhonePasswordView.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                number = parseInt(value);
            } catch (NumberFormatException nf) {
                ErrorView.display(this.getClass().getName(), "Invalid input. Please enter a number between 0 and 9 inclusive: " + nf.getMessage());
               
                //System.out.println("\nInvalid input. Please enter a number between 0 and 9 inclusive:");
                continue;
            }

            if (number < 0 || number > 9) {
                
                this.console.println("\nInvalid value: Choose a correct value");
                continue;
            }
            break;
        }
        return number;
    }

    public void checkPassword() {
        if (password == phonePassword) {
            this.console.println("The password is correct"
                    + "\n You may now read your messages");
//            messageList = PhoneControl.displayMessages();
//              messageList = this.displayMessages();
            this.displayMessages();
            //set the game value to unlocked phone
            Blackout.getCurrentGame().setUnlockedPhone(true);
            
            //return for use when other code is finished
            //return true;
        } else {
            this.console.println("Incorrect Password");
            //return for use when other code is finished
            //return false;
        }
    }
    
    public PhoneMessage[] displayMessages() {
        PhonePasswordView.messageBanner = "\n----------------------------------------------------"
            + "\nYour have " + NUM_MESSAGES + " messages"
            +"\n---------------------------------------------------";
        
        this.console.println(messageBanner);
        
        messageList = PhoneControl.createMessageList();
        
        
        for(PhoneMessage message: messageList) {
            
            this.console.println(message);
        }
        
        return messageList;
        }

//    private void displayMessagesView() {
//        
//        this.messageBanner = "\n----------------------------------------------------"
//                + "\nYour have " + numMessages + " messages"
//                +"\n---------------------------------------------------";
//        
//        System.out.println(messageBanner);
//        
//        messageList = PhoneControl.createMessageList();
//        
//        
//    }
}
