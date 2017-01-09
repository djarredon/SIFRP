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

    public Feature (String name) {
        if (!setFeature(name)) {
            featureType = 0;
            description = null;
        }
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

    public String getName() {
        return description;
    }

    public boolean setFeatureType(int featureType) {
        if (setFeature(this.featureType)) {
            this.featureType = featureType;
            return true;
        }
        return false;
    }

    public boolean setFeature(String name) {
        switch (name) {
            case "Coast":
                return setFeature(1);
            case "Community: Hamlet":
                return setFeature(2);
            case "Community: Small Town":
                return setFeature(3);
            case "Community: Large Town":
                return setFeature(4);
            case "Community: Small City":
                return setFeature(5);
            case "Community: Large City":
                return setFeature(6);
            case "Grassland":
                return setFeature(7);
            case "Island":
                return setFeature(8);
            case "Road":
                return setFeature(9);
            case "Ruin":
                return setFeature(10);
            case "Water: Stream":
                return setFeature(11);
            case "Water: River":
                return setFeature(12);
            case "Water: Pond":
                return setFeature(13);
            case "Water: Lake":
                return setFeature(14);
            case "Woods: Light":
                return setFeature(15);
            case "Woods: Dense":
                return setFeature(16);
        }
        return false;
    }

    private boolean setFeature(int featureType) {
        description = new String();
        switch (featureType) {
            case 1: description = "Coast";
                setCost(3);
                return true;
            case 2: description = "Community: Hamlet";
                setCost(10);
                return true;
            case 3: description = "Community: Small Town";
                setCost(20);
                return true;
            case 4: description = "Community: Large Town";
                setCost(30);
                return true;
            case 5: description = "Community: Small City";
                setCost(40);
                return true;
            case 6: description = "Community: Large City";
                setCost(50);
                return true;
            case 7: description = "Grassland";
                setCost(1);
                return true;
            case 8: description = "Island";
                setCost(10);
                return true;
            case 9: description = "Road";
                setCost(5);
                return true;
            case 10: description = "Ruin";
                setCost(3);
                return true;
            case 11: description = "Water: Stream";
                setCost(1);
                return true;
            case 12: description = "Water: River";
                setCost(3);
                return true;
            case 13: description = "Water: Pond";
                setCost(5);
                return true;
            case 14: description = "Water: Lake";
                setCost(7);
                return true;
            case 15: description = "Woods: Light";
                setCost(3);
                return true;
            case 16: description = "Woods: Dense";
                setCost(5);
                return true;
            default:
                System.out.println("FEATURE ERROR.");
                return false;
        }
    }

    public int getFeatureType() {
        return featureType;
    }

    public String getFeature() {
        return description;
    }

    public String print() {
        return description + "\n";
    }

    public void display() {
        if (description != null)
            System.out.println(description);
    }

}
