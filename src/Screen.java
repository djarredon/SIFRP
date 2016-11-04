import com.sun.javaws.exceptions.ExitException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

/**
 * Created by arredon on 10/27/2016.
 */
public class Screen extends JFrame {
    private int xMax;     //x dimension of frame
    private int yMax;      //y dimension of frame
    private int halfX;
    private Point labelPos;             //Position of screen label (i.e. "main menu", "account menu", etc.)
    private Dimension buttonSize;       //size of buttons
    private Color background;           //color of background

    private JLabel screenName;

    private Container c;

    private HouseList houseList;

    public Screen(String title, int xMax, int yMax) {
        super(title);
        this.xMax = xMax;
        this.yMax = yMax;
        setSize(xMax, yMax);
        halfX = xMax/2 - 100;

        buttonSize = new Dimension(200,30);
        labelPos = new Point(halfX, 20);
        background = new Color(170,170,120);

        //Screen name
        screenName = new JLabel();
        screenName.setSize(buttonSize);
        screenName.setLocation(labelPos);

        c = null;
        setLayout(null);

        initializeHouseList();

        mainMenu();
        //houseMenu();

    }

    public void mainMenu() {
        repaint();
        getContentPane().removeAll();

        screenName.setName("Main Menu");
        //House menu button
        JButton house = new JButton("House Menu");
        house.setSize(buttonSize);
        house.setLocation(halfX, 250);
        //Character Menu Screen
        JButton character = new JButton("Character Menu");
        character.setSize(buttonSize);
        character.setLocation(halfX, 290);
        //exit program
        JButton exit = new JButton("Exit");
        exit.setSize(buttonSize);
        exit.setLocation(halfX, 210);

        c = getContentPane();

        c.setBackground(background);
        c.add(house);
        c.add(character);
        c.add(exit);
        c.add(screenName);

        character.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                characterMenu();
            }
        });

        house.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                houseMenu();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void houseMenu() {
        //clear screen
        //repaint();
        getContentPane().removeAll();

        //Screen name
        screenName.setName("House Menu");
        //Back button
        JButton back = new JButton("Back");
        back.setSize(buttonSize);
        back.setLocation(20,10);

        //next button
        JButton next = new JButton("Next");
        next.setSize(buttonSize);
        next.setLocation(700, 575);
        //previous button
        JButton previous = new JButton("Previous");
        previous.setSize(buttonSize);
        previous.setLocation(300, 575);

        //displays house information
        JTextArea textArea = new JTextArea(houseList.printCurrent());
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setLocation(250, 150);
        scrollPane.setBounds(250, 150, 800, 400);
        //System.out.println(houseList.printCurrent());

        c = getContentPane();

        c.setBackground(background);
        c.add(screenName);
        c.add(scrollPane);
        c.add(next);
        c.add(previous);
        c.add(back);

        repaint();

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                houseList.moveNext();
                textArea.setText(houseList.printCurrent());
                houseMenu();
            }
        });

        previous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                houseList.movePrev();
                textArea.setText(houseList.printCurrent());
                houseMenu();
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu();
            }
        });
    }

    public void initializeHouseList() {
        HouseNode temp;
        houseList = new HouseList();
        for (int i = 0; i < 10; ++i) {
            temp = new HouseNode();
            temp.generateRandHouse();
            houseList.insert(temp);
        }
    }

    /*  In character menu should be able to
            1. Create new Character
            2. Create list of random characters
            3. Display list of characters
            4. Edit Character
            5. Delete Character
     */
    public void characterMenu() {
        repaint();
        getContentPane().removeAll();

        JButton back = new JButton("Back");
        back.setSize(buttonSize);
        back.setLocation(20,10);

        JButton newCharacter = new JButton("New Character");
        newCharacter.setSize(buttonSize);
        newCharacter.setLocation(halfX, 150);

        JButton randCharacters = new JButton("Random Characters");
        randCharacters.setSize(buttonSize);
        randCharacters.setLocation(halfX, 190);

        JButton editCharacter = new JButton("Edit Character");
        editCharacter.setSize(buttonSize);
        editCharacter.setLocation(halfX, 230);

        JButton deleteCharacter = new JButton("Delete Character");
        deleteCharacter.setSize(buttonSize);
        deleteCharacter.setLocation(halfX, 270);

        JButton characterSheet = new JButton("Character Sheet");
        characterSheet.setSize(buttonSize);
        characterSheet.setLocation(halfX, 310);


        c = getContentPane();
        c.setBackground(background);
        c.add(back);
        c.add(newCharacter);
        c.add(randCharacters);
        c.add(editCharacter);
        c.add(deleteCharacter);
        c.add(characterSheet);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenu();
            }
        });

        newCharacter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                characterCreation();
            }
        });

        characterSheet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Character character = new Character();
                character.generateCharacter();

                Armor test = new Armor();
                test.randArmor();
                character.giveArmor(test);

                Weapon weapon = new Weapon();
                weapon.randWeapon();
                character.giveWeapon(weapon);
                weapon.randWeapon();
                character.giveWeapon(weapon);
                weapon.randWeapon();
                character.giveWeapon(weapon);

                characterSheet(character);
            }
        });
    }

    public void characterCreation() {
        repaint();
        getContentPane().removeAll();

        JButton back = new JButton("Back");
        back.setSize(buttonSize);
        back.setLocation(20,10);

        JTextField charName = new JTextField();
        charName.setSize(buttonSize);
        charName.setLocation(200, 100);

        c = getContentPane();

        c.add(back);
        c.add(charName);


        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                characterMenu();
            }
        });
    }

    public void characterSheet(Character character) {
        repaint();
        getContentPane().removeAll();
        if (character == null) {
            character = new Character();
            character.generateCharacter();
        }

        Dimension specialtySize = new Dimension(250, 30);
        Dimension fieldSize = new Dimension(75, 30);
        //column and row locations
        int col1 = 20;  //column one for rating
        int col2 = 100;  //column for ability name
        int col3 = 175; //column for specialties
        int row = 100;  //y coordinate
        int rowInc = 40; //row increment value

        //Back button
        JButton back = new JButton("Back");
        back.setSize(buttonSize);
        back.setLocation(20,10);

        //Bio stuff
        //name
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setLocation(250, 10);
        nameLabel.setSize(buttonSize);
        JTextField charName = new JTextField(character.getName());
        charName.setSize(300, 30);
        charName.setLocation(300, 10);
        //age
        JLabel ageLabel = new JLabel("Age");
        ageLabel.setLocation(250, 50);
        ageLabel.setSize(fieldSize);
        JTextField charAge = new JTextField(character.getAge());
        charAge.setSize(fieldSize);
        charAge.setLocation(300, 50);
        //gender
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setLocation(400, 50);
        genderLabel.setSize(fieldSize);
        JTextField charGender = new JTextField(character.getGender());
        charGender.setSize(fieldSize);
        charGender.setLocation(450, 50);
        //house
        JLabel houseLabel = new JLabel("House");
        houseLabel.setSize(buttonSize);
        houseLabel.setLocation(550, 50);
        JTextField charHouse = new JTextField(character.getHouseName());
        charHouse.setSize(fieldSize);
        charHouse.setLocation(600, 50);
        //Stats
        //column labels
        JLabel rating = new JLabel("Rating");
        rating.setSize(fieldSize);
        rating.setLocation(col1, row);
        JLabel ability = new JLabel("Ability");
        ability.setSize(fieldSize);
        ability.setLocation(col2, row);
        JLabel specialties = new JLabel("Specialties");
        specialties.setSize(fieldSize);
        specialties.setLocation(col3, row);
        row += rowInc;
        //agility
        JLabel agility = new JLabel("Agility");
        agility.setSize(fieldSize);
        agility.setLocation(col2, row);
        JTextField agilityRating = new JTextField(character.printAgility());
        agilityRating.setEditable(false);
        agilityRating.setSize(fieldSize);
        agilityRating.setLocation(col1, row);
        JTextField agilitySpecialties = new JTextField(character.printAgilitySpecialties());
        agilitySpecialties.setEditable(false);
        agilitySpecialties.setSize(specialtySize);
        agilitySpecialties.setLocation(col3, row);
        row += rowInc;
        //animal handling
        JLabel animalHandling = new JLabel("<html>Animal<br>Handling</html>");
        animalHandling.setSize(fieldSize);
        animalHandling.setLocation(col2, row);
        JTextField animalHandlingRating = new JTextField(character.printAnimalHandling());
        animalHandlingRating.setEditable(false);
        animalHandlingRating.setSize(fieldSize);
        animalHandlingRating.setLocation(col1, row);
        JTextField animalHandlingSpecialties = new JTextField(character.printAnimalHandlingSpecialties());
        animalHandlingSpecialties.setEditable(false);
        animalHandlingSpecialties.setSize(specialtySize);
        animalHandlingSpecialties.setLocation(col3, row);
        row += rowInc;
        //Athletics
        JLabel athletics = new JLabel("Athletics");
        athletics.setSize(fieldSize);
        athletics.setLocation(col2, row);
        JTextField athleticsRating = new JTextField(character.printAthletics());
        athleticsRating.setEditable(false);
        athleticsRating.setSize(fieldSize);
        athleticsRating.setLocation(col1, row);
        JTextField athleticsSpecialties = new JTextField(character.printAthleticsSpecialties());
        athleticsSpecialties.setEditable(false);
        athleticsSpecialties.setSize(specialtySize);
        athleticsSpecialties.setLocation(col3, row);
        row += rowInc;
        //Awareness
        JLabel awareness = new JLabel("Awareness");
        awareness.setSize(fieldSize);
        awareness.setLocation(col2, row);
        JTextField awarenessRating = new JTextField(character.printAwareness());
        awarenessRating.setEditable(false);
        awarenessRating.setSize(fieldSize);
        awarenessRating.setLocation(col1, row);
        JTextField awarenessSpecialties = new JTextField(character.printAwarenessSpecialties());
        awarenessSpecialties.setEditable(false);
        awarenessSpecialties.setSize(specialtySize);
        awarenessSpecialties.setLocation(col3, row);
        row += rowInc;
        //Cunning
        JLabel cunning = new JLabel("Cunning");
        cunning.setSize(fieldSize);
        cunning.setLocation(col2, row);
        JTextField cunningRating = new JTextField(character.printCunning());
        cunningRating.setEditable(false);
        cunningRating.setSize(fieldSize);
        cunningRating.setLocation(col1, row);
        JTextField cunningSpecialties = new JTextField(character.printCunningSpecialties());
        cunningSpecialties.setEditable(false);
        cunningSpecialties.setSize(specialtySize);
        cunningSpecialties.setLocation(col3, row);
        row += rowInc;
        //Deception
        JLabel deception = new JLabel("Deception");
        deception.setSize(fieldSize);
        deception.setLocation(col2, row);
        JTextField deceptionRating = new JTextField(character.printDeception());
        deceptionRating.setEditable(false);
        deceptionRating.setSize(fieldSize);
        deceptionRating.setLocation(col1, row);
        JTextField deceptionSpecialties = new JTextField(character.printDeceptionSpecialties());
        deceptionSpecialties.setEditable(false);
        deceptionSpecialties.setSize(specialtySize);
        deceptionSpecialties.setLocation(col3, row);
        row += rowInc;
        //Endurance
        JLabel endurance = new JLabel("Endurance");
        endurance.setSize(fieldSize);
        endurance.setLocation(col2, row);
        JTextField enduranceRating = new JTextField(character.printEndurance());
        enduranceRating.setEditable(false);
        enduranceRating.setSize(fieldSize);
        enduranceRating.setLocation(col1, row);
        JTextField enduranceSpecialties = new JTextField(character.printEnduranceSpecialties());
        enduranceSpecialties.setEditable(false);
        enduranceSpecialties.setSize(specialtySize);
        enduranceSpecialties.setLocation(col3, row);
        row += rowInc;
        //Fighting
        JLabel fighting = new JLabel("Fighting");
        fighting.setSize(fieldSize);
        fighting.setLocation(col2, row);
        JTextField fightingRating = new JTextField(character.printFighting());
        fightingRating.setEditable(false);
        fightingRating.setSize(fieldSize);
        fightingRating.setLocation(col1, row);
        JTextField fightingSpecialties = new JTextField(character.printFightingSpecialties());
        fightingSpecialties.setEditable(false);
        fightingSpecialties.setSize(specialtySize);
        fightingSpecialties.setLocation(col3, row);
        row += rowInc;
        //Healing
        JLabel healing = new JLabel("Healing");
        healing.setSize(fieldSize);
        healing.setLocation(col2, row);
        JTextField healingRating = new JTextField(character.printHealing());
        healingRating.setEditable(false);
        healingRating.setSize(fieldSize);
        healingRating.setLocation(col1, row);
        JTextField healingSpecialties = new JTextField(character.printHealingSpecialties());
        healingSpecialties.setEditable(false);
        healingSpecialties.setSize(specialtySize);
        healingSpecialties.setLocation(col3, row);
        row += rowInc;
        //Language
        JLabel language = new JLabel("Language");
        language.setSize(fieldSize);
        language.setLocation(col2, row);
        JTextField languageRating = new JTextField(character.printLanguage());
        languageRating.setEditable(false);
        languageRating.setSize(fieldSize);
        languageRating.setLocation(col1, row);
        JTextField languageSpecialties = new JTextField(character.printLanguageSpecialties());
        languageSpecialties.setEditable(false);
        languageSpecialties.setSize(180 + (specialtySize.width * 2), specialtySize.height);
        languageSpecialties.setLocation(col3, row);
        row += rowInc;
        //new columns
        int col12 = col1 + 430;
        int col22 = col2 + 430;
        int col32 = col3 + 430;
        row = 100;
        //second column labels
        JLabel rating2 = new JLabel("Rating");
        rating2.setSize(fieldSize);
        rating2.setLocation(col12, row);
        JLabel ability2 = new JLabel("Ability");
        ability2.setSize(fieldSize);
        ability2.setLocation(col22, row);
        JLabel specialties2 = new JLabel("Specialties");
        specialties2.setSize(fieldSize);
        specialties2.setLocation(col32, row);
        row += rowInc;
        //Knowledge
        JLabel knowledge = new JLabel("Knowledge");
        knowledge.setSize(fieldSize);
        knowledge.setLocation(col22, row);
        JTextField knowledgeRating = new JTextField(character.printKnowledge());
        knowledgeRating.setEditable(false);
        knowledgeRating.setSize(fieldSize);
        knowledgeRating.setLocation(col12, row);
        JTextField knowledgeSpecialties = new JTextField(character.printKnowledgeSpecialties());
        knowledgeSpecialties.setEditable(false);
        knowledgeSpecialties.setSize(specialtySize);
        knowledgeSpecialties.setLocation(col32, row);
        row += rowInc;
        //Marksmanship
        JLabel marksmanship = new JLabel("<html>Marks-<br>manship</html>");
        marksmanship.setSize(fieldSize);
        marksmanship.setLocation(col22, row);
        JTextField marksmanshipRating = new JTextField(character.printMarksmanship());
        marksmanshipRating.setEditable(false);
        marksmanshipRating.setSize(fieldSize);
        marksmanshipRating.setLocation(col12, row);
        JTextField marksmanshipSpecialties = new JTextField(character.printMarksmanshipSpecialties());
        marksmanshipSpecialties.setEditable(false);
        marksmanshipSpecialties.setSize(specialtySize);
        marksmanshipSpecialties.setLocation(col32, row);
        row += rowInc;
        //Persuasion
        JLabel persuasion = new JLabel("Persuasion");
        persuasion.setSize(fieldSize);
        persuasion.setLocation(col22, row);
        JTextField persuasionRating = new JTextField(character.printPersuasion());
        persuasionRating.setEditable(false);
        persuasionRating.setSize(fieldSize);
        persuasionRating.setLocation(col12, row);
        JTextField persuasionSpecialties = new JTextField(character.printPersuasionSpecialties());
        persuasionSpecialties.setEditable(false);
        persuasionSpecialties.setSize(specialtySize);
        persuasionSpecialties.setLocation(col32, row);
        row += rowInc;
        //Status
        JLabel status = new JLabel("Status");
        status.setSize(fieldSize);
        status.setLocation(col22, row);
        JTextField statusRating = new JTextField(character.printStatus());
        statusRating.setEditable(false);
        statusRating.setSize(fieldSize);
        statusRating.setLocation(col12, row);
        JTextField statusSpecialties = new JTextField(character.printStatusSpecialties());
        statusSpecialties.setEditable(false);
        statusSpecialties.setSize(specialtySize);
        statusSpecialties.setLocation(col32, row);
        row += rowInc;
        //Stealth
        JLabel stealth = new JLabel("Stealth");
        stealth.setSize(fieldSize);
        stealth.setLocation(col22, row);
        JTextField stealthRating = new JTextField(character.printStealth());
        stealthRating.setEditable(false);
        stealthRating.setSize(fieldSize);
        stealthRating.setLocation(col12, row);
        JTextField stealthSpecialties = new JTextField(character.printStealthSpecialties());
        stealthSpecialties.setEditable(false);
        stealthSpecialties.setSize(specialtySize);
        stealthSpecialties.setLocation(col32, row);
        row += rowInc;
        //Survival
        JLabel survival = new JLabel("Survival");
        survival.setSize(fieldSize);
        survival.setLocation(col22, row);
        JTextField survivalRating = new JTextField(character.printSurvival());
        survivalRating.setEditable(false);
        survivalRating.setSize(fieldSize);
        survivalRating.setLocation(col12, row);
        JTextField survivalSpecialties = new JTextField(character.printSurvivalSpecialties());
        survivalSpecialties.setEditable(false);
        survivalSpecialties.setSize(specialtySize);
        survivalSpecialties.setLocation(col32, row);
        row += rowInc;
        //Thievery
        JLabel thievery = new JLabel("Thievery");
        thievery.setSize(fieldSize);
        thievery.setLocation(col22, row);
        JTextField thieveryRating = new JTextField(character.printThievery());
        thieveryRating.setEditable(false);
        thieveryRating.setSize(fieldSize);
        thieveryRating.setLocation(col12, row);
        JTextField thieverySpecialties = new JTextField(character.printThieverySpecialties());
        thieverySpecialties.setEditable(false);
        thieverySpecialties.setSize(specialtySize);
        thieverySpecialties.setLocation(col32, row);
        row += rowInc;
        //Warfare
        JLabel warfare = new JLabel("Warfare");
        warfare.setSize(fieldSize);
        warfare.setLocation(col22, row);
        JTextField warfareRating = new JTextField(character.printWarfare());
        warfareRating.setEditable(false);
        warfareRating.setSize(fieldSize);
        warfareRating.setLocation(col12, row);
        JTextField warfareSpecialties = new JTextField(character.printWarfareSpecialties());
        warfareSpecialties.setEditable(false);
        warfareSpecialties.setSize(specialtySize);
        warfareSpecialties.setLocation(col32, row);
        row += rowInc;
        //Will
        JLabel will = new JLabel("Will");
        will.setSize(fieldSize);
        will.setLocation(col22, row);
        JTextField willRating = new JTextField(character.printWill());
        willRating.setEditable(false);
        willRating.setSize(fieldSize);
        willRating.setLocation(col12, row);
        JTextField willSpecialties = new JTextField(character.printWillSpecialties());
        willSpecialties.setEditable(false);
        willSpecialties.setSize(specialtySize);
        willSpecialties.setLocation(col32, row);
        //row += rowInc;

        //Qualities
        JLabel qualitiesLabel = new JLabel("Qualities");
        qualitiesLabel.setSize(fieldSize);
        qualitiesLabel.setLocation(col1, row += 80);
        JTextArea qualities = new JTextArea();
        qualities.setEditable(false);
        qualities.setSize(400, 90);
        qualities.setLocation(col1, row + 30);

        //Destiny points
        //will do later

        //Intrigue
        JLabel intrigueLabel = new JLabel("Intrigue");
        intrigueLabel.setSize(fieldSize);
        intrigueLabel.setLocation(col12, row);
        JLabel intrigueDefenseLabel = new JLabel("Intrigue Defense");
        intrigueDefenseLabel.setSize(buttonSize);
        intrigueDefenseLabel.setLocation(col12, row + 20);
        JTextField intrigueValue = new JTextField(character.printIntrigueDefense());
        intrigueValue.setEditable(false);
        intrigueValue.setLocation(col12, row + 45);
        intrigueValue.setSize(buttonSize);
        JLabel intrigueExplanation = new JLabel("Awareness + Cunning + Status");
        intrigueExplanation.setSize(buttonSize);
        intrigueExplanation.setLocation(col12 + 15, row + 75);
        JLabel composureLabel = new JLabel("Composure");
        composureLabel.setLocation(col12, row + 100);
        composureLabel.setSize(buttonSize);
        JTextField composureValue = new JTextField(character.printComposure());
        composureValue.setEditable(false);
        composureValue.setSize(buttonSize);
        composureValue.setLocation(col12, row + 130);
        JLabel composureExplanation = new JLabel("Will Ranks x 3");
        composureExplanation.setLocation(col12 + 45, row + 155);
        composureExplanation.setSize(buttonSize);

        //Combat
        JLabel combatLabel = new JLabel("Combat");
        combatLabel.setSize(fieldSize);
        combatLabel.setLocation(col32 + 50, row);
        JLabel combatDefenseLabel = new JLabel("Combat Defense");
        combatDefenseLabel.setSize(buttonSize);
        combatDefenseLabel.setLocation(col32 + 50, row + 20);
        JTextField combatValue = new JTextField(character.printCombatDefense());
        combatValue.setEditable(false);
        combatValue.setLocation(col32 + 50, row + 45);
        combatValue.setSize(buttonSize);
        JLabel combatExplanation = new JLabel("<html>Agility+Athletics+Awareness<br>" +
                "Defensive Bonus-Armor Penalty</html>");
        combatExplanation.setSize(buttonSize);
        combatExplanation.setLocation(col32 + 50 + 15, row + 75);
        JLabel healthLabel = new JLabel("Health");
        healthLabel.setLocation(col32 + 50, row + 100);
        healthLabel.setSize(buttonSize);
        JTextField healthValue = new JTextField(character.printHealth());
        healthValue.setEditable(false);
        healthValue.setSize(buttonSize);
        healthValue.setLocation(col32 + 50, row + 130);
        JLabel healthExplanation = new JLabel("Endurance Ranks x 3");
        healthExplanation.setLocation(col32 + 50 + 25, row + 155);
        healthExplanation.setSize(buttonSize);

        //Weapons, Armor, Damage
        //Weapons columns
        int weaponNameCol = col1;
        int weaponDiceCol = col1 + 160;
        int weaponDamageCol = weaponDiceCol + fieldSize.width + 10;
        row += 160;
        JLabel weaponSection = new JLabel("Weapons");
        weaponSection.setSize(buttonSize);
        weaponSection.setLocation(col3, row);
        //
        JLabel attack = new JLabel("Attack");
        attack.setLocation(weaponNameCol, row + 40);
        attack.setSize(150, 30);
        //
        JLabel testDice = new JLabel("Test Dice");
        testDice.setLocation(weaponDiceCol, row + 40);
        testDice.setSize(specialtySize);
        //
        JLabel weaponDamage = new JLabel("Weapon Damage");
        weaponDamage.setSize(specialtySize);
        weaponDamage.setLocation(weaponDamageCol, row + 40);
        //Weapon1
        JTextField weapon1Name = new JTextField(character.printWeapon1Name());
        weapon1Name.setLocation(weaponNameCol, row + 70);
        weapon1Name.setSize(150, 30);
        weapon1Name.setEditable(false);
        JTextField weapon1Dice = new JTextField(character.printWeapon1AttackDice());
        weapon1Dice.setLocation(weaponDiceCol, row + 70);
        weapon1Dice.setSize(fieldSize);
        weapon1Dice.setEditable(false);
        JTextField weapon1Damage = new JTextField(character.printWeapon1Damage()
                + "   " + character.printWeapon1Description());
        weapon1Damage.setLocation(weaponDamageCol, row + 70);
        weapon1Damage.setSize(specialtySize.width + 50, specialtySize.height);
        weapon1Damage.setEditable(false);
        //
        row += 40;
        //Off-Hand weapon
        JTextField offHandName = new JTextField(character.printOffHandName());
        offHandName.setLocation(weaponNameCol, row + 70);
        offHandName.setSize(150, 30);
        offHandName.setEditable(false);
        JTextField offHandDice = new JTextField(character.printOffHandAttackDice());
        offHandDice.setLocation(weaponDiceCol, row + 70);
        offHandDice.setSize(fieldSize);
        offHandDice.setEditable(false);
        JTextField offHandDamage = new JTextField(character.printOffHandDamage()
                + "   " + character.printOffHandDescription());
        offHandDamage.setLocation(weaponDamageCol, row + 70);
        offHandDamage.setSize(specialtySize.width + 50, specialtySize.height);
        offHandDamage.setEditable(false);
        //
        row += 40;
        //weapon2
        JTextField weapon2Name = new JTextField(character.printWeapon2Name());
        weapon2Name.setLocation(weaponNameCol, row + 70);
        weapon2Name.setSize(150, 30);
        weapon2Name.setEditable(false);
        JTextField weapon2Dice = new JTextField(character.printWeapon2AttackDice());
        weapon2Dice.setLocation(weaponDiceCol, row + 70);
        weapon2Dice.setSize(fieldSize);
        weapon2Dice.setEditable(false);
        JTextField weapon2Damage = new JTextField(character.printWeapon2Damage()
                + "   " + character.printWeapon2Description());
        weapon2Damage.setLocation(weaponDamageCol, row + 70);
        weapon2Damage.setSize(specialtySize.width + 50, specialtySize.height);
        weapon2Damage.setEditable(false);
        //
        row += 40;
        //weapon3
        JTextField weapon3Name = new JTextField(character.printWeapon3Name());
        weapon3Name.setLocation(weaponNameCol, row + 70);
        weapon3Name.setSize(150, 30);
        weapon3Name.setEditable(false);
        JTextField weapon3Dice = new JTextField(character.printWeapon3AttackDice());
        weapon3Dice.setLocation(weaponDiceCol, row + 70);
        weapon3Dice.setSize(fieldSize);
        weapon3Dice.setEditable(false);
        JTextField weapon3Damage = new JTextField(character.printWeapon3Damage()
                + "   " + character.printWeapon2Description());
        weapon3Damage.setLocation(weaponDamageCol, row + 70);
        weapon3Damage.setSize(specialtySize.width + 50, specialtySize.height);
        weapon3Damage.setEditable(false);



        //panel for containing things
        JPanel sheet = new JPanel(null);
        sheet.setPreferredSize(new Dimension(xMax-100, yMax*3));



        c = getContentPane();

        sheet.add(weapon1Name);
        sheet.add(weapon1Dice);
        sheet.add(weapon1Damage);
        sheet.add(weapon2Name);
        sheet.add(weapon2Dice);
        sheet.add(weapon2Damage);
        sheet.add(weapon3Name);
        sheet.add(weapon3Dice);
        sheet.add(weapon3Damage);
        sheet.add(offHandName);
        sheet.add(offHandDice);
        sheet.add(offHandDamage);
        sheet.add(weaponSection);
        sheet.add(attack);
        sheet.add(testDice);
        sheet.add(weaponDamage);

        sheet.add(back);
        sheet.add(charName);
        sheet.add(nameLabel);
        sheet.add(charAge);
        sheet.add(ageLabel);
        sheet.add(charGender);
        sheet.add(genderLabel);
        sheet.add(charHouse);
        sheet.add(houseLabel);
        //qualities, destiny, intrigue, combat
        sheet.add(qualitiesLabel);
        sheet.add(qualities);
        //combat
        sheet.add(combatLabel);
        sheet.add(combatDefenseLabel);
        sheet.add(combatValue);
        sheet.add(combatExplanation);
        sheet.add(healthLabel);
        sheet.add(healthValue);
        sheet.add(healthExplanation);
        //intrigue
        sheet.add(intrigueDefenseLabel);
        sheet.add(intrigueLabel);
        sheet.add(intrigueValue);
        sheet.add(intrigueExplanation);
        sheet.add(composureLabel);
        sheet.add(composureValue);
        sheet.add(composureExplanation);
        //Abilities section
        sheet.add(rating);
        sheet.add(rating2);
        sheet.add(ability);
        sheet.add(ability2);
        sheet.add(specialties);
        sheet.add(specialties2);
        sheet.add(agility);
        sheet.add(agilityRating);
        sheet.add(agilitySpecialties);
        sheet.add(animalHandling);
        sheet.add(animalHandlingRating);
        sheet.add(animalHandlingSpecialties);
        sheet.add(athletics);
        sheet.add(athleticsRating);
        sheet.add(athleticsSpecialties);
        sheet.add(awareness);
        sheet.add(awarenessRating);
        sheet.add(awarenessSpecialties);
        sheet.add(cunning);
        sheet.add(cunningRating);
        sheet.add(cunningSpecialties);
        sheet.add(deception);
        sheet.add(deceptionRating);
        sheet.add(deceptionSpecialties);
        sheet.add(endurance);
        sheet.add(enduranceRating);
        sheet.add(enduranceSpecialties);
        sheet.add(fighting);
        sheet.add(fightingRating);
        sheet.add(fightingSpecialties);
        sheet.add(healing);
        sheet.add(healingRating);
        sheet.add(healingSpecialties);
        sheet.add(language);
        sheet.add(languageRating);
        sheet.add(languageSpecialties);
        sheet.add(knowledge);
        sheet.add(knowledgeRating);
        sheet.add(knowledgeSpecialties);
        sheet.add(marksmanship);
        sheet.add(marksmanshipRating);
        sheet.add(marksmanshipSpecialties);
        sheet.add(persuasion);
        sheet.add(persuasionRating);
        sheet.add(persuasionSpecialties);
        sheet.add(status);
        sheet.add(statusRating);
        sheet.add(statusSpecialties);
        sheet.add(stealth);
        sheet.add(stealthRating);
        sheet.add(stealthSpecialties);
        sheet.add(survival);
        sheet.add(survivalRating);
        sheet.add(survivalSpecialties);
        sheet.add(thievery);
        sheet.add(thieveryRating);
        sheet.add(thieverySpecialties);
        sheet.add(warfare);
        sheet.add(warfareRating);
        sheet.add(warfareSpecialties);
        sheet.add(will);
        sheet.add(willRating);
        sheet.add(willSpecialties);


        //contains the panel for scrolling
        JScrollPane scrollPane = new JScrollPane(sheet);
        scrollPane.setViewportView(sheet);

        scrollPane.setSize(xMax-50, yMax - 120);
        scrollPane.setLocation(20, 60);
        scrollPane.setWheelScrollingEnabled(true);
        scrollPane.setPreferredSize(new Dimension(xMax - 100, yMax-100));
        //scrollPane.revalidate();
        repaint();

        c.add(back);
        c.add(scrollPane);
/*
        c.add(back);
        c.add(charName);
        c.add(nameLabel);
        c.add(charAge);
        c.add(ageLabel);
        c.add(charGender);
        c.add(genderLabel);
        c.add(charHouse);
        c.add(houseLabel);
        //qualities, destiny, intrigue, combat
        c.add(qualitiesLabel);
        c.add(qualities);
        //combat
        c.add(combatLabel);
        c.add(combatDefenseLabel);
        c.add(combatValue);
        c.add(combatExplanation);
        c.add(healthLabel);
        c.add(healthValue);
        c.add(healthExplanation);
        //intrigue
        c.add(intrigueDefenseLabel);
        c.add(intrigueLabel);
        c.add(intrigueValue);
        c.add(intrigueExplanation);
        c.add(composureLabel);
        c.add(composureValue);
        c.add(composureExplanation);
        //Abilities section
        c.add(rating);
        c.add(rating2);
        c.add(ability);
        c.add(ability2);
        c.add(specialties);
        c.add(specialties2);
        c.add(agility);
        c.add(agilityRating);
        c.add(agilitySpecialties);
        c.add(animalHandling);
        c.add(animalHandlingRating);
        c.add(animalHandlingSpecialties);
        c.add(athletics);
        c.add(athleticsRating);
        c.add(athleticsSpecialties);
        c.add(awareness);
        c.add(awarenessRating);
        c.add(awarenessSpecialties);
        c.add(cunning);
        c.add(cunningRating);
        c.add(cunningSpecialties);
        c.add(deception);
        c.add(deceptionRating);
        c.add(deceptionSpecialties);
        c.add(endurance);
        c.add(enduranceRating);
        c.add(enduranceSpecialties);
        c.add(fighting);
        c.add(fightingRating);
        c.add(fightingSpecialties);
        c.add(healing);
        c.add(healingRating);
        c.add(healingSpecialties);
        c.add(language);
        c.add(languageRating);
        c.add(languageSpecialties);
        c.add(knowledge);
        c.add(knowledgeRating);
        c.add(knowledgeSpecialties);
        c.add(marksmanship);
        c.add(marksmanshipRating);
        c.add(marksmanshipSpecialties);
        c.add(persuasion);
        c.add(persuasionRating);
        c.add(persuasionSpecialties);
        c.add(status);
        c.add(statusRating);
        c.add(statusSpecialties);
        c.add(stealth);
        c.add(stealthRating);
        c.add(stealthSpecialties);
        c.add(survival);
        c.add(survivalRating);
        c.add(survivalSpecialties);
        c.add(thievery);
        c.add(thieveryRating);
        c.add(thieverySpecialties);
        c.add(warfare);
        c.add(warfareRating);
        c.add(warfareSpecialties);
        c.add(will);
        c.add(willRating);
        c.add(willSpecialties);
        */

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                characterMenu();
            }
        });
    }

    //print text blocks on multiple lines
    public void drawString(Graphics g, String text, int x, int y) {
        for (String line: text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }
}
