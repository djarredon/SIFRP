/**
 * Created by arredon on 10/7/2016.
 */
public class DefenseHolding extends Holding {
    private String name;
    private String description;
    private String benefit;
    private int type;

    public DefenseHolding() {
        super();
        name = null;
        description = null;
        benefit = null;
        type = 0;
    }

    public DefenseHolding(DefenseHolding toCopy) {
        this.name = toCopy.name;
        this.description = toCopy.description;
        this.benefit = toCopy.benefit;
        this.type = toCopy.type;
        setCost(toCopy.getCost());
    }

    public DefenseHolding(String toBe) {
        super();
        setHolding(toBe);
    }

    public DefenseHolding(int type) {
        super();
        name = null;
        description = null;
        benefit = null;
        this.type = type;
        setType(this.type);
    }

    public void setHolding(String string) {
        switch (string) {
            case "Superior Castle":
                setName(1);
                break;
            case "Castle":
                setName(2);
                break;
            case "Small Castle":
                setName(3);
                break;
            case "Hall":
                setName(4);
                break;
            case "Tower":
                setName(5);
                break;
            default:
                setName(5);
                break;
        }
    }

    public String print() {
        return "Type: " + name + "\n" +
                "Benefits: " + benefit + "\n" +
                "----------\n";
    }

    public void display() {
        System.out.println("Type: " + name);
        //System.out.println("Description: " + description);
        System.out.println("Benefits: " + benefit);
        System.out.println("----------");
    }

    public String getBenefit() {
        return benefit;
    }

    public String getName() {
        return name;
    }

    private void setName(int type) {
        switch (type) {
            case 1: name =  "Superior Castle";
                description = "A superior castle is a massive stronghold in the vein of Harrenhal, the" +
                        "Eyrie, Storm’s End, Dragonstone, and Winterfell. A superior castle has" +
                        "several towers, structures, and smaller buildings, all surrounded by a" +
                        "steep curtain wall and likely a moat as well.";
                benefit = "Units defending a superior castle gain a +12 bonus to their" +
                        "Defense.";
                setCost(50);
                break;
            case 2: name = "Castle";
                description = "Castles are impressive fortified strongholds but are not as large or as" +
                        "imposing as a superior castle. Most castles incorporate at least one" +
                        "central keep and several towers connected by walls and surrounded" +
                        "by a moat. Example castles include Deepwood Motte, the Twins, and" +
                        "Riverrun.";
                benefit = "Units defending a castle gain a +8 bonus to their Defense.";
                setCost(40);
                break;
            case 3: name = "Small Castle";
                description = "A small castle is simply a smaller version of a standard castle. It usually" +
                        "has no more than a single keep, perhaps two towers and a wall. Examples" +
                        "of small castles include Bronzegate, Honeyholt, and Yronwood.";
                benefit = "Units defending a small castle gain a +6 bonus to their" +
                        "Defense.";
                setCost(30);
                break;
            case 4: name = "Hall";
                description = "A hall (or keep) is usually a small, fortified building. It may or may not" +
                        "be surrounded by a wall, and it could have a tower, though it’s unlikely." +
                        "Examples of halls include Acorn Hall, Cider Hall, and Longbow Hall.";
                benefit = "Units defending a hall gain a +4 bonus to their Defense.";
                setCost(20);
                break;
            case 5: name = "Tower";
                description = "Towers are single free-standing stone or timber structures that thrust" +
                        "up from the ground. If they have any outbuildings, they are small and" +
                        "unprotected. Petyr Baelish’s holdings in the Fingers included a single" +
                        "tower.";
                benefit = "Units defending a tower gain a +3 bonus to their Defense.";
                setCost(10);
                break;
            default:
                setName(5);
                break;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setType(int type) {
        this.type = type;
        Data data = new Data();
        description = data.getDefenseHoldingDescription(type);
        benefit = data.getDefenseHoldingBenefit(type);
        setName(type);
    }
}
