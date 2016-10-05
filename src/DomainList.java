/**
 * Created by arredon on 10/1/2016.
 */
public class DomainList {
    private DomainNode head;

    public DomainList() {
        head = null;
    }

    public DomainList(DomainList domains) {
        copyList(domains);
    }

    public void display() {
        if (head == null)
            System.out.println("No Features");
        else {
            DomainNode current = head;
            while (current != null) {
                current.display();
                current = current.getNext();
            }
        }
    }

    public void insert(Domain domain) {
        if (head == null)
            head = new DomainNode(domain);
        else {
            DomainNode temp = new DomainNode(domain);
            temp.setNext(head);
            head = temp;
        }
    }

    public void copyList(DomainList toCopy) {
        if (toCopy.head == null)
            head = null;
        else {
            head = new DomainNode(toCopy.head);
            DomainNode prevNode = head;
            DomainNode thisCurrent;
            DomainNode copyCurrent = toCopy.head;
            copyCurrent = copyCurrent.getNext();

            while (copyCurrent != null) {
                thisCurrent = new DomainNode(copyCurrent);
                prevNode.setNext(thisCurrent);
                prevNode = prevNode.getNext();
                copyCurrent = copyCurrent.getNext();
            }
        }
    }
}
