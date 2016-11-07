/**
 * Created by arredon on 11/5/2016.
 */
public class WealthNode extends Wealth {
    private WealthNode next;
    private WealthNode prev;

    public WealthNode() {
        super();
        next = prev = null;
    }

    public WealthNode(Wealth toCopy) {
        super(toCopy);
        next = prev = null;
    }

    public WealthNode(String name) {
        super(name);
        next = prev = null;
    }

    public void setNext(WealthNode next) {
        this.next = next;
    }

    public void setPrev(WealthNode prev) {
        this.prev = prev;
    }

    public WealthNode getNext() {
        return next;
    }

    public WealthNode getPrev() {
        return prev;
    }
}
