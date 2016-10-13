/**
 * Created by arredon on 10/1/2016.
 */
public class Domain extends Holding{
    private Terrain terrain;
    private FeatureList features;
    private int cost; //sum of cost of terrain and features

    public Domain() {
        terrain = null;
        features = null;
    }

    public Domain(Terrain terrain) {
        this.terrain = terrain;
        features = null;
    }

    public Domain(Domain toCopy) {
        this.terrain = toCopy.terrain;
        if (toCopy.features != null)
            features = new FeatureList(toCopy.features);
        else
            features = null;
    }

    public int getCost() {
        if (terrain == null)
            return 0;
        else {
            cost = terrain.getCost();
            cost += features.getCost();
        }
        return cost;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public void addFeature(Feature feature) {
        if (features == null) {
            features = new FeatureList(feature);
        }
        else {
            features.insert(feature);
        }
    }

    public void display() {
        if (terrain == null)
            System.out.println("No Domain to display");
        else {
            System.out.print("Terrain: ");
            terrain.display();

            System.out.print("Features: ");
            if (features != null)
                features.display();
            else
                System.out.println("Barren");
            System.out.println("----------");
        }
    }

    public boolean containsFeature(Feature toCheck) {
        if (features == null)
            return false;
        else
            return features.contains(toCheck);
    }
}
