import java.util.Random;

/**
 * Created by arredon on 10/9/2016.
 */
public class Character {
    //name
    private String name;
    private String title;
    //bio stuff
    private String age;
    private String gender;
    private String background;
    private String goal;
    private String motivation;
    private String virtue;
    private String vice;
    //house stuff
    private String houseName;
    private String realm;
    //stats
    private int agility, animalHandling, athletics, awareness, cunning, deception, endurance, fighting,
                healing, knowledge, marksmanship, persuasion, status, stealth, survival,
                thievery, warfare, will;
    private int language;   //this eventually should be translated into a list of known languages.
    private int moveSpeed; //movement speed of character
    //Destiny and qualities
    private int destinyPoints;
    private int maximumBenefits;
    private int requiredDrawbacks;
    //specialties
    private int specialtyExperience;
    private int[] agilitySpecialties, animalHandlingSpecialties, athleticsSpecialties,
            awarenessSpecialties, cunningSpecialties, deceptionSpecialties, enduranceSpecialties,
            fightingSpecialties, healingSpecialties, knowledgeSpecialties, marksmanshipSpecialties,
            persuasionSpecialties, statusSpecialties, stealthSpecialties, survivalSpecialties,
            thieverySpecialties, warfareSpecialties, willSpecialties;
    //derived stats
    private int combatDefense, health, intrigueDefense, composure;
    //gear info
    private int defensiveBonus, armorPenalty;
    private Weapon weapon1, weapon2, weapon3, offHand;
    private Armor armor;

    private int experience;

    public Character() {
        nullAll();
        status = -1;
        startingStats();
    }

    public Character(Character toCopy) {
        nullAll();
        copyCharacter(toCopy);
    }

    public Character(String name) {
        nullAll();
        this.name = name;
        status = -1;
        startingStats();
    }

    public Character(String houseName, String realm, String gender, int status) {
        nullAll();
        this.houseName = houseName;
        this.realm = realm;
        this.gender = gender;
        this.status = status;
        startingStats();
    }

    public Character(String houseName, String realm, int status) {
        nullAll();
        this.houseName = houseName;
        this.realm = realm;
        this.status = status;
        startingStats();
    }

    //this exists because there are so many constructors
    private void nullAll() {
        name = null;
        gender = null;
        title = null;
        houseName = null;
        realm = null;
        background = null;
        goal = null;
        motivation = null;
        virtue = null;
        vice = null;
        //gear
        armor = null;
        weapon1 = null;
        weapon2 = null;
        weapon3 = null;
        offHand = null;
        //specialties
        agilitySpecialties = null;
        animalHandlingSpecialties = null;
        athleticsSpecialties = null;
        awarenessSpecialties = null;
        cunningSpecialties = null;
        deceptionSpecialties = null;
        enduranceSpecialties = null;
        fightingSpecialties = null;
        healingSpecialties = null;
        knowledgeSpecialties = null;
        marksmanshipSpecialties = null;
        persuasionSpecialties = null;
        statusSpecialties = null;
        stealthSpecialties = null;
        survivalSpecialties = null;
        thieverySpecialties = null;
        warfareSpecialties = null;
        willSpecialties = null;

    }

    public void displayAll() {
        displayName();
        displayBio();
        System.out.println();
        displayConcept();
        System.out.println();
        displayStats();
        System.out.println();
        displayCombatInfo();
        System.out.println();
        displayGear();

        System.out.println("----------");
    }

    //displays name and house information
    public void displayName() {
        if (title != null)
            System.out.print(title + " ");
        System.out.print(name);
        if (houseName != null)
            System.out.print(" of House " + houseName);
        if (realm != null)
            System.out.println(" of " + realm);
        else
            System.out.println();
    }

    public void displayBio() {
        System.out.println("Age: " + age + "\n" +
                "Gender: " + gender);
    }

    public void displayStats() {
        displayStatus();
        displayAgility();
        displayAnimalHandling();
        displayAthletics();
        displayAwareness();
        displayCunning();
        displayDeception();
        displayEndurance();
        displayFighting();
        displayHealing();
        displayKnowledge();
        displayMarksmanship();
        displayPersuasion();
        displayStealth();
        displaySurvival();
        displayThievery();
        displayWarfare();
        displayWill();

        if (language > 2)
            System.out.println("Language: " + language);
    }

    public void displayCombatInfo() {
        //movement
        displayMoveSpeed();
        //armor
        if (armor == null)
            System.out.println("Armor (None): 0\n");
        else
            System.out.println("Armor (" + armor.getName() + "): " + armor.getArmorRating()
                + "\n");

        //derived stats
        displayDerivedStats();
    }

    public void displayDerivedStats() {
        System.out.println("Combat Defense\t\tIntrigue Defense");
        if (armor != null)
            System.out.println(combatDefense + " (" + (combatDefense + armor.getArmorPenalty() )
                + " W/Armor)\t\t" + intrigueDefense);
        else
            System.out.println(combatDefense + "\t\t\t\t\t" + intrigueDefense);

        System.out.println("\nHealth\t\t\t\tComposure");
        System.out.println(health + "\t\t\t\t\t" + composure);
    }

