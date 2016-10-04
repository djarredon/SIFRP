/**
 * Created by arredon on 9/30/2016.
 */
public class HouseList {
    private HouseNode head;

    public HouseList() {
        head = null;
    }

    public HouseList(HouseNode head) {
        head = new HouseNode(head);
    }

    public HouseList(HouseList toCopy) {
        head = null;
        if (toCopy != null)
            copyList(toCopy);
    }

    public void copyList(HouseList toCopy) {
        if (toCopy.head == null)
            head = null;
        else {
            head = new HouseNode(toCopy.head);
            HouseNode prevNode = head;
            HouseNode thisCurrent;
            HouseNode copyCurrent = toCopy.head;
            copyCurrent = copyCurrent.getNext();

            while (copyCurrent != null) {
                thisCurrent = new HouseNode(copyCurrent);
                prevNode.setNext(thisCurrent);
                prevNode = prevNode.getNext();
                copyCurrent = copyCurrent.getNext();
            }
        }
    }

    public void insert(HouseNode toAdd) {
        if (head == null)
            head = new HouseNode(toAdd);
        else {
            HouseNode temp = new HouseNode(toAdd);
            temp.setNext(head);
            head = temp;
        }
    }

    public void display() {
        if (head == null)
            System.out.println("No Houses to display.");
        else {
            HouseNode current = head;
            while (current != null) {
                current.displayAll();
                current = current.getNext();
            }
        }
    }
}
