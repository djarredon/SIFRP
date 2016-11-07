/**
 * Created by arredon on 11/5/2016.
 */
public class WealthList {
    private WealthNode head;
    private WealthNode current;

    public WealthList() {
        head = null;
        current = null;
    }

    public WealthList(WealthList toCopy) {
        head = null;
        current = null;
        copyList(toCopy);
    }

    public void insert(WealthNode toAdd) {
        if (head == null) {
            head = new WealthNode(toAdd);
            current = head;
        }
        else {
            WealthNode temp = head;
            WealthNode trail = head;
            while (temp != null) {
                trail = temp;
                temp = temp.getNext();
            }
            temp = new WealthNode(toAdd);
            trail.setNext(temp);
            temp.setPrev(trail);
        }
    }

    public String printAll() {
        return printAll(head);
    }

    private String printAll(WealthNode head) {
        if (head == null)
            return "";
        return head.print() + "\n" + printAll(head.getNext());
    }

    public boolean hasHolding(String toCheck) {
        if (head == null)
            return false;
        return hasHolding(toCheck, head);
    }

    private boolean hasHolding(String toCheck, WealthNode head) {
        if (head == null)
            return false;
        if (head.getName().equalsIgnoreCase(toCheck))
            return true;
        return hasHolding(toCheck, head.getNext());
    }

    public void copyList(WealthList toCopy) {
        if (toCopy.head == null)
            head = current = null;
        else {
            head = new WealthNode(toCopy.head);
            current = head;

            WealthNode copyCurrent = toCopy.head.getNext();
            WealthNode tail = toCopy.head;
            head.setNext(copyCurrent);
            while (copyCurrent != null) {
                current = new WealthNode(toCopy.current);
                current.setPrev(tail);
                tail.setNext(current);

                copyCurrent = copyCurrent.getNext();
            }
        }
    }
}
