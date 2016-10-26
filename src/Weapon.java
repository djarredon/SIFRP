/**
 * Created by arredon on 10/11/2016.
 */
public class Weapon extends Item {
    //name, speciality, training, damage, qualities
    private String specialty;
    private String damageDesc;
    private int training;
    private int damage;
    private int[] qualities;
    private int abilityScore;    //the relevant abilityScore score of user
    private String ability;

    public Weapon() {
        super();
        specialty = null;
        qualities = null;
        damageDesc = null;
        ability = null;

        qualities = new int[25];
        for (int i = 0; i < 25; ++i)
            qualities[i] = 0;
    }

    public Weapon(String name) {
        super(name);
        specialty = null;
        qualities = null;
        damageDesc = null;
        ability =  null;

        qualities = new int[25];
        for (int i = 0; i < 25; ++i)
            qualities[i] = 0;
        setWeapon(name);
    }

    public Weapon(String name, int abilityScore) {
        super(name);
        this.abilityScore = abilityScore;
        specialty = null;
        qualities = null;
        damageDesc = null;
        ability = null;

        qualities = new int[25];
        for (int i = 0; i < 25; ++i)
            qualities[i] = 0;

        setWeapon(name);
    }

    public void setWeapon(String name, int abilityScore) {
        this.abilityScore = abilityScore;
        setWeapon(name);
    }

    public Weapon getWeapon(String name, int abilityScore) {
        if (name != null) {
            Weapon temp = new Weapon(name, abilityScore);
            return temp;
        }
        else
            return null;
    }

    public String getAbility() {
        return ability;
    }

    public String print() {
        setWeapon(getName());
        String toReturn = new String();

        toReturn = toReturn.concat(getName());
        toReturn = toReturn.concat("Specialty: " + specialty + "\n" +
                "Damage: (" + damageDesc + ") = " + damage + "\n");
        if (training != 0)
            toReturn = toReturn.concat("Training: " + training + "\n");
        if (qualities != null) {
            toReturn = toReturn.concat("Qualities:");
            if (qualities[0] != 0)
                toReturn = toReturn.concat(" Adaptable");
            if (qualities[1] != 0)
                toReturn = toReturn.concat(" Bulk " + qualities[1]);
            if (qualities[2] != 0)
                toReturn = toReturn.concat(" Close Range");
            if (qualities[3] != 0)
                toReturn = toReturn.concat(" Defensive " + qualities[3]);
            if (qualities[4] != 0)
                toReturn = toReturn.concat(" Entangling");
            if (qualities[5] != 0)
                toReturn = toReturn.concat(" Fast");
            if (qualities[6] != 0)
                toReturn = toReturn.concat(" Fragile");
            if (qualities[7] != 0)
                toReturn = toReturn.concat(" Grab");
            if (qualities[8] != 0)
                toReturn = toReturn.concat(" Impale");
            if (qualities[9] != 0)
                toReturn = toReturn.concat(" Pinning an Opponent");
            if (qualities[10] != 0)
                toReturn = toReturn.concat(" Getting Free");
            if (qualities[11] != 0)
                toReturn = toReturn.concat(" Long Range");
            if (qualities[12] != 0)
                toReturn = toReturn.concat(" Mounted");
            if (qualities[13] != 0)
                toReturn = toReturn.concat(" Off-hand " + qualities[13]);
            if (qualities[14] != 0)
                toReturn = toReturn.concat(" Piercing " + qualities[14]);
            if (qualities[15] != 0)
                toReturn = toReturn.concat(" Powerful");
            if (qualities[16] != 0)
                toReturn = toReturn.concat(" Reach " + qualities[16]);
            if (qualities[17] != 0 && qualities[17] == 1)
                toReturn = toReturn.concat(" Reload (Lesser)");
            if (qualities[17] != 0 && qualities[17] == 2)
                toReturn = toReturn.concat(" Reload {Greater)");
            if (qualities[18] != 0)
                toReturn = toReturn.concat(" Set for Charge Only");
            if (qualities[19] != 0)
                toReturn = toReturn.concat(" Shattering " + qualities[19]);
            if (qualities[20] != 0)
                toReturn = toReturn.concat(" Slow");
            if (qualities[21] != 0)
                toReturn = toReturn.concat(" Staggering");
            if (qualities[22] != 0)
                toReturn = toReturn.concat(" Two-handed");
            if (qualities[23] != 0)
                toReturn = toReturn.concat(" Unwieldy");
            if (qualities[24] != 0)
                toReturn = toReturn.concat(" Vicious");
        }

        return toReturn;
    }

