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

}