    public void displayConcept() {
        System.out.println("Background: " + background + "\n" +
                "Goal: " + goal + "\n" +
                "Motivation: " + motivation + "\n" +
                "Virtue: " + virtue + "\n" +
                "Vice: " + vice);
    }

    public void displayGear() {
        System.out.println("Gear: ");
        displayWeapons();
        System.out.println("Armor: ");
        displayArmor();
    }

    public void displayMoveSpeed() {
        setMoveSpeed();
        if (armor == null)
            System.out.println("Movement: " + moveSpeed + "\n");
        else {
            int temp = moveSpeed - armor.getBulk();
            if (temp < 1)
                temp = 1;
            System.out.println("Movement: " + moveSpeed + " (" +
                    temp + " W/Armor)");
        }
    }

    public void displayArmor() {
        if (armor == null)
            System.out.println("No Armor.");
        else
            armor.display();
    }

    public void displayWeapons() {
        if (weapon1 != null) {
            System.out.print("Weapon 1: ");
            weapon1.display();
            System.out.println("\n");
        }
        if (offHand != null) {
            System.out.print("Off-Hand: ");
            offHand.display();
            System.out.println("\n");
        }
        if (weapon2 != null) {
            System.out.print("Weapon 2: ");
            weapon2.display();
            System.out.println("\n");
        }
        if (weapon3 != null) {
            System.out.print("Weapon 3: ");
            weapon3.display();
            System.out.println("\n");
        }
    }

    public void generateCharacter() {
        randAge();
        randStats();
        randSpecialties();
        if (gender == null) {
            randGender();
        }
        if (name == null) {
            Data data = new Data();
            if (gender.equalsIgnoreCase("Male"))
                name = data.randMaleName();
            else
                name = data.randFemaleName();
        }
        generateConcept();
        generateDerivedStats();
    }

    public void generateConcept() {
        randBackground();
        randGoal();
        randMotivation();
        randVirtue();
        randVice();
    }

    public void randBackground() {
        Data data = new Data();
        background = data.randBackground();
    }

    public void randGoal() {
        Data data = new Data();
        goal = data.randGoal();
    }

    public void randMotivation() {
        Data data = new Data();
        motivation = data.randMotivation();
    }

    public void randVirtue() {
        Data data = new Data();
        virtue = data.randVirtue();
    }

    public void randVice() {
        Data data = new Data();
        vice = data.randVice();
    }

    public void randGender() {
        Dice die = new Dice();
        if (die.roll() > 3)
            gender = "Male";
        else
            gender = "Female";
    }

    public void randMaleName() {
        Data data = new Data();
        name = data.randMaleName();
    }

    public void randFemaleName() {
        Data data = new Data();
        name = data.randFemaleName();
    }

    public void randAge() {
        Dice die = new Dice();
        int num = die.roll(3);
        switch (num) {
            case 3: age = "Youth";
                experience = 120;
                specialtyExperience = 40;
                destinyPoints = 7;
                maximumBenefits = 3;
                requiredDrawbacks = 0;
                break;
            case 4: age = "Adolescent";
                specialtyExperience = 40;
                destinyPoints = 6;
                experience = 150;
                maximumBenefits = 3;
                requiredDrawbacks = 0;
                break;
            case 5:
            case 6: age = "Young Adult";
                experience = 180;
                specialtyExperience = 60;
                destinyPoints = 5;
                maximumBenefits = 3;
                requiredDrawbacks = 0;
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11: age = "Adult";
                experience = 210;
                specialtyExperience = 80;
                destinyPoints = 4;
                maximumBenefits = 3;
                requiredDrawbacks = 1;
                break;
            case 12:
            case 13:
            case 14:
            case 15: age = "Middle Age";
                experience = 240;
                specialtyExperience = 100;
                destinyPoints = maximumBenefits = 3;
                requiredDrawbacks = 2;
                break;
            case 16: age = "Old";
                specialtyExperience = 160;
                experience = 270;
                destinyPoints = maximumBenefits = 2;
                requiredDrawbacks = 3;
                break;
            case 17: age = "Very Old";
                specialtyExperience = 200;
                experience = 330;
                destinyPoints = maximumBenefits = 1;
                requiredDrawbacks = 4;
                break;
            case 18: age = "Venerable";
                specialtyExperience = 240;
                experience = 360;
                destinyPoints = maximumBenefits = 0;
                requiredDrawbacks = 5;
        }
    }

