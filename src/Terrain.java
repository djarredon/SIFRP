/**
 * Created by arredon on 10/1/2016.
 */
public class Terrain extends Holding{
    private int type;
    private String name;

    public Terrain() {
        name = null;
    }

    public void setTerrain(int type) {
        this.type = type;
        setName(this.type);
    }

    public void display() {
        if (name != null)
            System.out.println(name);
        else
            System.out.println("No Terrain.");
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
