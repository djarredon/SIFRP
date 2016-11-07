import java.util.Random;

/**
 * Created by arredon on 10/1/2016.
 */
public class Terrain extends Holding{
    private int type;
    private String name;
    private Random rand;

    public Terrain() {
        name = null;
        rand = null;
    }

    public void setTerrain(int type) {
        this.type = type;
        rand = null;
        setName(this.type);
    }

    public String print() {
        if (name == null)
            return "No Terrain.\n";
        return name;
    }

    public String getName() {
        return name;
    }

    public void display() {
        if (name != null)
            System.out.println(name);
        else
            System.out.println("No Terrain.");
    }

    public void randomTerrain(String realm) {
        rand = new Random();
        int num = rand.nextInt(4) + 1;
        switch (realm) {
            case "Dorne": //1-3
                while ( num > 3)
                    num = rand.nextInt(3) + 1;
                break;
            case "Dragonstone": //1,3,4
                while (num == 2)
                    num = rand.nextInt(4) + 1;
                break;
            case "The Iron Islands": //1,3
                while (num == 2 || num == 4)
                    num = rand.nextInt(4) + 1;
                break;
            case "King's Landing": //3
                num = 3;
                break;
            case "The Mountains of the Moon": //1,2
                while (num > 2)
                    num = rand.nextInt(4) + 1;
                break;
            case "The North": //1-4(all)
                break;
            case "The Reach": //3
                num = 3;
                break;
            case "The Riverlands": //1,3,4
                while (num == 2)
                    num = rand.nextInt(4) + 1;
                break;
            case "The Stormlands": //1-4 (all)
                break;
            case "The Westerlands": //1-3
                while (num > 3)
                    num = rand.nextInt(4) + 1;
                break;
            default:
                System.out.println("TERRAIN REALM ERROR");
        }
        setName(num);
    }

    public void setName(int type) {
        switch (type) {
            case 1: name = "Hills";
                setCost(7);
                break;
            case 2: name = "Mountains";
                setCost(9);
                break;
            case 3: name = "Plains";
                setCost(5);
                break;
            case 4: name = "Wetlands";
                setCost(3);
                break;
            default:
                System.out.println("Invalid Terrain Type");
        }
    }
}
