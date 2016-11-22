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
                "        accurateScroll.revalidate();";
        String from = "";
        String to = "";

        //CharacterTest();
        //benefitListTest();

        //System.out.println(replaceBenefits(input));
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

    public static void benefitListTest() {
        BenefitList list = new BenefitList();
        Benefit temp = new Benefit();

        list.insert(temp.ArmorMastery());
        list.insert(temp.Artist());
        list.insert(temp.Wealthy());
        list.insert(temp.Dutiful());
        list.insert(temp.Wealthy());

        System.out.println(list.print());
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

    public static String replaceBenefits(String input) {
        if (input == null || input.length() < 5)
            return input;

        String toReturn = input.concat(stringReplace(input, "Accurate", "AcrobaticDefense"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "AdeptNegotiator"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "AnimalCohort"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Anointed"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "ArmorMastery"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Artist"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Attractive"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Authority"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "AxeFighterI"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "AxeFighterII"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "AxeFighterIII"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Beastfriend"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Berserker"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "BloodOfHeroes"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "BloodOfTheAndals"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "BloodOfTheFirstMen"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "BloodOfTheIronmen"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "BloodOfTheRhoyne"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "BloodOfTheWildlings"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "BloodOfValyria"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "BludgeonFighterI"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "BludgeonFighterII"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "BludgeonFighterIII"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "BraavosiFighterI"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "BraavosiFighterII"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "BraavosiFighterIII"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "BrawlerI"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "BrawlerII"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "BrawlerIII"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "BrotherOfTheNightsWatch"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Cadre"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "CautiousDiplomat"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Charismatic"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Cohort"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Compelling"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Connections"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Courteous"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "DangerSense"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "DeadlyShot"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "DeftHands"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Dextrous"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "DoubleShot"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Dutiful"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "EideticMemory"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Eloquent"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Evaluation"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Expertise"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "FaceInTheCrowd"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Famous"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Fast"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "FavoredOfNobles"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "FavoredOfSmallfolk"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Furtive"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Fury"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "GiftedAthleteClimb"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "GiftedAthleteJump"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "GiftedAthleteRun"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "GiftedAthleteStrength"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "GiftedAthleteSwim"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "GiftedAthleteThrow"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "GiftedTeacher"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "GreatHunter"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Greensight"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Guttersnipe"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "HailOfSteel"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Hardy"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "HeadForNumbers"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "HeadOfHouse"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Heir"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Heirloom"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "ImprovedArmorMastery"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "ImprovedWeaponMastery"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Inspiring"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "KeenSenses"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "KnowledgeFocusAlchemy"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "KnowledgeFocusArchitecture"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "KnowledgeFocusAstronomy"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "KnowledgeFocusGeography"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "KnowledgeFocusHeraldry"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "KnowledgeFocusHistory"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "KnowledgeFocusLegends"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "KnowledgeFocusMagic"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "KnowledgeFocusNature"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "KnowledgeFocusReligion"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "KnowledgeFocusUnderworld"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Landed"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "LeaderOfMen"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "LongBladeFighterI"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "LongBladeFighterII"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "LongBladeFighterIII"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Lucky"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Maester"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Magnetic"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "ManOfTheKingsguard"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Massive"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "MasterOfRavens"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "MiracleWorker"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Mummer"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "NightEyes"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Pious"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "PolearmFighterI"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "PolearmFighterII"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "PolearmFighterIII"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Polyglot"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Respected"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "ShieldMastery"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "ShortBladeFighterI"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "ShortBladeFighterII"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "ShortBladeFighterIII"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Sinister"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Skinchanger"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "SpearFighterI"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "SpearFighterII"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "SpearFighterIII"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Sponsor"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Stubborn"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Talented"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "TerrainSpecialist"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Tough"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "TourneyKnight"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Trade"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Treacherous"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "TripleShot"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Warg"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "WargDreams"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "WaterDancerI"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "WaterDancerII"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "WaterDancerIII"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Wealthy"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "WeaponMastery"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "WeaponSavant"));
        toReturn = toReturn.concat(stringReplace(input, "Accurate", "Worldly"));

        return toReturn;
    }

    public static String stringReplace(String input, String from, String to) {
        //Replace Strings in "input" matching "from" with "to"
        if (input == null || input.length() <= 0 || from == null)
            return null;
        if (to == null)
            to = "";

        //first replace lowercase, then uppercase
        //lower
        input = input.replaceAll(from, to);

        //upper
        String temp = from.substring(0,1).toLowerCase();
        from = temp.concat(from.substring(1));
        temp = to.substring(0,1).toUpperCase();
        to = temp.concat(to.substring(1));

        input = input.replaceAll(from,to);
        return input;
    }

    public static void CharacterTest() {
        Character test = new Character();
        Benefit temp = new Benefit();
        test.generateCharacter();

        test.addBenefit(temp.ArmorMastery());
        test.addBenefit(temp.Artist());
        test.addBenefit(temp.Wealthy());
        test.addBenefit(temp.Dutiful());
        test.addBenefit(temp.Wealthy());

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

