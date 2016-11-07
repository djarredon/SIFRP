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

    public String printAll() {
        if (head == null)
            return "No Features\n";
        String toReturn = new String();
        DomainNode current = head;
        while (current != null) {
            toReturn = toReturn.concat(current.print());
            current = current.getNext();
        }
        return toReturn;
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

    public boolean hasHolding(String toCheck) {
        if (head == null)
            return false;
        return hasHolding(toCheck, head);
    }

    private boolean hasHolding(String toCheck, DomainNode head) {
        if (head == null)
            return false;
        if (head.hasFeature(toCheck))
            return true;
        return hasHolding(toCheck, head.getNext());
    }

    public boolean hasTerrain(String toCheck) {
        return hasTerrain(toCheck, head);
    }

    private boolean hasTerrain(String toCheck, DomainNode head) {
        if (head == null)
            return false;
        if (head.printTerrainName().equalsIgnoreCase(toCheck))
            return true;
        return hasTerrain(toCheck, head.getNext());
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
