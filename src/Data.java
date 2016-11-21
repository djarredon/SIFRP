import java.util.Random;

/**
 * Created by arredon on 9/29/2016.
 */
public class Data {
    //This class contains all of the data (Strings and stuff) used
    //by the program

    public String getAge(int age) {
        //assign age name
        switch (age) {
            case 1:
                return "Ancient";
            case 2:
                return  "Very Old";
            case 3:
                return  "Old";
            case 4:
                return  "Established";
            case 5:
                return  "Recent";
            case 6:
                return  "New";
            default:
                return ("Invalid");
        }
    }

    public String getDefenseHoldingDescription(int type) {
        switch (type) {
            case 1: return "A superior castle is a massive stronghold in the vein of Harrenhal, the\n" +
                    "\t\t\tEyrie, Storm’s End, Dragonstone, and Winterfell. A superior castle has\n" +
                    "\t\t\tseveral towers, structures, and smaller buildings, all surrounded by a\n" +
                    "\t\t\tsteep curtain wall and likely a moat as well.";
            case 2: return "Castles are impressive fortified strongholds but are not as large or as\n" +
                    "\t\t\timposing as a superior castle. Most castles incorporate at least one\n" +
                    "\t\t\tcentral keep and several towers connected by walls and surrounded\n" +
                    "\t\t\tby a moat. Example castles include Deepwood Motte, the Twins, and\n" +
                    "\t\t\tRiverrun.";
            case 3: return "A small castle is simply a smaller version of a standard castle. It usually\n" +
                    "\t\t\thas no more than a single keep, perhaps two towers and a wall. Examples\n" +
                    "\t\t\tof small castles include Bronzegate, Honeyholt, and Yronwood.";
            case 4: return "A hall (or keep) is usually a small, fortified building. It may or may not\n" +
                    "\t\t\tbe surrounded by a wall, and it could have a tower, though it’s unlikely.\n" +
                    "\t\t\tExamples of halls include Acorn Hall, Cider Hall, and Longbow Hall.";
            case 5: return "Towers are single free-standing stone or timber structures that thrust\n" +
                    "\t\t\tup from the ground. If they have any outbuildings, they are small and\n" +
                    "\t\t\tunprotected. Petyr Baelish’s holdings in the Fingers included a single\n" +
                    "\t\t\ttower.";
            default:
                System.out.println("DEFENSE HOLDING DESCRIPTION ERROR");
                return "";
        }
    }

    public String getDefenseHoldingBenefit(int type) {
        switch (type) {
            case 1: return "Units defending a superior castle gain a +12 bonus to their Defense.";
            case 2: return "Units defending a castle gain a +8 bonus to their Defense.";
            case 3: return "Units defending a small castle gain a +6 bonus to their Defense.";
            case 4: return "Units defending a hall gain a +4 bonus to their Defense.";
            case 5: return "Units defending a tower gain a +3 bonus to their Defense.";
            default:
                System.out.println("DEFENSE HOLDING BENEFIT ERROR");
                return "";
        }
    }

    public History getHistory(int age) {
        //determine number of events
        Dice die = new Dice();
        int numEvents;
        switch (age) {
            case 1:
                numEvents = die.roll(1) + 3;
                break;
            case 2:
                numEvents = die.roll(1) + 2;
                break;
            case 3:
                numEvents = die.roll(1) + 1;
                break;
            case 4:
                numEvents = die.roll(1);
                break;
            case 5:
                numEvents = die.roll(1) -1;
                break;
            case 6:
                numEvents = die.roll(1) -2;
                break;
            default:
                numEvents = 0;
                break;
        }
        //create events
        History history = new History();
        if (numEvents < 1)
            numEvents = 1;
        for (int i = 0; i < numEvents; ++i) {
            Event temp = new Event();
            temp.createRandom();
            history.insert(temp);
        }

        return history;
    }

    public String setEventType(int event) {
        switch (event) {
            case 1: return "Ascent";
            case 2: return "Catastrophe";
            case 3: return "Conquest";
            case 4: return "Defeat";
            case 5: return "Descent";
            case 6: return "Doom";
            case 7: return "Favor";
            case 8: return "Glory";
            case 9: return "Infrastructure";
            case 10: return "Invasion/Revolt";
            case 11: return  "Madness";
            case 12: return "Scandal";
            case 13: return "Treachery";
            case 14: return "Victory";
            case 15: return "Villain";
            case 16: return "Windfall";
            default: return "Event Type Error.";
        }
    }

