/**
 * Created by arredon on 11/18/2016.
 */

public class BenefitList {
    private Benefit head;

    public BenefitList() {
        head = null;
    }

    public BenefitList(BenefitList toCopy) {
        copyList(toCopy);
    }

    private void copyList(BenefitList toCopy) {
        if (toCopy == null || toCopy.head == null)
            head = null;
        else {
            head = toCopy.head;
            Benefit current = head;

            Benefit toCopyCurrent = toCopy.head.getNext();

            while (toCopyCurrent != null) {
                current.setNext(toCopyCurrent);
                current = current.getNext();
                toCopyCurrent = current.getNext();
            }
        }
    }

    public void insert(Benefit toInsert) {
        //change to insert alphabetically
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

    public int knowledgeFocusCount() {
        return knowledgeFocusCount(head);
    }

    private int knowledgeFocusCount(Benefit head) {
        if (head == null)
            return 0;
        else if (head.getName().equalsIgnoreCase("Knowledge Focus [Alchemy]")
                || head.getName().equalsIgnoreCase("Knowledge Focus [Architecture]")
                || head.getName().equalsIgnoreCase("Knowledge Focus [Astronomy]")
                || head.getName().equalsIgnoreCase("Knowledge Focus [Geography]")
                || head.getName().equalsIgnoreCase("Knowledge Focus [Heraldry]")
                || head.getName().equalsIgnoreCase("Knowledge Focus [History]")
                || head.getName().equalsIgnoreCase("Knowledge Focus [Legends]")
                || head.getName().equalsIgnoreCase("Knowledge Focus [Magic]")
                || head.getName().equalsIgnoreCase("Knowledge Focus [Nature]")
                || head.getName().equalsIgnoreCase("Knowledge Focus [Religion]")
                || head.getName().equalsIgnoreCase("Knowledge Focus [Underworld]"))
            return knowledgeFocusCount(head.getNext()) + 1;
        else
            return knowledgeFocusCount(head.getNext());
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
                "none",
                "short",
                "long");
    }
}

*/

class Worldly extends Benefit {
    Worldly() {
        super("Worldly",
                "none",
                "You are familiar with people from beyond the Seven Kingdoms.",
                "When interacting with a character from the Free Cities or beyond, you\n" +
                        "gain +2B on all Persuasion tests.");
    }
}

class WeaponSavant extends Benefit {
    WeaponSavant() {
        super("Weapon Savant",
                "Requires Agility 4, Cunning 4, Fighting 5",
                "You are able to pick up any weapon and fight with accomplished skill.",
                "You can wield any weapon without penalty, regardless of its training\n" +
                        "requirements.");
    }
}

class WeaponMastery extends Benefit {
    WeaponMastery() {
        super("Weapon Mastery",
                "none",
                "You are skilled with a particular weapon.",
                "When you take this quality, choose a single weapon. When you wield\n" +
                        "this weapon in combat, you increase its damage by +1.\n" +
                        "You may select this quality multiple times. Each time, its effects apply\n" +
                        "to a different weapon.");
    }
}

class Wealthy extends Benefit {
    Wealthy() {
        super("Wealthy",
                "none",
                "You have fortunes from inheritance or through mastery of business.",
                "At the start of each month, you may roll an Easy (3) Cunning or Status test\n" +
                        "to refill your coffers. Success earns you 10 gold dragons times your degree.");
    }
}

class WaterDancerIII extends Benefit {
    WaterDancerIII() {
        super("Water Dancer III",
                "Requires Water Dancer II",
                "You are graceful and elusive in battle.",
                "When you fight with a Fencing weapon, you may add your Fencing\n" +
                        "specialty rank to your Combat Defense. This bonus to Combat Defense\n" +
                        "is negated if the water dancer is denied his Awareness to his Combat\n" +
                        "Defense at any point. Whenever you wear armor with Bulk 1 or greater,\n" +
                        "you lose this benefit.");
    }
}

class WaterDancerII extends Benefit {
    WaterDancerII() {
        super("Water Dancer II",
                "Requires Water Dancer I",
                "You are swift as a deer and quick as a snake.",
                "You may add your Fighting rank to all Agility test results.");
    }
}