    public void calculateExperience() {
        switch (age) {
            case "Youth": experience = 120;
                break;
            case "Adolescent": experience = 150;
                break;
            case "Young Adult": experience = 180;
                break;
            case "Adult": experience = 210;
                break;
            case "Middle Age": experience = 240;
                break;
            case "Old": experience = 270;
                break;
            case "Very Old": experience = 330;
                break;
            case "Venerable": experience = 360;
        }
        if (status == 3)
            experience -= 10;
        else if (status > 3)
            experience -= (status - 3) * 30;
    }

    public void setMoveSpeed() {
        moveSpeed = 3;
        if (athleticsSpecialties != null)
            moveSpeed += athleticsSpecialties[2] / 2;
    }

    /*
Adult
    Any one
Middle Age
    A flaw for any of the following abilities:
    Agility, Athletics, or Endurance
Old
    Any one plus a flaw for any of the following abilities:
    Agility, Athletics, Awareness, Cunning, Endurance,
    Fighting, or Marksmanship
Very Old
    Any one plus a flaw for any two of the following
    abilities: Agility, Athletics, Awareness, Cunning,
    Endurance, Fighting, or Marksmanship
Venerable
    Any one plus a flaw for any three of the following
    abilities: Agility, Athletics, Awareness, Cunning,
    Endurance, Fighting, or Marksmanship
     */

    public void setDrawbacks() {
        if (requiredDrawbacks > 0) {
            switch (requiredDrawbacks) {
                case 2: //Middle age: agility, athletics, or endurance
                    break;
                case 5: //Adult: any one
                case 4: //Old: plus flaw for Agility, Athletics, Awareness,
                        //Cunning, Endurance, Fighting, or Markmanship
                case 3: //Very Old: plus another Old
                case 1: //Venerable plus another Old
                    break;
                    default:
                        System.out.println("Drawback error");
            }
        }
    }

    //generates all stats.
    //if stats equals zero, then generate status as well
    public void randStats() {
        //first, generate status if not provided
        if (status == -1)
            randStatus();
        //the, calculate remaining experience
        calculateExperience();
        //then, randomly purchase upgrades until experience == 0
        Random rand = new Random();
        int improve;
        while (experience > 0) {
            improve = rand.nextInt(18) + 1;
            switch (improve) {
                case 1: ++agility;
                    if (agility == 3)
                        experience -= 10;
                    else
                        experience -= 30;
                    break;
                case 2: ++animalHandling;
                    if (animalHandling == 3)
                        experience -= 10;
                    else
                        experience -= 30;
                    break;
                case 3: ++athletics;
                    if (athletics == 3)
                        experience -= 10;
                    else
                        experience -= 30;
                    break;
                case 4: ++awareness;
                    if (awareness == 3)
                        experience -= 10;
                    else
                        experience -= 30;
                    break;
                case 5: ++cunning;
                    if (cunning == 3)
                        experience -= 10;
                    else
                        experience -= 30;
                    break;
                case 6: ++deception;
                    if (deception == 3)
                        experience -= 10;
                    else
                        experience -= 30;
                    break;
                case 7: ++endurance;
                    if (endurance == 3)
                        experience -= 10;
                    else
                        experience -= 30;
                    break;
                case 8: ++fighting;
                    if (fighting == 3)
                        experience -= 10;
                    else
                        experience -= 30;
                    break;
                case 9: ++healing;
                    if (healing == 3)
                        experience -= 10;
                    else
                        experience -= 30;
                    break;
                case 10: ++language;
                    if (language == 3)
                        experience -= 10;
                    else
                        experience -= 30;
                    break;
                case 11: ++knowledge;
                    if (knowledge == 3)
                        experience -= 10;
                    else
                        experience -= 30;
                    break;
                case 12: ++marksmanship;
                    if (marksmanship == 3)
                        experience -= 10;
                    else
                        experience -= 30;
                    break;
                case 13: ++persuasion;
                    if (persuasion == 3)
                        experience -= 10;
                    else
                        experience -= 30;
                    break;
                case 14: ++stealth;
                    if (stealth == 3)
                        experience -= 10;
                    else
                        experience -= 30;
                    break;
                case 15: ++survival;
                    if (survival == 3)
                        experience -= 10;
                    else
                        experience -= 30;
                    break;
                case 16: ++thievery;
                    if (thievery == 3)
                        experience -= 10;
                    else
                        experience -= 30;
                    break;
                case 17: ++warfare;
                    if (warfare == 3)
                        experience -= 10;
                    else
                        experience -= 30;
                    break;
                case 18: ++will;
                    if (will == 3)
                        experience -= 10;
                    else
                        experience -= 30;
                    break;
            }
        }
    }

