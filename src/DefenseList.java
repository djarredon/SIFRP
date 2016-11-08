import java.util.zip.DeflaterInputStream;

/**
 * Created by arredon on 10/7/2016.
 */
public class DefenseList {
    DefenseNode head;

    public DefenseList() {
        head = null;
    }

    public DefenseList(DefenseList castle) {
        copyList(castle);
    }

    public String printAll() {
        if (head == null)
            return "No Defense Holdings\n";
        DefenseNode current = head;
        String toReturn = new String();
        while (current != null) {
            toReturn = toReturn.concat(current.print());
            current = current.getNext();
        }
        return toReturn;
    }

    public int getCost() {
        int toReturn = 0;
        if (head == null)
            return toReturn;
        else {
            DefenseNode current = head;
            while (current != null) {
                toReturn += current.getCost();
                current = current.getNext();
            }
            return toReturn;
        }
    }

    public void display() {
        if (head == null)
            System.out.println("No Defense Holdings");
        else {
            DefenseNode current = head;
            while (current != null) {
                current.display();
                current = current.getNext();
            }
        }
    }

    public void insert(DefenseNode castle) {
        if (head == null)
            head = new DefenseNode(castle);
        else {
            DefenseNode temp = new DefenseNode(castle);
            temp.setNext(head);
            head = temp;
        }
    }

    public boolean hasHolding(String toCheck) {
        return hasHolding(toCheck, head);
    }

    private boolean hasHolding(String toCheck, DefenseNode head) {
        if (head == null)
            return false;
        if (head.getName().equalsIgnoreCase(toCheck))
            return true;
        return hasHolding(toCheck, head.getNext());
    }

    public void copyList(DefenseList toCopy) {
        if (toCopy.head == null)
            head = null;
        else {
            head = new DefenseNode(toCopy.head);
            DefenseNode prevNode = head;
            DefenseNode thisCurrent;
            DefenseNode copyCurrent = toCopy.head;
            copyCurrent = copyCurrent.getNext();

            while (copyCurrent != null) {
                thisCurrent = new DefenseNode(copyCurrent);
                prevNode.setNext(thisCurrent);
                prevNode = prevNode.getNext();
                copyCurrent = copyCurrent.getNext();
            }
        }
    }
}
