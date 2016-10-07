import java.util.zip.DeflaterInputStream;

/**
 * Created by arredon on 10/7/2016.
 */
public class DefenseList {
    DefenseNode head;

    public DefenseList() {
        head = null;
    }

    public DefenseList(DefenseList domains) {
        copyList(domains);
    }

    public void display() {
        if (head == null)
            System.out.println("No Features");
        else {
            DefenseNode current = head;
            while (current != null) {
                current.display();
                current = current.getNext();
            }
        }
    }

    public void insert(DefenseNode domain) {
        if (head == null)
            head = new DefenseNode(domain);
        else {
            DefenseNode temp = new DefenseNode(domain);
            temp.setNext(head);
            head = temp;
        }
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