class WaterDancerI extends Benefit {
    WaterDancerI() {
        super("Water Dancer I",
                "Requires Fighting 3 (Fencing 1B)",
                "Your eyes see true.",
                "You may add your Fighting rank to all Awareness test results and to\n" +
                        "your passive Awareness result.");
    }
}

class WargDreams extends Benefit {
    WargDreams() {
        super("Warg Dreams",
                "Requires Will 4 (Dedication 1B), Animal Cohort",
                "Plagued with queer dreams, you have an uncanny connection with\n" +
                        "your animal companion, and sometimes you feel as though you\n" +
                        "wear its body when you sleep.",
                "Whenever you sleep, roll 1d6. On a result of 1–5 you have a normal night\n" +
                        "of sleep. A result of 6 indicates you slipped into the skin of your Animal\n" +
                        "Cohort, filling your mind with strange sensations and experiences. While\n" +
                        "wearing its skin, you can attempt to influence the creature by making an\n" +
                        "opposed Will test. If you win, you take control of the animal. You may act\n" +
                        "normally, but you use the beast’s statistics in place of your own.\n" +
                        "If the animal wins, it retains control, but you can see through its eyes\n" +
                        "and experience what it experiences. In either case, you cannot free yourself\n" +
                        "from the animal unless you succeed on another Challenging (9) Will\n" +
                        "test. You may test just once per hour you occupy the animal. An ally can\n" +
                        "give you another test before this time is up by shaking you vigorously. If\n" +
                        "the animal takes any Damage while this is happening, you are snapped\n" +
                        "back to your own body and gain a point of Fatigue from the experience.\n" +
                        "Finally, each time you have an out-of-body experience, you must succeed\n" +
                        "on a Challenging (9) Will test (Dedication applies). If you succeed,\n" +
                        "you suffer no ill effect. On a failure, you take –1D on all Persuasion tests\n" +
                        "until you next sleep. If you ever fail two consecutive Will tests after two\n" +
                        "nights of skinchanging, you permanently reduce your Cunning by 1 rank.\n" +
                        "Should you die, a part of yourself enters your Animal Cohort, making\n" +
                        "it more intelligent, with emotional ties to people, places, and events\n" +
                        "inherited from you.");
    }
}

class Warg extends Benefit {
    Warg() {
        super("Warg",
                "Requires Will 5 (Dedication 2B), Warg Dreams",
                "The connection between your animal friend and yourself is\n" +
                        "available to you while you are awake, allowing you to slip into its\n" +
                        "skin as you will.",
                "You can safely wear the skin of your Animal Cohort, slipping into its\n" +
                        "skin as a Greater Action. You use the animal’s statistics but retain your\n" +
                        "own Cunning and Will; during this time, however, your body is insensate\n" +
                        "and unconscious, and you have no awareness of what is going on\n" +
                        "around you.\n" +
                        "You may remain in this form as long as you wish, though be aware\n" +
                        "your true body’s needs must be met, and extended trips into your Animal\n" +
                        "Cohort could cause you to starve to death if you remain out for a\n" +
                        "week or more. You can return to your body automatically. While you are\n" +
                        "wearing your Animal Cohort’s skin, you may even enter into combat\n" +
                        "with it. As an added benefit, the animal can take Injuries, but if this\n" +
                        "happens you snap back to your own body and gain a point of Fatigue\n" +
                        "from the experience.");
    }
}

class TripleShot extends Benefit {
    TripleShot() {
        super("Triple Shot",
                "Requires Marks manship 7 (Bows 5B), Double Shot",
                "Like Anguy the Archer, you can fire three arrows at once.",
                "As a Greater Action, you may fire three arrows simultaneously. Roll\n" +
                        "three tests using your full Marksmanship, but take –2D on each test.\n" +
                        "You may fire the arrows at the same target or at three adjacent targets.");
    }
}

class Treacherous extends Benefit {
    Treacherous() {
        super("Treacherous",
                "none",
                "You use your cunning and duplicity to outmaneuver your enemies.",
                "Whenever you use Deception in an intrigue, you may add your Cunning\n" +
                        "rank to your Deception test results.");
    }
}

