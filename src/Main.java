/**
 * Created by arredon on 3/7/2016.
 */
import java.util.Random;

public class Main {
    public static Random rand = new Random();

    public static void main(String [] args) {
        System.out.println("\n\n");
        Dice die = new Dice();
        Data data = new Data();

        //CharacterTest();
        HouseTest();
        //HouseListTest();
    }

    public static void CharacterTest() {
        Character test = new Character();
        test.generateCharacter();
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

