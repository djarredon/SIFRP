import java.util.Random;

/**
 * Created by arredon on 10/1/2016.
 */
public class Feature extends Holding {
    private int featureType;
    private String description;
    private Random rand;

    public Feature() {
        super();
        description = null;
        rand = null;
    }

    public Feature(int featureType) {
        this.featureType = featureType;
        description = null;
        rand = null;
    }

    public Feature(Feature feature) {
        rand = null;
        copyFeature(feature);
    }

    public boolean equals(Feature toCompare) {
        if (featureType == toCompare.featureType) {
            if (description != null && toCompare.description != null)
            if (toCompare.description.equalsIgnoreCase(description)) {
                return true;
            }
        }
        return false;
    }

    public void copyFeature(Feature feature) {
        featureType = feature.featureType;
        description = feature.description;
    }

    public void randomFeature() {
        rand = new Random();
        setFeatureType(rand.nextInt(16) + 1);
    }

    public void randomFeature(String realm) {
        rand = new Random();
        int num = rand.nextInt(16) + 1;
        switch (realm) {
            case "Dorne": //1-6, 8,9-14
                while (num == 7 || num > 14)
                    num = rand.nextInt(16) + 1;
                break;
            case "Dragonstone": //1-10;
                while (num > 10)
                    num = rand.nextInt(16) + 1;
                break;
            case "The Iron Islands": //1-10
                while (num > 10)
                    num = rand.nextInt(16) + 1;
                break;
            case "King's Landing": //1-7, 9-16
                while (num == 8)
                    num = rand.nextInt(16) + 1;
                break;
            case "The Mountains of the Moon": //1-14
                while (num > 14)
                    num = rand.nextInt(16) + 1;
                break;
            case "The North": //1-16 (all)
                break;
            case "The Reach": //1-14
                while (num > 14)
                    num = rand.nextInt(16) + 1;
                break;
            case "The Riverlands": //2-7, 9-14
                while (num < 2 || num == 8 || num > 14)
                    num = rand.nextInt(16) + 1;
                break;
            case "The Stormlands": //1-16 (all)
                break;
            case "The Westerlands": //1-14
                while (num > 14)
                    num = rand.nextInt(16) + 1;
                break;
            default:
                System.out.println("FEATURE REALM ERROR");
        }
        setFeatureType(num);
    }

    public void setFeatureType(int featureType) {
        this.featureType = featureType;
        setFeature(this.featureType);
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
            default:
                System.out.println("FEATURE ERROR.");
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