class Trade extends Benefit {
    Trade() {
        super("Trade",
                "none",
                "You are a skilled craftsman.",
                "You have learned a trade. Choose any one trade. You have to invest at\n" +
                        "least 2 silver stags and spend ten hours each day for five days. After this\n" +
                        "period is up, roll a Challenging (9) Cunning test. A success grants you\n" +
                        "6 × your initial investment (12 silver stags for a Profit of 10 silver stags).\n" +
                        "Each additional degree improves the multiplier by 1 (so 35 silver stags\n" +
                        "for two degrees of success and 5 silver stags as investment). If you roll\n" +
                        "a Critical failure, your investment is lost, and you receive –1D on your\n" +
                        "next Trade test. Finally, you may create items related to your trade that\n" +
                        "allow you to purchase them for half the list price.");
    }
}

class TourneyKnight extends Benefit {
    TourneyKnight() {
        super("Tourney Knight",
                "Requires Fighting 3 (Spears 1B), Status 3 (Tournaments 1B)",
                "You are a veteran of numerous tournaments.",
                "Whenever you joust, you may add the number of bonus dice from the\n" +
                        "Tournaments specialty to your Fighting test result and to your passive\n" +
                        "Animal Handling result to stay in the saddle.");
    }
}

class Tough extends Benefit {
    Tough() {
        super("Tough",
                "Requires Resilience 1B",
                "You are uncommonly tough and can shrug off damage with ease.",
                "You may add the number of bonus dice you have in the Resilience specialty\n" +
                        "to your Health.");
    }
}

class TerrainSpecialist extends Benefit {
    TerrainSpecialist() {
        super("Terrain Specialist",
                "Requires Survival 4",
                "Vast experience in the wild gives you an advantage\n" +
                        "when moving through familiar terrain.",
                "Choose one terrain type from any of the following—deserts, forests,\n" +
                        "hills, marshes, mountains, plains, and coastal lands. When testing Survival\n" +
                        "in these areas, you may add the number of bonus dice you have in\n" +
                        "Education to your Survival test results. In addition, you never take a\n" +
                        "Movement penalty when moving through this terrain.\n" +
                        "You may select this benefit multiple times. Each time, its effects apply\n" +
                        "to a different terrain type.");
    }
}

class Talented extends Benefit {
    Talented() {
        super("Talented",
                "none",
                "You have a natural talent with a single ability.",
                "Choose a single ability (Fighting, Knowledge, etc.). Whenever you test\n" +
                        "the chosen ability, add +1 to the test result.\n" +
                        "You may select this benefit multiple times. Each time, choose a\n" +
                        "new ability.");
    }
}

class Stubborn extends Benefit {
    Stubborn() {
        super("Stubborn",
                "Requires Will 3 (Dedication 1B)",
                "You are hard to persuade",
                "You may add the number of bonus dice you have in Dedication to your\n" +
                        "Composure.");
    }
}

class Sponsor extends Benefit {
    Sponsor() {
        super("Sponsor",
                "none",
                "You have the favor of an important personage.",
                "A person of quality will vouch for you. Sponsor is a requirement for\n" +
                        "several qualities. You and the Narrator should work together to define\n" +
                        "the person who stands for you. The Sponsor should be related to one\n" +
                        "of the qualities you pursue. A Sponsor may grant you information,\n" +
                        "audiences, companionship, and even take an interest in your development,\n" +
                        "though this quality typically does not provide a mechanical\n" +
                        "benefit");
    }
}

class SpearFighterIII extends Benefit {
    SpearFighterIII() {
        super("Spear Fighter III",
                "Requires Athletics 5, Spear Fighter II",
                "With skill and brute strength,\n" +
                        "you thrust your spear through your foes.",
                "Spears in your hands gain the Piercing 2 quality. If the spear already has\n" +
                        "the Piercing quality, instead increase it by +2");
    }
}

class SpearFighterII extends Benefit {
    SpearFighterII() {
        super("Spear Fighter II",
                "Requires Spear Fighter I",
                "You can trip up your foes with a deft strike of your spear.",
                "Spears in your hands can attack opponents 1 yard further than they\n" +
                        "normally could and at no penalty. In addition, when armed with a spear,\n" +
                        "you gain +1D on tests to Knockdown your opponents.");
    }
}