    public void randSpecialties() {
        calculateExperience();
        Random rand = new Random();
        int num;
        int toSpend = specialtyExperience;

        while (toSpend > 10) {
            num = rand.nextInt(17) + 1;
            switch (num) {
                case 1:
                    if (agilitySpecialties == null) {
                        agilitySpecialties = new int[5];
                        for (int i = 0; i < 5; ++i)
                            agilitySpecialties[i] = 0;
                    }
                    num = rand.nextInt(5);
                    if (agilitySpecialties[num] < agility) {
                        ++agilitySpecialties[num];
                        toSpend -= 10;
                    }
                    break;
                case 2:
                    if (animalHandlingSpecialties == null) {
                        animalHandlingSpecialties = new int[4];
                        for (int i = 0; i < 4; ++i)
                            animalHandlingSpecialties[i] = 0;
                    }
                    num = rand.nextInt(4);
                    if (animalHandlingSpecialties[num] < animalHandling) {
                        ++animalHandlingSpecialties[num];
                        toSpend -= 10;
                    }
                    break;
                case 3:
                    if (athleticsSpecialties == null) {
                        athleticsSpecialties = new int[6];
                        for (int i = 0; i < 6; ++i)
                            athleticsSpecialties[i] = 0;
                    }
                    num = rand.nextInt(6);
                    if (athleticsSpecialties[num] < athletics) {
                        ++athleticsSpecialties[num];
                        toSpend -= 10;
                    }
                    break;
                case 4:
                    if (awarenessSpecialties == null) {
                        awarenessSpecialties = new int[2];
                        awarenessSpecialties[0] = 0;
                        awarenessSpecialties[1] = 0;
                    }
                    num = rand.nextInt(2);
                    if (awarenessSpecialties[num] < awareness) {
                        ++awarenessSpecialties[num];
                        toSpend -= 10;
                    }
                    break;
                case 5:
                    if (cunningSpecialties == null) {
                        cunningSpecialties = new int[3];
                        for (int i = 0; i < 3; ++i)
                            cunningSpecialties[i] = 0;
                    }
                    num = rand.nextInt(3);
                    if (cunningSpecialties[num] < cunning) {
                        ++cunningSpecialties[num];
                        toSpend -= 10;
                    }
                    break;
                case 6:
                    if (deceptionSpecialties == null) {
                        deceptionSpecialties = new int[4];
                        for (int i = 0; i < 4; ++i)
                            deceptionSpecialties[i] = 0;
                    }
                    num = rand.nextInt(4);
                    if (deceptionSpecialties[num] < deception) {
                        ++deceptionSpecialties[num];
                        toSpend -= 10;
                    }
                    break;
                case 7:
                    if (enduranceSpecialties == null) {
                        enduranceSpecialties = new int[2];
                        enduranceSpecialties[0] = 0;
                        enduranceSpecialties[1] = 0;
                    }
                    num = rand.nextInt(2);
                    if (enduranceSpecialties[num] < endurance) {
                        ++enduranceSpecialties[num];
                        toSpend -= 10;
                    }
                    break;
                case 8:
                    if (fightingSpecialties == null) {
                        fightingSpecialties = new int[9];
                        for (int i = 0; i < 9; ++i)
                            fightingSpecialties[i] = 0;
                    }
                    num = rand.nextInt(9);
                    if (fightingSpecialties[num] < fighting) {
                        ++fightingSpecialties[num];
                        toSpend -= 10;
                    }
                    break;
                case 9:
                    if (healingSpecialties == null) {
                        healingSpecialties = new int[3];
                        healingSpecialties[0] = 0;
                        healingSpecialties[1] = 0;
                        healingSpecialties[2] = 0;
                    }
                    num = rand.nextInt(3);
                    if (healingSpecialties[num] < healing) {
                        ++healingSpecialties[num];
                        toSpend -= 10;
                    }
                    break;
                case 10:
                    if (knowledgeSpecialties == null) {
                        knowledgeSpecialties = new int[3];
                        knowledgeSpecialties[0] = 0;
                        knowledgeSpecialties[1] = 0;
                        knowledgeSpecialties[2] = 0;
                    }
                    num = rand.nextInt(3);
                    if (knowledgeSpecialties[num] < knowledge) {
                        ++knowledgeSpecialties[num];
                        toSpend -= 10;
                    }
                    break;
                case 11:
                    if (marksmanshipSpecialties == null) {
                        marksmanshipSpecialties = new int[4];
                        for (int i = 0; i < 4; ++i)
                            marksmanshipSpecialties[i] = 0;
                    }
                    num = rand.nextInt(4);
                    if (marksmanshipSpecialties[num] < marksmanship) {
                        ++marksmanshipSpecialties[num];
                        toSpend -= 10;
                    }
                    break;
                case 12:
                    if (persuasionSpecialties == null) {
                        persuasionSpecialties = new int[7];
                        for (int i = 0; i < 7; ++i)
                            persuasionSpecialties[i] = 0;
                    }
                    num = rand.nextInt(7);
                    if (persuasionSpecialties[num] < persuasion) {
                        ++persuasionSpecialties[num];
                        toSpend -= 10;
                    }
                    break;
                case 13:
                    if (statusSpecialties == null) {
                        statusSpecialties = new int[4];
                        for (int i = 0; i < 4; ++i)
                            statusSpecialties[i] = 0;
                    }
                    num = rand.nextInt(4);
                    if (statusSpecialties[num] < status) {
                        ++statusSpecialties[num];
                        toSpend -= 10;
                    }
                    break;
                case 14:
                    if (stealthSpecialties == null) {
                        stealthSpecialties = new int[2];
                        stealthSpecialties[0] = 0;
                        stealthSpecialties[1] = 0;
                    }
                    num = rand.nextInt(2);
                    if (stealthSpecialties[num] < stealth) {
                        ++stealthSpecialties[num];
                        toSpend -= 10;
                    }
                    break;
                case 15:
                    if (thieverySpecialties == null) {
                        thieverySpecialties = new int[3];
                        thieverySpecialties[0] = 0;
                        thieverySpecialties[1] = 0;
                        thieverySpecialties[2] = 0;
                    }
                    num = rand.nextInt(3);
                    if (thieverySpecialties[num] < thievery) {
                        ++thieverySpecialties[num];
                        toSpend -= 10;
                    }
                    break;
                case 16:
                    if (warfareSpecialties == null) {
                        warfareSpecialties = new int[3];
                        warfareSpecialties[0] = 0;
                        warfareSpecialties[1] = 0;
                        warfareSpecialties[2] = 0;
                    }
                    num = rand.nextInt(3);
                    if (warfareSpecialties[num] < warfare) {
                        ++warfareSpecialties[num];
                        toSpend -= 10;
                    }
                    break;
                case 17:
                    if (willSpecialties == null) {
                        willSpecialties = new int[3];
                        willSpecialties[0] = 0;
                        willSpecialties[1] = 0;
                        willSpecialties[2] = 0;
                    }
                    num = rand.nextInt(3);
                    if (willSpecialties[num] < will) {
                        ++willSpecialties[num];
                        toSpend -= 10;
                    }
                    break;
                default:
                    System.out.println("Specialty Assignment Error");

            }
        }
    }

