/**
 * Created by arredon on 10/13/2016.
 */
public class DrawbackList {
    DrawbackNode head;

    public DrawbackList() {
        head = null;
    }

    public void display() {
        if (head == null) {
            System.out.println("No Flaws");
        }
        else {
            DrawbackNode current = head;
            while (current != null) {
                current.display();
                current = current.getNext();
            }
        }
    }

    public void insert(DrawbackNode in) {
        if (head == null) {
            head = new DrawbackNode(in);
        }
        else {
            DrawbackNode temp = new DrawbackNode(in);
            temp.setNext(head);
            head = temp;
        }
    }
}
