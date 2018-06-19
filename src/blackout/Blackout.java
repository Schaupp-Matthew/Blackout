package blackout;

import byui.cit260.blackout.model.Game;
import byui.cit260.blackout.model.Player;
import byui.cit260.blackout.view.StartProgramView;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Blackout {

    private static Game currentGame = null;
    public static PrintWriter outFile = null;
    public static BufferedReader inFile = null;
    
    private static PrintWriter logFile = null;
            

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        Blackout.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Blackout.player = player;
    }
    private static Player player = null;

    public static void main(String[] args) {
        
        try {
            
            //open charater stream file for end user input and output
            Blackout.inFile = new BufferedReader(new InputStreamReader(System.in));
            Blackout.outFile = new PrintWriter(System.out, true);
            
            //open log file
            String filePath = "log.txt";
            Blackout.logFile = new PrintWriter(filePath);
            
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.displayStartProgramView();
            return;
            
        } catch (Throwable e){
            System.out.println("Exception: " + e.toString() +
                            "\nCause: " + e.getCause() + 
                            "\nMessage: " + e.getMessage());
            
            e.printStackTrace();  
            
        }
        
        finally {
            try {
                if(Blackout.inFile != null)
                    Blackout.inFile.close();
                if(Blackout.outFile != null)
                    Blackout.outFile.close();
                if(Blackout.logFile != null)
                    Blackout.logFile.close();
                
            } catch (IOException ex) {
                
                System.out.println("Error closing files");
                return;
                //Logger.getLogger(Blackout.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        /*
        StartProgramView startProgramView = new StartProgramView();

        try {

            //create StartProgramViewOrig and display the start program view
            startProgramView.displayStartProgramView();
        } catch (Throwable te) {
            System.out.println(te.getMessage());
            te.printStackTrace();
            startProgramView.displayStartProgramView();
        }
        */
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        Blackout.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        Blackout.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        Blackout.logFile = logFile;
    }
    
    

}
