/**
 * Created by arredon on 9/30/2016.
 */
public class HouseNode extends House {
    private HouseNode next;

    //default constructor
    public HouseNode() {
        super();
        next = null;
    }

    //Constructor with House name
    public HouseNode(String name) {
        super(name);
        next = null;
    }

    //copy constructor
    public HouseNode(HouseNode toCopy) {
        super(toCopy);
        next = null;
    }

    public void setNext(HouseNode next) {
        this.next = next;
    }

    public HouseNode getNext() {
        return next;
    }
}
