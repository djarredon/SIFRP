/**
 * Created by arredon on 11/18/2016.
 */

public class BenefitList {
    private Benefit head;

    public BenefitList() {
        head = null;
    }

    public void insert(Benefit toInsert) {
        if (head == null)
            head = toInsert;
        else {
            toInsert.setNext(head);
            head = toInsert;
        }
    }

    public boolean contains(String toCheck) {
        if (find(toCheck) == null)
            return false;
        return true;
    }

    public Benefit find(String toFind) {
        if (head == null)
            return null;
        return find(toFind, head);
    }

    private Benefit find(String toFind, Benefit current) {
        if (current == null)
            return null;
        if (current.getName().equalsIgnoreCase(toFind))
            return current;
        return find(toFind,current.getNext());
    }

}

abstract class Benefit {
    private String name;
    private String requirement;
    private String shortDescription;
    private String longDescription;

    private Benefit next;

    Benefit(String name, String requirement, String shortDescription, String longDescription) {
        this.name = name;
        this.requirement = requirement;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        next = null;
    };

    public void setNext(Benefit next) {
        this.next = next;
    }

    public Benefit getNext() {
        return next;
    }

    public String getName() {
        return name;
    }

    public String getRequirement() {
        return requirement;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String toString() {
        return name + ": " + "\nRequirement: " + requirement + "\n" + shortDescription;
    }
}
/*
class name extends Benefit {
    name() {
        super("name",
                "req",
                "short",
                "long");
    }
}

*/

class LeaderOfMen extends Benefit {
    LeaderOfMen() {
        super("Leader Of Men",
                "Requires Warfare 4 (Command 1B)",
                "The men you lead would give their lives for you",
                "Once per round of a skirmish or battle, you may automatically reorganize\n" +
                        "one disorganized unit or rally one routed unit. Using this quality\n" +
                        "does not count as an order.");
    }
}

class Landed extends Benefit {
    Landed() {
        super("Landed",
                "Requires Sponsor",
                "You have earned the favor of your lord, and in exchange, you have\n" +
                        "been granted lands and title.",
                "The individual to whom your sword is sworn recognizes your constant\n" +
                        "and loyal service and grants you a parcel of land on which to build a home\n" +
                        "and rule as you see fit. As a landed knight, you are in the debt to your\n" +
                        "lord and must answer to his call to arms and attend him whenever he has\n" +
                        "need. You may spend Experience to increase your Status. See Chapter 6:\n" +
                        "House & Lands for guidelines on founding a house and managing lands.");
    }
}

class KnowledgeFocus extends Benefit {
    KnowledgeFocus() {
        super("Knowledge Focus",
                "Requires Knowledge 4",
                "You are an expert on a particular subject.",
                "Select one of the following areas of expertise—alchemy, architecture,\n" +
                        "astronomy, geography, heraldry, history and legends, magic, nature, religion,\n" +
                        "or underworld. When testing Knowledge in the chosen area(s),\n" +
                        "convert your Education bonus dice into test dice.\n" +
                        "You may select this quality multiple times. Each time, select a new\n" +
                        "area of expertise.");
    }
}

class KeenSenses extends Benefit {
    KeenSenses() {
        super("Keen Senses",
                "Requires Awareness 4",
                "You have highly developed senses.",
                "Whenever you roll an Awareness test to notice something, you may\n" +
                        "re-roll a number of 1s equal to your Notice rank (minimum 1). In addition,\n" +
                        "you may add your Cunning rank to your passive Awareness result.\n" +
                        "Thus, your passive Awareness result is equal to your Cunning rank +\n" +
                        "(Awareness × 4).");
    }
}

class Inspiring extends Benefit {
    Inspiring() {
        super("Inspiring",
                "Requires Warfare 4",
                "You have a way about you that makes men want to fight\n" +
                        "for you and follow you, even into the Seven Hells.",
                "In warfare, you gain 1 additional command each round. In addition,\n" +
                        "when testing Warfare to issue a command, you may sacrifice a command\n" +
                        "to re-roll the test and take the better result.");
    }
}

class ImprovedWeaponMastery extends Benefit {
    ImprovedWeaponMastery() {
        super("Improved Weapon Mastery",
                "Requires Weapon Mastery",
                "You are skilled with a particular weapon.",
                "When you take this benefit, choose a single weapon for which you have\n" +
                        "selected Weapon Mastery. When rolling Fighting or Marksmanship\n" +
                        "test with this weapon, you increase the weapon’s damage by +1.\n" +
                        "You may select this quality multiple times. Each time, its effects apply\n" +
                        "to a different weapon.");
    }
}

class ImprovedArmorMastery extends Benefit {
    ImprovedArmorMastery() {
        super("Improved Armor Mastery",
                "Requires Armor Mastery",
                "Your prowess lets you maximize the effects of armor in combat.",
                "When wearing any type of armor, increase its Armor Rating by 1. This\n" +
                        "benefit is cumulative with Armor Mastery.");
    }
}

class Heirloom extends Benefit {
    Heirloom() {
        super("Heirloom",
                "Requires Head of House or Heir",
                "You inherited a weapon of great quality.",
                "You inherited the Valyrian steel weapon that has been in your family\n" +
                        "for countless generations. Valyrian steel weapons are typically swords or\n" +
                        "daggers, but with your Narrator’s permission, you may apply this benefit\n" +
                        "to a different weapon. See page 128 for details on these weapons.");
    }
}

class Heir extends Benefit {
    Heir() {
        super("Heir",
                "none",
                "You stand to inherit the fortunes of your house.",
                "You are the heir to the lordship of your house. Should anything happen\n" +
                        "to the head of house, you exchange this quality for the Head of\n" +
                        "House quality.\n" +
                        "You must secure permission from your Narrator as well as your fellow\n" +
                        "players before you can select this quality. Only one member of your\n" +
                        "group can have this quality at a time.");
    }
}

class HeadOfHouse extends Benefit {
    HeadOfHouse() {
        super("Head Of House",
                "none",
                "You are the head of your household.",
                "You command your house and are responsible for the upkeep of your\n" +
                        "lands, the security of your people, and the dispensation of your fortunes.\n" +
                        "Add +2 to the results of all Status tests.\n" +
                        "You must secure permission from your Narrator and your fellow\n" +
                        "players before you can select this quality. Only one member of your\n" +
                        "group can have this quality at a time.");
    }
}

class HeadForNumbers extends Benefit {
    HeadForNumbers() {
        super("Head For Numbers",
                "Requires Status 3 (Stewardship 1B)",
                "You manage your household with expert precision.",
                "When you roll for House Fortunes, you may add your Cunning rank to\n" +
                        "your Status test result. In addition, anytime you make House Fortunes\n" +
                        "roll that results in an increase of the Wealth Resource, gain one additional\n" +
                        "point of Wealth to that increase.");
    }
}

class Hardy extends Benefit {
    Hardy() {
        super("Hardy",
                "Requires Endurance 3 (Stamina 1B)",
                "You are exceptionally healthy and can recover from injuries rapidly.",
                "When testing Endurance to remove injuries or wounds, you may ignore\n" +
                        "one –1 penalty or one –1D on your test.");
    }
}

class HailOfSteel extends Benefit {
    HailOfSteel() {
        super("Hail Of Steel",
                "Requires Marks manship 4 (Thrown 2B)",
                "You can fling knives and axes with amazing speed and accuracy.",
                "Thrown weapons in your hands gain the Fast quality");
    }
}

class Guttersnipe extends Benefit {
    Guttersnipe() {
        super("Guttersnipe",
                "none",
                "You are comfortable among the scum of Westeros",
                "Whenever you test Thievery, you may re-roll a number of 1s rolled equal\n" +
                        "to your rank in the specialty that relates best to the test (e.g. Sleight of\n" +
                        "Hand for picking pockets), minimum 1 re-roll.");
    }
}

class Greensight extends Benefit {
    Greensight() {
        super("Greensight",
                "Requires Will 5",
                "Your dreams sometimes come true.",
                "According to legend, greenseers were children of the forest who possessed\n" +
                        "incredible powers over nature, but more importantly, they possessed\n" +
                        "the ability to accurately foretell the future. Though the greenseers\n" +
                        "and the children of the forest are long gone from Westeros, some possess\n" +
                        "the greensight and experience the occasional prophetic dream if\n" +
                        "they know what it is they are looking for.\n" +
                        "You have two kinds of dreams: premonitions and portents. When you\n" +
                        "sleep, roll 1d6. On a 6, you experience one or the other.\n" +
                        "Premonitions are simple dreams, more emotion and feeling than\n" +
                        "concrete images. They are warnings of trouble in your personal life, and\n" +
                        "provide inspiration and strength to make it through those events. In\n" +
                        "game terms, you may choose any single test the following day to gain\n" +
                        "a +1D on, reflecting a sudden insight into the difficulty and how to\n" +
                        "navigate it best.\n" +
                        "Another way that premonitions might be employed is when spending\n" +
                        "or burning a point of Destiny to edit a scene, allowing you to have\n" +
                        "retroactively dreamt of this situation (although such dreams aren’t always\n" +
                        "believed or remembered when they happen). In such a situation,\n" +
                        "the scene editing results from the character gaining insight from the\n" +
                        "dream.\n" +
                        "Portents are prophetic dreams, powerful visions of what is to\n" +
                        "come—or of what is happening now. The dreams are filled with symbolic\n" +
                        "meaning, images, and metaphors. The meaning behind the dreams\n" +
                        "is not always obvious, but once you have experienced one, you will see\n" +
                        "the fulfillment of your visions in the unfolding of the events around you.\n" +
                        "You may also choose the nature of a portent. By spending a point\n" +
                        "of Destiny, you may choose the symbolism and meaning of a portent\n" +
                        "dream, granting you a +1D that may be used toward making that dream\n" +
                        "come true. Unlike premonitions, this bonus remains for longer than a\n" +
                        "single day, waiting until it is used. (It is notable that it is not the character,\n" +
                        "but the player, who chooses the content and goals of this dream;\n" +
                        "it is just another dream filled with strange symbols to the character.)\n" +
                        "If your Narrator has a portent ready, when you experience a green\n" +
                        "dream, you receive that portent. Otherwise, such dreams are assumed\n" +
                        "to be premonitions.");
    }
}

class GreatHunter extends Benefit {
    GreatHunter() {
        super("Great Hunter",
                "Requires Survival 4",
                "You are a hunter of great prowess.",
                "When fighting animals, you may add your Survival rank to your Fighting\n" +
                        "or Marksmanship test results. In addition to the combat benefit,\n" +
                        "when testing Survival to hunt or track animals, you may convert one\n" +
                        "bonus die from the Hunt specialty into a test die.");
    }
}

class GiftedTeacher extends Benefit {
    GiftedTeacher() {
        super("Gifted Teacher",
                "Requires Knowledge 4, Persuasion 3",
                "You can impart your wisdom onto your students.",
                "You can impart your knowledge onto other characters. A successful Persuasion\n" +
                        "test allows you to grant that character bonus dice on Knowledge\n" +
                        "tests your student makes related to the topic of instruction. Thus, if you\n" +
                        "succeeded on Persuasion test to instruct another character about architecture,\n" +
                        "that character would gain bonus dice on his own Knowledge\n" +
                        "test related to architecture. You may not instruct characters who have a\n" +
                        "greater rank than you do in Knowledge. The Difficulty of the test depends\n" +
                        "on the size of the bonus you wish to confer. A failed test indicates\n" +
                        "the subject matter was too lofty for the student to absorb.\n\n" +
                        "Difficulty \tBonus Dice\n" +
                        "Routine (6) \t\t1B\n" +
                        "Challenging (9) \t\t2B\n" +
                        "Formidable (12) \t\t3B\n" +
                        "Hard (15) \t\t4B\n" +
                        "Very Hard (18) \t5B\n" +
                        "Heroic (21) \t\t6B\n\n" +
                        "Once you have successfully instructed the student, that student may\n" +
                        "at any time make a Challenging (9) Cunning test (Memory applies)\n" +
                        "to recall your teachings. A success grants the character +1B per degree,\n" +
                        "drawn from the bonus dice you conferred. Once the student exhausts the\n" +
                        "pool of bonus dice, the student may not draw further on your teachings.");
    }
}

class GiftedAthlete extends Benefit {
    GiftedAthlete() {
        super("Gifted Athlete",
                "Requires Athletics 4",
                "You are in excellent physical shape\n" +
                        "and are skilled in a particular area of Athletics.",
                "Choose one Athletics specialty. When testing Athletics to perform your\n" +
                        "chosen specialty, you may convert half your bonus dice (round down,\n" +
                        "minimum 1) into test dice.\n" +
                        "You may select this quality multiple times. Each time, choose a new\n" +
                        "Athletics specialty.");
    }
}

class Fury extends Benefit {
    Fury() {
        super("Fury",
                "Requires Athletics 4 (Strength 2B)",
                "You are wrathful and filled with rage in battle.",
                "As a Greater Action, you can deliver a terrible blow to a single opponent\n" +
                        "with a Fighting weapon. Resolve as a normal attack, but take –2D on\n" +
                        "the attack. If you succeed, increase the damage by +4 before applying\n" +
                        "the benefits of degrees of success.");
    }
}

class Furtive extends Benefit {
    Furtive() {
        super("Furtive",
                "Requires Stealth 4 (Sneak 1B)",
                "You are hard to spot when you don’t want to be seen.",
                "When interacting with characters of 3 or lower Status, you gain a +1B\n" +
                        "on all Persuasion tests.");
    }
}

class FavoredOfSmallfolk extends Benefit {
    FavoredOfSmallfolk() {
        super("Favored Of Smallfolk",
                "none",
                "You are comfortable around those of low rank.",
                "When interacting with characters of 3 or lower Status, you gain a +1B\n" +
                        "on all Persuasion tests.");
    }
}

class FavoredOfNobles extends Benefit {
    FavoredOfNobles() {
        super("Favored Of Nobles",
                "none",
                "Those of high birth regard you as one of their own.",
                "When interacting with characters of 4 or higher Status, you gain a +1B\n" +
                        "on all Persuasion tests.");
    }
}

class Fast extends Benefit {
    Fast() {
        super("Fast",
                "none",
                "You are uncommonly fast on your feet.",
                "When calculating your move, your starting move is 5 yards. When running,\n" +
                        "you move five times your Movement.");
    }
}

class Famous extends Benefit {
    Famous() {
        super("Famous",
                "none",
                "You are known throughout the Seven Kingdoms.",
                "You are famous. When rolling Persuasion tests to Charm or Seduce\n" +
                        "another target, you may convert a number of bonus dice derived from\n" +
                        "Charm or Seduce into test dice equal to your Status.\n" +
                        "While Famous does carry significant benefits, there are drawbacks\n" +
                        "as well. You are well known, and you have a hard time concealing your\n" +
                        "identity. Whenever you use Stealth to create a disguise, you take penalty\n" +
                        "dice equal to Status. You and your Narrator should work together to\n" +
                        "determine what you did and why you are famous. If you are a young\n" +
                        "adult or younger, you may only select this quality after you have done\n" +
                        "something in the game the Narrator deems particularly worthy of fame.");
    }
}

class FaceInTheCrowd extends Benefit {
    FaceInTheCrowd() {
        super("Face In The Crowd",
                "Requires Stealth 3 (Blend In 1B)",
                "Even in strange places, you ou are adept at\n" +
                        "making it seem as though you belong.",
                "You may make a Stealth check to Blend In as a Free Action. In addition,\n" +
                        "you may add your Cunning rank to your Stealth test results made\n" +
                        "to Blend In.");
    }
}

class Exptertise extends Benefit {
    Exptertise() {
        super("Exptertise",
                "none",
                "You possess amazing talent with a single ability.",
                "Choose one specialty. Whenever you test the ability to perform an action\n" +
                        "related to that specialty, you gain +1D. This benefit does not apply\n" +
                        "to passive results.\n" +
                        "You may select this quality multiple times. Each time, it applies to a\n" +
                        "new specialty.");
    }
}

class Evaluation extends Benefit {
    Evaluation() {
        super("Evaluation",
                "Requires Knowledge 3",
                "You have a knack for identifying an object’s worth.",
                "Whenever you encounter a potentially valuable object, you may spend\n" +
                        "one minute examining it and roll a Challenging (9) Cunning test.\n" +
                        "A successful test allows you to determine its relative worth. Each additional\n" +
                        "degree reveals a piece of trivia about the object, including its\n" +
                        "maker, circumstances related to its maker’s life, and so on.");
    }
}

class Eloquent extends Benefit {
    Eloquent() {
        super("Eloquent",
                "Requires Language 4, Persuasion 4",
                "You have an uncanny knack for wordplay and diplomacy.",
                "When engaged in an intrigue using a Language in which you have rank\n" +
                        "4 or greater, you automatically go first in the round.");
    }
}

class EideticMemory extends Benefit {
    EideticMemory() {
        super("Eidetic Memory",
                "Requires Cunning 2 (Memory 1B)",
                "You have an astonishing capacity for recalling\n" +
                        "details about something you have seen or read.",
                "When testing Cunning to use Memory, you may add your Memory\n" +
                        "bonus dice as test dice.");
    }
}

class Dutiful extends Benefit {
    Dutiful() {
        super("Dutiful",
                "Requires Will 4",
                "You are unfailingly loyal.",
                "Your opponents take a –1D on all Persuasion checks made to influence\n" +
                        "you involving Convince, Intimidate, or Seduce.");
    }
}

class DoubleShot extends Benefit {
    DoubleShot() {
        super("Double Shot",
                "Requires Marks manship 5 (Bows 3B)",
                "You can fire two arrows at once.",
                "As a Greater Action, you may fire two arrows at once. Roll two tests\n" +
                        "using your full Marksmanship, but take –1D on each test. You may fire\n" +
                        "the arrows at the same target or at two adjacent targets.");
    }
}

class Dextrous extends Benefit {
    Dextrous() {
        super("Dextrous",
                "none",
                "You have uncanny reflexes.",
                "When rolling an Agility test, you may re-roll a number of ones equal to\n" +
                        "the bonus dice in the specialty that relates best to the test (e.g. balance\n" +
                        "for tightrope walking) (minimum 1 die).");
    }
}

class DeftHands extends Benefit {
    DeftHands() {
        super("Deft Hands",
                "Requires Agility 4",
                "Your quick hands let you reload your weapon more quickly.",
                "When armed with a weapon that has the Reload quality, you may reduce\n" +
                        "its reload time from one Greater Action to one Lesser Action, or\n" +
                        "one Lesser Action to one Free Action.");
    }
}

class DeadlyShot extends Benefit {
    DeadlyShot() {
        super("Deadly Shot",
                "Requires Marksmanship 5",
                "You have deadly aim, and know where to\n" +
                        "fire projectiles to achieve maximum effect.",
                "All bows and crossbows you wield gain Piercing 1 or increase their existing\n" +
                        "Piercing quality by 1. In addition, these weapons gain the Vicious\n" +
                        "quality.");
    }
}

class DangerSense extends Benefit {
    DangerSense() {
        super("Danger Sense",
                "Requires Awareness 4",
                "Your keen senses hel p you to can anticipate danger before it reveals\n" +
                        "itself.",
                "You may re-roll all 1s on Agility tests made to determine the order of\n" +
                        "initiative. In addition, whenever you or a unit to which you are attached\n" +
                        "is surprised in combat, your opponent does not gain the customary +1D\n" +
                        "on the Fighting or Marksmanship tests.");
    }
}

class Courteous extends Benefit {
    Courteous() {
        super("Courteous",
                "Requires Persuasion 3",
                "You have impeccable manners.",
                "You may add one half of your Persuasion rank (round down) to your\n" +
                        "Deception tests. In addition, whenever an opponent in an intrigue\n" +
                        "would use the Read Target action, you may add your Cunning rank to\n" +
                        "your passive Deception result.");
    }
}

class Connections extends Benefit {
    Connections() {
        super("Connections",
                "Requires Streetwise 1B",
                "You have a number of spies and informants in a particular area.",
                "Upon gaining this quality, choose one land (the North, the Reach,\n" +
                        "Dorne, etc.) or city (King’s Landing, Port of Ibben, etc.). You have\n" +
                        "connections in this place, and you can tap them to gather information\n" +
                        "about them. You gain +1D on all Knowledge tests made while in your\n" +
                        "chosen location.\n" +
                        "You may select this quality multiple times. Each time, it applies to a\n" +
                        "new location.");
    }
}

class Compelling extends Benefit {
    Compelling() {
        super("Compelling",
                "Requires Charismatic",
                "Such is the power of your personality,\n" +
                        "others find it hard to resist your demands.",
                "Choose one Persuasion specialty for which you selected the Charismatic\n" +
                        "benefit. When using this specialty in an intrigue, increase its Influence\n" +
                        "by 1.\n" +
                        "You may choose this benefit multiple times. Each time you select this\n" +
                        "quality, its benefits apply to a different specialty of Persuasion for which\n" +
                        "you have also selected the Charismatic quality.");
    }
}

class Cohort extends Benefit {
    Cohort() {
        super("Cohort",
                "Requires Status 3",
                "You have a close bond with another character\n" +
                        "and benefit when in his or her company.",
                "You gain the service of a particularly loyal ally. Create another character\n" +
                        "using the rules described in Chapter 3: Character Creation. Your\n" +
                        "cohort must have a lower Status than you and must be drawn from your\n" +
                        "own household. Your cohort is completely loyal and follows your commands\n" +
                        "to the best of his or her ability. If your cohort dies, you lose this\n" +
                        "quality and the Destiny Point you invested to gain it.\n" +
                        "When engaged in combat, so long as your cohort is adjacent to you,\n" +
                        "increase your Combat Defense by +2.");
    }
}

class Charismatic extends Benefit {
    Charismatic() {
        super("Charismatic",
                "Requires Persuasion 3",
                "You can put your strong personality to good use.",
                "When you select this quality, choose a single Persuasion specialty. Whenever\n" +
                        "you test Persuasion to use that specialty, add +2 to your test result.\n" +
                        "You may choose this benefit multiple times. Each time, choose a new\n" +
                        "specialty.");
    }
}

class CautiousDiplomat extends Benefit {
    CautiousDiplomat() {
        super("Cautious Diplomat",
                "Requires Awareness 4 (Empathy 2B)",
                "Extensive experience with negotiation gives you an advantage\n" +
                        "when you take the time to size up your opponent first.",
                "Whenever you take the Consider action during an intrigue, the bonus\n" +
                        "dice gained can exceed the normal limits on bonus dice. In addition, you\n" +
                        "retain these dice until the end of the intrigue.");
    }
}

class Cadre extends Benefit {
    Cadre() {
        super("Cadre",
                "Requires Persuasion 5",
                "You surround yourself with experienced fighting men\n" +
                        "who are unfailingly loyal to you and yours.",
                "Gain one veteran squad. A squad is a group of 10 men (see page 176).\n" +
                        "These characters have the statistics of Guards or of any unit the character’s\n" +
                        "House has invested in. This squad automatically reorganizes or rallies\n" +
                        "at the start of each round until destroyed. Should this unit be wiped\n" +
                        "out, you lose this quality and the Destiny Point you used to acquire it.\n" +
                        "While you need not pay this squad, you must feed and provide for the\n" +
                        "soldiers in it.");
    }
}

class BrotherOfTheNightsWatch extends Benefit {
    BrotherOfTheNightsWatch() {
        super("Brother Of The Night's Watch",
                "none",
                "You have forsworn any claims to kin or lands to\n" +
                        "serve as a brother of the Night’s Watch.",
                "You are a Sworn Brother of the Night’s Watch, and as such, you are\n" +
                        "immune to your house’s fortunes. Your Status drops to 2, and you\n" +
                        "lose Heir and Head of House benefits (but you regain the invested\n" +
                        "Destiny Points). Whenever you earn Coin or Glory, you may not invest\n" +
                        "them into your house, but may invest them into your division\n" +
                        "(Castle Black, Shadow Tower, or Eastwatch-by-the-Sea). Based on\n" +
                        "your abilities, you may be sorted into the rangers, builders, or stewards,\n" +
                        "as determined by the Narrator. You gain an additional benefit based\n" +
                        "on your order.\n" +
                        "BB Ranger: You may add your Cunning rank as a bonus to all\n" +
                        "Survival test results.\n" +
                        "BB Build er: You gain the Trade benefit for free. The specific trade\n" +
                        "must be of a benefit to the Wall.\n" +
                        "BB Steward : You may add the number of bonus dice assigned to\n" +
                        "Stewardship to all Persuasion test results.\n" +
                        "You must have the Narrator’s permission to select this quality. Taking\n" +
                        "this quality results in the loss of all Fate qualities tied to your birth\n" +
                        "house, but you regain the Destiny Points invested in them.");
    }
}

class BrawlerIII extends Benefit {
    BrawlerIII() {
        super("Brawler III",
                "Requires Fighting 5 (Brawling 5B), Brawler III",
                "So powerful are your unarmed attacks that foes\n" +
                        "crumple when struck.",
                "Whenever you succeed on a Fighting test to hit an opponent using\n" +
                        "your fist, you may choose to sacrifice three degrees of success to stun\n" +
                        "your opponent. You must have attained at least three degrees of success\n" +
                        "on the test result. Compare your test result to your opponent’s passive\n" +
                        "Endurance result. If it equals or beats the passive result, your opponent\n" +
                        "is stunned and can only take a special Recover action on its next turn.\n" +
                        "An opponent stunned by this benefit cannot be stunned again while\n" +
                        "suffering its effects.\n" +
                        "\nRecover (Greater Action): You must succeed on a Challenging\n" +
                        "(9) Endurance test or be forced to attempt another Recover action\n" +
                        "on your next turn. You gain a cumulative +1B for each previous failed\n" +
                        "test. If you succeed on your Endurance test, you immediately gain and\n" +
                        "can use a Lesser Action.");
    }
}

class BrawlerII extends Benefit {
    BrawlerII() {
        super("Brawler II",
                "Requires Fighting 4 (Brawling 3B), Brawler I",
                "You are capable of delivering powerful, damaging\n" +
                        "blows with your bare hands.",
                "Your fist attacks gain the Powerful property. In addition, you may add\n" +
                        "your Athletics rank to your Fighting test results when making Fighting\n" +
                        "tests using your fists.");
    }
}

class BrawlerI extends Benefit {
    BrawlerI() {
        super("Brawler I",
                "Requires Fighting 4 (Brawling 1B)",
                "You are lightning fast with your fists.",
                "Your fist attacks gain the Fast quality. In addition, your fist attacks deal\n" +
                        "damage equal to your Athletics rank –2.");
    }
}

class BraavosiFighterIII extends Benefit {
    BraavosiFighterIII() {
        super("Braavosi Fighter III",
                "Requires Fighting 6 (Fencing 3B), Braavosi Fighter II",
                "Your highly trained fighting instincts let you\n" +
                        "seize opportunities when presented to you.",
                "You can deliver a swift counterattack when your foe leaves himself\n" +
                        "open. Whenever an opponent armed with a Fighting weapon attacks\n" +
                        "and misses you, you may make a single attack against him as a Free\n" +
                        "Action. You must be armed with a Fencing weapon to use this benefit.");
    }
}

class BraavosiFighterII extends Benefit {
    BraavosiFighterII() {
        super("Braavosi Fighter II",
                "Requires Fighting 5 (Fencing 2B), Braavosi Fighter I",
                "Your can weave a curtain of steel about you.",
                "When armed with a Fencing weapon, you perform a series of cuts and\n" +
                        "maneuvers to deflect incoming attacks. As a Greater Action, sacrifice\n" +
                        "all of your bonus dice and make a single attack against an adjacent opponent.\n" +
                        "A hit deals normal damage. However, for every full 5 points of\n" +
                        "your test result, you also increase your Combat Defense by 1 until you\n" +
                        "next make a Fighting test.");
    }
}

class BraavosiFighterI extends Benefit {
    BraavosiFighterI() {
        super("Braavosi Fighter I",
                "Requires Fighting 4 (Fencing 1B)",
                "You skill with fencing weapons lets you\n" +
                        "turn aside your enemies’ attacks with ease.",
                "Fencing weapons in your hands gain Defensive +1 or increase their existing\n" +
                        "Defensive Bonus by +1. You always retain +1 of this bonus, even\n" +
                        "when making an attack with the weapon.");
    }
}

class BludgeonFighterIII extends Benefit {
    BludgeonFighterIII() {
        super("Bludgeon Fighter III",
                "Requires Fighting 6 (Bludgeons 4B),\n" +
                        "Bludgeon Fighter II",
                "You can land crushing blows that\n" +
                        "can splinter bones and cave in skulls.",
                "When armed with a bludgeoning weapon, you may sacrifice all of your\n" +
                        "bonus dice to crush your opponent. If your attack hits and you achieve\n" +
                        "three or more degrees, you knock your opponent to the ground, and he\n" +
                        "cannot take more than a Lesser Action on his next turn. Finally, you\n" +
                        "impose a wound in addition to any damage the attack dealt. Acquiring\n" +
                        "a wound from this attack does not count toward reducing damage to\n" +
                        "Health.");
    }
}

class BludgeonFighterII extends Benefit {
    BludgeonFighterII() {
        super("Bludgeon Fighter II",
                "Requires Fighting 5 (Bludgeons 3B),\n" +
                        "Bludgeon Fighter I",
                "Those struck by your bludgeoning attacks are sent reeling.",
                "When armed with a bludgeoning weapon, you may sacrifice all of your\n" +
                        "bonus dice to knock your foe senseless. If you hit your opponent, that\n" +
                        "opponent cannot take more than a Lesser Action on his next turn. In\n" +
                        "addition, your opponent also subtracts –1 from all test results for each\n" +
                        "degree gained after the first until the end of his next turn (so two degrees\n" +
                        "is a –1, three a –2, etc.).");
    }
}


class BludgeonFighterI extends Benefit {
    BludgeonFighterI() {
        super("Bludgeon Fighter I",
                "Requires Fighting 4 (Bludgeons 2B)",
                "Shields are no defense against your attacks.",
                "Your bludgeoning assault batters down your opponent’s defenses. Increase\n" +
                        "the Shattering rating of any bludgeoning weapon you wield by\n" +
                        "+1. If the weapon doesn’t have the Shattering quality, it instead gains\n" +
                        "it at 1.");
    }
}

class BloodOfTheWildlings extends Benefit {
    BloodOfTheWildlings() {
        super("Blood of the Wildlings",
                "none",
                "You are one of the many peoples that dwell\n" +
                        "in the lands beyond the Wall.",
                "Characters with high Status cannot automatically compel you and must\n" +
                        "engage you in an intrigue. In addition, whenever you are affected by\n" +
                        "extreme cold, you may add your Athletics rank to your passive Endurance\n" +
                        "result.");
    }
}

class BloodOfValyria extends Benefit {
    BloodOfValyria() {
        super("Blood of Valyria",
                "none",
                "The blood of Valyria flows hot in your veins, giving you a certain\n" +
                        "fierceness and natural command that others find unsettling. You\n" +
                        "have the silver hair and purple eyes common to most folk hailing\n" +
                        "from that ancient freehold.",
                "Before engaging in an intrigue, your Status counts as one rank higher\n" +
                        "for the purposes of influencing a target without fully engaging in an\n" +
                        "intrigue. In addition, whenever you test Persuasion to Intimidate, you\n" +
                        "add +2 to the test results.\n" +
                        "Finally, you may add +2 to your passive Endurance result when attacked\n" +
                        "by fire or exposed to the effects of heat.");
    }
}

class BloodOfTheRhoyne extends Benefit {
    BloodOfTheRhoyne() {
        super("Blood of the Rhoyne",
                "none",
                "You descend from the hardy warrior people known as the Rhoyne,\n" +
                        "those folks who came to Westeros to fight for the favor of their\n" +
                        "legendary warrior queen, Nymeria.",
                "Increase your Combat Defense by +2. In addition, when testing Tactics\n" +
                        "you may re-roll a number of 1s equal to your Cunning rank.");
    }
}

class BloodOfTheIronmen extends Benefit {
    BloodOfTheIronmen() {
        super("Blood of the Ironmen",
                "none",
                "You are descended from the ironmen, and you are suffused with\n" +
                        "the might of this warlike people.",
                "Once per combat, you may add +1D to a single Fighting test. Furthermore,\n" +
                        "whenever you test Athletics and are on a ship or in water, you may\n" +
                        "re-roll a number of 1s equal to your rank in the specialty that best relates\n" +
                        "to the test (e.g. Swim to negotiate the rapids of a river).");
    }
}

class BloodOfHeroes extends Benefit {
    BloodOfHeroes() {
        super("Blood of Heroes",
                "none",
                "Your innate talent with a specific ability far exceeds\n" +
                        "the limitations of ordinary men.",
                "Choose one ability. You may spend Experience to increase this ability\n" +
                        "beyond 7.");
    }
}

class BloodOfTheFirstMen extends Benefit {
    BloodOfTheFirstMen() {
        super("Blood of the First Men",
                "none",
                "You are of the First Men, those ancient peoples\n" +
                        "who settled in Westeros during the Age of Dawn.",
                "Increase your Health by +2. In addition, whenever you test Endurance,\n" +
                        "add +2 to the test result.");
    }
}

class BloodOfTheAndals extends Benefit {
    BloodOfTheAndals() {
        super("Blood of the Andals",
                "none",
                "The blood of the Andals flows through your veins.\n" +
                        "You are fair-haired and light-skinned.",
                "Upon selecting this benefit, choose one ability you have at rank 3 or\n" +
                        "greater. Whenever you test this ability, you may re-roll a single die. You\n" +
                        "must take the result of the second roll, even if it’s worse than the first.\n" +
                        "In addition, once per day, you may add +2 to the result of any one test.");
    }
}

class Berserker extends Benefit {
    Berserker() {
        super("Berserker",
                "none",
                "You can fly into an frenzy, becoming a brutal killing machine.",
                "You are always at risk of losing your temper in battle. Whenever you\n" +
                        "take an injury or wound, you may make a Fighting test as a Free Action\n" +
                        "against an adjacent opponent. You gain no bonus dice on this test.\n" +
                        "In addition, you can continue fighting even when you should be\n" +
                        "defeated. At the end of the current round, if you have taken wounds\n" +
                        "sufficient to defeat you, you may roll a Formidable (12) Will test\n" +
                        "to continue fighting. The penalty dice gained from wounds do not\n" +
                        "apply. You may make a number of such tests equal to your Endurance\n" +
                        "rank.");
    }
}

class Beastfriend extends Benefit {
    Beastfriend() {
        super("Beastfriend",
                "none",
                "You have a knack for handling and dealing with animals.",
                "Your affinity with animals grants you +1D on Animal Handling tests\n" +
                        "made to Charm or Train an animal.");
    }
}

class AxeFighterIII extends Benefit {
    AxeFighterIII() {
        super("Axe Fighter III",
                "Requires Fighting 6 (Axes 4B), Axe Fighter II",
                "A swing of your axe can rip off limbs and shatter heads.",
                "Whenever you are armed with an axe and roll a Fighting test to attack\n" +
                        "a foe, you can sacrifice all of your bonus dice to threaten a crippling\n" +
                        "injury. If you damage your foe, he gains a wound and must succeed on\n" +
                        "an Endurance test against your Fighting result or permanently gain the\n" +
                        "Maimed quality. An opponent may burn a Destiny Point to avoid gaining\n" +
                        "this quality");
    }
}

class AxeFighterII extends Benefit {
    AxeFighterII() {
        super("Axe Fighter II",
                "Requires Fighting 5 (Axes 3B), Axe Fighter I",
                "You can cripple your opponents with your savage strikes.",
                "Whenever you are armed with an axe and roll a Fighting test to attack a\n" +
                        "foe, you can sacrifice all of your bonus dice to threaten a bloody wound.\n" +
                        "If you damage your foe and get at least two degrees of success, that opponent\n" +
                        "takes a wound in addition to any damage the attack deals. The\n" +
                        "wound does not reduce any damage.");
    }
}

class AxeFighterI extends Benefit {
    AxeFighterI() {
        super("Axe Fighter I",
                "Requires Fighting 4 (Axes 2B)",
                "Your swings with axes produce dreadful results.",
                "Whenever you are armed with an axe and roll a Fighting test to attack\n" +
                        "a foe, you can sacrifice a number of bonus dice to threaten a nasty gash.\n" +
                        "If you damage your foe, that opponent takes additional damage at the\n" +
                        "start of his next turn. The amount of damage is equal to the number of\n" +
                        "bonus dice sacrificed. This damage ignores AR.");
    }
}

class Authority extends Benefit {
    Authority() {
        super("Authority",
                "none",
                "You wear the mantle of leadership,\n" +
                        "and people recognize you as figure of authority.",
                "During an intrigue, reduce your Persuasion penalty (if any) by two.\n" +
                        "Thus, when your disposition is Dislike, you take no penalty, when Unfriendly\n" +
                        "it is –2, and when Malicious it is –4.");
    }
}

class Attractive extends Benefit {
    Attractive() {
        super("Attractive",
            "none",
            "You possess incredible beauty. Those who are susceptible to such\n" +
                    "looks find it hard to concentrate when in your presence.",
            "Whenever you roll a Persuasion test, you may re-roll a number of 1s\n" +
                    "equal to half your Persuasion rank (minimum one re-roll).");

    }
}

class ArmorMastery extends Benefit {
    ArmorMastery() {
        super("Armor Mastery",
                "none",
                "You are accustomed to the weight and bulk of armor\n" +
                        "and know how to wear it to maximize its benefits.",
                "Armor you wear fits like a second skin. Increase your armor’s AR by +1,\n" +
                        "and reduce the Bulk (if any) by 1.");
    }
}

class Anointed extends Benefit {
    Anointed() {
        super("Anointed",
                "Requires Sponsor",
                "You have stood vigil, sworn your vows,\n" +
                        "and received the seven oils from a holy septon.\n" +
                        "In the eyes of all, you are a true knight.",
                "Add +2 to the result of all Status tests. You may draw strength from\n" +
                        "your commitment to the knightly virtues and the strength of your\n" +
                        "convictions. Once per day, as a Free Action, increase both Combat\n" +
                        "Defense and Intrigue Defense and all passive ability results by +5 for\n" +
                        "one round.\n" +
                        "A character need not take the Anointed Benefit in order to be a\n" +
                        "knight. It simply reflects a knight whose anointing was a major event,\n" +
                        "sponsored by an important figure.");
    }
}

class AnimalCohort extends Benefit {
    AnimalCohort() {
        super("Animal Cohort",
                "Requires Animal Handling 3 (Train 1B)",
                "Your bond with an animal has instilled in it\n" +
                        "unwavering loyalty, and a willingness to defend you.",
                "Choose one animal from the following list: dog, eagle, horse, raven,\n" +
                        "shadowcat, or wolf. This animal is extremely loyal to you and fights\n" +
                        "on your behalf. Whenever you roll Fighting tests in combat and your\n" +
                        "animal is nearby, add +1D to your Fighting test. You need never test\n" +
                        "Animal Handling to control your animal. Your Animal Cohort has\n" +
                        "statistics as described in the Creatures section in Chapter 11: The\n" +
                        "Narrator on pages 218-221. Should your Animal Cohort die, you\n" +
                        "lose this benefit and the Destiny Point you invested.\n" +
                        "You may select other animals (such as a direwolf, for example) with\n" +
                        "the Narrator’s permission.");
    }
}

class AdeptNegotiator extends Benefit {
    AdeptNegotiator() {
        super("Adept Negotiator",
                "Requires Deception 3",
                "By deeply burying your feelings, your opponents\n" +
                        "have difficulty assessing your true motives.",
                "So long as your disposition remains hidden from your opponent, you\n" +
                        "take no penalty on your Persuasion tests from your starting disposition.");
    }
}

class AcrobaticDefense extends Benefit {
    AcrobaticDefense() {
        super("Acrobatic Defense",
                "Requires Agility 4 (Acrobatics 1B)",
                "You are extraordinarily mobile in combat. By flipping and\n" +
                        "somersaulting, you make yourself a difficult target.",
                "As a Lesser Action, you may add twice the number of bonus dice in\n" +
                        "Acrobatics to your Combat Defense. You may not use this benefit when\n" +
                        "you wear armor with Bulk 1 or greater. The bonus to your Combat Defense\n" +
                        "last until the beginning of your next turn.");
    }
}

class Accurate extends Benefit {
    Accurate() {
        super("Accurate",
                "Requires Marks manship 4",
                "Your steady hand and keen eye make you\n" +
                        "deadly accurate with ranged weapons.",
                "Your Marksmanship attacks can defeat your opponents’ cover. Whenever\n" +
                        "you roll a Marksmanship test to attack an opponent protected by\n" +
                        "some form of cover, you gain +1D.");
    }
}

class Artist extends Benefit {
    Artist() {
        super("Artist",
                "none",
                "Creates works of art.",
                "You create art. Choose one art form—painting, poetry, composition,\n" +
                "sculpture, and so on. If you spend eight hours each day for five days,\n" +
                "you earn 10 silver stags. You may also roll a Challenging (9) Cunning\n" +
                "test. A success grants you one additional silver stag per degree.\n" +
                "At your option, you can spend the coins you earned to gain +1D on\n" +
                "a single Persuasion test used against someone who is aware of your\n" +
                "work and talents.");
    }
}
