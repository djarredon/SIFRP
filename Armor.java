import java.util.Random;

/**
 * Created by arredon on 10/11/2016.
 */
public class Armor extends Item {
    private int armorRating;
    private int armorPenalty;
    private int bulk;

    public Armor() {
        super();
        armorPenalty = 0;
        armorRating = 0;
        bulk = 0;
    }

    public Armor(String name) {
        super(name);
        setArmor(name);
    }

    public void setArmor(String name) {
        if (name != null) {
            setName(name);
            switch (name) {
                case "Clothes":
                    armorRating = 0;
                    armorPenalty = 0;
                    bulk = 0;
                    break;
                case "Vestments":
                case "Robes":
                    armorRating = 1;
                    armorPenalty = 0;
                    bulk = 1;
                    break;
                case "Padded":
                    armorRating = 1;
                    armorPenalty = 0;
                    bulk = 0;
                    break;
                case "Leather, Soft":
                    armorRating = 2;
                    armorPenalty = -1;
                    bulk = 0;
                    break;
                case "Leather, Hard":
                    armorRating = 3;
                    armorPenalty = -2;
                    bulk = 0;
                    break;
                case "Bone":
                case "Wood":
                    armorRating = 4;
                    armorPenalty = -3;
                    bulk = 1;
                    break;
                case "Ring":
                    armorRating = 4;
                    armorPenalty = -2;
                    bulk = 1;
                    break;
                case "Hide":
                    armorRating = 5;
                    armorPenalty = -3;
                    bulk = 3;
                    break;
                case "Mail":
                    armorRating = 5;
                    armorPenalty = -3;
                    bulk = 2;
                    break;
                case "Breastplate":
                    armorRating = 5;
                    armorPenalty = -2;
                    bulk = 3;
                    break;
                case "Scale":
                    armorRating = 6;
                    armorPenalty = -3;
                    bulk = 2;
                    break;
                case "Splint":
                    armorRating = 7;
                    armorPenalty = -3;
                    bulk = 3;
                    break;
                case "Brigandine":
                    armorRating = 8;
                    armorPenalty = -4;
                    bulk = 3;
                    break;
                case "Half Plate":
                    armorRating = 9;
                    armorPenalty = -5;
                    bulk = 3;
                    break;
                case "Full Plate":
                    armorRating = 10;
                    armorPenalty = -6;
                    bulk = 3;
                    break;
                default:
                    System.out.println("+++++SETARMOR ERROR+++++");
            }
        }
    }

    public void display() {
        System.out.println(getName() + "\n" +
                "Rating: " + armorRating + "\n" +
                "Penalty: " + armorPenalty + "\n" +
                "Bulk: " + bulk);
    }

    public void randArmor() {
        Random rand = new Random();
        int num = rand.nextInt(16) + 1;
        switch (num) {
            case 1: setArmor("Clothing");
                break;
            case 17: setArmor("Vestments");
                break;
            case 2: setArmor("Robes");
                break;
            case 3: setArmor("Padded");
                break;
            case 4: setArmor("Leather, Soft");
                break;
            case 5: setArmor("Leather, Hard");
                break;
            case 6: setArmor("Bone");
                break;
            case 7: setArmor("Wood");
                break;
            case 8: setArmor("Ring");
                break;
            case 9: setArmor("Hide");
                break;
            case 10: setArmor("Mail");
                break;
            case 11: setArmor("Breastplate");
                break;
            case 12: setArmor("Scale");
                break;
            case 13: setArmor("Splint");
                break;
            case 14: setArmor("Brigandine");
                break;
            case 15: setArmor("Half Plate");
                break;
            case 16: setArmor("Full Plate");
                break;
            default:
                System.out.println("+++++ RANDOM ARMOR ERROR+++++");
        }
    }

    public int getArmorPenalty() {
        return armorPenalty;
    }

    public int getArmorRating() {
        return armorRating;
    }

    public int getBulk() {
        return bulk;
    }
}