    public String getDefenseDefinition(int score) {
        if (score == 0)
            return "Desolate, ruined land, ravaged by disaster, war, or simply abandoned. \n" +
                    "\t\t\tNo defensible structures of any kind, and no infrastructure for\n" +
                    "\t\t\tmoving troops. You have no fortifications whatsoever.";
        if (score >= 1 && score <= 10)
            return "Scarce cultivation, mostly wilderness with a few unprotected pockets of \n" +
                    "\t\t\tcivilization, having one or two roads or a minor stronghold.";
        if (score >= 11 && score <= 20)
            return "Some cultivation, presence of a keep or smaller stronghold with a few roads, rivers, or ports.";
        if (score >= 21 && score <= 30)
            return "Defensible, with at least one fortified town or castle. Roads and trails \n" +
                    "\t\t\tare present, and rivers or ports are likely.";
        if (score >= 31 && score <= 40)
            return "Good defenses with, almost certainly, a castle, along with a few other \n" +
                    "\t\t\tstrong points. Roads and rivers provide easy transportation. Alternatively,\n" +
                    "\t\t\tnatural terrain features, such as mountains or swamps, provide additional fortification.";
        if (score >= 41 && score <= 50)
            return "Excellent defenses, with man-made fortifications likely combined with \n" +
                    "\t\t\tdefensible terrain features.";
        if (score >= 51 && score <= 60)
            return "Extraordinary defenses with structures, walls, and terrain features that, \n" +
                    "\t\t\twhen combined, make attacking this land very costly.";
        if (score >= 61 && score <= 70)
            return "Among the greatest defenses in the world. A good example would be \n" +
                    "\t\t\tthe Eyrie and the Vale of Arryn.";
        else
            return "Invalid Score";
    }

    public String getInfluenceDefinition(int score) {
        if (score == 0)
            return "The house’s name and history has been erased from all\n" +
                    "\t\t\trecords, and no one speaks of them anymore.";
        if (score >= 1 && score <= 10)
            return "Maximum Lord's Status 2. A minor landed knight or the\n" +
                    "\t\t\tequivalent. An example would be Craster.";
        if (score >= 11 && score <= 20)
            return "Maximum Lord's Status 3. A greater landed knight or the\n" +
                    "\t\t\tequivalent. A sample house would include the Knotts and Liddles of the North.";
        if (score >= 21 && score <= 30)
            return "Maximum Lord's Status 4. A small minor house. Examples\n" +
                    "\t\t\tinclude House Mormont and House Westerling.";
        if (score >= 31 && score <= 40)
            return "Maximum Lord's Status 4. A minor house. Examples\n" +
                    "\t\t\tinclude House Clegane, House Payne, and House Karstark.";
        if (score >= 41 && score <= 50)
            return "Maximum Lord's Status 5. A powerful minor house with\n" +
                    "\t\t\tcolorful history. Examples include House Florrent and House Frey.";
        if (score >= 51 && score <= 60)
            return "Maximum Lord's Status 6. A major house. Examples\n" +
                    "\t\t\tinclude House Tully and House Martell.";
        if (score >= 61 && score <= 70)
            return "Maximum Lord's Status 7. A great house. Examples\n" +
                    "\t\t\tinclude House Arryn, House Stark, House Baratheon and House Lannister.";
        else
            return "Invalid Score";
    }

    public String getLandsDefinition(int score) {
        if (score == 0)
            return "Landless, the house has been\n" +
                    "\t\t\tcompletely stripped of its holdings.";
        if (score >= 1 && score <= 10)
            return "A speck of land, no larger than a single town.";
        if (score >= 11 && score <= 20)
            return "A small stretch of land, about the size of a single small\n" +
                    "\t\t\tisland or small portion of a larger island, or a large city and\n" +
                    "\t\t\tits immediate environs, such as House Mormont.";
        if (score >= 21 && score <= 30)
            return "A modest stretch of land or\n" +
                    "\t\t\tmedium-size island, such as House Frey.";
        if (score >= 31 && score <= 40)
            return "An area of land that includes several terrain features, islands,\n" +
                    "\t\t\tor large groups of islands, House Greyjoy for example.";
        if (score >= 41 && score <= 50)
            return "A large area of land, that spreads across a great\n" +
                    "\t\t\tdistance. This area likely includes a variety of\n" +
                    "\t\t\tterrain features. House Martell’s control of Dorne\n" +
                    "\t\t\tis representative of this level of resource.";
        if (score >= 51 && score <= 60)
            return "A huge area of land representing a considerable\n" +
                    "\t\t\tportion of Westeros’ geography. House Stark’s\n" +
                    "\t\t\ttcommand of the North is a good example.";
        if (score >= 61 && score <= 70)
            return "Most, if not all, of the Seven Kingdoms,\n" +
                    "\t\t\tsuch as the holdings of King Robert and\n" +
                    "\t\t\tthe royal branch of House Baratheon.";
        else
            return "Invalid Score";
    }