    public void randStatus() {
        Dice die = new Dice();
        int num = die.roll(2);
        switch (num) {
            case 2: status = 2;
                break;
            case 3:
            case 4: status = 3;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9: status = 4;
                break;
            case 10:
            case 11: status = 5;
                break;
            case 12: status = 6;
        }
    }

    public void generateDerivedStats() {
        combatDefense = agility + awareness + athletics
                + defensiveBonus - armorPenalty;
        health = endurance * 3;
        intrigueDefense = awareness + cunning + status;
        composure = will * 3;
    }

    public void copyCharacter(Character toCopy) {
        this.name = toCopy.name;
        this.title = toCopy.title;
        this.realm = toCopy.realm;
        this.houseName = toCopy.houseName;
        this.status = toCopy.status;
        this.gender = toCopy.gender;
        this.age = toCopy.age;
        this.experience = toCopy.experience;

        this.agility = toCopy.agility;
        this.animalHandling = toCopy.animalHandling;
        this.athletics = toCopy.athletics;
        this.awareness = toCopy.awareness;
        this.cunning = toCopy.cunning;
        this.deception = toCopy.cunning;
        this.endurance = toCopy.endurance;
        this.fighting = toCopy.fighting;
        this.healing = toCopy.healing;
        this.language = toCopy.language;
        this.knowledge = toCopy.knowledge;
        this.marksmanship = toCopy.marksmanship;
        this.persuasion = toCopy.persuasion;
        this.stealth = toCopy.stealth;
        this.survival = toCopy.survival;
        this.thievery = toCopy.thievery;
        this.warfare = toCopy.warfare;
        this.will = toCopy.will;
    }

    public void startingStats() {
        agility = 2;
        animalHandling = 2;
        athletics = 2;
        awareness = 2;
        cunning = 2;
        deception = 2;
        endurance = 2;
        fighting = 2;
        healing = 2;
        language = 2;
        knowledge = 2;
        marksmanship = 2;
        persuasion = 2;
        stealth = 2;
        survival = 2;
        thievery = 2;
        warfare = 2;
        will = 2;
    }

    //++++++++++Setters and Getters++++++++++
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        String temp = new String() ;
        if (title != null) {
            temp = title;
            temp = temp.concat(" ");
        }
        temp = temp.concat(name);

        return temp;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void giveWeapon(Weapon toGive) {
        String ability;
        int score;
        if (toGive != null) {
            ability = toGive.getAbility();
            switch (ability) {
                case "Athletics":
                    score = athletics;
                    break;
                case "Agility":
                    score = agility;
                    break;
                case "Animal Handling":
                    score = animalHandling;
                    break;
                case "None":
                    score = 0;
                    break;
                default:
                    System.out.println("GiveWeapon Error");
                    score = 0;
            }
            if (weapon1 == null)
                weapon1 = new Weapon(toGive.getName(),score);

            else if (weapon2 == null)
                weapon2 = new Weapon(toGive.getName(),score);

            else if (weapon3 == null)
                weapon3 = new Weapon(toGive.getName(),score);

            else
                weapon3.setWeapon(toGive.getName(),score);
        }
    }

