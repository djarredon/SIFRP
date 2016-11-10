/**
 * Created by arredon on 10/7/2016.
 */
public class DefenseNode extends DefenseHolding{
    private DefenseNode next;

    public DefenseNode() {
        super();
        next = null;
    }

    public DefenseNode(String toBe) {
        super(toBe);
        next = null;
    }

    public DefenseNode(DefenseNode toCopy) {
        super(toCopy);
        next = null;
    }

    public void setNext(DefenseNode next) {
        this.next = next;
    }

    public DefenseNode getNext() {
        return next;
    }
}