    public String getLawDefinition(int score) {
        if (score == 0)
            return "Lawless, uncivilized land. You have no\n" +
                    "\t\t\tauthority here—the lands beyond the Wall.";
        if (score >= 1 && score <= 10)
            return "Bandits, raiders, and other criminal bands are afoot in your\n" +
                    "\t\t\tlands, causing mischief and trouble.";
        if (score >= 11 && score <= 20)
            return "Lawlessness and banditry are a problem\n" +
                    "\t\t\talong the fringes of your lands.";
        if (score >= 21 && score <= 30)
            return "The typical level of Law throughout much of Westeros.\n" +
                    "\t\t\tCrime is common but not out of control.";
        if (score >= 31 && score <= 40)
            return "You exert a great deal of control over your lands,\n" +
                    "\t\t\tand crime is uncommon.";
        if (score >= 41 && score <= 50)
            return "Such is your influence and devotion to maintaining the\n" +
                    "\t\t\tpeace that crime is rare.";
        if (score >= 51 && score <= 60)
            return "You have almost no crime at all in your lands.";
        if (score >= 61 && score <= 70)
            return "There is no crime in your lands.";
        else
            return "Invalid Score";
    }

    public String getPowerDefinition(int score) {
        if (score == 0)
            return "Powerless, you have no troops, no soldiers,\n" +
                    "\t\t\tand none loyal to your family.";
        if (score >= 1 && score <= 10)
            return "Personal guard only, with one or two sworn swords\n" +
                    "\t\t\tand a cadre of smallfolk warriors at most.";
        if (score >= 11 && score <= 20)
            return "Small force of soldiers largely made up of smallfolk.";
        if (score >= 21 && score <= 30)
            return "A modest force of soldiers, including some trained troops.";
        if (score >= 31 && score <= 40)
            return "A trained force of soldiers, including cavalry and possibly\n" +
                    "\t\t\tships. You may have the service of a banner house.";
        if (score >= 41 && score <= 50)
            return "A large force of diverse, trained, and competent soldiers.\n" +
                    "\t\t\tYou probably also have the services of a small navy as well.\n" +
                    "\t\t\tSeveral banner houses are sworn to you.";
        if (score >= 51 && score <= 60)
            return "You can muster a huge force of soldiers, drawn from your\n" +
                    "\t\t\tlands and those from your numerous banner houses.";
        if (score >= 61 && score <= 70)
            return "You have the strength of most\n" +
                    "\t\t\tof the Seven Kingdoms behind you.";
        else
            return "Invalid Score";
    }

    public String getPopulationDefinition(int score) {
        if (score == 0)
            return "Barren. No people live under your rule.";
        if (score >= 1 && score <= 10)
            return "Thinly populated. Tiny settlements are\n" +
                    "\t\t\tscattered throughout your lands.";
        if (score >= 11 && score <= 20)
            return "Small population but no single community\n" +
                    "\t\t\tlarger than a small town.";
        if (score >= 21 && score <= 30)
            return "Typical population. Most smallfolk live on farmsteads or in\n" +
                    "\t\t\thamlets, but you might have a couple of small towns and a\n" +
                    "\t\t\tcommunity around your primary fortification.";
        if (score >= 31 && score <= 40)
            return "Modest population. At least one town and several small\n" +
                    "\t\t\thamlets.";
        if (score >= 41 && score <= 50)
            return "Large population. You have a large number of people\n" +
                    "\t\t\tin your lands; many live in a large town or spread\n" +
                    "\t\t\tthroughout a number of smaller towns.";
        if (score >= 51 && score <= 60)
            return "Immense population. An enormous number\n" +
                    "\t\t\tof people live under your protection.";
        if (score >= 61 && score <= 70)
            return "All or nearly all of Westeros.";
        else
            return "Invalid Score";
    }

