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
    private boolean isBanner;
    private DomainList domains;
    private DefenseList castles;
    private CharacterList heirs;

    //+++++GENERAL METHODS+++++
    //default constructor
    public House() {
        die = new Dice();
        history = null;
        name = null;
        founded = null;
        foundingEvent = null;
        banners = null;
        isBanner = false;
        domains = null;
        castles = null;
        steward = null;
    }

    //Constructor with House name
    public House(String name) {
        die = new Dice();
        this.name = new String(name);
        founded = null;
        foundingEvent = null;
        realm = null;
        history = null;
        banners = null;
        isBanner = false;
        domains = null;
        castles = null;
        steward = null;
    }

    //Copy Constructor
    public House(House toCopy) {
        die = new Dice();
        copyHouse(toCopy);
    }

    //set's House name
    public void setName(String toName) {
        name = toName;
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

        //Holdings
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

    //+++++DISPLAY SECTION+++++
    //calls all display functions
    public void displayAll() {
        displayHouseInfo();
        displayStats();
        displayHeirs();
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
        Data data = new Data();
        System.out.println("Defense " + defense + ": " + data.getDefenseDefinition(defense) + "\n" +
                "Influence " + influence + ": " + data.getInfluenceDefinition(influence) + "\n" +
                "Lands " + lands + ": " + data.getLandsDefinition(lands) + "\n" +
                "Law " + law + ": " + data.getLawDefinition(law) + "\n" +
                "Populaion " + population + ": " + data.getPopulationDefinition(population) + "\n" +
                "Power " + power + ": " + data.getPowerDefinition(power) + "\n" +
                "Wealth " + wealth + ": " + data.getWealthDefinition(wealth));
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
        if (heirs != null) {
            System.out.println("\nHeirs: ");
            heirs.display();
        }
        else
            System.out.println("\nNo Heirs.");
    }

    //+++++HOME HOUSE SECTION+++++
    //Create all random info except House name
    //House name may eventually be added.
    public void generateRandHouse() {
        randRealm();
        randStats();
        createHistory();
        generateSteward();
        generateHoldings();
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

        realmModifier();
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
    }

    //+++++HOLDINGS SECTION+++++
    public void generateHoldings() {
        generatePowerHoldings();
        generateLandHoldings();
        generateDefenseHoldings();
        generateHeirs();
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
        banners.insert(temp);
    }

    public void generateBannerHouse(String realm, int ageMax, int influenceMax) {
        this.realm = realm;
        this.isBanner = true;
        randStats(influenceMax, 5);
        createHistory(ageMax);
        generateLandHoldings();
        generateDefenseHoldings();
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
}