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
    private int agility;
    private int animalHandling;
    private int athletics;
    private int awareness;
    private int cunning;
    private int deception;
    private int endurance;
    private int fighting;
    private int healing;
    private int knowledge;
    private int marksmanship;
    private int persuasion;
    private int status;
    private int stealth;
    private int survival;
    private int thievery;
    private int warfare;

    private int will;
    private int language;   //this eventually should be translated into a list of known languages.
    private int moveSpeed; //movement speed of character
    //Destiny and qualities
    private int destinyPoints;
    private int maximumBenefits;
    private int requiredDrawbacks;
    //specialties
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
    private int specialtyExperience;    //for character creation
    private int abilityLimit;   //maximum starting rank


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

    public String printAll() {
        String toReturn = new String();
        toReturn = toReturn.concat(name);
        toReturn = toReturn.concat(printBio());
        toReturn = toReturn.concat(printConcept());
        toReturn = toReturn.concat(printStats());
        toReturn = toReturn.concat(printCombatInfo());
        toReturn = toReturn.concat(printGear());

        toReturn = toReturn.concat("----------");

        return toReturn;
    }

    public String printName() {
        return name;
    }

    public void displayBio() {
        System.out.println("Age: " + age + "\n" +
                "Gender: " + gender);
    }

    public String printBio() {
        return "Age: " + age + "\n" +
                "Gender: " + gender;
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

    public String printStats() {
        String toReturn = new String();
        toReturn = toReturn.concat(printStatus());
        toReturn = toReturn.concat(printAgility());
        toReturn = toReturn.concat(printAnimalHandling());
        toReturn = toReturn.concat(printAthletics());
        toReturn = toReturn.concat(printAwareness());
        toReturn = toReturn.concat(printCunning());
        toReturn = toReturn.concat(printDeception());
        toReturn = toReturn.concat(printEndurance());
        toReturn = toReturn.concat(printFighting());
        toReturn = toReturn.concat(printHealing());
        toReturn = toReturn.concat(printKnowledge());
        toReturn = toReturn.concat(printMarksmanship());
        toReturn = toReturn.concat(printPersuasion());
        toReturn = toReturn.concat(printStealth());
        toReturn = toReturn.concat(printSurvival());
        toReturn = toReturn.concat(printThievery());
        toReturn = toReturn.concat(printWarfare());
        toReturn = toReturn.concat(printWill());

        if (language > 2)
            toReturn = toReturn.concat("Language: " + language);

        return toReturn;
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

    public String printCombatInfo() {
        String toReturn = new String();
        toReturn = toReturn.concat(printMoveSpeed());

        if (armor == null)
            toReturn = toReturn.concat("Armor (None): 0\n");
        else
            toReturn = toReturn.concat("Armor (" + armor.getName() + ") " + armor.getArmorRating()
                + "\n");
        toReturn = toReturn.concat(printDerivedStats());

        return toReturn;
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

    public String printDerivedStats() {
        String toReturn = "Combat Defense\t\t\tIntrigue Defense\n";
        if (armor != null)
            toReturn = toReturn.concat(combatDefense + " (" + (combatDefense + armor.getArmorPenalty())
                    + " W/Armor)\t\t" + intrigueDefense + "\n");
        else
            toReturn = toReturn.concat(combatDefense + "\t\t\t\t\t" + intrigueDefense + "\n");

        toReturn = toReturn.concat("\nHealth\t\t\t\tComposure\n");
        toReturn = toReturn.concat(health + "\t\t\t\t\t" + composure + "\n");

        return toReturn;
    }

    public String printCombatDefense() {
        if (armor != null)
            return combatDefense + " (" + (combatDefense + armor.getArmorPenalty())
                    + " W/Armor)";
        else
            return combatDefense + "";
    }

    public String printHealth() {
        return "" + health;
    }

    public String printIntrigueDefense() {
        return "" + intrigueDefense;
    }

    public String printComposure() {
        return "" + composure;
    }

    public void displayConcept() {
        System.out.println("Background: " + background + "\n" +
                "Goal: " + goal + "\n" +
                "Motivation: " + motivation + "\n" +
                "Virtue: " + virtue + "\n" +
                "Vice: " + vice);
    }

    public String printConcept() {
        return "Background: " + background + "\n" +
                "Goal: " + goal + "\n" +
                "Motivation: " + "\n" +
                "Virtue: " + "\n" +
                "Vice: " + vice + "\n";
    }

    public String getBackground() {
        return background;
    }

    public String getGoal() {
        return goal;
    }

    public String getMotivation() {
        return motivation;
    }

    public String getVirtue() {
        return virtue;
    }

    public String getVice() {
        return vice;
    }

    public void displayGear() {
        System.out.println("Gear: ");
        displayWeapons();
        System.out.println("Armor: ");
        displayArmor();
    }

    public String printGear() {
        String toReturn = "Gear: ";
        toReturn = toReturn.concat(printWeapons());
        toReturn = toReturn.concat("\nArmor: " );
        toReturn = toReturn.concat(printArmor() + "\n");

        return toReturn;
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

    public String printMoveSpeed() {
        setMoveSpeed();
        String toReturn = new String();

        if (armor == null)
            toReturn = toReturn.concat("Movement: " + moveSpeed + "\n");
        else {
            int temp = moveSpeed - armor.getBulk();
            if (temp < 1)
                temp = 1;
            toReturn = toReturn.concat("Movement: " + moveSpeed + " (" +
                    temp + " W/Armor)");
        }
        return toReturn;
    }

    public void displayArmor() {
        if (armor == null)
            System.out.println("No Armor.");
        else
            armor.display();
    }

    public String printArmor() {
        if (armor == null)
            return "No Armor.";
        else
            return armor.print();
    }

    public Armor getArmor() {
        return armor;
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

    public String printWeapons() {
        String toReturn = new String();
        if (weapon1 != null)
            toReturn = toReturn.concat("Weapon 1: " + weapon1.print() + "\n");

        if (offHand != null)
            toReturn = toReturn.concat("Off-Hand: " + offHand.print() + "\n");

        if (weapon2 != null)
            toReturn = toReturn.concat("Weapon 2: " + weapon2.print() + "\n");

        if (weapon3 != null)
            toReturn = toReturn.concat("Weapon 3: " + weapon3.print() + "\n");

        return toReturn;
    }

    public String printWeapon1Description() {
        if (weapon1 == null)
            return "";
        return weapon1.printDescription();
    }

    public String printWeapon2Description() {
        if (weapon2 == null)
            return "";
        return weapon2.printDescription();
    }

    public String printWeapon3Description() {
        if (weapon3 == null)
            return "";
        return weapon3.printDescription();
    }

    public String printOffHandDescription() {
        if (offHand == null)
            return "";
        return offHand.printDescription();
    }

    public String printWeapon1Name() {
        if (weapon1 == null)
            return "";
        return weapon1.getName();
    }

    public String printWeapon2Name() {
        if (weapon2 == null)
            return "";
        return weapon2.getName();
    }

    public String printWeapon3Name() {
        if (weapon3 == null)
            return "";
        return weapon3.getName();
    }

    public String printOffHandName() {
        if (offHand == null)
            return "";
        return offHand.getName();
    }

    public String printWeapon1Damage() {
        if (weapon1 == null)
            return "";
        return printWeaponDamage(weapon1);
    }

    public String printWeapon2Damage() {
        if (weapon2 == null)
            return "";
        return printWeaponDamage(weapon2);
    }

    public String printWeapon3Damage() {
        if (weapon3 == null)
            return "";
        return printWeaponDamage(weapon3);
    }

    public String printOffHandDamage() {
        if (offHand == null)
            return "";
        return printWeaponDamage(offHand);
    }

    private String printWeaponDamage(Weapon weapon) {
        if (weapon == null)
            return "";
        String toReturn = "";
        if (weapon.printAbility() != null) {
            switch (weapon.printAbility()) {
                case "Agility":
                    if (agility + weapon.getDamage() < 1)
                        toReturn = toReturn.concat(1 + "");
                    else
                        toReturn = toReturn.concat((agility + weapon.getDamage()) + "");
                    break;
                case "Animal Handling":
                    if (animalHandling + weapon.getDamage() < 1)
                        toReturn = toReturn.concat(1 + "");
                    else
                        toReturn = toReturn.concat((animalHandling + weapon.getDamage()) + "");
                    break;
                case "Athletics":
                    if (athletics + weapon.getDamage() < 1)
                        toReturn = toReturn.concat(1 + "");
                    else
                        toReturn = toReturn.concat((athletics + weapon.getDamage()) + "");
                    break;
            }
        }
        return toReturn;
    }

    public String printWeapon1AttackDice() {
        if (weapon1 == null)
            return "";
        return printWeaponAttackDice(weapon1);
    }

    public String printWeapon2AttackDice() {
        if (weapon2 == null)
            return "";
        return printWeaponAttackDice(weapon2);
    }

    public String printWeapon3AttackDice() {
        if (weapon3 == null)
            return "";
        return printWeaponAttackDice(weapon3);
    }

    public String printOffHandAttackDice() {
        if (offHand == null)
            return "";
        return printWeaponAttackDice(offHand);
    }

    private String printWeaponAttackDice(Weapon weapon) {
        if (weapon == null)
            return "";
        else {
            String toReturn = fighting + "D";

            if (fightingSpecialties != null) {
                switch (weapon.printSpecialty()) {
                    case "Axes":
                        toReturn = toReturn.concat(" + " + fightingSpecialties[0] + "B");
                        break;
                    case "Bludgeon":
                        toReturn = toReturn.concat(" + " + fightingSpecialties[1] + "B");
                        break;
                    case "Brawling":
                        toReturn = toReturn.concat(" + " + fightingSpecialties[2] + "B");
                        break;
                    case "Fencing":
                        toReturn = toReturn.concat(" + " + fightingSpecialties[3] + "B");
                        break;
                    case "Long Blade":
                        toReturn = toReturn.concat(" + " + fightingSpecialties[4] + "B");
                        break;
                    case "Pole-Arm":
                        toReturn = toReturn.concat(" + " + fightingSpecialties[5] + "B");
                        break;
                    case "Shield":
                        toReturn = toReturn.concat(" + " + fightingSpecialties[6] + "B");
                        break;
                    case "Short Blade":
                        toReturn = toReturn.concat(" + " + fightingSpecialties[7] + "B");
                        break;
                    case "Spear":
                        toReturn = toReturn.concat(" + " + fightingSpecialties[8] + "B");
                        break;

                    default:
                }
            }
            if (marksmanshipSpecialties != null) {
                switch (weapon.printSpecialty()) {
                    case "Bow":
                        toReturn = toReturn.concat(" + " + marksmanshipSpecialties[0] + "B");
                        break;
                    case "Crossbow":
                        toReturn = toReturn.concat(" + " + marksmanshipSpecialties[1] + "B");
                        break;
                    case "Thrown":
                        toReturn = toReturn.concat(" + " + marksmanshipSpecialties[3] + "B");
                        break;
                }
            }
            return toReturn;
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
            case 3: setAge("Youth");
                break;
            case 4: setAge("Adolescent");
                break;
            case 5:
            case 6: setAge("Young Adult");
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11: setAge("Adult");
                break;
            case 12:
            case 13:
            case 14:
            case 15: setAge("MiddleAge");
                break;
            case 16: setAge("Old");
                break;
            case 17: setAge("Very Old");
                break;
            case 18: setAge("Venerable");
                break;
        }
    }

    public void calculateExperience() {
        switch (age) {
            case "Youth": experience = 120;
                specialtyExperience = 40;
                break;
            case "Adolescent": experience = 150;
                specialtyExperience = 40;
                break;
            case "Young Adult": experience = 180;
                specialtyExperience = 60;
                break;
            case "Adult": experience = 210;
                specialtyExperience = 80;
                break;
            case "Middle Age": experience = 240;
                specialtyExperience = 100;
                break;
            case "Old": experience = 270;
                specialtyExperience = 160;
                break;
            case "Very Old": experience = 330;
                specialtyExperience = 200;
                break;
            case "Venerable": experience = 360;
                specialtyExperience = 240;
                break;
            default: age = "Adult";
                experience = 210;
                specialtyExperience = 80;
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

        //stats
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
        //specialties
        this.agilitySpecialties = toCopy.agilitySpecialties;
        this.animalHandlingSpecialties = toCopy.animalHandlingSpecialties;
        this.athleticsSpecialties = toCopy.athleticsSpecialties;
        this.awarenessSpecialties = toCopy.awarenessSpecialties;
        this.cunningSpecialties = toCopy.cunningSpecialties;
        this.deceptionSpecialties = toCopy.deceptionSpecialties;
        this.enduranceSpecialties = toCopy.enduranceSpecialties;
        this.fightingSpecialties = toCopy.fightingSpecialties;
        this.healingSpecialties = toCopy.healingSpecialties;
        this.knowledgeSpecialties = toCopy.knowledgeSpecialties;
        this.marksmanshipSpecialties = toCopy.marksmanshipSpecialties;
        this.persuasionSpecialties = toCopy.persuasionSpecialties;
        this.statusSpecialties = toCopy.statusSpecialties;
        this.stealthSpecialties = toCopy.stealthSpecialties;
        this.survivalSpecialties = toCopy.survivalSpecialties;
        this.thieverySpecialties = toCopy.thieverySpecialties;
        this.warfareSpecialties = toCopy.warfareSpecialties;
        this.willSpecialties = toCopy.willSpecialties;
        //gear
        if (toCopy.weapon1 != null)
            this.weapon1 = new Weapon(toCopy.weapon1);
        if (toCopy.weapon2 != null)
            this.weapon2 = new Weapon(toCopy.weapon2);
        if (toCopy.weapon3 != null)
            this.weapon3 = new Weapon(toCopy.weapon3);
        if (toCopy.offHand != null)
            this.offHand = new Weapon(toCopy.offHand);
        if (toCopy.armor != null)
            this.armor = new Armor(toCopy.armor);

        generateDerivedStats();
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

    public void setAge(String age) {
        switch (age) {
            case "Youth": this.age = "Youth";
                experience = 120;
                specialtyExperience = 40;
                abilityLimit = 4;
                destinyPoints = 7;
                maximumBenefits = 3;
                requiredDrawbacks = 0;
                break;
            case "Adolescent": this.age = "Adolescent";
                specialtyExperience = 40;
                abilityLimit = 4;
                destinyPoints = 6;
                experience = 150;
                maximumBenefits = 3;
                requiredDrawbacks = 0;
                break;
            case "Young Adult": this.age = "Young Adult";
                experience = 180;
                specialtyExperience = 60;
                abilityLimit = 5;
                destinyPoints = 5;
                maximumBenefits = 3;
                requiredDrawbacks = 0;
                break;
            case "Adult": this.age = "Adult";
                experience = 210;
                specialtyExperience = 80;
                abilityLimit = 7;
                destinyPoints = 4;
                maximumBenefits = 3;
                requiredDrawbacks = 1;
                break;
            case "Middle Age": this.age = "Middle Age";
                experience = 240;
                specialtyExperience = 100;
                abilityLimit = 6;
                destinyPoints = maximumBenefits = 3;
                requiredDrawbacks = 2;
                break;
            case "Old": this.age = "Old";
                specialtyExperience = 160;
                experience = 270;
                abilityLimit = 5;
                destinyPoints = maximumBenefits = 2;
                requiredDrawbacks = 3;
                break;
            case "Very Old": this.age = "Very Old";
                specialtyExperience = 200;
                experience = 330;
                abilityLimit = 5;
                destinyPoints = maximumBenefits = 1;
                requiredDrawbacks = 4;
                break;
            case "Venerable": this.age = "Venerable";
                specialtyExperience = 240;
                experience = 360;
                abilityLimit = 5;
                destinyPoints = maximumBenefits = 0;
                requiredDrawbacks = 5;
                break;
            default:
                setAge("Adult");
        }
    }

    public String getAge() {
        return age;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getSpecialtyExperience() {
        return specialtyExperience;
    }

    public void setSpecialtyExperience(int experience) {
        this.specialtyExperience = experience;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public void setVirtue(String virtue) {
        this.virtue = virtue;
    }

    public void setVice(String vice) {
        this.vice = vice;
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
                weapon1 = new Weapon(toGive.getName());

            else if (weapon2 == null)
                weapon2 = new Weapon(toGive.getName());

            else if (weapon3 == null)
                weapon3 = new Weapon(toGive.getName());

            else
                weapon3.setWeapon(toGive.getName());
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
                offHand = new Weapon(toGive.getName());
            else
                offHand.setWeapon(toGive.getName());
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

    public String printAgility() {
        return "" + agility;
    }

    public String printAgilitySpecialties() {
        String toReturn = new String();
        if (agilitySpecialties != null) {
            if (agilitySpecialties[0] > 0)
                toReturn = toReturn.concat("Acrobatics " + agilitySpecialties[0] + " ");
            if (agilitySpecialties[1] > 0)
                toReturn = toReturn.concat("Balance " + agilitySpecialties[1] + " ");
            if (agilitySpecialties[2] > 0)
                toReturn = toReturn.concat("Contortions " + agilitySpecialties[2] + " ");
            if (agilitySpecialties[3] > 0)
                toReturn = toReturn.concat("Dodge " + agilitySpecialties[3] + " ");
            if (agilitySpecialties[4] > 0)
                toReturn = toReturn.concat("Quickness " + agilitySpecialties[4] + " ");
            toReturn = toReturn.concat("\n");
        }
        else
            toReturn = null;
        return toReturn;
    }

    public String printAnimalHandling() {
        return "" + animalHandling;
    }

    public String printAnimalHandlingSpecialties() {
        String toReturn = new String ();
         if (animalHandlingSpecialties != null) {
            if (animalHandlingSpecialties[0] > 0)
                toReturn = toReturn.concat("Charm " + animalHandlingSpecialties[0] + " ");
            if (animalHandlingSpecialties[1] > 0)
                toReturn = toReturn.concat("Drive " + animalHandlingSpecialties[1] + " ");
            if (animalHandlingSpecialties[2] > 0)
                toReturn = toReturn.concat("Ride " + animalHandlingSpecialties[2] + " ");
            if (animalHandlingSpecialties[3] > 0)
                toReturn = toReturn.concat("Train " + animalHandlingSpecialties[3] + " ");
            toReturn = toReturn.concat("\n");
        }
        else
            toReturn = null;

        return toReturn;
    }

    public String printAthletics() {
        return "" + athletics;
    }

    public String printAthleticsSpecialties() {
        if (athleticsSpecialties != null) {
            String toReturn = new String();
            //Jump, Run, Strength, Swim, Throw
            if (athleticsSpecialties[0] > 0)
                toReturn = toReturn.concat("Climb " + athleticsSpecialties[0] + " ");
            if (athleticsSpecialties[1] > 0)
                toReturn = toReturn.concat("Jump " + athleticsSpecialties[1] + " ");
            if (athleticsSpecialties[2] > 0)
                toReturn = toReturn.concat("Strength " + athleticsSpecialties[2] + " ");
            if (athleticsSpecialties[3] > 0)
                toReturn = toReturn.concat("Swim " + athleticsSpecialties[3] + " ");
            if (athleticsSpecialties[4] > 0)
                toReturn = toReturn.concat("Throw " + athleticsSpecialties[4] + " ");
            toReturn = toReturn.concat("\n");
            return toReturn;
        }
        else
            return null;
    }

    public String printAwareness() {
        return "" + awareness;
    }

    public String printAwarenessSpecialties() {
        if (awareness > 2 || awarenessSpecialties != null) {
            String toReturn = new String();
            if (awarenessSpecialties != null) {
                if (awarenessSpecialties[0] > 0)
                    toReturn = toReturn.concat("Empathy " + awarenessSpecialties[0] + " ");
                if (awarenessSpecialties[1] > 0)
                    toReturn = toReturn.concat("Notice " + awarenessSpecialties[1] + " ");
            }
            toReturn = toReturn.concat("\n");
            return toReturn;
        }
        return null;
    }

    public String printCunning() {
        return "" + cunning;
    }

    public String printCunningSpecialties() {
        String toReturn = new String ();
        if (cunning > 2 || cunningSpecialties != null) {
            if (cunningSpecialties != null) {
                //Decipher, Logic, Memory
                if (cunningSpecialties[0] > 0)
                    toReturn = toReturn.concat("Decipher " + cunningSpecialties[0] + " ");
                if (cunningSpecialties[1] > 0)
                    toReturn = toReturn.concat("Logic " + cunningSpecialties[1] + " ");
                if (cunningSpecialties[2] > 0)
                    toReturn = toReturn.concat("Memory " + cunningSpecialties[2] + " ");
            }
            toReturn = toReturn.concat("\n");
            return toReturn;
        }
        return null;
    }

    public String printDeception() {
        return "" + deception;
    }

    public String printDeceptionSpecialties() {
        String toReturn = new String ();
        if (deception > 2 || deceptionSpecialties != null) {
            if (deceptionSpecialties != null) {
                //Act, Bluff, Cheat, Disguise
                if (deceptionSpecialties[0] > 0)
                    toReturn = toReturn.concat("Act " + deceptionSpecialties[0] + " ");
                if (deceptionSpecialties[1] > 0)
                    toReturn = toReturn.concat("Bluff " + deceptionSpecialties[1] + " ");
                if (deceptionSpecialties[2] > 0)
                    toReturn = toReturn.concat("Cheat " + deceptionSpecialties[2] + " ");
                if (deceptionSpecialties[3] > 0)
                    toReturn = toReturn.concat("Disguise " + deceptionSpecialties[3] + " ");
            }
            toReturn = toReturn.concat("\n");
            return toReturn;
        }
        return null;
    }

    public String printEndurance() {
        return "" + endurance;
    }

    public String printEnduranceSpecialties() {
        String toReturn = new String ();
        if (endurance > 2 || enduranceSpecialties != null) {
            if (enduranceSpecialties != null) {
                //Resilience, Stamina
                if (enduranceSpecialties[0] > 0)
                    toReturn = toReturn.concat("Resilience " + enduranceSpecialties[0] + " ");
                if (enduranceSpecialties[1] > 0)
                    toReturn = toReturn.concat("Stamina " + enduranceSpecialties[1] + " ");
            }
            toReturn = toReturn.concat("\n");
            return toReturn;
        }
        return null;
    }

    public String printFighting() {
        return fighting + "";
    }

    public String printFightingSpecialties() {
        String toReturn = new String ();
        if (fighting > 2 || fightingSpecialties != null) {
            if (fightingSpecialties != null) {
                //Axes, Bludgeons, Brawling, Fencing, Long Blades,
                //Pole-Arms, Shields, Short Blades, Spears
                if (fightingSpecialties[0] > 0)
                    toReturn = toReturn.concat("Axes " + fightingSpecialties[0] + " ");
                if (fightingSpecialties[1] > 0)
                    toReturn = toReturn.concat("Bludgeon " + fightingSpecialties[1] + " ");
                if (fightingSpecialties[2] > 0)
                    toReturn = toReturn.concat("Brawling " + fightingSpecialties[2] + " ");
                if (fightingSpecialties[3] > 0)
                    toReturn = toReturn.concat("Fencing " + fightingSpecialties[3] + " ");
                if (fightingSpecialties[4] > 0)
                    toReturn = toReturn.concat("Long Blades " + fightingSpecialties[4] + " ");
                if (fightingSpecialties[5] > 0)
                    toReturn = toReturn.concat("Pole-Arms " + fightingSpecialties[5] + " ");
                if (fightingSpecialties[6] > 0)
                    toReturn = toReturn.concat("Shields " + fightingSpecialties[6] + " ");
                if (fightingSpecialties[7] > 0)
                    toReturn = toReturn.concat("Short Blades " + fightingSpecialties[7] + " ");
                if (fightingSpecialties[8] > 0)
                    toReturn = toReturn.concat("Spears " + fightingSpecialties[8] + " ");
            }
            toReturn = toReturn.concat("\n");
            return toReturn;
        }
        return null;
    }

    public String printHealing() {
        return healing + "";
    }

    public String printHealingSpecialties() {
        String toReturn = new String ();
        if (healing > 2 || healingSpecialties != null) {
            if (healingSpecialties != null) {
                //Diagnose, Treat Ailment, Treat Injury
                if (healingSpecialties[0] > 0)
                    toReturn = toReturn.concat("Diagnose " + healingSpecialties[0] + " ");
                if (healingSpecialties[1] > 0)
                    toReturn = toReturn.concat("Treat Ailment " + healingSpecialties[1] + " ");
                if (healingSpecialties[2] > 0)
                    toReturn = toReturn.concat("Treat Injury " + healingSpecialties[2] + " ");
            }
            toReturn = toReturn.concat("\n");
            return toReturn;
        }
        return null;
    }

    public String printKnowledge() {
        return "" + knowledge;
    }

    public String printKnowledgeSpecialties() {
        String toReturn = new String ();
        if (knowledge > 2 || knowledgeSpecialties != null) {
            if (knowledgeSpecialties != null) {
                //Education, Research, Streetwise
                if (knowledgeSpecialties[0] > 0)
                    toReturn = toReturn.concat("Education " + knowledgeSpecialties[0] + " ");
                if (knowledgeSpecialties[1] > 0)
                    toReturn = toReturn.concat("Research " + knowledgeSpecialties[1] + " ");
                if (knowledgeSpecialties[2] > 0)
                    toReturn = toReturn.concat("Streetwise " + knowledgeSpecialties[2] + " ");
            }
            toReturn = toReturn.concat("\n");
            return toReturn;
        }
        return null;
    }

    public String printLanguage() {
        return "" + language;
    }

    public String printLanguageSpecialties() {
        //will implement later
        return "";
    }

    public String printMarksmanship() {
        return "" + marksmanship;
    }

    public String printMarksmanshipSpecialties() {
        String toReturn = new String ();
        if (marksmanship > 2 || marksmanshipSpecialties != null) {
            if (marksmanshipSpecialties != null) {
                //Bows, Crossbows, Siege, Thrown
                if (marksmanshipSpecialties[0] > 0)
                    toReturn = toReturn.concat("Bows " + marksmanshipSpecialties[0] + " ");
                if (marksmanshipSpecialties[1] > 0)
                    toReturn = toReturn.concat("Crossbows " + marksmanshipSpecialties[1] + " ");
                if (marksmanshipSpecialties[2] > 0)
                    toReturn = toReturn.concat("Siege " + marksmanshipSpecialties[2] + " ");
                if (marksmanshipSpecialties[3] > 0)
                    toReturn = toReturn.concat("Thrown " + marksmanshipSpecialties[3] + " ");
            }
            toReturn = toReturn.concat("\n");
            return toReturn;
        }
        return null;
    }

    public String printPersuasion() {
        return "" + persuasion;
    }

    public String printPersuasionSpecialties() {
        String toReturn = new String ();
        if (persuasion > 2 || persuasionSpecialties != null) {
            if (persuasionSpecialties != null) {
                //Bargain, Charm, Convince, Incite, Intimidate, Seduce, Taunt
                if (persuasionSpecialties[0] > 0)
                    toReturn = toReturn.concat("Bargain " + persuasionSpecialties[0] + " ");
                if (persuasionSpecialties[1] > 0)
                    toReturn = toReturn.concat("Charm " + persuasionSpecialties[1] + " ");
                if (persuasionSpecialties[2] > 0)
                    toReturn = toReturn.concat("Convince " + persuasionSpecialties[2] + " ");
                if (persuasionSpecialties[3] > 0)
                    toReturn = toReturn.concat("Incite " + persuasionSpecialties[3] + " ");
                if (persuasionSpecialties[4] > 0)
                    toReturn = toReturn.concat("Intimidate " + persuasionSpecialties[4] + " ");
                if (persuasionSpecialties[5] > 0)
                    toReturn = toReturn.concat("Seduce " + persuasionSpecialties[5] + " ");
                if (persuasionSpecialties[6] > 0)
                    toReturn = toReturn.concat("Taunt " + persuasionSpecialties[6] + " ");
            }
            toReturn = toReturn.concat("\n");
            return toReturn;
        }
        return toReturn;
    }

    public String printStatus() {
        return "" + status;
    }

    public String printStatusSpecialties() {
        String toReturn = new String ();
        if (statusSpecialties != null) {
            //Breeding, Reputation, Stewardship, Tournaments
            if (statusSpecialties[0] > 0)
                toReturn = toReturn.concat("Breeding " + statusSpecialties[0] + " ");
            if (statusSpecialties[1] > 0)
                toReturn = toReturn.concat("Reputation " + statusSpecialties[1] + " ");
            if (statusSpecialties[2] > 0)
                toReturn = toReturn.concat("Stewardship " + statusSpecialties[2] + " ");
            if (statusSpecialties[3] > 0)
                toReturn = toReturn.concat("Tournaments " + statusSpecialties[3] + " ");
        }
        toReturn = toReturn.concat("\n");
        return toReturn;
    }

    public String printStealth() {
        return "" + stealth;
    }

    public String printStealthSpecialties() {
        String toReturn = new String ();
        if (stealth > 2 || stealthSpecialties != null) {
            if (stealthSpecialties != null) {
                //Blend In, Sneak
                if (stealthSpecialties[0] > 0)
                    toReturn = toReturn.concat("Blend In " + stealthSpecialties[0] + " ");
                if (stealthSpecialties[1] > 0)
                    toReturn = toReturn.concat("Sneak " + stealthSpecialties[1] + " ");
            }
            toReturn = toReturn.concat("\n");
        }
        return toReturn;
    }

    public String printSurvival() {
        return "" + survival;
    }

    public String printSurvivalSpecialties() {
        String toReturn = new String ();
        if (survival > 2 || survivalSpecialties != null) {
            if (survivalSpecialties != null) {
                //Forage, Hunt, Orientation, Track
                if (survivalSpecialties[0] > 0)
                    toReturn = toReturn.concat("Forage " + survivalSpecialties[0] + " ");
                if (survivalSpecialties[1] > 0)
                    toReturn = toReturn.concat("Hunt " + survivalSpecialties[1] + " ");
                if (survivalSpecialties[2] > 0)
                    toReturn = toReturn.concat("Orientation " + survivalSpecialties[2] + " ");
                if (survivalSpecialties[3] > 0)
                    toReturn = toReturn.concat("Track " + survivalSpecialties[3] + " ");
            }
            toReturn = toReturn.concat("\n");
        }
        return toReturn;
    }

    public String printThievery() {
        return "" + thievery;
    }

    public String printThieverySpecialties() {
        String toReturn = new String ();
        if (thievery > 2 || thieverySpecialties != null) {
            if (thieverySpecialties != null) {
                //Pick Lock, Sleight of Hand, Steal
                if (thieverySpecialties[0] > 0)
                    toReturn = toReturn.concat("Pick Lock " + thieverySpecialties[0] + " ");
                if (thieverySpecialties[1] > 0)
                    toReturn = toReturn.concat("Sleight of Hand " + thieverySpecialties[1] + " ");
                if (thieverySpecialties[2] > 0)
                    toReturn = toReturn.concat("Steal " + thieverySpecialties[2] + " ");
            }
            toReturn = toReturn.concat("\n");
        }
        return toReturn;
    }

    public String printWarfare() {
        return "" + warfare;
    }

    public String printWarfareSpecialties() {
        String toReturn = new String ();
        if (warfare > 2 || warfareSpecialties != null) {
            if (warfareSpecialties != null) {
                //Command, Strategy, Tactics
                if (warfareSpecialties[0] > 0)
                    toReturn = toReturn.concat("Command " + warfareSpecialties[0] + " ");
                if (warfareSpecialties[1] > 0)
                    toReturn = toReturn.concat("Strategy " + warfareSpecialties[1] + " ");
                if (warfareSpecialties[2] > 0)
                    toReturn = toReturn.concat("Tactics " + warfareSpecialties[2] + " \n");
            }
            toReturn = toReturn.concat("\n");
        }
        return toReturn;
    }

    public String printWill() {
        return "" + will;
    }

    public String printWillSpecialties() {
        String toReturn = new String ();
        if (will > 2 || willSpecialties != null) {
            if (willSpecialties != null) {
                //Courage, Coordinate, Dedication
                if (willSpecialties[0] > 0)
                    toReturn = toReturn.concat("Courage " + willSpecialties[0] + " ");
                if (willSpecialties[1] > 0)
                    toReturn = toReturn.concat("Coordinate " + willSpecialties[1] + " ");
                if (willSpecialties[2] > 0)
                    toReturn = toReturn.concat("Dedication " + willSpecialties[2] + " \n");
            }
            toReturn = toReturn.concat("\n");
        }
        return toReturn;
    }



    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getAnimalHandling() {
        return animalHandling;
    }

    public void setAnimalHandling(int animalHandling) {
        this.animalHandling = animalHandling;
    }

    public int getAthletics() {
        return athletics;
    }

    public void setAthletics(int athletics) {
        this.athletics = athletics;
    }

    public int getAwareness() {
        return awareness;
    }

    public void setAwareness(int awareness) {
        this.awareness = awareness;
    }

    public int getCunning() {
        return cunning;
    }

    public void setCunning(int cunning) {
        this.cunning = cunning;
    }

    public int getDeception() {
        return deception;
    }

    public void setDeception(int deception) {
        this.deception = deception;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getFighting() {
        return fighting;
    }

    public void setFighting(int fighting) {
        this.fighting = fighting;
    }

    public int getHealing() {
        return healing;
    }

    public void setHealing(int healing) {
        this.healing = healing;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(int knowledge) {
        this.knowledge = knowledge;
    }

    public int getMarksmanship() {
        return marksmanship;
    }

    public void setMarksmanship(int marksmanship) {
        this.marksmanship = marksmanship;
    }

    public int getPersuasion() {
        return persuasion;
    }

    public void setPersuasion(int persuasion) {
        this.persuasion = persuasion;
    }

    public int getStealth() {
        return stealth;
    }

    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    public int getSurvival() {
        return survival;
    }

    public void setSurvival(int survival) {
        this.survival = survival;
    }

    public int getThievery() {
        return thievery;
    }

    public void setThievery(int thievery) {
        this.thievery = thievery;
    }

    public int getWarfare() {
        return warfare;
    }

    public void setWarfare(int warfare) {
        this.warfare = warfare;
    }

    public int getWill() {
        return will;
    }

    public void setWill(int will) {
        this.will = will;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public int getDestinyPoints() {
        return destinyPoints;
    }

    public void setDestinyPoints(int destinyPoints) {
        this.destinyPoints = destinyPoints;
    }

    public int getMaximumBenefits() {
        return maximumBenefits;
    }

    public void setMaximumBenefits(int maximumBenefits) {
        this.maximumBenefits = maximumBenefits;
    }

    public int getRequiredDrawbacks() {
        return requiredDrawbacks;
    }

    public void setRequiredDrawbacks(int requiredDrawbacks) {
        this.requiredDrawbacks = requiredDrawbacks;
    }

    public int[] getAgilitySpecialties() {
        return agilitySpecialties;
    }

    public void setAgilitySpecialties(int[] agilitySpecialties) {
        this.agilitySpecialties = agilitySpecialties;
    }

    public int[] getAnimalHandlingSpecialties() {
        return animalHandlingSpecialties;
    }

    public void setAnimalHandlingSpecialties(int[] animalHandlingSpecialties) {
        this.animalHandlingSpecialties = animalHandlingSpecialties;
    }

    public int[] getAthleticsSpecialties() {
        return athleticsSpecialties;
    }

    public void setAthleticsSpecialties(int[] athleticsSpecialties) {
        this.athleticsSpecialties = athleticsSpecialties;
    }

    public int[] getAwarenessSpecialties() {
        return awarenessSpecialties;
    }

    public void setAwarenessSpecialties(int[] awarenessSpecialties) {
        this.awarenessSpecialties = awarenessSpecialties;
    }

    public int[] getCunningSpecialties() {
        return cunningSpecialties;
    }

    public void setCunningSpecialties(int[] cunningSpecialties) {
        this.cunningSpecialties = cunningSpecialties;
    }

    public int[] getDeceptionSpecialties() {
        return deceptionSpecialties;
    }

    public void setDeceptionSpecialties(int[] deceptionSpecialties) {
        this.deceptionSpecialties = deceptionSpecialties;
    }

    public int[] getEnduranceSpecialties() {
        return enduranceSpecialties;
    }

    public void setEnduranceSpecialties(int[] enduranceSpecialties) {
        this.enduranceSpecialties = enduranceSpecialties;
    }

    public int[] getFightingSpecialties() {
        return fightingSpecialties;
    }

    public void setFightingSpecialties(int[] fightingSpecialties) {
        this.fightingSpecialties = fightingSpecialties;
    }

    public int[] getHealingSpecialties() {
        return healingSpecialties;
    }

    public void setHealingSpecialties(int[] healingSpecialties) {
        this.healingSpecialties = healingSpecialties;
    }

    public int[] getKnowledgeSpecialties() {
        return knowledgeSpecialties;
    }

    public void setKnowledgeSpecialties(int[] knowledgeSpecialties) {
        this.knowledgeSpecialties = knowledgeSpecialties;
    }

    public int[] getMarksmanshipSpecialties() {
        return marksmanshipSpecialties;
    }

    public void setMarksmanshipSpecialties(int[] marksmanshipSpecialties) {
        this.marksmanshipSpecialties = marksmanshipSpecialties;
    }

    public int[] getPersuasionSpecialties() {
        return persuasionSpecialties;
    }

    public void setPersuasionSpecialties(int[] persuasionSpecialties) {
        this.persuasionSpecialties = persuasionSpecialties;
    }

    public int[] getStatusSpecialties() {
        return statusSpecialties;
    }

    public void setStatusSpecialties(int[] statusSpecialties) {
        this.statusSpecialties = statusSpecialties;
    }

    public int[] getStealthSpecialties() {
        return stealthSpecialties;
    }

    public void setStealthSpecialties(int[] stealthSpecialties) {
        this.stealthSpecialties = stealthSpecialties;
    }

    public int[] getSurvivalSpecialties() {
        return survivalSpecialties;
    }

    public void setSurvivalSpecialties(int[] survivalSpecialties) {
        this.survivalSpecialties = survivalSpecialties;
    }

    public int[] getThieverySpecialties() {
        return thieverySpecialties;
    }

    public void setThieverySpecialties(int[] thieverySpecialties) {
        this.thieverySpecialties = thieverySpecialties;
    }

    public int[] getWarfareSpecialties() {
        return warfareSpecialties;
    }

    public void setWarfareSpecialties(int[] warfareSpecialties) {
        this.warfareSpecialties = warfareSpecialties;
    }

    public int[] getWillSpecialties() {
        return willSpecialties;
    }

    public void setWillSpecialties(int[] willSpecialties) {
        this.willSpecialties = willSpecialties;
    }

    public int getCombatDefense() {
        return combatDefense;
    }

    public void setCombatDefense(int combatDefense) {
        this.combatDefense = combatDefense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getIntrigueDefense() {
        return intrigueDefense;
    }

    public void setIntrigueDefense(int intrigueDefense) {
        this.intrigueDefense = intrigueDefense;
    }

    public int getComposure() {
        return composure;
    }

    public void setComposure(int composure) {
        this.composure = composure;
    }

    public int getDefensiveBonus() {
        return defensiveBonus;
    }

    public void setDefensiveBonus(int defensiveBonus) {
        this.defensiveBonus = defensiveBonus;
    }

    public int getArmorPenalty() {
        return armorPenalty;
    }

    public void setArmorPenalty(int armorPenalty) {
        this.armorPenalty = armorPenalty;
    }

    public Weapon getWeapon1() {
        return weapon1;
    }

    public void setWeapon1(Weapon weapon1) {
        this.weapon1 = weapon1;
    }

    public Weapon getWeapon2() {
        return weapon2;
    }

    public void setWeapon2(Weapon weapon2) {
        this.weapon2 = weapon2;
    }

    public Weapon getWeapon3() {
        return weapon3;
    }

    public void setWeapon3(Weapon weapon3) {
        this.weapon3 = weapon3;
    }

    public Weapon getOffHand() {
        return offHand;
    }

    public void setOffHand(Weapon offHand) {
        this.offHand = offHand;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public int getAbilityLimit() {
        return abilityLimit;
    }

    public void setAbilityLimit(int abilityLimit) {
        this.abilityLimit = abilityLimit;
    }
}