class SpearFighterI extends Benefit {
    SpearFighterI() {
        super("Spear Fighter I",
                "Requires Fighting 3 (Spears 1B)",
                "A spear’s haft is as much a threat as is its point.",
                "As a Greater Action, make a normal attack against a single opponent. If\n" +
                        "you miss, you may immediately make a second attack at any other foe. If\n" +
                        "this attack hits, it deals damage equal to your Athletics –1.");
    }
}

class Skinchanger extends Benefit {
    Skinchanger() {
        super("Skinchanger",
                "Requires Will 5 (Dedication 2B), Warg",
                "You have mastered the method of skinchanging and can now freely\n" +
                        "leave your body for a variety of skins.",
                "You are now no longer restricted to your Animal Cohort for the purpose\n" +
                        "of warging. Entering an animal that is not your Animal Cohort\n" +
                        "requires mastering the animal’s Will.\n" +
                        "This process involves finding an animal in sensory range and engaging\n" +
                        "in a Conflict Test, using your Animal Handling against the beast’s\n" +
                        "passive Will. The animal resists its will being subsumed, and many\n" +
                        "animals will demonstrate either fear or anger at the intrusion. Success\n" +
                        "means that you have imprinted your will upon the animal, and may\n" +
                        "control it through your Warg Benefit.\n" +
                        "While you are wearing one of these skins, you may use it to enter into\n" +
                        "combat. As an added benefit, it can take Injuries and Wounds. If the\n" +
                        "animal takes a Wound, however, you snap back to your own body and\n" +
                        "gain a point of Fatigue from the experience.\n" +
                        "It is difficult to imprint upon too many beasts at once, however. After\n" +
                        "the first non-Animal Cohort beast so imprinted, add a +3 cumulative\n" +
                        "bonus to the beast’s passive Will for the purpose of imprinting it. There\n" +
                        "are practical limits to how many beasts may be active as potential wargskins\n" +
                        "at once, and those wargs who manage to accrue large numbers\n" +
                        "of beasts are well-respected and feared among those cultures (such as\n" +
                        "wildlings) who acknowledge the existence of wargs.\n" +
                        "By spending a Destiny point, a warg may also make a human of\n" +
                        "Cunning 1 into a viable target for this Benefit, allowing the warg to ride\n" +
                        "those who are simpler in mind.\n" +
                        "If, at the moment of his bodily death, a warg is either within one of\n" +
                        "his skins or cognizant enough to shift into one of them, he may burn\n" +
                        "a Destiny point to permanently take over that creature, continuing his\n" +
                        "existence. He retains his Cunning and Will, as well as all appropriate\n" +
                        "Benefits and Drawbacks, particularly his warging abilities.");
    }
}

class Sinister extends Benefit {
    Sinister() {
        super("Sinister",
                "none",
                "Everything about you suggests you are a dangerous individual",
                "During the first round of combat or intrigue, your opponents take –1D\n" +
                        "on all Fighting and Persuasion tests made to attack or influence you.");
    }
}

class ShortBladeFighterIII extends Benefit {
    ShortBladeFighterIII() {
        super("Short Blade Fighter III",
                "Requires Fighting 6, Short Blade Fighter II",
                "A short blade is a deadly weapon in your hands.",
                "When wielding a short blade weapon in combat, you may add the number\n" +
                        "of bonus dice you have in the Short Blades specialty to your damage\n" +
                        "result. This extra damage is added after you apply the effects of degree of\n" +
                        "success.");
    }
}

class ShortBladeFighterII extends Benefit {
    ShortBladeFighterII() {
        super("Short Blade Fighter II",
                "Requires Fighting 5, Short Blade Fighter I",
                "You can pull blades with lightning speed.",
                "You can draw a short blade as a Free Action. In addition, when using\n" +
                        "a short blade in combat, you may add the number of bonus dice in the\n" +
                        "Short Blades specialty to your Fighting test result. So if you have 3B,\n" +
                        "you would add +3 to your Fighting test result.");
    }
}

class ShortBladeFighterI extends Benefit {
    ShortBladeFighterI() {
        super("Short Blade Fighter I",
                "Requires Fighting 4 (Short Blades 1B)",
                "You know how to slip your blade through the chinks\n" +
                        "in even the heaviest armors.",
                "Whenever you wield a short blade in combat, your weapon gains Piercing\n" +
                        "1. If the weapon already has Piercing, increase it by +1.");
    }
}

