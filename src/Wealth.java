import java.util.Random;

/**
 * Created by arredon on 11/5/2016.
 */
public class Wealth extends Holding {
    private String name;
    private String definition;
    private String requirements;
    private String time;
    private String description;

    public Wealth() {
        super();
        name = null;
        definition = null;
        requirements = null;
        time = null;
        description = null;
    }

    public Wealth(String name) {
        setHolding(name);
    }

    public Wealth(Wealth toCopy) {
        copy(toCopy);
    }

    public void copy(Wealth toCopy) {
        this.name = toCopy.name;
        this.definition = toCopy.definition;
        this.requirements = toCopy.requirements;
        setCost(toCopy.getCost());
        this.time = toCopy.time;
        this.description = toCopy.description;
    }

    public String getName() {
        return name;
    }

    public String print() {
        return name + "\n" +
                definition + "\n" +
                description + "\n" +
                "----------";
    }

    public void randHolding() {
        Random rand = new Random();
        int num = rand.nextInt(8) + 1;
        switch (num) {
            case 1: setHolding("Artisan");
                break;
            case 2: setHolding("GodsWood");
                break;
            case 3: setHolding("Guilds");
                break;
            case 4: setHolding("Maester");
                break;
            case 5: setHolding("Marketplace");
                break;
            case 6: setHolding("Mine");
                break;
            case 7: setHolding("Port");
                break;
            case 8: setHolding("Sept");
                break;
            default: setHolding("Guilds");
                break;
        }
    }

    public void setHolding(String name) {
        switch (name) {
            case "Artisan":
                this.name = name;
                definition = "Your house acquires the service of a master artisan.";
                requirements = "Hall or Larger Defensive Structure.";
                setCost(10);
                time = "2D6 Months";
                description = "Choose one of the following benefits each time you invest in this holding:\n" +
                        "\t*All weapons forged in your house count as castle-forged.\n" +
                        "\t*Cover benefits from fortifications increase the Defense by +1.\n" +
                        "\t*Add +1 to the results of your House Fortunes rolls.\n" +
                        "\t*Other benefits may be available at the Narrator’s discretion.";
                break;
            case "GodsWood":
                this.name = name;
                definition = "Your home has a GodsWood, a place sacred to the Old Gods.";
                requirements = "Realm (The North)";
                setCost(5);
                time = "24 + 2D6 Months";
                description = "Having a GodsWood allows you to add 2D6-6 to the result when rolling House Fortunes.";
                break;
            case "Guilds":
                this.name = name;
                definition = "A Guild controls manufacturing and pricing of commodities.";
                requirements = "Small Town or Larger Community";
                setCost(15);
                time = "2D6 Months";
                description = "All members of the household gain a 10% discount on any goods \npurchased in their own lands.";
                break;
            case "Maester":
                this.name = name;
                definition = "All houses can benefit from the wisdom and learning of a maester.";
                requirements = "Influence 20+";
                setCost(10);
                time = "1d6 Months";
                description = "Gain a +3 bonus on House Fortunes rolls. In addition, your family acquires\n" +
                        "the service of a maester. This character can be a player character\n" +
                        "or a Narrator character.";
                break;
            case "Marketplace":
                this.name = name;
                definition = "A Marketplace facilitates trade and draws merchants from abroad.";
                requirements = "Small town or larger community";
                setCost(10);
                time = "1d6 Months";
                description = "Each month, whenever your House Fortune would increase your\n" +
                        "Wealth resource, the Marketplace increases it further by +1.";
                break;
            case "Mine":
                this.name = name;
                definition = "You open mines on your lands to generate additional income.";
                requirements = "Mountains or hills";
                setCost(10);
                time = "24+2d6 Months";
                description = "Owning a mine grants a +5 bonus on House Fortunes rolls";
                break;
            case "Port":
                this.name = name;
                definition = "A port enables merchant ships to come to your lands.";
                requirements = "Coastline";
                setCost(10);
                time = "3d6 Months";
                description = "Gain a +5 bonus on House Fortunes rolls. Also, if you have a Marketplace,\n" +
                        "whenever a House Fortune indicates you should increase your\n" +
                        "Wealth, add +1d6 instead of just +1.";
                break;
            case "Sept":
                this.name = name;
                definition = "You erect a sept of the Faith to show your family’s piety.";
                requirements = "Hall or larger defensive structure or small\n" +
                        "town or larger community";
                setCost(15);
                time = "12+2d6 Months";
                description = "Gain a +3 bonus on House Fortunes rolls. In addition, your family acquires\n" +
                        "the service of a septon or septa. This character can be a player\n" +
                        "character or a Narrator character.";
                break;
            default:
                this.name = "Guilds";
                definition = "A Guild controls manufacturing and pricing of commodities.";
                requirements = "Small Town or Larger Community";
                setCost(15);
                time = "2D6 Months";
                description = "All members of the household gain a 10% discount on any goods \npurchased in their own lands.";
                break;
        }
    }
}
