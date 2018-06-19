package byui.cit260.blackout.control;

import blackout.Blackout;
import byui.cit260.blackout.exceptions.GameControlExceptions;
import byui.cit260.blackout.model.Backpack;
import byui.cit260.blackout.model.Game;
import byui.cit260.blackout.model.Item;
import byui.cit260.blackout.model.ItemList;
import byui.cit260.blackout.model.Location;
import byui.cit260.blackout.model.Map;
import byui.cit260.blackout.model.Phone;
import byui.cit260.blackout.model.Player;
import byui.cit260.blackout.model.Scene;
import byui.cit260.blackout.model.SceneType;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author mgallup
 */
public class GameControl {
    
    public static int[] itemLocationXY = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24};
    
    public static int min = 0;
    public static int max = 4;

    public static Player createPlayer(String name) {

        if (name == null) {
            return null;
        }

        Player player = new Player();
        player.setName(name);
        // player.setWeight(200);
        //  player.setForce(20.3);

        //Blackout.setPlayer(player);
        return player;
    }

    public static void createNewGame(Player player) {
        //System.out.println("\n*** createNewGame stub function called ***");

        Game game = new Game();
        Blackout.setCurrentGame(game);
        game.setPlayer(player);

        Item[] itemList = GameControl.createItemList();
        game.setItem(itemList);

        Backpack backpack = new Backpack();
        game.setBackpack(backpack);

        Phone phone = new Phone();
        game.setPhone(phone);

        Map map = MapControl.createMap();
        game.setMap(map);
        
        game.setNumberMovesLeft(50);
        game.setFoundDoor(false);
        game.setFoundAntidote(false);
        game.setFoundCoat(false);
        game.setFoundPhone(false);
        game.setFoundWallet(false);
        game.setUnlockedPhone(false);
        game.setUnlockedDoor(false);
        
        game.setGameMenu("\n"
                + "\n----------------------------------------------------------"
                + "\n | Game Menu"
                + "\n----------------------------------------------------------"
                + "\nM - Move to New Location"
                + "\nV - View Map"
                + "\nF - Save Map Report"
                + "\nS - Status"
                + "\nB - Backpack Menu"
                + "\nH - Help Menu"
                //+ "\nT - Talk"
                + "\nQ - Back to Main Menu"
                + "\n-----------------------------------------------------------");

        
    }
   
