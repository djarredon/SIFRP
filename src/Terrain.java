/**
 * Created by arredon on 10/1/2016.
 */
public class Terrain {
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
                break;
            case 2: name = "Mountains";
                break;
            case 3: name = "Plains";
                break;
            case 4: name = "Wetlands";
                break;
            default:
                System.out.println("Invalid Terrain Type");
        }
    }
}
