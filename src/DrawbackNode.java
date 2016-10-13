/**
 * Created by arredon on 10/13/2016.
 */
public class DrawbackNode extends Drawback {
    DrawbackNode next;

    public DrawbackNode(){
        super();
        next = null;
    }

    public DrawbackNode(DrawbackNode flaw) {
        super(flaw);
        next = null;
    }

    public void setNext(DrawbackNode next) {
        this.next = next;
    }

    public DrawbackNode getNext() {
        return next;
    }
}