    public String getWealthDefinition(int score) {
        if (score == 0)
            return "Destitute. Your family is penniless";
        if (score >= 1 && score <= 10)
            return "Impoverished. Your family lacks essential resources and\n" +
                    "\t\t\tstruggles to make ends meet.";
        if (score >= 11 && score <= 20)
            return "Poor. Your family has little excess. While they\n" +
                    "\t\t\tare able to sustain themselves and their holdings,\n" +
                    "\t\t\tthey do not live in luxury.";
        if (score >= 21 && score <= 30)
            return "Common. Your family has enough to get by.";
        if (score >= 31 && score <= 40)
            return "Prosperous. Your family has the funds to\n" +
                    "\t\t\tlive in accordance with their station.";
        if (score >= 41 && score <= 50)
            return "Affluent. Your family has more funds\n" +
                    "\t\t\tthan it needs and lives in comfort.";
        if (score >= 51 && score <= 60)
            return "Rich. Your family wants for nothing.";
        if (score >= 61 && score <= 70)
            return "Decadent. Your family is so wealthy, they can\n" +
                    "\t\t\tafford to have seventy-seven course feasts.";
        else
            return "Invalid Score";
    }

    public String randMaleName() {
        Random rand = new Random();
        int num = rand.nextInt(6) + 1;

        switch (num) {
            case 1: return "Jon";
            case 2: return "Tyrion";
            case 3: return "Bran";
            case 4: return "Eddard";
            case 5: return "Jaime";
            case 6: return "Renly";
            default: return "Male Name Error";
        }
    }

    public String randFemaleName() {
        Random rand = new Random();
        int num = rand.nextInt(6) + 1;

        switch (num) {
            case 1: return "Cercei";
            case 2: return "Sansa";
            case 3: return "Igrid";
            case 4: return "Danaerys";
            case 5: return "Catelyn";
            case 6: return "Myrcella";
            default: return "Female Name Error";
        }
    }

    public String randHouseName() {
        Random rand = new Random();
        int num = rand.nextInt(6) + 1;

        switch (num) {
            case 1: return "Stark";
            case 2: return "Baratheon";
            case 3: return "Lannister";
            case 4: return "Martell";
            case 5: return "Tyrell";
            case 6: return "Tully";
            default: return "House Name Error";
        }
    }

    public String randRealm() {
        Dice die = new Dice();
        String realm;
        int res = die.roll(3);
        if (res == 3)
            realm = "King's Landing";
        else if (res == 4)
            realm = "Dragonstone";
        else if (res == 5 || res == 6)
            realm = "The North";
        else if (res == 7)
            realm = "The Iron Islands";
        else if (res == 8 || res == 9)
            realm = "The Riverlands";
        else if (res == 10 || res == 11)
            realm = "The Mountains of the Moon";
        else if (res == 12 || res == 13)
            realm = "The Westerlands";
        else if (res == 14 || res == 15)
            realm = "The Reach";
        else if (res == 16 || res == 17)
            realm = "The Stormlands";
        else
            realm = "Dorne";

        return realm;
    }

    public String randBackground() {
        Dice die = new Dice();
        int num = die.roll(2);
        switch (num) {
            case 2: return "You served another house (page, sworn sword).";
            case 3: return "You had a torrid love affair.";
            case 4: return "You fought or were involved in a battle.";
            case 5: return "You were kidnapped and escaped, were ransomed, or rescued.";
            case 6: return "You traveled across the narrow sea for a time.";
            case 7: return "You achieved a significant deed, maybe saving the life of your lord,\n" +
                    "killed a giant boar, and so on.";
            case 8: return "You kept the company of a famous individual.";
            case 9: return "You were present at a significant tournament (competing or watching).";
            case 10: return "You were involved in a villainous scandal.";
            case 11: return "You were falsely accused of wrongdoing.";
            case 12: return "You were held hostage by another house as a ward or prisoner.";
            default: return "Random Background Error";
        }
    }