//create random int values to assign items to map locations     
    public static int getRandomInt(int min, int max) {
        min = (int) Math.ceil(min);
        max = (int) Math.floor(max);
        int randomValue = (int) (Math.floor(Math.random() * (max - min)) + min);
        
        return randomValue;
    }

    public static Item[] createItemList() {
        Item[] itemList = new Item[6];

        Item antidote = new Item();
        antidote.setDescription("The antidote needed to live!");
        antidote.setName("The Antidote");
        antidote.setLocationX(itemLocationXY[(GameControl.getRandomInt(min, max))]);
        antidote.setLocationY(itemLocationXY[(GameControl.getRandomInt(min, max))]);
        antidote.setLocation(GameControl.getRandomInt(min, max), GameControl.getRandomInt(min, max));
        //antidote.setHasItem(false);
        antidote.setItemArt(""
                            + " \n......"
                            +" \n:.  .:"
                            +" \n.'  '."
                            +" \n|    |"
                            +" \n|    |"
                            +" \n`----'");
        antidote.setAlreadyFound(false);
        itemList[ItemList.antidote.ordinal()] = antidote;

        Item phone = new Item();
        phone.setDescription("Your cell phone");
        phone.setName("Android");
        phone.setLocationX(itemLocationXY[(GameControl.getRandomInt(min, max))]);
        phone.setLocationY(itemLocationXY[(GameControl.getRandomInt(min, max))]);
        phone.setLocation(GameControl.getRandomInt(min, max), GameControl.getRandomInt(min, max));
        //phone.setHasItem(false);
        phone.setItemArt(""
                        +"\n*"
                        +"\n|"
                        +"\n(O)"
                        +"\n|#|"
                        +"\n'-'");         
        phone.setAlreadyFound(false);
        itemList[ItemList.phone.ordinal()] = phone;

        Item wallet = new Item();
        wallet.setDescription("Your wallet");
        wallet.setName("Leather wallet");
        wallet.setLocationX(itemLocationXY[(GameControl.getRandomInt(min, max))]);
        wallet.setLocationY(itemLocationXY[(GameControl.getRandomInt(min, max))]);
        wallet.setLocation(GameControl.getRandomInt(min, max), GameControl.getRandomInt(min, max));
        //wallet.setHasItem(false);
        wallet.setItemArt(""

                + "\n          \\`\\/\\/\\/`/"
                + "\n           )======("
                + "\n         .'        '."
                + "\n        /    _||__   \\"
                + "\n       /    (_||_     \\"
                + "\n      |     __||_)     |"
                + "\n      |       ||       |"
                + "\n      '.              .'"
                + "\n        '------------'");
                
                

        wallet.setAlreadyFound(false);
        itemList[ItemList.wallet.ordinal()] = wallet;

        Item coat = new Item();
        coat.setDescription("Your coat");
        coat.setName("Leather coat");
        coat.setLocationX(itemLocationXY[(GameControl.getRandomInt(min, max))]);
        coat.setLocationY(itemLocationXY[(GameControl.getRandomInt(min, max))]);
        coat.setLocation(GameControl.getRandomInt(min, max), GameControl.getRandomInt(min, max));
       
        //coat.setHasItem(false);
        coat.setItemArt(""
                     + "\n     .-<\\ />-."
                     + "\n    / , \\V/ , \\"
                     + "\n    | |  :  | |"
                     + "\n    | |  :  | |"
                     + "\n    | |__:__| |"
                    + "\n    \\_/     \\_/"
                    + "\n     ~        ~ ");           

        coat.setAlreadyFound(false);
        itemList[ItemList.coat.ordinal()] = coat;

        Item magicDoor = new Item();
        magicDoor.setDescription("The Magic Door");
        magicDoor.setName("Magic Door");
        magicDoor.setLocationX(itemLocationXY[(GameControl.getRandomInt(min, max))]);
        magicDoor.setLocationY(itemLocationXY[(GameControl.getRandomInt(min, max))]);
        magicDoor.setLocation(GameControl.getRandomInt(min, max), GameControl.getRandomInt(min, max));
        //magicDoor.setHasItem(false);
        magicDoor.setItemArt(""
                
                + "\n  ,-' ;  ! `-."
                + "\n  / :  !  :  . \\"
                + "\n |_ ;   __:  ;  |"
                + "\n )| .  :)(.  !  |"
                + "\n |\"    (##)  _  |"
                + "\n |  :  ;`'  (_) ("
                + "\n |  :  :  .     |"
                + "\n )_ !  ,  ;  ;  |"
                + "\n || .  .  :  :  |"
                + "\n |\" .  |  :  .  |"
                + "\n |mt-2_;----.___|");

        
        magicDoor.setAlreadyFound(false);
        itemList[ItemList.magicDoor.ordinal()] = magicDoor;
        
        Item loveNote = new Item();
        loveNote.setDescription("The Love Note");
        loveNote.setName(" Formula to unlock you phone ((sqrt(Number1 – Number2) *  ( sqrt(Number1 – Number2)) +   (Number3 – Number4) ");
        loveNote.setLocationX(itemLocationXY[(GameControl.getRandomInt(min, max))]);
        loveNote.setLocationY(itemLocationXY[(GameControl.getRandomInt(min, max))]);
        loveNote.setLocation(GameControl.getRandomInt(min, max), GameControl.getRandomInt(min, max));
        loveNote.setItemArt(""
                
                +"\n                  _______                    ______"
                +"\n         ..//``~~~~~-=+=-=+~~~~\\.      .//~~~~=-=+=-~~~~~''\\.."
                +"\n     ..//=+=-=+=-=+=-=+=-=+=-=+=-\\    //=+=-=+=-=+=-=+=-=+=-=+=\\.."
                +"\n     //+=-=+=-=+=-=+=-=+=-=+=-=+=-=+\\//=-=+=-=+=-=+=-=+=-=+=-=+=-=+\\"
                +"\n   //-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-\\"
                +"\n  ++=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=++"
                +"\n  ||~~\\    /~~~\\/~~~\\   /~~~\\/~~~\\   /~~~\\/~~~\\   /~~~\\/~~~\\   /~~~\\/~~||"
                +"\n  ||  /    \\        /   \\        /   \\        /   \\        /   \\       ||"
                +"\n  ||/        \\    /       \\    /       \\    /       \\    /       \\    /||"
                +"\n  ||           \\/           \\/           \\/           \\/           \\/  ||"
                +"\n  ++=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=++"
                +"\n   \\-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=//"
                +"\n     `\\=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+//'"
                +"\n       |`\\+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=//'"
                +"\n       |   `\\=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=//''"
                +"\n       |      ``\\=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=//''"
                +"\n  _____|_____     ``\\=+=-=+=-=+=-=+=-=+=-=+=-=+=-=+=//''     --Jrf"
                +"\n |   I Love  |        ``\\=+=-=+=-=+=-=+=-=+=-=+=//''"
                +"\n |    You.   |            ``\\=+=-=+=-=+=-=+=//''"
                +"\n |   *kiss*  |                ``\\=+=-=+=//''"
                +"\n  ~~~~~~~~~~~                     ``\\//''");

        loveNote.setAlreadyFound(false);
        itemList[ItemList.loveNote.ordinal()] = loveNote;

        return itemList;

    }

    static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();

        locations[0][0].setScene(scenes[SceneType.subwayOne.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.subwayTwo.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.subwayThree.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.subwayFour.ordinal()]);
        locations[0][4].setScene(scenes[SceneType.subwayFive.ordinal()]);

        locations[1][0].setScene(scenes[SceneType.streetOne.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.streetTwo.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.streetThree.ordinal()]);
        locations[1][3].setScene(scenes[SceneType.streetFour.ordinal()]);
        locations[1][4].setScene(scenes[SceneType.streetFive.ordinal()]);

        locations[2][0].setScene(scenes[SceneType.apartmentOne.ordinal()]);
        locations[2][1].setScene(scenes[SceneType.apartmentTwo.ordinal()]);
        locations[2][2].setScene(scenes[SceneType.apartmentThree.ordinal()]);
        locations[2][3].setScene(scenes[SceneType.apartmentFour.ordinal()]);
        locations[2][4].setScene(scenes[SceneType.apartmentFive.ordinal()]);

        locations[3][0].setScene(scenes[SceneType.pharmacyOne.ordinal()]);
        locations[3][1].setScene(scenes[SceneType.pharmacyTwo.ordinal()]);
        locations[3][2].setScene(scenes[SceneType.pharmacyThree.ordinal()]);
        locations[3][3].setScene(scenes[SceneType.pharmacyFour.ordinal()]);
        locations[3][4].setScene(scenes[SceneType.pharmacyFive.ordinal()]);

        locations[4][0].setScene(scenes[SceneType.hospitalOne.ordinal()]);
        locations[4][1].setScene(scenes[SceneType.hospitalTwo.ordinal()]);
        locations[4][2].setScene(scenes[SceneType.hospitalThree.ordinal()]);
        locations[4][3].setScene(scenes[SceneType.hospitalFour.ordinal()]);
        locations[4][4].setScene(scenes[SceneType.hospitalFive.ordinal()]);
    }

    public static void saveGame(Game game, String filepath) throws GameControlExceptions{
        
        try( FileOutputStream fops = new FileOutputStream(filepath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(game);
        }
        
        catch(Exception e){
            throw new GameControlExceptions(e.getMessage());
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void getSavedGame(String filePath) throws GameControlExceptions{
        
        Game game = null;
        
        try ( FileInputStream fips = new FileInputStream(filePath)){
            ObjectInputStream input = new ObjectInputStream(fips);
            
            game = (Game) input.readObject();
        }
        
        catch(Exception e){
            throw new GameControlExceptions(e.getMessage());
        }
        
        Blackout.setCurrentGame(game);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

}
