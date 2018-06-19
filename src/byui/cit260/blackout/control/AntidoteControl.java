package byui.cit260.blackout.control;

import byui.cit260.blackout.exceptions.AntidoteControlException;
import byui.cit260.blackout.model.AntidoteMessage;
import byui.cit260.blackout.model.MessageList;

/**
 *
 * @author mgallup
 */
public class AntidoteControl {

    private static String messageBanner;
    private static final int NUM_MESSAGES = AntidoteControl.createMessageList().length;
    private static AntidoteMessage[] messageList;

    public static double calcMedAmount(double weightInPounds) throws AntidoteControlException {

        double weightInKilo = (weightInPounds * 0.4535);

        double medicineAmount = (weightInKilo /10);
        medicineAmount = Math.round(medicineAmount);
        
                    //for testing purposes
                    //System.out.println("Medicine Amount: " + medicineAmount);

        if (weightInPounds <= 100) { //weightInPounds is negative?
            throw new AntidoteControlException("\nWeight in pounds can not be less than or equal to 100 ");
            //return -1;
        }

        if (weightInPounds >= 10000) {  //that boy is tooo FAT  not enough pills for this guy he should die
            throw new AntidoteControlException("\nWeight in pounds can not be more than 10000 ");
            //return -2;
        }

        if (weightInKilo <= 0) { //weightInKilo is negative?
            throw new AntidoteControlException("\nWeight in kilograms can not be less than zero ");
            //return -3;
        }

        if (medicineAmount <= 0) { //medicineAmount is negative?
            throw new AntidoteControlException("\nMedicine amount can not be less than zero ");
            //return -4;

        } else {
            System.out.println("Your weight in kilograms is " + weightInKilo);
            return medicineAmount;

        }
        

    }

    public static boolean testAntidote(double medicineAmount, double numberOfPills) throws AntidoteControlException {
        boolean answer = false;
        if (medicineAmount == numberOfPills) {
            answer = true;
        } else answer = false;

        return answer;

    }

    public static AntidoteMessage[] createMessageList() {

        AntidoteMessage[] messageList = new AntidoteMessage[3];

        AntidoteMessage message1 = new AntidoteMessage();
        message1.setFrom("Doctor");
        message1.setMessage("That is the correct amount of pills, continue the game");
        messageList[MessageList.message1.ordinal()] = message1;

        AntidoteMessage message2 = new AntidoteMessage();
        message2.setFrom("The Pharmacist");
        message2.setMessage("You took too many pills! Your are dead! Game Over!");
        messageList[MessageList.message2.ordinal()] = message2;

        AntidoteMessage message3 = new AntidoteMessage();
        message3.setFrom("Wife");
        message3.setMessage("You didn't take enough pills.  You will now die in a matter of time.");
        messageList[MessageList.message3.ordinal()] = message3;

        return messageList;

    }

//    public static AntidoteMessage[] displayMessages() {
//        AntidoteMessage.messageBanner = "\n----------------------------------------------------"
//                + "\nYour have " + NUM_MESSAGES + " messages"
//                + "\n---------------------------------------------------";
//
//        System.out.println(messageBanner);
//
//        messageList = AntidoteControl.createMessageList();
//
//        for (AntidoteMessage message : messageList) {
//
//            System.out.println(message);
//        }
//
//        return messageList;
//    }

}