    public String randGoal() {
        Dice die = new Dice();
        int num = die.roll(2);
        switch (num) {
            case 2: return "Enlightenment";
            case 3: return "Skill, mastery in a specific ability";
            case 4: return "Fame";
            case 5: return "Knowledge";
            case 6: return "Love";
            case 7: return "Power";
            case 8: return "Security";
            case 9: return "Revenge";
            case 10: return "Wealth";
            case 11: return "Justice";
            case 12: return "Good";
            default: return "Random Goal Error";
        }
    }

    public String randMotivation() {
        Dice die = new Dice();
        int num = die.roll(2);
        switch (num) {
            case 2: return "Charity";
            case 3: return "Duty";
            case 4: return "Fear";
            case 5: return "Greed";
            case 6: return "Love";
            case 7: return "Hatred";
            case 8: return "Lust";
            case 9: return "Peace";
            case 10: return "Stability";
            case 11: return "Excellence";
            case 12: return "Madness";
            default: return "Random Motivation Error";
        }
    }

    public String randVirtue() {
        Dice die = new Dice();
        int num = die.roll(2);
        switch (num) {
            case 2: return "Charitable";
            case 3: return "Chaste";
            case 4: return "Courageous";
            case 5: return "Devoted";
            case 6: return "Honest";
            case 7: return "Humble";
            case 8: return "Just";
            case 9: return "Magnanimous";
            case 10: return "Merciful";
            case 11: return "Pious";
            case 12: return "Wise";
            default: return "Random Virtue Error";
        }
    }

    public String randVice() {
        Dice die = new Dice();
        int num = die.roll(2);
        switch (num) {
            case 2: return "Ambitious/Grasping";
            case 3: return "Arrogant";
            case 4: return "Avaricious";
            case 5: return "Cowardly";
            case 6: return "Cruel";
            case 7: return "Foolish";
            case 8: return "Licentious";
            case 9: return "Miserly";
            case 10: return "Prejudiced";
            case 11: return "Scheming";
            case 12: return "Wrathful";
            default: return "Random Vice Error";
        }
    }

    public int getRealmDefenseModifier(String realm) {
        switch (realm) {
            case "King's Landing": return 5;
            case "Dragonstone": return 20;
            case "The North": return 5;
            case "The Iron Islands": return 10;
            case "The Riverlands": return -5;
            case "Mountains of the Moon": return 20;
            case "The Westerlands": return -5;
            case "The Reach": return -5;
            case "The Stormlands": return 5;
            case "Dorne": return 0;
            default: return 0;
        }
    }

    public int getRealmInfluenceModifier(String realm) {
        switch (realm) {
            case "King's Landing": return -5;
            case "Dragonstone": return -5;
            case "The North": return 10;
            case "The Iron Islands": return -5;
            case "The Riverlands": return -5;
            case "Mountains of the Moon": return 10;
            case "The Westerlands": return 10;
            case "The Reach": return 10;
            case "The Stormlands": return 0;
            case "Dorne": return -5;
            default: return 0;
        }
    }

    public int getRealmLandsModifier(String realm) {
        switch (realm) {
            case "King's Landing": return -5;
            case "Dragonstone": return -5;
            case "The North": return 20;
            case "The Iron Islands": return -5;
            case "The Riverlands": return 5;
            case "Mountains of the Moon": return -5;
            case "The Westerlands": return -5;
            case "The Reach": return 0;
            case "The Stormlands": return -5;
            case "Dorne": return 10;
            default: return 0;
        }
    }

    public int getRealmLawModifier(String realm) {
        switch (realm) {
            case "King's Landing":          return 20;
            case "Dragonstone":             return 5;
            case "The North":               return -10;
            case "The Iron Islands":        return 0;
            case "The Riverlands":          return 0;
            case "Mountains of the Moon":   return -10;
            case "The Westerlands":         return -5;
            case "The Reach":               return -5;
            case "The Stormlands":          return 10;
            case "Dorne":                   return -5;
            default: return 0;
        }
    }

    public int getRealmPopulationModifier(String realm) {
        switch (realm) {
            case "King's Landing":          return 5;
            case "Dragonstone":             return 0;
            case "The North":               return -5;
            case "The Iron Islands":        return 0;
            case "The Riverlands":          return 10;
            case "Mountains of the Moon":   return -5;
            case "The Westerlands":         return -5;
            case "The Reach":               return 5;
            case "The Stormlands":          return -5;
            case "Dorne":                   return 0;
            default: return 0;
        }
    }

