/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.blackout.control;

import blackout.Blackout;
import byui.cit260.blackout.model.Item;
import byui.cit260.blackout.model.ItemList;
import byui.cit260.blackout.model.Map;
import byui.cit260.blackout.model.NonPlayer;
import byui.cit260.blackout.model.Scene;
import byui.cit260.blackout.model.SceneType;

/**
 *
 * @author Matthew
 */
public class MapControl {

    //public static Map map;
    
    static Map createMap() {
       Map map = new Map(5, 5);
        
        Scene[] scenes = createScenes();
        
        GameControl.assignScenesToLocations(map, scenes);
        
        //System.out.println("\n***creatMap()***");
        
        return map;
    }

    private static Scene[] createScenes() {
        
        Scene[] scenes = new Scene[SceneType.values().length];
        
//        subway,
//    appartment,
//    street,
//    pharmacy,
//    hospital
        
        Scene subwayOne = new Scene();
        subwayOne.setDescription("Crummy old subway where there was a crash Car One");
        subwayOne.setMapSymbol(";)");
        subwayOne.setNonPlayer(NonPlayer.Thug1);
        subwayOne.setNumberItems(2);
        //update ascii art  here
        
        subwayOne.setArtForScreen(" " 
        + "\n  ~~~~ ____   |~~~~~~~~~~~~~|"
        + "\nY_,___|[]|   | Subway Car   |"
        + "\n{|_|_|_|PU|_,_|_____________|"
       +" \n//oo---OO=OO     OOO     OOO"
                );
        
        scenes[SceneType.subwayOne.ordinal()] = subwayOne;
        
        
        
        Scene subwayTwo = new Scene();
        subwayTwo.setDescription("Crummy old subway where there was a crash Car Two");
        subwayTwo.setMapSymbol(";)");
        subwayTwo.setNonPlayer(NonPlayer.Thug1);
        subwayTwo.setNumberItems(2);
        subwayTwo.setArtForScreen(" " 
        + "\n  ~~~~ ____   |~~~~~~~~~~~~~|"
        + "\nY_,___|[]|   | Subway Car   |"
        + "\n{|_|_|_|PU|_,_|_____________|"
       +" \n//oo---OO=OO     OOO     OOO"
                );
        scenes[SceneType.subwayTwo.ordinal()] = subwayTwo;
        
        Scene subwayThree = new Scene();
        subwayThree.setDescription("Crummy old subway where there was a crash Car Three");
        subwayThree.setMapSymbol(";)");
        subwayThree.setNonPlayer(NonPlayer.Thug1);
        subwayThree.setNumberItems(2);
        subwayThree.setArtForScreen(" " 
        + "\n  ~~~~ ____   |~~~~~~~~~~~~~|"
        + "\nY_,___|[]|   | Subway Car   |"
        + "\n{|_|_|_|PU|_,_|_____________|"
       +" \n//oo---OO=OO     OOO     OOO"
                );
        scenes[SceneType.subwayThree.ordinal()] = subwayThree;
        
        Scene subwayFour = new Scene();
        subwayFour.setDescription("Crummy old subway where there was a crash Car Four");
        subwayFour.setMapSymbol(";)");
        subwayFour.setNonPlayer(NonPlayer.Thug1);
        subwayFour.setNumberItems(2);
        subwayFour.setArtForScreen(" " 
        + "\n  ~~~~ ____   |~~~~~~~~~~~~~|"
        + "\nY_,___|[]|   | Subway Car   |"
        + "\n{|_|_|_|PU|_,_|_____________|"
       +" \n//oo---OO=OO     OOO     OOO"
                );
        scenes[SceneType.subwayFour.ordinal()] = subwayFour;
        
        Scene subwayFive = new Scene();
        subwayFive.setDescription("Crummy old subway where there was a crash Car Five");
        subwayFive.setMapSymbol(";)");
        subwayFive.setNonPlayer(NonPlayer.Thug1);
        subwayFive.setNumberItems(2);
        subwayFive.setArtForScreen(" " 
        + "\n  ~~~~ ____   |~~~~~~~~~~~~~|"
        + "\nY_,___|[]|   | Subway Car   |"
        + "\n{|_|_|_|PU|_,_|_____________|"
       +" \n//oo---OO=OO     OOO     OOO"
                );
        scenes[SceneType.subwayFive.ordinal()] = subwayFive;
        
        
        Scene apartmentOne = new Scene();
        apartmentOne.setDescription("Billy Redneck Suites Room One");
        apartmentOne.setMapSymbol(";(");
        apartmentOne.setNonPlayer(NonPlayer.PoliceManJoe);
        apartmentOne.setNumberItems(1);
        
        apartmentOne.setArtForScreen(
"    /\\  ____\n" +
"    <> ( oo )\n" +
"    <>_| ^^ |_\n" +
"    <>   @    \\\n" +
"   /~~\\ . . _ |\n" +
"  /~~~~\\    | |\n" +
" /~~~~~~\\/ _| |\n" +
" |[][][]/ / [m]\n" +
" |[][][[m]\n" +
" |[][][]|\n" +
" |[][][]|\n" +
" |[][][]|\n" +
" |[|--|]|\n" +
" |[|  |]|\n" +
" ========\n" +
"==========\n" +
"|[[    ]]|\n" +
"========== " 
 );
        
        scenes[SceneType.apartmentOne.ordinal()] = apartmentOne;
        
        Scene apartmentTwo = new Scene();
        apartmentTwo.setDescription("Billy Redneck Suites Room Two");
        apartmentTwo.setMapSymbol(";(");
        apartmentTwo.setNonPlayer(NonPlayer.PoliceManJoe);
        apartmentTwo.setNumberItems(1);
        apartmentTwo.setArtForScreen(
"    /\\  ____\n" +
"    <> ( oo )\n" +
"    <>_| ^^ |_\n" +
"    <>   @    \\\n" +
"   /~~\\ . . _ |\n" +
"  /~~~~\\    | |\n" +
" /~~~~~~\\/ _| |\n" +
" |[][][]/ / [m]\n" +
" |[][][[m]\n" +
" |[][][]|\n" +
" |[][][]|\n" +
" |[][][]|\n" +
" |[|--|]|\n" +
" |[|  |]|\n" +
" ========\n" +
"==========\n" +
"|[[    ]]|\n" +
"========== " 
 );
        scenes[SceneType.apartmentTwo.ordinal()] = apartmentTwo;
        
        Scene apartmentThree = new Scene();
        apartmentThree.setDescription("Billy Redneck Suites Room Three");
        apartmentThree.setMapSymbol(";(");
        apartmentThree.setNonPlayer(NonPlayer.PoliceManJoe);
        apartmentThree.setNumberItems(1);
        apartmentThree.setArtForScreen(
"    /\\  ____\n" +
"    <> ( oo )\n" +
"    <>_| ^^ |_\n" +
"    <>   @    \\\n" +
"   /~~\\ . . _ |\n" +
"  /~~~~\\    | |\n" +
" /~~~~~~\\/ _| |\n" +
" |[][][]/ / [m]\n" +
" |[][][[m]\n" +
" |[][][]|\n" +
" |[][][]|\n" +
" |[][][]|\n" +
" |[|--|]|\n" +
" |[|  |]|\n" +
" ========\n" +
"==========\n" +
"|[[    ]]|\n" +
"========== " 
 );
        scenes[SceneType.apartmentThree.ordinal()] = apartmentThree;
        
        Scene apartmentFour = new Scene();
        apartmentFour.setDescription("Billy Redneck Suites Room Four");
        apartmentFour.setMapSymbol(";(");
        apartmentFour.setNonPlayer(NonPlayer.PoliceManJoe);
        apartmentFour.setNumberItems(1);
        apartmentFour.setArtForScreen(
"    /\\  ____\n" +
"    <> ( oo )\n" +
"    <>_| ^^ |_\n" +
"    <>   @    \\\n" +
"   /~~\\ . . _ |\n" +
"  /~~~~\\    | |\n" +
" /~~~~~~\\/ _| |\n" +
" |[][][]/ / [m]\n" +
" |[][][[m]\n" +
" |[][][]|\n" +
" |[][][]|\n" +
" |[][][]|\n" +
" |[|--|]|\n" +
" |[|  |]|\n" +
" ========\n" +
"==========\n" +
"|[[    ]]|\n" +
"========== " 
 );
        scenes[SceneType.apartmentFour.ordinal()] = apartmentFour;
        
        Scene apartmentFive = new Scene();
        apartmentFive.setDescription("Billy Redneck Suites Room Five");
        apartmentFive.setMapSymbol(";(");
        apartmentFive.setNonPlayer(NonPlayer.PoliceManJoe);
        apartmentFive.setNumberItems(1);
        apartmentFive.setArtForScreen(
"    /\\  ____\n" +
"    <> ( oo )\n" +
"    <>_| ^^ |_\n" +
"    <>   @    \\\n" +
"   /~~\\ . . _ |\n" +
"  /~~~~\\    | |\n" +
" /~~~~~~\\/ _| |\n" +
" |[][][]/ / [m]\n" +
" |[][][[m]\n" +
" |[][][]|\n" +
" |[][][]|\n" +
" |[][][]|\n" +
" |[|--|]|\n" +
" |[|  |]|\n" +
" ========\n" +
"==========\n" +
"|[[    ]]|\n" +
"========== " 
 );
        scenes[SceneType.apartmentFive.ordinal()] = apartmentFive;
        
        
        
        Scene streetOne = new Scene();
        streetOne.setDescription("Street One");
        streetOne.setMapSymbol(";0");
        streetOne.setNonPlayer(NonPlayer.Thug3);
        streetOne.setNumberItems(1);
        streetOne.setArtForScreen(
        "________/\"\"||\"\"\"\"\"\"\"\"\"\"\"\"\"|_________/\"\"||\"\"\"\"\"\"\"\"\"\"\"\"\"|_________/\"\"||\"\"\"\"\"\"\"\"\"\n" +
        ".._/\"\\_, |  ||_____________| ._/\"\\_, |  ||_____________| ._/\"\\_, |  ||_________\n" +
        "\"o---o\" 'O--OO       OO OO  \"o---o\" 'O--OO       OO OO  \"o---o\" 'O--OO       O\n" +
        "\"\"\"\"\\,   .__/\"\"\\__,   .__/\"\"\"\"\"\\,   .__/\"\"\\__,   .__/\"\"\"\"\"\\,   .__/\"\"\\__,   ._\n" +
        "---()\"   \"()----()\"   \"()-----()\"   \"()----()\"   \"()-----()\"   \"()----()\"   \"(\n" +
        "\\                 /\"\"\"T\"\"\"\\                 /\"\"\"T\"\"\"\\                 /\"\"\"T\"\"\"\n" +
        "_>---\\       ,---<____|____>---\\       ,---<____|____>---\\       ,---<____|___\n" +
        "-/\"\\ {      / /\"\\    -|   -/\"\\ {      / /\"\\    -|   -/\"\\ {      / /\"\\    -|\n" +
        "-\\_/-=      =-\\_/-----+----\\_/-=      =-\\_/-----+----\\_/-=      =-\\_/-----+---\n" +
        "______________________________________________________________________________");
        scenes[SceneType.streetOne.ordinal()] = streetOne;
        
        Scene streetTwo = new Scene();
        streetTwo.setDescription("Street Two");
        streetTwo.setMapSymbol(";0");
        streetTwo.setNonPlayer(NonPlayer.Thug3);
        streetTwo.setNumberItems(1);
        streetTwo.setArtForScreen(
        "________/\"\"||\"\"\"\"\"\"\"\"\"\"\"\"\"|_________/\"\"||\"\"\"\"\"\"\"\"\"\"\"\"\"|_________/\"\"||\"\"\"\"\"\"\"\"\"\n" +
        ".._/\"\\_, |  ||_____________| ._/\"\\_, |  ||_____________| ._/\"\\_, |  ||_________\n" +
        "\"o---o\" 'O--OO       OO OO  \"o---o\" 'O--OO       OO OO  \"o---o\" 'O--OO       O\n" +
        "\"\"\"\"\\,   .__/\"\"\\__,   .__/\"\"\"\"\"\\,   .__/\"\"\\__,   .__/\"\"\"\"\"\\,   .__/\"\"\\__,   ._\n" +
        "---()\"   \"()----()\"   \"()-----()\"   \"()----()\"   \"()-----()\"   \"()----()\"   \"(\n" +
        "\\                 /\"\"\"T\"\"\"\\                 /\"\"\"T\"\"\"\\                 /\"\"\"T\"\"\"\n" +
        "_>---\\       ,---<____|____>---\\       ,---<____|____>---\\       ,---<____|___\n" +
        "-/\"\\ {      / /\"\\    -|   -/\"\\ {      / /\"\\    -|   -/\"\\ {      / /\"\\    -|\n" +
        "-\\_/-=      =-\\_/-----+----\\_/-=      =-\\_/-----+----\\_/-=      =-\\_/-----+---\n" +
        "______________________________________________________________________________");
        scenes[SceneType.streetTwo.ordinal()] = streetTwo;
        
        Scene streetThree = new Scene();
        streetThree.setDescription("Street Three");
        streetThree.setMapSymbol(";0");
        streetThree.setNonPlayer(NonPlayer.Thug3);
        streetThree.setNumberItems(1);
        streetThree.setArtForScreen(
        "________/\"\"||\"\"\"\"\"\"\"\"\"\"\"\"\"|_________/\"\"||\"\"\"\"\"\"\"\"\"\"\"\"\"|_________/\"\"||\"\"\"\"\"\"\"\"\"\n" +
        ".._/\"\\_, |  ||_____________| ._/\"\\_, |  ||_____________| ._/\"\\_, |  ||_________\n" +
        "\"o---o\" 'O--OO       OO OO  \"o---o\" 'O--OO       OO OO  \"o---o\" 'O--OO       O\n" +
        "\"\"\"\"\\,   .__/\"\"\\__,   .__/\"\"\"\"\"\\,   .__/\"\"\\__,   .__/\"\"\"\"\"\\,   .__/\"\"\\__,   ._\n" +
        "---()\"   \"()----()\"   \"()-----()\"   \"()----()\"   \"()-----()\"   \"()----()\"   \"(\n" +
        "\\                 /\"\"\"T\"\"\"\\                 /\"\"\"T\"\"\"\\                 /\"\"\"T\"\"\"\n" +
        "_>---\\       ,---<____|____>---\\       ,---<____|____>---\\       ,---<____|___\n" +
        "-/\"\\ {      / /\"\\    -|   -/\"\\ {      / /\"\\    -|   -/\"\\ {      / /\"\\    -|\n" +
        "-\\_/-=      =-\\_/-----+----\\_/-=      =-\\_/-----+----\\_/-=      =-\\_/-----+---\n" +
        "______________________________________________________________________________");
        scenes[SceneType.streetThree.ordinal()] = streetThree;
        
        Scene streetFour = new Scene();
        streetFour.setDescription("Street Four");
        streetFour.setMapSymbol(";0");
        streetFour.setNonPlayer(NonPlayer.Thug3);
        streetFour.setNumberItems(1);
        streetFour.setArtForScreen(
        "________/\"\"||\"\"\"\"\"\"\"\"\"\"\"\"\"|_________/\"\"||\"\"\"\"\"\"\"\"\"\"\"\"\"|_________/\"\"||\"\"\"\"\"\"\"\"\"\n" +
        ".._/\"\\_, |  ||_____________| ._/\"\\_, |  ||_____________| ._/\"\\_, |  ||_________\n" +
        "\"o---o\" 'O--OO       OO OO  \"o---o\" 'O--OO       OO OO  \"o---o\" 'O--OO       O\n" +
        "\"\"\"\"\\,   .__/\"\"\\__,   .__/\"\"\"\"\"\\,   .__/\"\"\\__,   .__/\"\"\"\"\"\\,   .__/\"\"\\__,   ._\n" +
        "---()\"   \"()----()\"   \"()-----()\"   \"()----()\"   \"()-----()\"   \"()----()\"   \"(\n" +
        "\\                 /\"\"\"T\"\"\"\\                 /\"\"\"T\"\"\"\\                 /\"\"\"T\"\"\"\n" +
        "_>---\\       ,---<____|____>---\\       ,---<____|____>---\\       ,---<____|___\n" +
        "-/\"\\ {      / /\"\\    -|   -/\"\\ {      / /\"\\    -|   -/\"\\ {      / /\"\\    -|\n" +
        "-\\_/-=      =-\\_/-----+----\\_/-=      =-\\_/-----+----\\_/-=      =-\\_/-----+---\n" +
        "______________________________________________________________________________");
        scenes[SceneType.streetFour.ordinal()] = streetFour;
        
        Scene streetFive = new Scene();
        streetFive.setDescription("Street Five");
        streetFive.setMapSymbol(";0");
        streetFive.setNonPlayer(NonPlayer.Thug3);
        streetFive.setNumberItems(1);
        streetFive.setArtForScreen(
        "________/\"\"||\"\"\"\"\"\"\"\"\"\"\"\"\"|_________/\"\"||\"\"\"\"\"\"\"\"\"\"\"\"\"|_________/\"\"||\"\"\"\"\"\"\"\"\"\n" +
        ".._/\"\\_, |  ||_____________| ._/\"\\_, |  ||_____________| ._/\"\\_, |  ||_________\n" +
        "\"o---o\" 'O--OO       OO OO  \"o---o\" 'O--OO       OO OO  \"o---o\" 'O--OO       O\n" +
        "\"\"\"\"\\,   .__/\"\"\\__,   .__/\"\"\"\"\"\\,   .__/\"\"\\__,   .__/\"\"\"\"\"\\,   .__/\"\"\\__,   ._\n" +
        "---()\"   \"()----()\"   \"()-----()\"   \"()----()\"   \"()-----()\"   \"()----()\"   \"(\n" +
        "\\                 /\"\"\"T\"\"\"\\                 /\"\"\"T\"\"\"\\                 /\"\"\"T\"\"\"\n" +
        "_>---\\       ,---<____|____>---\\       ,---<____|____>---\\       ,---<____|___\n" +
        "-/\"\\ {      / /\"\\    -|   -/\"\\ {      / /\"\\    -|   -/\"\\ {      / /\"\\    -|\n" +
        "-\\_/-=      =-\\_/-----+----\\_/-=      =-\\_/-----+----\\_/-=      =-\\_/-----+---\n" +
        "______________________________________________________________________________");
        scenes[SceneType.streetFive.ordinal()] = streetFive;
        
        
        Scene pharmacyOne = new Scene();
        pharmacyOne.setDescription("Old Joe's Drugs Front Door");
        pharmacyOne.setMapSymbol(";P");
        pharmacyOne.setNonPlayer(NonPlayer.Thug2);
        pharmacyOne.setNumberItems(0);
        pharmacyOne.setArtForScreen("                    _..._                  \n" +
" hjm               //''\\\\\\                 \n" +
"                   ||. .||                 \n" +
"                   |\\ _ /|      (          \n" +
"                  .-/\\ /\\-.     )   |      \n" +
"                 |  ` \\ '  |    _   |      \n" +
"           (     | |  |  | |    H=--+-     \n" +
"           ))    | |__|[ | |    U   |      \n" +
"           __    \\___(_3/ /     )   |      \n" +
"-|_H_H_|---||---------|!|/------|---|---.  \n" +
" |_U_U_|  /__\\        |_|      _[_ _|__  \\ \n" +
"------------------------------------------`");
        scenes[SceneType.pharmacyOne.ordinal()] = pharmacyOne;
        
        Scene pharmacyTwo = new Scene();
        pharmacyTwo.setDescription("Old Joe's Drugs Check Stand One");
        pharmacyTwo.setMapSymbol(";P");
        pharmacyTwo.setNonPlayer(NonPlayer.Thug2);
        pharmacyTwo.setNumberItems(0);
        pharmacyTwo.setArtForScreen("                    _..._                  \n" +
" hjm               //''\\\\\\                 \n" +
"                   ||. .||                 \n" +
"                   |\\ _ /|      (          \n" +
"                  .-/\\ /\\-.     )   |      \n" +
"                 |  ` \\ '  |    _   |      \n" +
"           (     | |  |  | |    H=--+-     \n" +
"           ))    | |__|[ | |    U   |      \n" +
"           __    \\___(_3/ /     )   |      \n" +
"-|_H_H_|---||---------|!|/------|---|---.  \n" +
" |_U_U_|  /__\\        |_|      _[_ _|__  \\ \n" +
"------------------------------------------`");
        scenes[SceneType.pharmacyTwo.ordinal()] = pharmacyTwo;
        
        Scene pharmacyThree = new Scene();
        pharmacyThree.setDescription("Old Joe's Drugs Three Check Stand Two");
        pharmacyThree.setMapSymbol(";P");
        pharmacyThree.setNonPlayer(NonPlayer.Thug2);
        pharmacyThree.setNumberItems(0);
        pharmacyThree.setArtForScreen("                    _..._                  \n" +
" hjm               //''\\\\\\                 \n" +
"                   ||. .||                 \n" +
"                   |\\ _ /|      (          \n" +
"                  .-/\\ /\\-.     )   |      \n" +
"                 |  ` \\ '  |    _   |      \n" +
"           (     | |  |  | |    H=--+-     \n" +
"           ))    | |__|[ | |    U   |      \n" +
"           __    \\___(_3/ /     )   |      \n" +
"-|_H_H_|---||---------|!|/------|---|---.  \n" +
" |_U_U_|  /__\\        |_|      _[_ _|__  \\ \n" +
"------------------------------------------`");
        scenes[SceneType.pharmacyThree.ordinal()] = pharmacyThree;
        
        Scene pharmacyFour = new Scene();
        pharmacyFour.setDescription("Old Joe's Drugs Back Door");
        pharmacyFour.setMapSymbol(";P");
        pharmacyFour.setNonPlayer(NonPlayer.Thug2);
        pharmacyFour.setNumberItems(0);
        pharmacyFour.setArtForScreen("                    _..._                  \n" +
" hjm               //''\\\\\\                 \n" +
"                   ||. .||                 \n" +
"                   |\\ _ /|      (          \n" +
"                  .-/\\ /\\-.     )   |      \n" +
"                 |  ` \\ '  |    _   |      \n" +
"           (     | |  |  | |    H=--+-     \n" +
"           ))    | |__|[ | |    U   |      \n" +
"           __    \\___(_3/ /     )   |      \n" +
"-|_H_H_|---||---------|!|/------|---|---.  \n" +
" |_U_U_|  /__\\        |_|      _[_ _|__  \\ \n" +
"------------------------------------------`");
        scenes[SceneType.pharmacyFour.ordinal()] = pharmacyFour;
        
        Scene pharmacyFive = new Scene();
        pharmacyFive.setDescription("Old Joe's Drugs Restroom");
        pharmacyFive.setMapSymbol(";P");
        pharmacyFive.setNonPlayer(NonPlayer.Thug2);
        pharmacyFive.setNumberItems(0);
        pharmacyFive.setArtForScreen("                    _..._                  \n" +
" hjm               //''\\\\\\                 \n" +
"                   ||. .||                 \n" +
"                   |\\ _ /|      (          \n" +
"                  .-/\\ /\\-.     )   |      \n" +
"                 |  ` \\ '  |    _   |      \n" +
"           (     | |  |  | |    H=--+-     \n" +
"           ))    | |__|[ | |    U   |      \n" +
"           __    \\___(_3/ /     )   |      \n" +
"-|_H_H_|---||---------|!|/------|---|---.  \n" +
" |_U_U_|  /__\\        |_|      _[_ _|__  \\ \n" +
"------------------------------------------`");
        scenes[SceneType.pharmacyFive.ordinal()] = pharmacyFive;
        
        Scene hospitalOne = new Scene();
        hospitalOne.setDescription("St. Granny Crack Memorial Hospital Front Door");
        hospitalOne.setMapSymbol(";X");
        hospitalOne.setNonPlayer(NonPlayer.PoliceManJoe);
        hospitalOne.setNumberItems(1);
        hospitalOne.setArtForScreen("   \\\\\\\\\n" +
"   c  oo\n" +
"    | .U\n" +
"   __=__                        ,,,   \n" +
"  |.  __|___                    oo ; \n" +
"  ||_/  /  /                    U= _  0\n" +
"  \\_/__/__E   o                 /. .| |\n" +
"   (___ ||    |~~~~~~~~~~~~~~~~'----'~|\n" +
"   I---|||    |-----------------------|\n" +
"   I   |||    |       c(__)           |\n" +
"   ^   '--''  ^                       ^");
        scenes[SceneType.hospitalOne.ordinal()] = hospitalOne;
        
        Scene hospitalTwo = new Scene();
        hospitalTwo.setDescription("St. Granny Crack Memorial Hospital Room One");
        hospitalTwo.setMapSymbol(";X");
        hospitalTwo.setNonPlayer(NonPlayer.PoliceManJoe);
        hospitalTwo.setNumberItems(1);
        hospitalTwo.setArtForScreen("   \\\\\\\\\n" +
"   c  oo\n" +
"    | .U\n" +
"   __=__                        ,,,   \n" +
"  |.  __|___                    oo ; \n" +
"  ||_/  /  /                    U= _  0\n" +
"  \\_/__/__E   o                 /. .| |\n" +
"   (___ ||    |~~~~~~~~~~~~~~~~'----'~|\n" +
"   I---|||    |-----------------------|\n" +
"   I   |||    |       c(__)           |\n" +
"   ^   '--''  ^                       ^");
        scenes[SceneType.hospitalTwo.ordinal()] = hospitalTwo;
        
        Scene hospitalThree = new Scene();
        hospitalThree.setDescription("St. Granny Crack Memorial Hospital  Room Two");
        hospitalThree.setMapSymbol(";X");
        hospitalThree.setNonPlayer(NonPlayer.PoliceManJoe);
        hospitalThree.setNumberItems(1);
        hospitalThree.setArtForScreen("   \\\\\\\\\n" +
"   c  oo\n" +
"    | .U\n" +
"   __=__                        ,,,   \n" +
"  |.  __|___                    oo ; \n" +
"  ||_/  /  /                    U= _  0\n" +
"  \\_/__/__E   o                 /. .| |\n" +
"   (___ ||    |~~~~~~~~~~~~~~~~'----'~|\n" +
"   I---|||    |-----------------------|\n" +
"   I   |||    |       c(__)           |\n" +
"   ^   '--''  ^                       ^");
        scenes[SceneType.hospitalThree.ordinal()] = hospitalThree;
        
        Scene hospitalFour = new Scene();
        hospitalFour.setDescription("St. Granny Crack Memorial Room Three");
        hospitalFour.setMapSymbol(";X");
        hospitalFour.setNonPlayer(NonPlayer.PoliceManJoe);
        hospitalFour.setNumberItems(1);
        hospitalFour.setArtForScreen("   \\\\\\\\\n" +
"   c  oo\n" +
"    | .U\n" +
"   __=__                        ,,,   \n" +
"  |.  __|___                    oo ; \n" +
"  ||_/  /  /                    U= _  0\n" +
"  \\_/__/__E   o                 /. .| |\n" +
"   (___ ||    |~~~~~~~~~~~~~~~~'----'~|\n" +
"   I---|||    |-----------------------|\n" +
"   I   |||    |       c(__)           |\n" +
"   ^   '--''  ^                       ^");
        scenes[SceneType.hospitalFour.ordinal()] = hospitalFour;
        
        Scene hospitalFive = new Scene();
        hospitalFive.setDescription("St. Granny Crack Memorial Parking Lot");
        hospitalFive.setMapSymbol(";X");
        hospitalFive.setNonPlayer(NonPlayer.PoliceManJoe);
        hospitalFive.setNumberItems(1);
        hospitalFive.setArtForScreen("   \\\\\\\\\n" +
"   c  oo\n" +
"    | .U\n" +
"   __=__                        ,,,   \n" +
"  |.  __|___                    oo ; \n" +
"  ||_/  /  /                    U= _  0\n" +
"  \\_/__/__E   o                 /. .| |\n" +
"   (___ ||    |~~~~~~~~~~~~~~~~'----'~|\n" +
"   I---|||    |-----------------------|\n" +
"   I   |||    |       c(__)           |\n" +
"   ^   '--''  ^                       ^");
        scenes[SceneType.hospitalFive.ordinal()] = hospitalFive;
        
        return scenes;
        
        
    
    }
    
    public static void movePlayerToStartingLocation(Map map) {
     // If starting location is not supposed to be 0,0 then use the correct values here.
        movePlayer(map, 0, 0);
    }


    public static void movePlayer(Map map, int row, int column) {
        map.setCurrentLocation(map.getLocations()[row][column]);
        map.getCurrentLocation().setVisited(true);
        map.setCurrentRow(row);
        map.setCurrentColumn(column);
        
        //update the number of moves left
        int movesLeft = Blackout.getCurrentGame().getNumberMovesLeft();
        movesLeft--;
        
        if(movesLeft < 0){
            //game over
        } else {
            Blackout.getCurrentGame().setNumberMovesLeft(movesLeft);
        }

    }
    
}
