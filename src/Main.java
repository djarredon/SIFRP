/**
 * Created by arredon on 3/7/2016.
 */
import com.sun.corba.se.impl.orbutil.graph.Graph;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
    public static Random rand = new Random();

    public static void main(String [] args) {
        System.out.println("\n\n");
        Dice die = new Dice();
        Data data = new Data();

        runScreen();

        String input ="\n" +
                "        acrobaticsMinus.addActionListener(new ActionListener() {\n" +
                "            @Override\n" +
                "            public void actionPerformed(ActionEvent e) {\n" +
                "                character.decreaseAcrobatics();\n" +
                "                characterSpecialtyAssignment(house, character);\n" +
                "            }\n" +
                "        });\n" +
                "\n" +
                "        acrobaticsPlus.addActionListener(new ActionListener() {\n" +
                "            @Override\n" +
                "            public void actionPerformed(ActionEvent e) {\n" +
                "                character.increaseAcrobatics();\n" +
                "                characterSpecialtyAssignment(house, character);\n" +
                "            }\n" +
                "        });\n";
        String from = "";
        String to = "";

        //System.out.println(stringReplace(input, from, to));
        //System.out.println(replaceAbilities(input));
        //System.out.println(replaceSpecialties(input));

    }

    public static void runScreen() {
        int xmax = 1000;
        int ymax = 1000;


        Screen screen = new Screen("SIFRP", xmax, ymax);
        screen.setVisible(true);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static String replaceSpecialties(String input) {
        if (input == null || input.length() < 5)
            return input;

        //String  = input;

        //assume already contains "acrobatics"
        String toReturn = input.concat(stringReplace(input, "acrobatics", "balance"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "contortions"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "dodge"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "quickness"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "charmAnimal"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "drive"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "ride"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "train"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "climb"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "jump"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "run"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "strength"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "swim"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "throw"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "empathy"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "notice"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "decipher"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "logic"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "memory"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "act"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "bluff"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "cheat"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "disguise"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "resilience"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "stamina"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "axes"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "bludgeons"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "brawling"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "fencing"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "longblades"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "polearms"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "shields"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "shortblades"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "spears"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "diagnose"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "treatAilment"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "treatInjury"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "education"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "research"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "streetwise"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "bows"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "crossbows"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "siege"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "thrown"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "bargain"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "charm"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "convince"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "incite"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "intimidate"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "seduce"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "taunt"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "breeding"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "reputation"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "stewardship"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "tournaments"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "blendIn"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "sneak"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "forage"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "hunt"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "orientation"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "track"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "pickLock"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "sleightOfHand"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "steal"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "command"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "strategy"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "tactics"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "courage"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "coordinate"));
        toReturn = toReturn.concat(stringReplace(input, "acrobatics", "dedication"));

        return toReturn;
    }

    public static String replaceAbilities(String input) {
        if (input == null || input.length() < 5)
            return input;

        //String  = input;

        //assume already contains "agility"
        String toReturn = input.concat(stringReplace(input, "agility", "animalHandling"));
        toReturn = toReturn.concat(stringReplace(input, "agility", "athletics"));
        toReturn = toReturn.concat(stringReplace(input, "agility", "awareness"));
        toReturn = toReturn.concat(stringReplace(input, "agility", "cunning"));
        toReturn = toReturn.concat(stringReplace(input, "agility", "deception"));
        toReturn = toReturn.concat(stringReplace(input, "agility", "endurance"));
        toReturn = toReturn.concat(stringReplace(input, "agility", "fighting"));
        toReturn = toReturn.concat(stringReplace(input, "agility", "healing"));
        toReturn = toReturn.concat(stringReplace(input, "agility", "knowledge"));
        toReturn = toReturn.concat(stringReplace(input, "agility", "language"));
        toReturn = toReturn.concat(stringReplace(input, "agility", "marksmanship"));
        toReturn = toReturn.concat(stringReplace(input, "agility", "persuasion"));
        toReturn = toReturn.concat(stringReplace(input, "agility", "status"));
        toReturn = toReturn.concat(stringReplace(input, "agility", "stealth"));
        toReturn = toReturn.concat(stringReplace(input, "agility", "survival"));
        toReturn = toReturn.concat(stringReplace(input, "agility", "thievery"));
        toReturn = toReturn.concat(stringReplace(input, "agility", "warfare"));
        toReturn = toReturn.concat(stringReplace(input, "agility", "will"));


        return toReturn;
    }

    public static String stringReplace(String input, String from, String to) {
        //Replace Strings in "input" matching "from" with "to"
        if (input == null || input.length() <= 0 || from == null)
            return null;
        if (to == null)
            to = "";

        //first replace lowercase, then uppercase
        input = input.replaceAll(from, to);
        String temp = from.substring(0,1).toUpperCase();
        from = temp.concat(from.substring(1));
        temp = to.substring(0,1).toUpperCase();
        to = temp.concat(to.substring(1));

        input = input.replaceAll(from,to);
        return input;
    }

    public static void CharacterTest() {
        Character test = new Character();
        test.generateCharacter();
        test.displayAll();
    }

    public static void WeaponTest() {
        Character test = new Character();
        test.generateCharacter();

        Weapon weapon = new Weapon("Battleaxe");
        test.giveWeapon(weapon);
        test.giveOffHand(new Weapon("Buckler"));
        Armor armor = new Armor();
        armor.randArmor();
        test.giveArmor(armor);
        test.displayAll();
    }

    public static void HouseTest() {
        House test = new House();
        test.generateRandHouse();
        test.displayAll();
    }

    public static void HouseListTest() {
        HouseNode temp;
        HouseList list = new HouseList();
        for (int i = 0; i < 10; ++i) {
            temp = new HouseNode();
            temp.generateRandHouse();
            list.insert(temp);
        }

        list.display();
    }

}

