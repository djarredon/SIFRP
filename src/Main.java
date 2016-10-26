/**
 * Created by arredon on 3/7/2016.
 */
import com.sun.corba.se.impl.orbutil.graph.Graph;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main extends JPanel {
    public static Random rand = new Random();

    public static void main(String [] args) {
        System.out.println("\n\n");
        Dice die = new Dice();
        Data data = new Data();

        JFrame f = new JFrame();
        f.getContentPane().add(new Main());
        f.setSize(650,550);
        f.setVisible(true);

        //WeaponTest();
        //CharacterTest();
        //HouseTest();
        //HouseListTest();
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setFont(new Font("Serif", Font.PLAIN, 12));
        //g2.drawString("Hello, World!", 50, 50);

        printHouse(g);
    }

    public void printHouse(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        HouseNode temp;
        HouseList list = new HouseList();
        for (int i = 0; i < 10; ++i) {
            temp = new HouseNode();
            temp.generateRandHouse();
            list.insert(temp);
        }

        //g2.drawString(list.printList(), 30, 30);
        drawString(g2, list.printList(), 30, 30);
    }

    //print text blocks on multiple lines
    public void drawString(Graphics g, String text, int x, int y) {
        for (String line: text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }

    public static void CharacterTest() {
        Character test = new Character();
        test.generateCharacter();
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