    public void display() {
        setWeapon(getName());

        System.out.println(getName());
        System.out.println("Specialty: " + specialty + "\n" +
                "Damage: (" + damageDesc + ") = " +damage);
        if (training != 0)
            System.out.println("Training: " + training);
        if (qualities != null) {
            System.out.print("Qualities:");
            if (qualities[0] != 0)
                System.out.print(" Adaptable");
            if (qualities[1] != 0)
                System.out.print(" Bulk " + qualities[1]);
            if (qualities[2] != 0)
                System.out.print(" Close Range");
            if (qualities[3] != 0)
                System.out.print(" Defensive " + qualities[3]);
            if (qualities[4] != 0)
                System.out.print(" Entangling");
            if (qualities[5] != 0)
                System.out.print(" Fast");
            if (qualities[6] != 0)
                System.out.print(" Fragile");
            if (qualities[7] != 0)
                System.out.print(" Grab");
            if (qualities[8] != 0)
                System.out.print(" Impale");
            if (qualities[9] != 0)
                System.out.print(" Pinning an Opponent");
            if (qualities[10] != 0)
                System.out.print(" Getting Free");
            if (qualities[11] != 0)
                System.out.print(" Long Range");
            if (qualities[12] != 0)
                System.out.print(" Mounted");
            if (qualities[13] != 0)
                System.out.print(" Off-hand " + qualities[13]);
            if (qualities[14] != 0)
                System.out.print(" Piercing " + qualities[14]);
            if (qualities[15] != 0)
                System.out.print(" Powerful");
            if (qualities[16] != 0)
                System.out.print(" Reach " + qualities[16]);
            if (qualities[17] != 0 && qualities[17] == 1)
                System.out.print(" Reload (Lesser)");
            if (qualities[17] != 0 && qualities[17] == 2)
                System.out.print(" Reload {Greater)");
            if (qualities[18] != 0)
                System.out.print(" Set for Charge Only");
            if (qualities[19] != 0)
                System.out.print(" Shattering " + qualities[19]);
            if (qualities[20] != 0)
                System.out.print(" Slow");
            if (qualities[21] != 0)
                System.out.print(" Staggering");
            if (qualities[22] != 0)
                System.out.print(" Two-handed");
            if (qualities[23] != 0)
                System.out.print(" Unwieldy");
            if (qualities[24] != 0)
                System.out.print(" Vicious");
        }
    }

    public void setWeapon(String name) {
        //test name against all weapons in book,
        //set other stats (including weight and price)
        if (name != null) {
            switch (name) {
                case "Battleaxe":
                    specialty = "Axes";
                    training = 0;
                    damage = abilityScore;
                    ability = "Athletics";
                    damageDesc = "Athletics";
                    qualities[0] = 1;  //Adaptable
                    break;
                case "Ball and Chain":
                    specialty = "Bludgeon";
                    training = 1;
                    damage = abilityScore;
                    ability = "Athletics";
                    damageDesc = "Athletics";
                    qualities[15] = 1; //Powerful
                    qualities[19] = 1; //Shattering 1
                    break;
                case "Fist":
                    specialty = "Brawling";
                    training = 0;
                    damage = abilityScore - 3;
                    ability = "Athletics";
                    damageDesc = "Athletics - 3";
                    qualities[7] = 1; //grab
                    qualities[13] = 1; //off-hand
                    break;
                case "Braavosi Blade":
                    specialty = "Fencing";
                    training = 1;
                    damage = abilityScore;
                    ability = "Agility";
                    damageDesc = "Agility";
                    qualities[3] = 1; //Defensive + 1
                    qualities[5] = 1; //Fast
                    break;
                case "Arakh":
                    specialty = "Long Blade";
                    training = 1;
                    damage = abilityScore;
                    ability = "Athletics";
                    damageDesc = "Athletics";
                    qualities[0] = 1; //Adaptable
                    qualities[5] = 1;  //Fast
                    break;
                case "Halberd":
                    specialty = "Pole-arm";
                    training = 1;
                    damage = abilityScore + 3;
                    ability = "Athletics";
                    damageDesc = "Athletics + 3";
                    qualities[1] = 1; //Bulk 1
                    qualities[15] = 1; //Powerful
                    qualities[22] = 1; //Two-handed
                    break;
                case "Buckler":
                    specialty = "Shield";
                    training = 0;
                    damage = abilityScore -2;
                    ability = "Athletics";
                    damageDesc = "Athletics - 2";
                    qualities[3] = 1; //Defensive 1
                    qualities[13] = 1; //Off-hand 1
                    break;
                case "Dagger":
                    specialty = "Short Blade";
                    training = 0;
                    damage = abilityScore - 2;
                    ability = "Agility";
                    damageDesc = "Agility - 2";
                    qualities[3] = 1; //Defensive 1
                    qualities[13] = 1; //Off-hand 1
                    break;
                case "Boar Spear":
                    specialty = "Spear";
                    training = 1;
                    damage = abilityScore + 1;
                    ability = "Athletics";
                    damageDesc = "Athletics + 1";
                    qualities[8] = 1; //Impale
                    qualities[15] = 1; //Powerful
                    qualities[20] = 1; //Slow
                    qualities[22] = 1; //Two-handed
                    break;
                case "Bow, Double-curved":
                    specialty = "Bow";
                    training = 1;
                    damage = abilityScore + 1;
                    ability = "Agility";
                    damageDesc = "Agility + 1";
                    qualities[11] = 1; //Long Range
                    qualities[15] = 1; //Powerful
                    qualities[22] = 1; //Two-handed
                    break;
                case "Crossbow, Heavy":
                    specialty = "Crossbow";
                    training = 0;
                    damage = abilityScore + 2;
                    ability = "Agility";
                    damageDesc = "Agility + 2";
                    qualities[11] = 1; //Long Range
                    qualities[14] = 2; //Piercing 2
                    qualities[17] = 2; //Reload (Greater)
                    qualities[20] = 1; //Slow
                    qualities[22] = 1; //Two-handed
                    break;
                case "Frog Spear":
                    specialty = "Thrown";
                    training = 1;
                    damage = abilityScore + 1;
                    ability = "Agility";
                    damageDesc = "Agility + 1";
                    qualities[3] = 1; //Close Range
                    break;
                default:
                    System.out.println("+++++SetWeapon FAILURE+++++");
            }
        }
    }
}
