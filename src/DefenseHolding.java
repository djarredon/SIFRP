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
    }

    public DefenseHolding(int type) {
        super();
        name = null;
        description = null;
        benefit = null;
        this.type = type;
        setType(this.type);
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
                setCost(50);
                break;
            case 2: name = "Castle";
                setCost(40);
                break;
            case 3: name = "Small Castle";
                setCost(30);
                break;
            case 4: name = "Hall";
                setCost(20);
                break;
            case 5: name = "Tower";
                setCost(10);
                break;
            default:
                System.out.println("DEFENSE HOLDING NAME ERROR");
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
