/**
 * Created by arredon on 3/7/2016.
 */
import java.io.*;
import java.util.Random;

public class Main {
    public static Random rand = new Random();

    public static void main(String [] args) {
        System.out.println("\n\n");
        Dice die = new Dice();
        Data data = new Data();

        House test = new House();
        test.setName("Daniel");
        test.generateRandHouse();
        test.generateHoldings();
        //test.buyBanner();
        test.displayAll();


        /*
        for (int i = 1; i <= 10; ++i)
            System.out.println("Rolling " + i + " dice: " + die.roll(i));
        System.out.println("\n");
        for (int i = 1; i <= 10; ++i)
            for (int j = 0; j <= i; ++j)
                System.out.println("Rolling "+i+" dice " +
                        "plus "+j+" bonus dice: " + die.roll(i,j));
         */
    }

}

