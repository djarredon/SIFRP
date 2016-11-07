/**
 * Created by arredon on 9/28/2016.
 */
public class History {
    public EventNode head;

    public History() {
        head = null;
    }

    public History(History toCopy) {
        head = null;
        copyHistory(toCopy);
    }

    public void copyHistory(History toCopy) {
        if (toCopy.head == null) {
            head = null;
        }
        else {
            head = new EventNode(toCopy.head);
            EventNode prevNode = head;
            EventNode thisCurrent;
            EventNode copyCurrent = toCopy.head;
            copyCurrent = copyCurrent.getNext();

            while (copyCurrent != null) {
                thisCurrent = new EventNode(copyCurrent);
                prevNode.setNext(thisCurrent);
                prevNode = prevNode.getNext();
                copyCurrent = copyCurrent.getNext();
            }
        }
    }

    public void insert(Event toAdd) {
        if (head == null) {
            head = new EventNode(toAdd);
        }
        else {
            EventNode temp = new EventNode(toAdd);
            temp.setNext(head);
            head = temp;
        }
    }

    public String printAll() {
        if (head == null)
            return "No History\n";
        EventNode current = head;
        String toReturn = new String();
        while (current != null) {
            toReturn = toReturn.concat(current.print() + "\n");
            current = current.getNext();
        }
        return toReturn;
    }

    public void display() {
        if (head == null)
            System.out.println("No History");
        else {
            EventNode current = head;
            while (current != null) {
                current.display();
                current = current.getNext();
            }
        }
    }
}
