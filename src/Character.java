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
    //house stuff
    private String houseName;
    private String realm;
    //stats
    private int agility, animalHandling, athletics, awareness, cunning, deception, endurance, fighting,
                healing, language, knowledge, marksmanship, persuasion, status, stealth, survival,
                thievery, warfare, will;
    private int experience;

    public Character() {
        randName();
        title = null;
        status = -1;
        startingStats();
    }

    public Character(Character toCopy) {
        copyCharacter(toCopy);
    }

    public Character(String name) {
        this.name = name;
        title = null;
        status = -1;
        startingStats();
    }

    public Character(String houseName, String realm, String gender, int status) {
        randName();
        this.title = null;
        this.houseName = houseName;
        this.realm = realm;
        this.gender = gender;
        this.status = status;
        startingStats();
    }

    public Character(String houseName, String realm, int status) {
        randName();
        this.title = null;
        this.houseName = houseName;
        this.realm = realm;
        this.gender = null;
        this.status = status;
        startingStats();
    }

    public void displayAll() {
        displayName();
        displayBio();
        displayStats();

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
        System.out.println("Status: " + status);
        if (agility > 2)
            System.out.println("Agility: " + agility);
        if (animalHandling > 2)
            System.out.println("Animal Handling: " + animalHandling);
        if (athletics > 2)
            System.out.println("Athletics: " + athletics);
        if (awareness > 2)
            System.out.println("Awareness: " + awareness);
        if (cunning > 2)
            System.out.println("Cunning: " + cunning);
        if (deception > 2)
            System.out.println("Deception: " + deception);
        if (endurance > 2)
            System.out.println("Endurance: " + endurance);
        if (fighting > 2)
            System.out.println("Fighting: " + fighting);
        if (healing > 2)
            System.out.println("Healing: " + healing);
        if (language > 2)
            System.out.println("Language: " + language);
        if (knowledge > 2)
            System.out.println("Knowledge: " + knowledge);
        if (marksmanship > 2)
            System.out.println("Marksmanship: " + marksmanship);
        if (persuasion > 2)
            System.out.println("Persuasion: " + persuasion);
        if (stealth > 2)
            System.out.println("Stealth: " + stealth);
        if (survival > 2)
            System.out.println("Survival: " + survival);
        if (thievery > 2)
            System.out.println("Thievery: " + thievery);
        if (warfare > 2)
            System.out.println("Warfare: " + warfare);
        if (will > 2)
            System.out.println("Will: " + will);
    }

    public void generateCharacter() {
        randName();
        randAge();
        randStats();
        if (gender == null) {
            randGender();
        }
    }

    public void randGender() {
        Dice die = new Dice();
        if (die.roll() > 3)
            gender = "Male";
        else
            gender = "Female";
    }

    public void randName() {
        Data data = new Data();
        name = data.randName();
    }

    public void randAge() {
        Dice die = new Dice();
        int num = die.roll(3);
        switch (num) {
            case 3: age = "Youth";
                experience = 120;
                break;
            case 4: age = "Adolescent";
                experience = 150;
                break;
            case 5:
            case 6: age = "Young Adult";
                experience = 180;
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11: age = "Adult";
                experience = 210;
                break;
            case 12:
            case 13:
            case 14:
            case 15: age = "Middle Age";
                experience = 240;
                break;
            case 16: age = "Old";
                experience = 270;
                break;
            case 17: age = "Very Old";
                experience = 330;
                break;
            case 18: age = "Venerable";
                experience = 360;
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

    public String getTitle() {
        return title;
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

}
