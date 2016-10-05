/**
 * Created by arredon on 10/1/2016.
 */
public class DomainNode extends Domain {
    private DomainNode next;

    public DomainNode() {
        next = null;
    }

    public DomainNode(Terrain terrain) {
        super(terrain);
        next = null;
    }

    public DomainNode(DomainNode domainNode) {
        super(domainNode);
        next = null;
    }

    public void setNext(DomainNode next) {
        this.next = next;
    }

    public DomainNode getNext() {
        return next;
    }
}
