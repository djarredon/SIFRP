/**
 * Created by arredon on 9/27/2016.
 *
 * Sections
 *      General
 *      Display
 *      Home House
 *      Holdings
 *      Banner House
 */
public class House {
    private String name;    //name of the House
    private String realm;   //
    private String founded;   //age of founding
    private String foundingEvent;
    private History history;    //list of historical events
    private int age;    //age of the house
    private Character steward;  //Lord/Lady of the House

    private Dice die;   //used for rolling dice
    private CharacterList residents;

    //stats
    private int defense;
    private int influence;
    private int lands;
    private int law;
    private int population;
    private int power;
    private int wealth;

    private int maxStatus;

    //Holdings
    private HouseList banners;
    private HouseNode liegeHouse;
    private boolean isBanner;
    private DomainList domains;
    private DefenseList castles;
    private Character firstHeir;
    private Character secondHeir;
    private CharacterList heirs;
    private WealthList wealthHoldings;
    private String lawHoldings;
    private String populationHoldings;

    //+++++GENERAL METHODS+++++
    //default constructor
    public House() {
        die = new Dice();
        nullAll();
    }

    //Constructor with House name
    public House(String name) {
        die = new Dice();
        nullAll();
        this.name = new String(name);
    }

    //Copy Constructor
    public House(House toCopy) {
        die = new Dice();
        copyHouse(toCopy);
    }

    private void nullAll() {
        history = null;
        name = null;
        founded = null;
        foundingEvent = null;
        banners = null;
        isBanner = false;
        domains = null;
        castles = null;
        steward = null;
        heirs = null;
        firstHeir = null;
        secondHeir = null;
        residents = null;
        wealthHoldings = null;
        lawHoldings = null;
        populationHoldings = null;
        liegeHouse = null;
    }

