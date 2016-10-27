/**
 * Created by arredon on 9/30/2016.
 */
public class HouseNode extends House {
    private HouseNode next;
    private HouseNode prev;

    //default constructor
    public HouseNode() {
        super();
        next = prev =  null;
    }

    //Constructor with House name
    public HouseNode(String name) {
        super(name);
        next = prev =  null;
    }

    //copy constructor
    public HouseNode(HouseNode toCopy) {
        super(toCopy);
        next = prev =  null;
    }

    public void setPrev(HouseNode prev) {
        this.prev = prev;
    }

    public HouseNode getPrev() {
        return prev;
    }

    public void setNext(HouseNode next) {
        this.next = next;
    }

    public HouseNode getNext() {
        return next;
    }
}
