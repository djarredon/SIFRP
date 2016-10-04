/**
 * Created by arredon on 9/27/2016.
 */
public class EventNode extends Event{
    private EventNode next;

    public EventNode() {
        super();
        next = null;
    }

    public EventNode(EventNode toCopy) {
        super(toCopy);
        next = null;
    }

    public EventNode(Event toCopy) {
        super(toCopy);
        next = null;
    }

    public EventNode getNext() {
        return next;
    }

    public void setNext(EventNode next) {
        this.next = next;
    }
}
