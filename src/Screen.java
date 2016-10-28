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
                characterSheet();
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

    public void characterSheet() {
        repaint();
        getContentPane().removeAll();

        //Back button
        JButton back = new JButton("Back");
        back.setSize(buttonSize);
        back.setLocation(20,10);

        //Bio stuff
        JTextField charName = new JTextField();
        charName.setSize(300, 30);
        charName.setLocation(150, 50);
        JTextField charAge = new JTextField();
        charAge.setSize(75, 30);
        charAge.setLocation(150, 90);
        JTextField charGender = new JTextField();
        charGender.setSize(75, 30);
        charGender.setLocation(250, 90);
        JTextField charHouse = new JTextField();
        charHouse.setSize(75, 30);
        charHouse.setLocation(350, 90);
        //Stats
        //agility
        JLabel agility = new JLabel("Agility");
        agility.setSize(buttonSize);
        //agility.setLocation();
        JTextField agilityRating = new JTextField();
        JTextField agilitySpecialties = new JTextField();
        //animal handling
        JLabel animalHandling = new JLabel("Animal Handling");
        animalHandling.setSize(buttonSize);
        JTextField animalHandlingRating = new JTextField();
        JTextField animalHandlingSpecialties = new JTextField();
        //Athletics
        JLabel athletics = new JLabel("Athletics");
        athletics.setSize(buttonSize);
        JTextField athleticsRating = new JTextField();
        JTextField athleticsSpecialties = new JTextField();
        //Awareness
        JLabel awareness = new JLabel("Awareness");
        awareness.setSize(buttonSize);
        JTextField awarenessRating = new JTextField();
        JTextField awarenessSpecialties = new JTextField();
        //Cunning
        JLabel cunning = new JLabel("Cunning");
        cunning.setSize(buttonSize);
        JTextField cunningRating = new JTextField();
        JTextField cunningSpecialties = new JTextField();
        //Deception
        JLabel deception = new JLabel("Deception");
        deception.setSize(buttonSize);
        JTextField deceptionRating = new JTextField();
        JTextField deceptionSpecialties = new JTextField();
        //Endurance
        JLabel endurance = new JLabel("Endurance");
        endurance.setSize(buttonSize);
        JTextField enduranceRating = new JTextField();
        JTextField enduranceSpecialties = new JTextField();
        //Fighting
        JLabel fighting = new JLabel("Fighting");
        fighting.setSize(buttonSize);
        JTextField fightingRating = new JTextField();
        JTextField fightingSpecialties = new JTextField();
        //Healing
        JLabel healing = new JLabel("Healing");
        healing.setSize(buttonSize);
        JTextField healingRating = new JTextField();
        JTextField healingSpecialties = new JTextField();
        //Language
        JLabel language = new JLabel("Language");
        language.setSize(buttonSize);
        JTextField languageRating = new JTextField();
        JTextField languageSpecialties = new JTextField();
        //Knowledge
        JLabel knowledge = new JLabel("Knowledge");
        knowledge.setSize(buttonSize);
        JTextField knowledgeRating = new JTextField();
        JTextField knowledgeSpecialties = new JTextField();
        //Marksmanship
        JLabel marksmanship = new JLabel("Marksmanship");
        marksmanship.setSize(buttonSize);
        JTextField marksmanshipRating = new JTextField();
        JTextField marksmanshipSpecialties = new JTextField();
        //Persuasion
        JLabel persuasion = new JLabel("Persuasion");
        persuasion.setSize(buttonSize);
        JTextField persuasionRating = new JTextField();
        JTextField persuasionSpecialties = new JTextField();
        //Status
        JLabel status = new JLabel("Status");
        status.setSize(buttonSize);
        JTextField statusRating = new JTextField();
        JTextField statusSpecialties = new JTextField();
        //Stealth
        JLabel stealth = new JLabel("Stealth");
        stealth.setSize(buttonSize);
        JTextField stealthRating = new JTextField();
        JTextField stealthSpecialties = new JTextField();
        //Survival
        JLabel survival = new JLabel("Survival");
        survival.setSize(buttonSize);
        JTextField survivalRating = new JTextField();
        JTextField survivalSpecialties = new JTextField();
        //Thievery
        JLabel thievery = new JLabel("Thievery");
        thievery.setSize(buttonSize);
        JTextField thieveryRating = new JTextField();
        JTextField thieverySpecialties = new JTextField();
        //Warfare
        JLabel warfare = new JLabel("Warfare");
        warfare.setSize(buttonSize);
        JTextField warfareRating = new JTextField();
        JTextField warfareSpecialties = new JTextField();
        //Will
        JLabel will = new JLabel("Will");
        will.setSize(buttonSize);
        JTextField willRating = new JTextField();
        JTextField willSpecialties = new JTextField();


        c = getContentPane();

        c.add(back);
        c.add(charName);
        c.add(charAge);
        c.add(charGender);
        c.add(charHouse);
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
