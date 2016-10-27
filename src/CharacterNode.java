/**
 * Created by arredon on 10/9/2016.
 */
public class CharacterNode extends Character {
    CharacterNode next;
    CharacterNode prev;

    //default constructor
    public CharacterNode() {
        super();
        next = null;
        prev = null;
    }

    //copy constructor
    public CharacterNode(CharacterNode toCopy) {
        super(toCopy);
        next = null;
        prev = null;
    }

    public CharacterNode(Character toCopy) {
        super(toCopy);
        next = null;
        prev = null;
    }

    //Constructor given House Name, Realm, and status. For Heirs
    public CharacterNode(String houseName, String realm, int status) {
        super(houseName, realm, status);
        next = null;
        prev = null;
    }

    //Constructor given House Name, Realm, status, and gender. For Heirs
    public CharacterNode(String houseName, String realm, String gender, int status) {
        super(houseName, realm, gender, status);
        next = null;
    }

    public void setPrev(CharacterNode prev) {
        this.prev = prev;
    }

    public CharacterNode getPrev() {
        return prev;
    }

    public void setNext(CharacterNode next) {
        this.next = next;
    }

    public CharacterNode getNext() {
        return next;
    }
}