class ShieldMastery extends Benefit {
    ShieldMastery() {
        super("Shield Mastery",
                "Requires Fighting 3 (Shields 1B)",
                "You are able to deflect attacks with ease when wielding a shield.",
                "Increase the Defensive Bonus of any shield carried by +1 per rank in\n" +
                        "the Shields specialty, to a maximum of doubling the bonus granted by\n" +
                        "the shield.");
    }
}

class Respected extends Benefit {
    Respected() {
        super("Respected",
                "Requires Reputation 2B",
                "Your accomplishments are widely known and\n" +
                        "your reputation inspires respect in others.",
                "During intrigues, your opponents take –1D on Persuasion tests involving\n" +
                        "Incite, Intimidate, and Taunt.");
    }
}

class Polyglot extends Benefit {
    Polyglot() {
        super("Polyglot",
                "Requires Cunning 4 (Decipher 1B)",
                "You have a great facility with languages.",
                "You may read any language in which you have at least 1 rank. As well,\n" +
                        "when exposed to a language with which you aren’t familiar, you may\n" +
                        "roll a Formidable (12) Cunning test to pick up enough of the tongue\n" +
                        "to get by. If this test succeeds, you gain 1 rank in the Language for the\n" +
                        "duration of the encounter. For every two additional degrees on the test,\n" +
                        "you gain an additional rank.");
    }
}

class PolearmFighterIII extends Benefit {
    PolearmFighterIII() {
        super("Polearm Fighter III",
                "Requires Fighting 5, Pole-Arm Fighter II",
                "You can pin your opponent in place with a deft jab of your weapon",
                "With a hard thrust of your pole-arm, you can pin your opponent. Make\n" +
                        "a Fighting test as normal to attack your opponent as a Greater Action.\n" +
                        "If you succeed and achieve at least two degrees of success, you\n" +
                        "prevent your opponent from spending actions to move. Your opponent\n" +
                        "can break the pin by beating you on an opposed Athletics test (Strength\n" +
                        "applies). Your bonus dice from the Pole-arm specialty apply to the opposed\n" +
                        "Strength test.");
    }
}

class PolearmFighterII extends Benefit {
    PolearmFighterII() {
        super("Polearm Fighter II",
                "Requires Fighting 4 or Athletics 4, Pole-Arm Fighter I",
                "You can use your pole-arm to unhorse your opponents.",
                "When you use a pole-arm to pull a rider from his mount, you may convert\n" +
                        "your pole-arm bonus dice into test dice. If you fail to beat the rider’s\n" +
                        "Animal Handling test, you are disarmed.");
    }
}

class PolearmFighterI extends Benefit {
    PolearmFighterI() {
        super("Polearm Fighter I",
                "Requires Fighting 4 (Pole-arms 2B)",
                "You are highly trained with the pole-arm.",
                "You can sweep your pole-arm out to knock your foes to the ground. Roll a\n" +
                        "Fighting test as normal, but subtract 2 from your test result for each opponent\n" +
                        "within reach that you want to attack with the sweep. Compare the test\n" +
                        "result to the Combat Defense of each opponent within reach. Opponents\n" +
                        "whose Combat Defense you equal or beat are knocked to the ground");
    }
}

class Pious extends Benefit {
    Pious() {
        super("Pious",
                "Requires Will 3 (Dedication 1B)",
                "You have deep-seated conviction and unwavering\n" +
                        "devotion to your god or gods.",
                "Choose one religious group, god, or quasi-religious principle. Examples\n" +
                        "include the Old Way, the Seven, the Lord of Light, and so on. Once per\n" +
                        "day, you may call upon your faith to help you and your efforts. You gain\n" +
                        "+1D on a single test.");
    }
}

class NightEyes extends Benefit {
    NightEyes() {
        super("Night Eyes",
                "none",
                "You have exceptional vision and can see clearly in the dark.",
                "The shadows hold no fear for you. You take no penalty on Fighting and\n" +
                        "Marksmanship tests or on other physical tests when in areas of poor\n" +
                        "visibility caused by low light.");
    }
}