    public void giveOffHand(Weapon toGive) {
        String ability;
        int score;
        if (toGive != null) {
            ability = toGive.getAbility();
            switch (ability) {
                case "Athletics":
                    score =athletics;
                    break;
                case "Agility":
                    score = agility;
                    break;
                case "Animal Handling":
                    score = animalHandling;
                    break;
                case "None":
                    score = 0;
                    break;
                default:
                    System.out.println("GiveWeapon Error");
                    score = 0;
            }

            if (offHand == null)
                offHand = new Weapon(toGive.getName(), score);
            else
                offHand.setWeapon(toGive.getName(), score);
        }

    }

    public void giveArmor(Armor toGive) {
        armor = toGive;
    }

    //display stats stuff
    public void displayAgility() {
        if (agility > 2 || agilitySpecialties != null) {
            System.out.print("Agility: " + agility + "\t\t\t||");
            if (agilitySpecialties != null) {
                if (agilitySpecialties[0] > 0)
                    System.out.print("Acrobatics " + agilitySpecialties[0] + " ");
                if (agilitySpecialties[1] > 0)
                    System.out.print("Balance " + agilitySpecialties[1] + " ");
                if (agilitySpecialties[2] > 0)
                    System.out.print("Contortions " + agilitySpecialties[2] + " ");
                if (agilitySpecialties[3] > 0)
                    System.out.print("Dodge " + agilitySpecialties[3] + " ");
                if (agilitySpecialties[4] > 0)
                    System.out.print("Quickness " + agilitySpecialties[4] + " ");
            }
            System.out.println();
        }
    }

    public void displayAnimalHandling() {
        if (animalHandling > 2 || animalHandlingSpecialties != null) {
            System.out.print("Animal Handling: " + animalHandling + "\t||");
            if (animalHandlingSpecialties != null) {
                if (animalHandlingSpecialties[0] > 0)
                    System.out.print("Charm " + animalHandlingSpecialties[0] + " ");
                if (animalHandlingSpecialties[1] > 0)
                    System.out.print("Drive " + animalHandlingSpecialties[1] + " ");
                if (animalHandlingSpecialties[2] > 0)
                    System.out.print("Ride " + animalHandlingSpecialties[2] + " ");
                if (animalHandlingSpecialties[3] > 0)
                    System.out.print("Train " + animalHandlingSpecialties[3] + " ");
            }
            System.out.println();
        }
    }

    public void displayAthletics() {
        if (athletics > 2 || athleticsSpecialties != null) {
            System.out.print("Athletics: " + athletics + "\t\t||");
            if (athleticsSpecialties != null) {
                //Jump, Run, Strength, Swim, Throw
                if (athleticsSpecialties[0] > 0)
                    System.out.print("Climb " + athleticsSpecialties[0] + " ");
                if (athleticsSpecialties[1] > 0)
                    System.out.print("Jump " + athleticsSpecialties[1] + " ");
                if (athleticsSpecialties[2] > 0)
                    System.out.print("Strength " + athleticsSpecialties[2] + " ");
                if (athleticsSpecialties[3] > 0)
                    System.out.print("Swim " + athleticsSpecialties[3] + " ");
                if (athleticsSpecialties[4] > 0)
                    System.out.print("Throw " + athleticsSpecialties[4] + " ");
            }
            System.out.println();
        }
    }

    public void displayAwareness() {
        if (awareness > 2 || awarenessSpecialties != null) {
            System.out.print("Awareness: " + awareness + "\t\t||");
            if (awarenessSpecialties != null) {
                if (awarenessSpecialties[0] > 0)
                    System.out.print("Empathy " + awarenessSpecialties[0] + " ");
                if (awarenessSpecialties[1] > 0)
                    System.out.print("Notice " + awarenessSpecialties[1] + " ");
            }
            System.out.println();
        }
    }

    public void displayCunning() {
        if (cunning > 2 || cunningSpecialties != null) {
            System.out.print("Cunning: " + cunning + "\t\t\t||");
            if (cunningSpecialties != null) {
                //Decipher, Logic, Memory
                if (cunningSpecialties[0] > 0)
                    System.out.print("Decipher " + cunningSpecialties[0] + " ");
                if (cunningSpecialties[1] > 0)
                    System.out.print("Logic " + cunningSpecialties[1] + " ");
                if (cunningSpecialties[2] > 0)
                    System.out.print("Memory " + cunningSpecialties[2] + " ");
            }
            System.out.println();
        }
    }