    public int getRealmPowerModifier(String realm) {
        switch (realm) {
            case "King's Landing":          return 5;
            case "Dragonstone":             return 0;
            case "The North":               return -5;
            case "The Iron Islands":        return 10;
            case "The Riverlands":          return 0;
            case "Mountains of the Moon":   return 0;
            case "The Westerlands":         return 0;
            case "The Reach":               return 0;
            case "The Stormlands":          return 5;
            case "Dorne":                   return 10;
            default: return 0;
        }
    }

    public int getRealmWealthModifier(String realm) {
        switch (realm) {
            case "King's Landing":          return -5;
            case "Dragonstone":             return -5;
            case "The North":               return -5;
            case "The Iron Islands":        return 0;
            case "The Riverlands":          return 5;
            case "Mountains of the Moon":   return 0;
            case "The Westerlands":         return 20;
            case "The Reach":               return 5;
            case "The Stormlands":          return 0;
            case "Dorne":                   return 0;
            default: return 0;
        }
    }

    public String benefits() {
        String abilityQualities = "Artist — Create works of art.\n" +
                "Beastfriend — +1D on Animal Handling tests to Charm or Train.\n" +
                "Connections† Streetwise 1B +1D on Knowledge tests in chosen location.\n" +
                "Dexterous — Re-roll 1s on Agility tests.\n" +
                "Eidetic Memory Cunning 2 (Memory 1B) Memory bonus dice are test dice for you.\n" +
                "Evaluation Knowledge 3 Test Cunning to learn about object.\n" +
                "Expertise† — Gain +1D with one specialty.\n" +
                "Face in the Crowd Stealth 3 (Blend In 1B) Blend In as Free Action, and add Cunning rank\n" +
                "to Blend In test results.\n" +
                "Furtive Stealth 4 (Sneak 1B) Re-roll 1s, and add Agility rank to Sneak test results.\n" +
                "Gifted Athlete† Athletics 4 Convert half bonus dice to test dice.\n" +
                "Gifted Teacher Knowledge 4, Persuasion 3 Grant bonus dice to students.\n" +
                "Great Hunter Survival 4 Bonus when fighting, hunting, and tracking animals.\n" +
                "Guttersnipe — Re-roll 1s on Thievery tests.\n" +
                "Hardy Endurance 3 (Stamina 1B) Ignore –1 or –1D on Endurance tests to recover from injuries.\n" +
                "Head for Numbers Status 3 (Stewardship 1B) Add Cunning rank to Status test result for turn events,\n" +
                "and re-roll 1s on Status test to generate coin.\n" +
                "Keen Senses Awareness 4 Re-roll 1s on Awareness tests, and add Cunning rank to base Awareness.\n" +
                "Knowledge Focus† Knowledge 4 Gain unequaled expertise in a particular area of knowledge.\n" +
                "Miracle Worker Healing 4 Diagnose patient to gain significant bonuses.\n" +
                "Mummer Persuasion 3 You can entertain audiences.\n" +
                "Polyglot Cunning 4 (Decipher 1B) Learn languages easily.\n" +
                "Sinister — You radiate menace.\n" +
                "Talented† — Add +1 to chosen test result.\n" +
                "Terrain Specialist† Survival 4 Add Education to Survival results in chosen terrain.\n" +
                "Trade — Learn a trade.";
        String fateQualites = "Animal Cohort Animal Handling 3 (Train 1B) Gain service of Animal Cohort.\n" +
                "Brother of the Night’s\n" +
                "Watch — You are a member of the Night’s Watch.\n" +
                "Cadre Persuasion 5 Gain veteran squad.\n" +
                "Cohort Status 3 Gain service of a devoted ally.\n" +
                "Famous — Your fame gives you advantages in intrigues.\n" +
                "Greensight Will 5 Experience true dreams\n" +
                "Head of House — You are the highest-ranking member in your noble house.\n" +
                "Heir — You will one day inherit your family’s lands and holdings.\n" +
                "Heirloom Head of House or Heir You gain a Valyrian steel weapon\n" +
                "Landed Sponsor You gain lands and holdings.\n" +
                "Lucky — Re-roll one test per day, and take best result.\n" +
                "Maester Cunning 3, Knowledge Focus (x2) You are a maester of the Citadel.\n" +
                "Master of Ravens Animal Handling 3 Dispatch ravens to bear your messages.\n" +
                "Man of the Kingsguard Sponsor You are charged with protecting the royal family.\n" +
                "Night Eyes — See in darkness.\n" +
                "Pious Will 3 (Dedication 1B) Gain +1D once per day.\n" +
                "Skinchanger Will 5 (Dedication 3B,) Warg You may warg into animals other than your Animal Cohort\n" +
                "Sponsor — Gain a powerful ally.\n" +
                "Warg Will 5 (Dedication 2B), Warg Dreams You can wear the skin of your Animal Cohort\n" +
                "Warg Dreams Will 4 (Dedication 1B), Animal Cohort You ccasionally dream through the eyes of your Animal Cohort\n" +
                "Wealthy — Replenish coffers each month.";
        String heritageQualites = "Blood of the Andals — You are uncommonly lucky.\n" +
                "Blood of the First Men — Your heritage makes you tough and hardy.\n" +
                "Blood of Heroes — Exceed 7 limit on a specific ability.\n" +
                "Blood of the Ironmen — Seawater flows through your veins.\n" +
                "Blood of the Rhoyne — You are agile and elusive.\n" +
                "Blood of Valyria — People find you compelling.\n" +
                "Blood of the Wildlings — You were born free of the tyranny of Westeros.\n" +
                "Massive Endurance 5 You are uncommonly large.";
        String martialQualities = "Accurate Marksmanship 4 +1D against opponents with cover.\n" +
                "Acrobatic Defense Agility 4 (Acrobatics 1B) Lesser Action to add twice Acrobatics to Combat Defense.\n" +
                "Anointed Sponsor +2 on Status test, 1/day gain +5 to Defenses.\n" +
                "Armor Mastery — +1 AR, –1 Bulk.\n" +
                "Axe Fighter I Fighting 4 (Axes 2B) Sacrifice bonus dice to deal extra damage.\n" +
                "Axe Fighter II Fighting 5 (Axes 3B), Axe Fighter I Sacrifice bonus dice to inflict a wound.\n" +
                "Axe Fighter III Fighting 6 (Axes 4B), Axe Fighter II Sacrifice bonus dice to inflict a wound and Maimed quality.\n" +
                "Berserker — Make free attack with injury or wound; fight past death.\n" +
                "Bludgeon Fighter I Fighting 4 (Bludgeons 2B) Weapon gains or increases Shattering by 1.\n" +
                "Bludgeon Fighter II Fighting 5 (Bludgeons 3B),\n" +
                "Bludgeon Fighter I Foe loses 1 Lesser Action on hit and –1 tests.\n" +
                "Bludgeon Fighter III Fighting 6 (Bludgeons 4B),\n" +
                "Bludgeon Fighter II Foe gains wound, prone, loses action.\n" +
                "Braavosi Fighter I Fighting 4 (Fencing 1B) Increase Defensive Bonus by +1.\n" +
                "Braavosi Fighter II Fighting 5 (Fencing 2B), Braavosi Fighter I Boost Combat Defense.\n" +
                "Braavosi Fighter III Fighting 6 (Fencing 3B), Braavosi Fighter II Free attack when opponent misses you.\n" +
                "Brawler I Fighting 4 (Brawling 1B) Fists are Fast and deal extra damage.\n" +
                "Brawler II Fighting 4 (Brawling 3B), Brawler I Fists are Powerful and add Athletics rank to Fighting result.\n" +
                "Brawler III Fighting 5 (Brawling 5B), Brawler II Stun opponents with fist attack.\n" +
                "Danger Sense Awareness 4 Re-roll 1s on initiative tests, deny surprising opponent +1D to attack you.\n" +
                "Deadly Shot Marksmanship 5 Bows and crossbow gain Armor Piercing 1 and Vicious.\n" +
                "Deft Hands Agility 4 Reduce weapon’s reload time.\n" +
                "Double Shot Marksmanship 5 (Bows 3B) Fire two arrows at once.\n" +
                "Fast — Move +1 yard, run ×5 Movement.\n" +
                "Fury Athletics 4 (Strength 2B) –2D to deal +4 damage.\n" +
                "Hail of Steel Marksmanship 4 (Thrown 2B) Thrown weapons gain Fast quality.\n" +
                "Improved Armor Mastery Armor Mastery Increase AR by 1 for a total of +2." +
                "\nImproved Weapon Mastery Weapon Mastery Increase weapon damage by 1.\n" +
                "Inspiring Warfare 4 Gain extra command, plus sacrifice command to re-roll test result.\n" +
                "Leader of Men Warfare 4 (Command 1B) Automatically reorganize or rally one unit.\n" +
                "Long Blade Fighter I Fighting 4 (Long Blades 2B) Sacrifice bonus dice for a free degree.\n" +
                "Long Blade Fighter II Fighting 5, Long Blade Fighter I Sacrifice bonus dice to move target with hit.\n" +
                "Long Blade Fighter III Fighting 6, Long Blade Fighter II Sacrifice bonus dice to Maim opponent.\n" +
                "Pole-arm Fighter I Fighting 4, (Pole-arms 2B) Knock foes to the ground with a sweep.\n" +
                "Pole-arm Fighter II Athletics 4 or Fighting 4, Pole-arm Fighter I Bonus dice are test dice when pulling riders from mounts.\n" +
                "Pole-arm Fighter III Fighting 5, Pole-arm Fighter II Pin opponent with weapon.\n" +
                "Shield Mastery Fighting 3 (Shields 1B) Increase Defensive Bonus by +1 with shields.\n" +
                "Short Blade Fighter I Fighting 4 (Short Blades 1B) Short blades gain Piercing 1.\n" +
                "Short Blade Fighter II Fighting 5, Short Blade Fighter I Draw as Free Action, bonus to test results.\n" +
                "Short Blade Fighter III Fighting 6, Short Blade Fighter II Add number of bonus dice as extra damage.\n" +
                "Spear Fighter I Fighting 3 (Spears 1B) Attack again on a miss.\n" +
                "Spear Fighter II Spear Fighter I +1D on Knockdown attempts; attack foes up to 1 extra yard away.\n" +
                "Spear Fighter III Athletics 5, Spear Fighter II Spears gain Piercing 2.\n" +
                "Tough Resilience 1B Add Resilience to Health.\n" +
                "Tourney Knight Fighting 3 (Spears 1B), Status 3\n" +
                "(Tournaments 1B)\n" +
                "Add Tournaments bonus dice on Fighting.\n" +
                "and Animal Handling test results when jousting.\n" +
                "Triple Shot Marksmanship 7 (Bows 5B), Double Shot Fire three arrows at once.\n" +
                "Water Dancer I Fighting 3 (Fencing 1B) Add Fighting rank to Awareness results.\n" +
                "Water Dancer II Water Dancer I Add Fighting rank to Agility results.\n" +
                "Water Dancer III Water Dancer II Add Fencing to Combat Defense.\n" +
                "Weapon Mastery† — Increase weapon damage by +1.\n" +
                "Weapon Savant Agility 4, Cunning 4, Fighting 5 Ignore Trained requirement and penalties with weapons.\n";

        String socialQualities = "Adept Negotiator Deception 3 No penalty from your disposition.\n" +
                "Attractive — Re-roll 1s on Persuasion tests.\n" +
                "Authority — Reduce disposition penalties to Persuasion by 2.\n" +
                "Cautious Diplomat Awareness 4 (Empathy 2B) Retain bonus dice from consider during intrigues.\n" +
                "Charismatic† Persuasion 3 Add +2 to the result of Persuasion test.\n" +
                "Compelling† Charismatic Increase influence with specialty by 1.\n" +
                "Courteous Persuasion 3 You have impeccable manners.\n" +
                "Dutiful Will 4 You are unfailing in your loyalty.\n" +
                "Eloquent Language 4, Persuasion 4 Automatically go first in an intrigue.\n" +
                "Favored of Nobles — +1B on Persuasion tests against characters with 4 or higher Status.\n" +
                "Favored of Smallfolk — +1B on Persuasion tests against characters with 3 or lower Status.\n" +
                "Magnetic Charismatic Achieve greater results with Charm.\n" +
                "Respected Reputation 2B Your accomplishments and reputation inspire respect.\n" +
                "Stubborn Will 3 (Dedication 1B) Add Dedication to Composure.\n" +
                "Treacherous — Add Cunning rank to Deception result.\n" +
                "Worldly — +2B on Persuasion tests against characters\n" +
                "from lands other than Westeros.\n";

        return "";
    }

    public Benefit randBenefit(Character character) {
        //has Character object to make sure
        Random rand = new Random();

        int num = rand.nextInt(118) + 1;


        return null;
    }
}
