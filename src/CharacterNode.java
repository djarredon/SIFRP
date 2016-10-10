/**
 * Created by arredon on 10/9/2016.
 */
public class CharacterNode extends Character {
    CharacterNode next;

    public CharacterNode() {
        super();
        next = null;
    }

    public CharacterNode(CharacterNode toCopy) {
        super(toCopy);
        next = null;
    }

    public void setNext(CharacterNode next) {
        this.next = next;
    }

    public CharacterNode getNext() {
        return next;
    }
}
