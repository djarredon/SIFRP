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

    public void setFeature(int featureType) {
        description = new String();
        switch (featureType) {
            case 1: description = "Coast";
                setCost(3);
                break;
            case 2: description = "Community: Hamlet";
                setCost(10);
                break;
            case 3: description = "Community: Small Town";
                setCost(20);
                break;
            case 4: description = "Community: Large Town";
                setCost(30);
                break;
            case 5: description = "Community: Small City";
                setCost(40);
                break;
            case 6: description = "Community: Large City";
                setCost(50);
                break;
            case 7: description = "Grassland";
                setCost(1);
                break;
            case 8: description = "Island";
                setCost(10);
                break;
            case 9: description = "Road";
                setCost(5);
                break;
            case 10: description = "Ruin";
                setCost(3);
                break;
            case 11: description = "Water: Stream";
                setCost(1);
                break;
            case 12: description = "Water: River";
                setCost(3);
                break;
            case 13: description = "Water: Pond";
                setCost(5);
                break;
            case 14: description = "Water: Lake";
                setCost(7);
                break;
            case 15: description = "Woods: Light";
                setCost(3);
                break;
            case 16: description = "Woods: Dense";
                setCost(5);
                break;
        }
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
