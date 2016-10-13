import java.util.Random;

/**
 * Created by arredon on 9/27/2016.
 */
public class Dice {
    private static Random rand = new Random();

    public int roll(int dice, int bonus) {
        if (bonus == 0)
            return roll(dice);
        if (dice < 0 || bonus < 0)
            return 0;
        List a = new List();
        for (int i = 0; i < dice+bonus; ++i) {
            a.sortAdd(rand.nextInt(6) + 1);
        }
        return a.result(dice);
    }

    public int roll(int dice) {
        if (dice < 0)
            return 0;
        int num = 0;
        for (int i = 0; i < dice; ++i) {
            num += rand.nextInt(6) + 1;
        }
        return num;
    }

    public int roll() {
        return rand.nextInt(6) + 1;
    }

    public void bonusDiceTest() {

        // format "win/lose/tie"

        //like twoVsThree, but 2D+1B vs 3D
        boolean topRow = true;
        int low = 2;
        int oneDice = low;
        int oneBonus = 0;
        int twoDice = low;
        int twoBonus = 0;
        String groupOne = "" + oneDice + "D+" + oneBonus + "B";
        String groupTwo = "" + twoDice + "D+" + twoBonus + "B";
        System.out.print("\t\t");

        //print top row
        for (twoDice = low; twoDice <= 7; ++twoDice) {
            //bonus dice two
            for (twoBonus = 0; twoBonus <= twoDice; ++twoBonus) {
                groupTwo = "" + twoDice + "D+" + twoBonus + "B";
                System.out.print(groupTwo+"\t");
            }
        }

        System.out.println();

        //print table
        //base dice one
        for (oneDice = low; oneDice <= 7; ++oneDice) {

            //bonus dice one
            for (oneBonus = 0; oneBonus <= oneDice; ++oneBonus) {
                groupOne = "" + oneDice + "D+" + oneBonus + "B";
                System.out.print(groupOne+"\t");

                //base dice two
                for (twoDice = low; twoDice <= 7; ++twoDice) {

                    //bonus dice two
                    for (twoBonus = 0; twoBonus <= twoDice; ++twoBonus) {

                        groupTwo = "" + twoDice + "D+" + twoBonus + "B";

                        int rollNum = 1000;

                        int one = 0;
                        int two = 0;

                        List dieOne = new List();
                        List dieTwo = new List();

                        List dieOneResult = new List();
                        List dieTwoResult = new List();

                        int oneWins = 0;
                        int twoWins = 0;
                        int ties = 0;

                        for (int i = 0; i < rollNum; ++i) {
                            for (int j = 0; j < oneDice + oneBonus; ++j)
                                dieOne.sortAdd(rand.nextInt(6) + 1);
                            for (int j = 0; j < twoDice + twoBonus; ++j)
                                dieTwo.sortAdd(rand.nextInt(6) + 1);

                            one = dieOne.result(oneDice);
                            two = dieTwo.result(twoDice);

                            dieOneResult.sortAdd(one);
                            dieTwoResult.sortAdd(two);
                            dieOne.empty();
                            dieTwo.empty();

                            if (one > two)
                                ++oneWins;
                            else if (two > one)
                                ++twoWins;
                            else
                                ++ties;
                        }

                        float onePercent = ((float) oneWins / rollNum) * 100;
                        float twoPercent = ((float) twoWins / rollNum) * 100;
                        float tiePercent = ((float) ties / rollNum) * 100;

                        //format to one decimal place
                        int format = (int) (onePercent * 10);
                        onePercent = ((float) format)/10;
                        format = (int) (twoPercent*10);
                        twoPercent = ((float) format/10);
                        format = (int) (tiePercent*10);
                        tiePercent = ((float) format/10);

                        //calculate experience and experience difference
                        int expOne = (oneDice-2)*30 + (oneBonus*10);
                        int expTwo = (twoDice-2)*30 + (twoBonus*10);

                        //display
                        System.out.print(onePercent+"/"+twoPercent+"/"+tiePercent
                                +"/"+expOne+"/"+expTwo+"\t");

                    }
                }
                System.out.println();
            }
        }
    }

}
