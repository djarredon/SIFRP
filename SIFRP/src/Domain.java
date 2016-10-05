/**
 * Created by arredon on 10/1/2016.
 */
public class Domain extends Holding{
    private Terrain terrain;
    private FeatureList features;

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
        features = new FeatureList(toCopy.features);
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public void addFeature(Feature feature) {
        if (feature == null) {
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
            terrain.display();

            if (features != null)
                features.display();
        }
    }
}