    //set's House name
    public void setName(String toName) {
        name = toName;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    //Modifies stats based on history
    private void historyModifier() {
        if (history == null)
            System.out.println("No History");
        else {
            EventNode current = history.head;
            while (current != null) {
                switch (current.getEventInt()) {
                    case 1: //Ascent
                        influence += die.roll();
                        lands += die.roll();
                        power += die.roll();
                        wealth += die.roll();
                        break;
                    case 2: //Catastrophe
                        law -= die.roll();
                        population -= die.roll();
                        power -= die.roll();
                        wealth -= die.roll();
                        break;
                    case 3: //Conquest
                        defense -= die.roll();
                        influence += die.roll();
                        lands += die.roll();
                        law -= die.roll();
                        population += die.roll();
                        wealth += die.roll();
                        break;
                    case 4: //Defeat
                        defense -= die.roll();
                        influence -= die.roll();
                        lands -= die.roll();
                        population -= die.roll();
                        power -= die.roll();
                        wealth -= die.roll();
                        break;
                    case 5: //Descent
                        influence -= die.roll();
                        lands -= die.roll();
                        power -= die.roll();
                        wealth -= die.roll();
                        break;
                    case 6: //event = "Doom";
                        defense -= die.roll(2);
                        influence -= die.roll(2);
                        lands -= die.roll(2);
                        law -= die.roll(2);
                        population -= die.roll(2);
                        power -= die.roll(2);
                        wealth -= die.roll(2);
                        break;
                    case 7: //event = "Favor";
                        influence += die.roll();
                        lands += die.roll();
                        law += die.roll();
                        power += die.roll();
                        break;
                    case 8: //event = "Glory";
                        defense += die.roll();
                        influence += die.roll();
                        law += die.roll();
                        power += die.roll();
                        break;
                    case 9: //event = "Infrastructure";
                        //increase two random resources by 1d6
                        break;
                    case 10: //event = "Invasion/Revolt";
                        law -= die.roll(2);
                        population -= die.roll();
                        power -= die.roll();
                        wealth -= die.roll();
                        break;
                    case 11: //event = "Madness";
                        defense += (6 - die.roll(2));
                        influence += (6 - die.roll(2));
                        lands += (6 - die.roll(2));
                        law += (6 - die.roll(2));
                        population += (6 - die.roll(2));
                        power += (6 - die.roll(2));
                        wealth += (6 - die.roll(2));
                        break;
                    case 12: //event = "Scandal";
                        influence -= die.roll();
                        lands -= die.roll();
                        power -= die.roll();
                        break;
                    case 13: //event = "Treachery";
                        influence -= die.roll();
                        law -= die.roll();
                        power += die.roll();
                        break;
                    case 14: //event = "Victory";
                        defense += die.roll();
                        influence += die.roll();
                        power += die.roll();
                        break;
                    case 15: //event = "Villain";
                        influence += die.roll();
                        law -= die.roll();
                        population -= die.roll();
                        power += die.roll();
                        break;
                    case 16: //event = "Windfall";
                        defense += die.roll();
                        influence += die.roll(2);
                        lands += die.roll();
                        law += die.roll();
                        population += die.roll();
                        power += die.roll(2);
                        wealth += die.roll(2);
                        break;
                    default:
                        System.out.println("Event Type Error 218.");
                        break;
                }
                current = current.getNext();
            }
            //reset negative stats to zero
            if (defense < 0)
                defense = 0;
            if (influence < 0)
                influence = 0;
            if (lands < 0)
                lands = 0;
            if (law < 0)
                law = 0;
            if (population < 0)
                population = 0;
            if (power < 0)
                power = 0;
            if (wealth < 0)
                wealth = 0;

        }
    }

    //Modifies stats based on realm
    private void realmModifier() {
        if (realm.equalsIgnoreCase("King's Landing")) {
            defense += 5;
            influence -= 5;
            lands -= 5;
            law += 20;
            population += 5;
            power -= 5;
            wealth -= 5;
        } else if (realm.equalsIgnoreCase("Dragonstone")) {
            defense += 20;
            influence -= 5;
            lands -= 5;
            law += 5;
            wealth -= 5;
        } else if (realm.equalsIgnoreCase("The North")) {
            defense += 5;
            influence += 10;
            lands += 20;
            law -= 10;
            population -= 5;
            power -= 5;
            wealth -= 5;
        } else if (realm.equalsIgnoreCase("The Iron Islands")) {
            defense += 10;
            influence -= 5;
            lands -= 5;
            power += 10;
        } else if (realm.equalsIgnoreCase("The Riverlands")) {
            defense -= 5;
            influence -= 5;
            lands += 5;
            population += 10;
            wealth += 5;
        } else if (realm.equalsIgnoreCase("The Mountains of the Moon")) {
            defense += 20;
            influence += 10;
            lands -= 5;
            law -= 10;
            population -= 5;
        } else if (realm.equalsIgnoreCase("The Westerlands")) {
            defense -= 5;
            influence += 10;
            lands -= 5;
            law -= 5;
            population -= 5;
            wealth += 20;
        } else if (realm.equalsIgnoreCase("The Reach")) {
            defense -= 5;
            influence += 10;
            law -= 5;
            population += 5;
            wealth += 5;
        } else if (realm.equalsIgnoreCase("The Stormlands")) {
            defense += 5;
            lands -= 5;
            law += 10;
            population -= 5;
            power += 5;
        } else if (realm.equalsIgnoreCase("Dorne")) {
            influence -= 5;
            lands += 10;
            law -= 5;
            power += 10;
        } else
            System.out.println("Realms error: " + realm);
    }

    //copies House toCopy into this House
    public void copyHouse(House toCopy) {
        name = toCopy.name;
        realm = toCopy.realm;
        founded = toCopy.founded;
        foundingEvent = toCopy.foundingEvent;

        if (toCopy.history != null)
            history = new History(toCopy.history);
        else
            history = null;
        if (toCopy.steward != null)
            steward = new Character(toCopy.steward);
        else
            steward = null;
        if (toCopy.residents != null)
            this.residents = new CharacterList(toCopy.residents);
        else
            this.residents = null;

        this.liegeHouse = toCopy.liegeHouse;

        //Holdings
        if (toCopy.firstHeir != null)
            this.firstHeir = new Character(toCopy.firstHeir);
        else
            firstHeir = null;
        if (toCopy.secondHeir != null)
            this.secondHeir = new Character(toCopy.secondHeir);
        else
            secondHeir = null;
        if (toCopy.heirs != null)
            heirs = new CharacterList(toCopy.heirs);
        else
            heirs = null;
        if (toCopy.banners != null)
            banners = new HouseList(toCopy.banners);
        else
            banners = null;
        isBanner = toCopy.isBanner;
        if (toCopy.domains != null)
            domains = new DomainList(toCopy.domains);
        else
            domains = null;
        if (toCopy.castles != null)
            this.castles = new DefenseList(toCopy.castles);
        else
            castles = null;
        if (toCopy.wealthHoldings != null)
            wealthHoldings = new WealthList(toCopy.wealthHoldings);
        else
            wealthHoldings = null;
        if (toCopy.lawHoldings != null)
            lawHoldings = new String(toCopy.lawHoldings);
        else
            lawHoldings = null;
        if (toCopy.populationHoldings != null)
            populationHoldings = new String(toCopy.populationHoldings);
        else
            populationHoldings = null;

        maxStatus = toCopy.maxStatus;
        age = toCopy.age;
        //stats
        defense = toCopy.defense;
        influence = toCopy.influence;
        lands = toCopy.lands;
        law = toCopy.law;
        population = toCopy.population;
        power = toCopy.power;
        wealth = toCopy.wealth;
    }

    public boolean getIsBanner() {
        return isBanner;
    }

    public void setIsBanner(boolean value) {
        isBanner = value;
    }

    public void insertResident(Character toAdd) {
        if (residents == null)
            residents = new CharacterList();
        residents.insert(toAdd);
    }

    //+++++PRINT SECTION+++++
    public String printAll() {
        String toReturn = printHouseInfo() + "\n";
        toReturn = toReturn.concat(printStats() + "\n");
        toReturn = toReturn.concat(printHeirs() + "\n");
        toReturn = toReturn.concat(printResidents() + "\n");
        toReturn = toReturn.concat(printHistory() + "\n");
        toReturn = toReturn.concat(printLandHoldings() + "\n");
        toReturn = toReturn.concat(printDefenseHoldings());

        if (!isBanner) {
            toReturn = toReturn.concat(printBanner());
            toReturn = toReturn.concat("----------------------------------------\n" +
                    "----------------------------------------");
        }

        return toReturn;
    }

    public String printHouseInfo() {
        String toReturn = new String();

        toReturn = toReturn.concat("House " + name + "\n" +
                "Realm: " + realm + "\n" +
                "Founded: " + founded + "\n" +
                "Founding Event: " + foundingEvent);
        if (steward != null) {
            toReturn = toReturn.concat("\nCurrent Steward: "
                    + steward.getName() + "\n");
        }
        return toReturn;
    }

    public String printName() {
        return name;
    }

    public String printRealm() {
        return realm;
    }

    public String printFounded() {
        return founded;
    }

    public String printFoundingEvent() {
        return foundingEvent;
    }

    public String printStats() {
        return "Defense: " + defense + "\n" +
                "Influence: " + influence + "\n" +
                "Lands: " + lands + "\n" +
                "Population: " + population + "\n" +
                "Power " + power + "\n" +
                "Wealth " + wealth + "\n";
    }

    public String printResidents() {
        if (residents == null)
            return "No Residents\n";
        return residents.printNames();
    }

    public String printHeirs() {
        String toReturn = "";
        if (firstHeir != null)
            toReturn = "First Heir: " + firstHeir.getName() + "\n";
        if (secondHeir != null)
            toReturn = toReturn.concat("Second Heir: " + secondHeir.getName() + "\n");
        if (heirs != null)
            toReturn = toReturn.concat("Additional heirs: " + heirs.printNames());
        return toReturn;
    }

    public String printHistory() {
        String toReturn = "";
        if (history != null)
            toReturn = toReturn.concat(history.printAll());
        return toReturn + "\n";
    }

    public String printHoldings() {
        String toReturn = "";

        toReturn = toReturn.concat(printDefenseHoldings());
        toReturn = toReturn.concat(printInfluenceHoldings());
        toReturn = toReturn.concat(printLandHoldings());
        toReturn = toReturn.concat(printLawHoldings());
        toReturn = toReturn.concat(printPopulationHoldings());
        toReturn = toReturn.concat(printPowerHoldings());
        toReturn = toReturn.concat(printWealthHoldings());

        return toReturn;
    }

    public String printLandHoldings() {
        if (domains == null)
            return "No Domains\n";
        return domains.printAll();
    }

    public String printInfluenceHoldings() {
        return printHeirs();
    }

    public String printPowerHoldings() {
        return printBannerNames();
    }

    public String printLawHoldings() {
        if (law == 0)
            return lawHoldings = "House Fortunes -20\n";
        else if (law >= 1 && law <= 10)
            return lawHoldings = "House Fortunes -10\n";
        else if (law >= 11 && law <= 20)
            return lawHoldings = "House Fortunes -5\n";
        else if (law >= 21 && law <= 30)
            return lawHoldings = "House Fortunes -2\n";
        else if (law >= 31 && law <= 40)
            return lawHoldings = "House Fortunes -1\n";
        else if (law >= 41 && law <= 50)
            return lawHoldings = "House Fortunes +0\n";
        else if (law >= 51 && law <= 60)
            return lawHoldings = "House Fortunes +1\n";
        else if (law >= 61 && law <= 70)
            return lawHoldings = "House Fortunes +2\n";
        else if (law > 70)
            return lawHoldings = "House Fortunes +5\n";
        else
            return lawHoldings = "House Fortunes +0\n";
    }

    public String printPopulationHoldings() {
        if (population == 0)
            return populationHoldings = "House Fortunes -10\n";
        else if (population >= 1 && population <= 10)
            return populationHoldings = "House Fortunes -5\n";
        else if (population >= 11 && population <= 20)
            return populationHoldings = "House Fortunes +0\n";
        else if (population >= 21 && population <= 30)
            return populationHoldings = "House Fortunes +1\n";
        else if (population >= 31 && population <= 40)
            return populationHoldings = "House Fortunes +3\n";
        else if (population >= 41 && population <= 50)
            return populationHoldings = "House Fortunes +1\n";
        else if (population >= 51 && population <= 60)
            return populationHoldings = "House Fortunes +0\n";
        else if (population >= 61 && population <= 70)
            return populationHoldings = "House Fortunes -5\n";
        else if (population >= 71)
            return populationHoldings = "House Fortunes -10\n";
        else
            return populationHoldings = "House Fortunes +0\n";
    }

    public String printDefenseHoldings() {
        if (castles == null)
            return "No Defense Holdings.\n";
        return castles.printAll();
    }

    public String printWealthHoldings() {
        if (wealthHoldings == null)
            return "No Wealth Holdings.\n";
        return wealthHoldings.printAll();
    }

    public String printBanner() {
        if (banners == null)
            return "No Banner Houses\n";
        return banners.getNum() + " Banners \n" +
                banners.printList();
    }

    public String printBannerNames() {
        if (banners == null)
            return "No Banner Houses\n";
        return banners.printNames();
    }

    public HouseList getBanners() {
        return banners;
    }

    public boolean hasBanners() {
        if (banners == null)
            return false;
        return true;
    }

    public HouseNode getLiegeHouse() {
        return liegeHouse;
    }

    public void setLiegeHouse(HouseNode liegeHouse) {
        this.liegeHouse = liegeHouse;
    }

    public boolean hasLiegeHouse() {
        if (liegeHouse != null)
            return true;
        return false;
    }

    //+++++DISPLAY SECTION+++++
    //calls all display functions
    public void displayAll() {
        displayHouseInfo();
        displayStats();
        displayHeirs();
        displayResidents();
        displayHistory();
        displayLandHoldings();
        displayDefenseHoldings();

        if (!isBanner) {
            displayBanners();
            System.out.println("----------------------------------------\n" +
                    "----------------------------------------");
        }
    }

    //displays name, realm, and founding
    public void displayHouseInfo() {
        if (name != null)
            System.out.println("House " + name);
        System.out.println("Realm: " + realm + "\n" +
                "Founded: " + founded + "\n" +
                "Founding Event: " + foundingEvent);
        if (steward != null) {
            System.out.println("Current Steward: " + steward.getName());
        }
    }

    //displays House history
    public void displayHistory() {
        System.out.println("\nHistorical Events:");
        if (history != null)
            history.display();
        else
            System.out.println("No history.");
    }

    //displays House's seven stats and definitions
    public void displayStats() {
        /*
        Data data = new Data();
        System.out.println("\nDefense " + defense + ": " + data.getDefenseDefinition(defense) + "\n" +
                "Influence " + influence + ": " + data.getInfluenceDefinition(influence) + "\n" +
                "Lands " + lands + ": " + data.getLandsDefinition(lands) + "\n" +
                "Law " + law + ": " + data.getLawDefinition(law) + "\n" +
                "Populaion " + population + ": " + data.getPopulationDefinition(population) + "\n" +
                "Power " + power + ": " + data.getPowerDefinition(power) + "\n" +
                "Wealth " + wealth + ": " + data.getWealthDefinition(wealth));
        */
        System.out.println("\nDefense: " + defense + "\n" +
                "Influence: " + influence + "\n" +
                "Lands " + lands + "\n" +
                "Law " + law + "\n" +
                "Population " + population + "\n" +
                "Power " + power + "\n" +
                "Wealth " + wealth);
    }

    public void displayBanners() {
        if (banners != null) {
            System.out.println("\nBanners: " + banners.getNum());
            banners.display();
        }
        else
            System.out.println("\nNo Banner Houses");
    }

    public void displayLandHoldings() {
        if (domains != null) {
            System.out.println("\nDomains: ");
            domains.display();
        }
        else
            System.out.println("\nNo Domains.");
    }

    public void displayDefenseHoldings() {
        if (castles != null) {
            System.out.println("\nDefense Holdings: ");
            castles.display();
        }
        else
            System.out.println("\nNo Defense Holdings.");
    }

    public void displayHeirs() {
        System.out.println(printHeirs());
    }

    public void displayResidents() {
        if (residents != null) {
            System.out.println("\nResidents: ");
            residents.displayNames();
        }
        else
            System.out.println("\nNo Residents.");
    }

    //+++++HOME HOUSE SECTION+++++
    //Create all random info except House name
    //House name may eventually be added.
    public void generateRandHouse() {
        randName();
        randRealm();
        randStats();
        createHistory();
        generateSteward();
        generateHoldings();
    }

    public void randName() {
        if (name == null) {
            Data data = new Data();
            name = data.randHouseName();
        }
    }

    //create random stats for Home House
    public void randStats() {
        defense = die.roll(7);
        influence = die.roll(7);
        lands = die.roll(7);
        law = die.roll(7);
        population = die.roll(7);
        power = die.roll(7);
        wealth = die.roll(7);

        //realmModifier();
    }

    public void setMaxStatus() {
        if (influence >= 0 && influence <= 10)
            maxStatus = 2;
        else if (influence >10 && influence <= 20)
            maxStatus = 3;
        else if (influence > 20 && influence <= 30)
            maxStatus = 4;
        else if (influence > 30 && influence <= 40)
            maxStatus = 5;
        else if (influence > 40 && influence <= 50)
            maxStatus = 6;
        else if (influence > 50 && influence <= 60)
            maxStatus = 7;
        else if (influence > 70)
            maxStatus = 8;
    }

    //creates history for Home House
    private void createHistory() {
        //generate age
        Data data = new Data();
        age = die.roll(1);

        founded = data.getAge(age);
        history = new History(data.getHistory(age));

        foundingEvent = history.head.getEvent();
        historyModifier();
    }

    public void generateHistory() {
        Data data = new Data();
        founded = data.getAge(age);
        history = new History(data.getHistory(age));

        foundingEvent = history.head.getEvent();
        historyModifier();
    }

    //Chooses random realm for Home House
    private void randRealm() {
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
    }

    private void generateSteward() {
        setMaxStatus();
        steward = new Character(name, realm, maxStatus);
        steward.generateCharacter();
        if (steward.getGender().equalsIgnoreCase("Male"))
            steward.setTitle("Lord");
        else
            steward.setTitle("Lady");
    }

    //+++++HOLDINGS SECTION+++++
    public void generateHoldings() {
        generatePowerHoldings();
        generateLandHoldings();
        generateDefenseHoldings();
        generateHeirs();
        generateLawHoldings();
        generatePopulationHoldings();
        generateWealthHoldings();
    }

    //Generates Domains for the House usings this.lands
    //Should eventually purchase holdings based on realm
    public void generateLandHoldings() {
        int toSpend = lands;
        this.domains = new DomainList();
        //while tospend > 3, keep purchasing domains
        // (3 is the cheapest terrain)
        while (toSpend > 3 ) {
            DomainNode domain = new DomainNode();
            Terrain terrain = new Terrain();
            //purchase terrain

            terrain.randomTerrain(realm);
            toSpend -= terrain.getCost();

            //purchase features
            //Each Terrain can have zero or more features,
            //but let's just go with 1d6
            int numFeatures = die.roll();
            while (numFeatures-- > 0 && toSpend > 1) {
                Feature temp = new Feature();
                if (toSpend < 3) {
                    //purchase grassland
                    temp.setFeatureType(7);
                    domain.addFeature(temp);
                    --toSpend;
                    numFeatures = 0;
                }
                else if (toSpend > 50) {
                    //buy large city
                    temp.setFeatureType(6);
                    domain.addFeature(temp);
                    toSpend -= 50;
                }
                else if (toSpend > 40) {
                    //buy Small city
                    temp.setFeatureType(5);
                    domain.addFeature(temp);
                    toSpend -= 40;
                }
                else if (toSpend > 30) {
                    //buy Large Town
                    temp.setFeatureType(4);
                    domain.addFeature(temp);
                    toSpend -= 30;
                }
                else if (toSpend >= 20) {
                    //buy Small Town
                    temp.setFeatureType(3);
                    domain.addFeature(temp);
                    toSpend -= 20;
                }
                else {
                    //loop through potential purchases until price is less
                    //than toSpend
                    temp.randomFeature(realm);
                    int attempts = 5;   //this prevents the following loop from
                                        //looping infinitely
                    while (attempts-- > 0 && temp.getCost() > toSpend)
                        temp.randomFeature(realm);

                    if (attempts != 0 && !domain.containsFeature(temp) && temp.getCost() <= toSpend) {
                        domain.addFeature(temp);
                        toSpend -= temp.getCost();
                    }
                    else
                        numFeatures = 0;
                }
            }

            //Insert new Domain into this.domains
            domain.setTerrain(terrain);
            this.domains.insert(domain);
        }
    }

    public void generatePopulationHoldings() {
        populationHoldings = printPopulationHoldings();
    }

    public boolean hasWealthRequirements(Wealth wealth) {
        if (wealthHoldings == null)
            wealthHoldings = new WealthList();

        switch (wealth.getName()) {
            case "Sept":
                if (castles == null){
                    if (domains == null)
                        return false;
                    return domains.hasHolding("Community: Small Town")
                            || domains.hasHolding("Community: Large Town") || domains.hasHolding("Community: Small City")
                            || domains.hasHolding("Community: Large City");
                }
                else {
                    if (domains != null)
                        return !wealthHoldings.hasHolding("Sept") && castles.hasHolding("Hall")|| castles.hasHolding("Small Castle")
                                || castles.hasHolding("Castle") || castles.hasHolding("Superior Castle") || domains.hasHolding("Community: Small Town")
                                || domains.hasHolding("Community: Large Town") || domains.hasHolding("Community: Small City")
                                || domains.hasHolding("Community: Large City");
                    else
                        return !wealthHoldings.hasHolding("Sept") && castles.hasHolding("Hall")|| castles.hasHolding("Small Castle")
                                || castles.hasHolding("Castle") || castles.hasHolding("Superior Castle");
                }
            case "GodsWood":
                return !wealthHoldings.hasHolding("GodsWood") && realm.equalsIgnoreCase("The North");
            case "Guilds":
                if (domains == null)
                    return false;
                return !wealthHoldings.hasHolding("Guilds") && domains.hasHolding("Community: Small Town")
                        || domains.hasHolding("Community: Large Town") || domains.hasHolding("Community: Small City")
                        || domains.hasHolding("Community: Large City");
            case "Artisan":
                if (castles == null)
                    return false;
                return castles.hasHolding("Hall")|| castles.hasHolding("Small Castle")
                        || castles.hasHolding("Castle") || castles.hasHolding("Superior Castle");
            case "Maester":
                return !wealthHoldings.hasHolding("Maester") && influence > 20;
            case "Marketplace":
                if (domains == null)
                    return false;
                return !wealthHoldings.hasHolding("Marketplace") && domains.hasHolding("Community: Small Town")
                        || domains.hasHolding("Community: Large Town") || domains.hasHolding("Community: Small City")
                        || domains.hasHolding("Community: Large City");
            case "Mine":
                if (domains == null)
                    return false;
                return domains.hasTerrain("Hills") || domains.hasTerrain("Mountains");
            case "Port":
                if (domains == null)
                    return false;
                return !wealthHoldings.hasHolding("Port") && domains.hasTerrain("Coastline");
        }
        return false;
    }

    public boolean hasWealthRequirements(String wealth) {
        return hasWealthRequirements(new Wealth(wealth));
    }

    public void generateWealthHoldings() {
        int toSpend = wealth;
        wealthHoldings = new WealthList();

        int loops = 4;
        while (toSpend >= 10 && --loops >= 0) {
            if (toSpend >= 15 && hasWealthRequirements("Sept")) {
                wealthHoldings.insert(new WealthNode("Sept"));
                toSpend -= 15;
            }
            if (toSpend >= 5 && hasWealthRequirements("GodsWood")) {
                wealthHoldings.insert(new WealthNode("GodsWood"));
                toSpend -= 5;
            }
            if (toSpend >= 15 && hasWealthRequirements("Guilds")) {
                wealthHoldings.insert(new WealthNode("Guilds"));
                toSpend -= 15;
            }
            if (toSpend >= 10 && hasWealthRequirements("Artisan")) {
                wealthHoldings.insert(new WealthNode("Artisan"));
                toSpend -= 10;
            }
            if (toSpend >= 10 && hasWealthRequirements("Maester")) {
                wealthHoldings.insert(new WealthNode("Maester"));
                toSpend -= 10;
            }
            if (toSpend >= 10 && hasWealthRequirements("Marketplace")) {
                wealthHoldings.insert(new WealthNode("Marketplace"));
                toSpend -= 10;
            }
            if (toSpend >= 10 && hasWealthRequirements("Mine")) {
                wealthHoldings.insert(new WealthNode("Mine"));
                toSpend -= 10;
            }
            if (toSpend >= 10 && hasWealthRequirements("Port")) {
                wealthHoldings.insert(new WealthNode("Port"));
                toSpend -= 10;
            }
        }
    }

    public void buyWealthHolding(String toBuy) {
        if (wealthHoldings == null)
            wealthHoldings = new WealthList();
        wealthHoldings.insert(new WealthNode(toBuy));
    }

    public void generateLawHoldings() {
        lawHoldings = printLawHoldings();
    }

    public void generatePowerHoldings() {
        //if house has barely enough power for a Banner house, 40% of generating one
        //if house has enough for two banner houses (30+), buy the first one.
        int toSpend = power;

        if (toSpend >= 50) {
            //buy first Banner house
            toSpend -= 20;
            buyBanner();
        }
        if (toSpend >= 30) {
            //if there are still 30 or more points,
            //66% chance to buy banner house
            if (die.roll() >= 3) {
                toSpend -= 10;
                buyBanner();
            }
        }
        if (toSpend >= 25) {
            //33% chance of buying Banner
            if (die.roll() >= 5) {
                toSpend -= 5;
                buyBanner();
            }
        }
        //After buying any banner houses, purchase units
    }

    public void generateDefenseHoldings() {
        castles = new DefenseList();
        int toSpend = defense;
        DefenseNode temp = new DefenseNode();

        while (toSpend >= 10) {
            if (toSpend > 60) {
                //superior castle
                temp.setType(1);
                toSpend -= temp.getCost();
                castles.insert(temp);
            }
            if (toSpend > 50) {
                //castle
                temp.setType(2);
                toSpend -= temp.getCost();
                castles.insert(temp);
            }
            if (toSpend > 40) {
                //small castle
                temp.setType(3);
                toSpend -= temp.getCost();
                castles.insert(temp);
            }
            if (toSpend > 30) {
                //Hall
                temp.setType(4);
                toSpend -= temp.getCost();
                castles.insert(temp);
            }
            if (toSpend >= 10) {
                //Tower
                temp.setType(5);
                toSpend -= temp.getCost();
                castles.insert(temp);
            }
        }
    }

    public boolean canAfford(String toBuy) {
        if (toBuy == null)
            return false;
        //check if heir
        switch (toBuy) {
            case "Heir One":
                if (getInfluenceRemaining() >= 20 && firstHeir == null)
                    return true;
                return false;
            case "Heir Two":
                if (getInfluenceRemaining() >= 10 && secondHeir == null)
                    return true;
                return false;
            case "Heir Three":
                if (getInfluenceRemaining() >= 5)
                    return true;
                return false;
        }

        DefenseHolding temp = new DefenseHolding();
        //Test if toBuy is a defense structure and can be bought
        if (temp.isValid(toBuy) && getDefenseRemaining() >= temp.getCost())
            return true;
        //check if wealth
        Wealth wealth = new Wealth();
        if (wealth.isValid(toBuy) && getWealthRemaining() >= wealth.getCost()
                && hasWealthRequirements(wealth))
            return true;
        return  false;
    }

    public boolean canAfford(Domain domain) {
        if (domain == null)
            return false;
        if (domain.getCost() <= getLandsRemaining())
            return true;
        return false;
    }

    public void buyDefenseHolding(String toBuy) {
        if (castles == null)
            castles = new DefenseList();
        if (canAfford(toBuy)) {
            DefenseNode temp = new DefenseNode(toBuy);
            castles.insert(temp);
        }
    }

    public void buyInfluenceHolding(String toBuy) {
        if (toBuy != null) {
            if (canAfford(toBuy)) {
                switch (toBuy) {
                    case "Heir One":
                        firstHeir = new Character();
                        break;
                    case "Heir Two":
                        secondHeir = new Character();
                        break;
                    case "Heir Three":
                        if (heirs == null)
                            heirs = new CharacterList();
                        heirs.insert(new Character());
                        break;
                }
            }
        }
    }

    public void buyLandHolding(Domain toBuy) {
        if (toBuy == null)
            return;
        if (domains == null)
            domains = new DomainList();
        domains.insert(toBuy);
    }

    public void generateHeirs() {
        setMaxStatus();
        int toSpend = influence;
        boolean firstHeir = false;
        boolean secondHeir = false;
        if (toSpend > 5)
            heirs = new CharacterList();

        /*create new character with
            > House name
            > realm
            > gender
            > max status
          */

        while (toSpend > 5) {
            if (!firstHeir && toSpend >= 20) {
                firstHeir = true;
                if (realm != "Dorne") {
                    CharacterNode temp = new CharacterNode(name, realm, "Male", maxStatus -1);
                    temp.generateCharacter();
                    heirs.insert(temp);
                }
                else {
                    CharacterNode temp = new CharacterNode(name, realm, maxStatus -1);
                    temp.generateCharacter();
                    heirs.insert(temp);
                }
                toSpend -= 20;
            }
            if (!secondHeir && toSpend >= 10) {
                secondHeir = true;
                CharacterNode temp = new CharacterNode(name, realm, maxStatus -2);
                temp.generateCharacter();
                heirs.insert(temp);
                toSpend -= 10;
            }
            if (toSpend >= 5) {
                CharacterNode temp = new CharacterNode(name, realm, maxStatus -3);
                temp.generateCharacter();
                heirs.insert(temp);
                toSpend -= 5;
            }
        }
    }

    //+++++BANNER HOUSE SECTION+++++
    //used to generate Banner House based on realm, age, and influence of Home House
    public void buyBanner() {
        if (banners == null)
            banners = new HouseList();

        HouseNode temp = new HouseNode();
        temp.generateBannerHouse(realm, age, influence);
        temp.setLiegeHouse((HouseNode) this);
        banners.insert(temp);
    }

    public void generateBannerHouse(String realm, int ageMax, int influenceMax) {
        this.realm = realm;
        this.isBanner = true;
        randName();
        randStats(influenceMax, 5);
        createHistory(ageMax);
        generateLandHoldings();
        generateDefenseHoldings();
        generateLawHoldings();
        generatePopulationHoldings();
        generateWealthHoldings();
        generateSteward();
        generateHeirs();
    }

    //create random stats for Banner House
    public void randStats(int influenceMax, int maxDice) {
        defense = die.roll(maxDice);
        influence = die.roll(maxDice);
        lands = die.roll(maxDice);
        law = die.roll(maxDice);
        population = die.roll(maxDice);
        power = die.roll(maxDice);
        wealth = die.roll(maxDice);

        //banner house can't have greater influence than
        //Home House
        if (influence > influenceMax)
            influence = influenceMax;

        realmModifier();
    }

    //creates history for Banner House
    private void createHistory(int ageMax) {
        //generate age
        Data data = new Data();
        age = ageMax + 1;

        founded = data.getAge(age);
        history = new History(data.getHistory(age));

        foundingEvent = history.head.getEvent();
        historyModifier();
    }

    //SETTERS AND GETTERS
    public String getName() {
        return name;
    }

    public int getMaxStatus() {
        setMaxStatus();
        return maxStatus;
    }

    public Character getSteward() {
        return steward;
    }

    public CharacterList getHeirs() {
        return heirs;
    }

    public CharacterList getResidents() {
        return residents;
    }

    public int getDefense() {
        return defense;
    }

    public int getDefenseInvested() {
        if (castles != null)
            return castles.getCost();
        return 0;
    }

    public int getDefenseRemaining() {
        return defense - getDefenseInvested();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() { return age; }

    public int getInfluence() { return influence; }

    public int getInfluenceInvested() {
        int toReturn = 0;
        if (firstHeir != null)
            toReturn += 20;
        if (secondHeir != null)
            toReturn += 10;
        if (heirs != null)
            toReturn += 5*heirs.getCount();

        return toReturn;
    }

    public int getInfluenceRemaining() {
        return influence - getInfluenceInvested();
    }

    public int getLands() { return lands; }

    public int getLandsInvested() {
        if (domains != null)
            return domains.getCost();
        else
            return 0;
    }

    public int getLandsRemaining() {
        return lands - getLandsInvested();
    }

    public int getLaw() { return law; }

    public int getPopulation() { return population; }

    public int getPower() { return power; }

    public int getPowerInvested() {
        int toReturn = 0;
        //add up banners
        if (banners!= null) {
            int num = banners.getNum();
            while (num-- > 0) {
                if (num == 1)
                    toReturn += 20;
                if (num == 2)
                    toReturn += 10;
                if (num >= 3)
                    toReturn += 5;
            }
        }
        //add up units

        return toReturn;
    }

    public int getPowerRemaining() {
        return power - getPowerInvested();
    }

    public int getWealth() { return wealth; }

    public int getWealthInvested() {
        if (wealthHoldings != null)
            return wealthHoldings.getCost();
        return 0;
    }

    public int getWealthRemaining() {
        return wealth - getWealthInvested();
    }

}
