/**
 * Created by arredon on 10/1/2016.
 */
public class Feature extends Holding {
    private  int featureType;
    private String description;

    public Feature() {
        super();
        description = null;
    }

    public Feature(int featureType) {
        this.featureType = featureType;
        description = null;
    }

    public Feature(Feature feature) {
        copyFeature(feature);
    }

    public void copyFeature(Feature feature) {
        featureType = feature.featureType;
        description = feature.description;
    }

    public void setFeatureType(int featureType) {
        this.featureType = featureType;
    }

    public void setFeature(String feature) {
        this.description = feature;
    }

    public int getFeatureType() {
        return featureType;
    }

    public String getFeature() {
        return description;
    }

    public void display() {
        if (description != null)
            System.out.println(description);
    }

}
