/**
 * Created by arredon on 10/11/2016.
 */
public class Item {
    private String name;
    private float weight;
    private float cost;

    public Item() {
        name = null;
        weight = 0;
        cost = 0;
    }

    public Item(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getWeight() {
        return weight;
    }

    public float getCost() {
        return cost;
    }
}