class Mummer extends Benefit {
    Mummer() {
        super("Mummer",
                "Requires Persuasion 3",
                "You are an accomplished performer and actor, skilled at\n" +
                        "entertaining audiences with your antics.",
                "You can perform in front of audiences and earn a living doing so. To\n" +
                        "perform, you must succeed on a Persuasion test. The Difficulty is usually\n" +
                        "Challenging (9), but it may be higher or lower depending on the\n" +
                        "atmosphere and mood of the crowd. If you succeed, you earn 1d6 silver\n" +
                        "stags. Each additional degree results in an additional coin. A single test\n" +
                        "represents an evening’s performance.\n" +
                        "If you roll a Critical failure, your act offends your audience and you\n" +
                        "are tossed out for your poor performance. Until you next succeed on a\n" +
                        "Persuasion test to perform, you take a –5 penalty on your Persuasion\n" +
                        "test results.");
    }
}

class MiracleWorker extends Benefit {
    MiracleWorker() {
        super("Miracle Worker",
                "Requires Healing 4",
                "You know a variety of techniques and remedies to aid your patients.",
                "Whenever you test Healing to first diagnose your patient, you gain +2B\n" +
                        "for a successful test, plus 1 bonus die for each additional degree. You\n" +
                        "may convert two bonus dice into test dice for your Healing test to treat\n" +
                        "the patient. Finally, you may add your Education rank to your Healing\n" +
                        "test results.");
    }
}

class MasterOfRavens extends Benefit {
    MasterOfRavens() {
        super("Master Of Ravens",
                "Requires Animal Handling 3",
                "You are skilled at handling ravens.",
                "You may dispatch ravens to bear your messages. The Narrator makes a\n" +
                        "secret Routine (6) Animal Handling test on your behalf (the Charm\n" +
                        "specialty applies). Success means the raven delivers the message to the\n" +
                        "appointed destination while failure means the message (and possibly\n" +
                        "the raven) goes astray. Additional degrees of success may allow you to\n" +
                        "coax some extra speed or distance out of your birds, at the Narrator’s\n" +
                        "discretion, or get a message through dangerous or difficult weather or\n" +
                        "the like.");
    }
}

class Massive extends Benefit {
    Massive() {
        super("Massive",
                "Requires Endurance 5",
                "You are uncommonly large.",
                "You can wield Two-handed weapons in one hand, and you may ignore\n" +
                        "the Unwieldy quality of these weapons (if any).");
    }
}

class ManOfTheKingsguard extends Benefit {
    ManOfTheKingsguard() {
        super("Man Of The Kingsguard",
                "Requires Sponsor",
                "You have been selected to protect the king as one of the seven\n" +
                        "Kingsguard.",
                "You are a member of the Kingsguard and have vowed to give your life\n" +
                        "to the protection of the royal family. As a result of this great honor, you\n" +
                        "gain the following benefits:\n" +
                        "\t* Your Status increases to 5.\n" +
                        "\t* Increase your Composure by +2.\n" +
                        "\t* When fighting to protect the king, queen, or other members of the\n" +
                        "\troyal family, you may add +1 to all Fighting test results.\n" +
                        "\t* You have a cell inside the White Tower at King’s Landing and are\n" +
                        "\tsupplied with a castle-forged longsword, castle-forged plate, and\n" +
                        "\tmail armor, and whenever you have need of general equipment, the\n" +
                        "\tcrown supplies it.\n" +
                        "There is a downside to this: you no longer have ties to your family\n" +
                        "and cannot derive any benefits from your house’s lands or fortunes,\n" +
                        "though when you gain Glory, you may invest up to one half into your\n" +
                        "former house.\n" +
                        "You must have the Narrator’s permission to select this quality. Taking\n" +
                        "this quality results in the loss of all Fate qualities tied to your birth\n" +
                        "house, but you regain the Destiny Points invested in them.");
    }
}

class Magnetic extends Benefit {
    Magnetic() {
        super("Magnetic",
                "Requires Charismatic",
                "You have a way about you that cultivates alliances and friendships.",
                "Whenever you defeat a foe using Charm, that foe’s disposition increases\n" +
                        "by a number of steps equal to the number of bonus dice you invested in\n" +
                        "Charm (minimum 2 steps).");
    }
}