    public void displayDeception() {
        if (deception > 2 || deceptionSpecialties != null) {
            System.out.print("Deception: " + deception + "\t\t||");
            if (deceptionSpecialties != null) {
                //Act, Bluff, Cheat, Disguise
                if (deceptionSpecialties[0] > 0)
                    System.out.print("Act " + deceptionSpecialties[0] + " ");
                if (deceptionSpecialties[1] > 0)
                    System.out.print("Bluff " + deceptionSpecialties[1] + " ");
                if (deceptionSpecialties[2] > 0)
                    System.out.print("Cheat " + deceptionSpecialties[2] + " ");
                if (deceptionSpecialties[3] > 0)
                    System.out.print("Disguise " + deceptionSpecialties[3] + " ");
            }
            System.out.println();
        }
    }

    public void displayEndurance() {
        if (endurance > 2 || enduranceSpecialties != null) {
            System.out.print("Endurance: " + endurance + "\t\t||");
            if (enduranceSpecialties != null) {
                //Resilience, Stamina
                if (enduranceSpecialties[0] > 0)
                    System.out.print("Resilience " + enduranceSpecialties[0] + " ");
                if (enduranceSpecialties[1] > 0)
                    System.out.print("Stamina " + enduranceSpecialties[1] + " ");
            }
            System.out.println();
        }
    }

    public void displayFighting() {
        if (fighting > 2 || fightingSpecialties != null) {
            System.out.print("Fighting: " + fighting + "\t\t\t||");
            if (fightingSpecialties != null) {
                //Axes, Bludgeons, Brawling, Fencing, Long Blades,
                //Pole-Arms, Shields, Short Blades, Spears
                if (fightingSpecialties[0] > 0)
                    System.out.print("Axes " + fightingSpecialties[0] + " ");
                if (fightingSpecialties[1] > 0)
                    System.out.print("Bludgeon " + fightingSpecialties[1] + " ");
                if (fightingSpecialties[2] > 0)
                    System.out.print("Brawling " + fightingSpecialties[2] + " ");
                if (fightingSpecialties[3] > 0)
                    System.out.print("Fencing " + fightingSpecialties[3] + " ");
                if (fightingSpecialties[4] > 0)
                    System.out.print("Long Blades " + fightingSpecialties[4] + " ");
                if (fightingSpecialties[5] > 0)
                    System.out.print("Pole-Arms " + fightingSpecialties[5] + " ");
                if (fightingSpecialties[6] > 0)
                    System.out.print("Shields " + fightingSpecialties[6] + " ");
                if (fightingSpecialties[7] > 0)
                    System.out.print("Short Blades " + fightingSpecialties[7] + " ");
                if (fightingSpecialties[8] > 0)
                    System.out.print("Spears " + fightingSpecialties[8] + " ");
            }
            System.out.println();
        }
    }

    public void displayHealing() {
        if (healing > 2 || healingSpecialties != null) {
            System.out.print("Healing: " + healing + "\t\t\t||");
            if (healingSpecialties != null) {
                //Diagnose, Treat Ailment, Treat Injury
                if (healingSpecialties[0] > 0)
                    System.out.print("Diagnose " + healingSpecialties[0] + " ");
                if (healingSpecialties[1] > 0)
                    System.out.print("Treat Ailment " + healingSpecialties[1] + " ");
                if (healingSpecialties[2] > 0)
                    System.out.print("Treat Injury " + healingSpecialties[2] + " ");
            }
            System.out.println();
        }
    }

    public void displayKnowledge() {
        if (knowledge > 2 || knowledgeSpecialties != null) {
            System.out.print("Knowledge: " + knowledge + "\t\t||");
            if (knowledgeSpecialties != null) {
                //Education, Research, Streetwise
                if (knowledgeSpecialties[0] > 0)
                    System.out.print("Education " + knowledgeSpecialties[0] + " ");
                if (knowledgeSpecialties[1] > 0)
                    System.out.print("Research " + knowledgeSpecialties[1] + " ");
                if (knowledgeSpecialties[2] > 0)
                    System.out.print("Streetwise " + knowledgeSpecialties[2] + " ");
            }
            System.out.println();
        }
    }

    public void displayMarksmanship() {
        if (marksmanship > 2 || marksmanshipSpecialties != null) {
            System.out.print("Marksmanship: " + marksmanship + "\t\t||");
            if (marksmanshipSpecialties != null) {
                //Bows, Crossbows, Siege, Thrown
                if (marksmanshipSpecialties[0] > 0)
                    System.out.print("Bows " + marksmanshipSpecialties[0] + " ");
                if (marksmanshipSpecialties[1] > 0)
                    System.out.print("Crossbows " + marksmanshipSpecialties[1] + " ");
                if (marksmanshipSpecialties[2] > 0)
                    System.out.print("Siege " + marksmanshipSpecialties[2] + " ");
                if (marksmanshipSpecialties[3] > 0)
                    System.out.print("Thrown " + marksmanshipSpecialties[3] + " ");
            }
            System.out.println();
        }
    }