class Maester extends Benefit {
    Maester() {
        super("Maester",
                "Requires Cunning 3, Knowledge Focus (any two or more)",
                "You have forged your chain of knowledge and wear it proudly.",
                "You are a maester of the Citadel. You are now immune to the household\n" +
                        "fortunes of your birth house, but you suffer the effects of the household\n" +
                        "fortunes of the house to which you are assigned. In addition, you may\n" +
                        "add your Cunning rank to all Knowledge and Will test results.\n" +
                        "You must have the Narrator’s permission to select this quality. Taking\n" +
                        "this quality results in the loss of any Fate qualities tied to your birth\n" +
                        "house, although you regain invested Destiny Points for lost qualities.\n" +
                        "A character need not take the Maester Benefit in order to be a maester.\n" +
                        "It simply reflects a maester who has successfully and fully severed\n" +
                        "all ties with his past, and whose learning has become an inspiration\n" +
                        "for others of the Citadel.");
    }
}

class Lucky extends Benefit {
    Lucky() {
        super("Lucky",
                "none",
                "You are uncharacteristically lucky.",
                "Fate favors you. Once per day you may re-roll a single test. You take the\n" +
                        "better of the two results");
    }
}

class LongBladeFighterIII extends Benefit {
    LongBladeFighterIII() {
        super("Long Blade Fighter III",
                "Requires Fighting 6, Long Blade Fighter II",
                "You can deliver a savage strike to cut your enemy to pieces.",
                "When you wield a long blade in combat, you may sacrifice all of your\n" +
                        "bonus dice to deliver a dreadful attack. If you hit with three or more\n" +
                        "degrees of success, you deal damage as normal, but you also impose a\n" +
                        "wound and the Maimed quality (see page 95). A target that burns a\n" +
                        "Destiny Point can avoid gaining this quality.");
    }
}

class LongBladeFighterII extends Benefit {
    LongBladeFighterII() {
        super("Long Blade Fighter II",
                "Requires Fighting 5, Long Blade Fighter I",
                "You drive your enemies before you with the fierceness of your attacks",
                "When wielding a long blade in combat—for every two bonus dice sacrificed—\n" +
                        "you and your opponent move 1 yard in any direction if you successfully\n" +
                        "hit your foe. You may drive your foe into terrain features, such\n" +
                        "as ponds, rivers, or off cliffs. Should you move your opponent in such a\n" +
                        "way that they would lose their balance or be in danger, your opponent\n" +
                        "can negate this movement by succeeding on a Challenging (9) Agility\n" +
                        "test. Bonus dice from the Dodge specialty apply.");
    }
}

class LongBladeFighterI extends Benefit {
    LongBladeFighterI() {
        super("Long Blade Fighter I",
                "Requires Fighting 4 (Long Blades 2B)",
                "The weight of your blade make your attacks harder to parry.",
                "When armed with a Long Blade, you may sacrifice all of your bonus\n" +
                        "dice from Long Blades to gain one free degree of success if you successfully\n" +
                        "hit your opponent. In addition, adversaries wielding nonshield\n" +
                        "parrying weapons take a –1 penalty to their Combat Defense\n" +
                        "against your attacks.");
    }
}

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

class GiftedAthleteClimb extends Benefit {
    GiftedAthleteClimb() {
        super("Gifted Athlete [Climb]",
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

class GiftedAthleteJump extends Benefit {
    GiftedAthleteJump() {
        super("Gifted Athlete [Jump]",
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

class GiftedAthleteRun extends Benefit {
    GiftedAthleteRun() {
        super("Gifted Athlete [Run]",
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

class GiftedAthleteStrength extends Benefit {
    GiftedAthleteStrength() {
        super("Gifted Athlete [Strength]",
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

class GiftedAthleteSwim extends Benefit {
    GiftedAthleteSwim() {
        super("Gifted Athlete [Swim]",
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

class GiftedAthleteThrow extends Benefit {
    GiftedAthleteThrow() {
        super("Gifted Athlete [Throw]",
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

class Expertise extends Benefit {
    Expertise() {
        super("Expertise",
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