    public void displayPersuasion() {
        if (persuasion > 2 || persuasionSpecialties != null) {
            System.out.print("Persuasion: " + persuasion + "\t\t||");
            if (persuasionSpecialties != null) {
                //Bargain, Charm, Convince, Incite, Intimidate, Seduce, Taunt
                if (persuasionSpecialties[0] > 0)
                    System.out.print("Bargain " + persuasionSpecialties[0] + " ");
                if (persuasionSpecialties[1] > 0)
                    System.out.print("Charm " + persuasionSpecialties[1] + " ");
                if (persuasionSpecialties[2] > 0)
                    System.out.print("Convince " + persuasionSpecialties[2] + " ");
                if (persuasionSpecialties[3] > 0)
                    System.out.print("Incite " + persuasionSpecialties[3] + " ");
                if (persuasionSpecialties[4] > 0)
                    System.out.print("Intimidate " + persuasionSpecialties[4] + " ");
                if (persuasionSpecialties[5] > 0)
                    System.out.print("Seduce " + persuasionSpecialties[5] + " ");
                if (persuasionSpecialties[6] > 0)
                    System.out.print("Taunt " + persuasionSpecialties[6] + " ");
            }
            System.out.println();
        }
    }

    public void displayStatus() {
        System.out.print("Status: " + status + "\t\t\t||");
        if (statusSpecialties != null) {
            //Breeding, Reputation, Stewardship, Tournaments
            if (statusSpecialties[0] > 0)
                System.out.print("Breeding " + statusSpecialties[0] + " ");
            if (statusSpecialties[1] > 0)
                System.out.print("Reputation " + statusSpecialties[1] + " ");
            if (statusSpecialties[2] > 0)
                System.out.print("Stewardship " + statusSpecialties[2] + " ");
            if (statusSpecialties[3] > 0)
                System.out.print("Tournaments " + statusSpecialties[3] + " ");
        }
        System.out.println();
    }

    public void displayStealth() {
        if (stealth > 2 || stealthSpecialties != null) {
            System.out.print("Stealth: " + stealth + "\t\t\t||");
            if (stealthSpecialties != null) {
                //Blend In, Sneak
                if (stealthSpecialties[0] > 0)
                    System.out.print("Blend In " + stealthSpecialties[0] + " ");
                if (stealthSpecialties[1] > 0)
                    System.out.print("Sneak " + stealthSpecialties[1] + " ");
            }
            System.out.println();
        }
    }

    public void displaySurvival() {
        if (survival > 2 || survivalSpecialties != null) {
            System.out.print("Survival: " + survival + "\t\t\t||");
            if (survivalSpecialties != null) {
                //Forage, Hunt, Orientation, Track
                if (survivalSpecialties[0] > 0)
                    System.out.print("Forage " + survivalSpecialties[0] + " ");
                if (survivalSpecialties[1] > 0)
                    System.out.print("Hunt " + survivalSpecialties[1] + " ");
                if (survivalSpecialties[2] > 0)
                    System.out.print("Orientation " + survivalSpecialties[2] + " ");
                if (survivalSpecialties[3] > 0)
                    System.out.print("Track " + survivalSpecialties[3] + " ");
            }
            System.out.println();
        }
    }

    public void displayThievery() {
        if (thievery > 2 || thieverySpecialties != null) {
            System.out.print("Thievery: " + thievery + "\t\t\t||");
            if (thieverySpecialties != null) {
                //Pick Lock, Sleight of Hand, Steal
                if (thieverySpecialties[0] > 0)
                    System.out.print("Pick Lock " + thieverySpecialties[0] + " ");
                if (thieverySpecialties[1] > 0)
                    System.out.print("Sleight of Hand " + thieverySpecialties[1] + " ");
                if (thieverySpecialties[2] > 0)
                    System.out.print("Steal " + thieverySpecialties[2] + " ");
            }
            System.out.println();
        }
    }

    public void displayWarfare() {
        if (warfare > 2 || warfareSpecialties != null) {
            System.out.print("Warfare: " + warfare + "\t\t\t||");
            if (warfareSpecialties != null) {
                //Command, Strategy, Tactics
                if (warfareSpecialties[0] > 0)
                    System.out.print("Command " + warfareSpecialties[0] + " ");
                if (warfareSpecialties[1] > 0)
                    System.out.print("Strategy " + warfareSpecialties[1] + " ");
                if (warfareSpecialties[2] > 0)
                    System.out.print("Tactics " + warfareSpecialties[2] + " ");
            }
            System.out.println();
        }
    }

    public void displayWill() {
        if (will > 2 || willSpecialties != null) {
            System.out.print("Will: " + will + "\t\t\t\t||");
            if (willSpecialties != null) {
                //Courage, Coordinate, Dedication
                if (willSpecialties[0] > 0)
                    System.out.print("Courage " + willSpecialties[0] + " ");
                if (willSpecialties[1] > 0)
                    System.out.print("Coordinate " + willSpecialties[1] + " ");
                if (willSpecialties[2] > 0)
                    System.out.print("Dedication " + willSpecialties[2] + " ");
            }
            System.out.println();
        }
    }
}
