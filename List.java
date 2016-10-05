/**
 * Created by arredon on 9/19/2016.
 */
public class List {

    Node head;
    int length;

    List () {
        head = null;
        length = 0;
    }

    public void display() {
        if (head == null)
            System.out.println("No List to display.");
        else {
            Node current = head;
            while (current != null) {
                System.out.println(current.num);
                current = current.next;
            }
        }
    }

    public int getLength() {
        return length;
    }

    public int getMedian() {
        if (length == 0)
            return length;

        Node current = head;
        int i = 0;
        while (current != null && i++ < length/2)
            current = current.next;
        if (current == null)
            return 0;
        return current.num;
    }

    public int result(int diceNum) {
        if (head == null) {
            return length = 0;
        }
        else{
            Node current = head;
            int i = 1;
            int num = 0;
            while (current != null && i++ <= diceNum) {
                num += current.num;
                current = current.next;
            }
            return num;
        }
    }

    public int result() {
        if (head == null)
            return length = 0;
        else {
            Node current = head;
            int num = 0;
            while (current != null) {
                num += current.num;
                current = current.next;
            }
            return num;
        }
    }

    public void empty() {
        head = null;
    }

    public int sortAdd(int numToAdd) {
        ++length;

        if (head == null) {
            head = new Node(numToAdd);
            return 1;
        } else {
            Node current = head;
            Node trail = head;

            if (numToAdd > head.num) {
                Node toadd = new Node(numToAdd);
                toadd.next = head;
                head = toadd;
                return 2;
            }

            trail = head;
            current = current.next;

            while (current != null && numToAdd < current.num) {
                trail = current;
                current = current.next;
            }

            if (current == null) {
                current = new Node(numToAdd);
                trail.next = current;
                return 3;
            } else {
                Node toadd = new Node(numToAdd);
                toadd.next = current;
                trail.next = toadd;
                return 4;
            }
        }
    }

    class Node {
        int num;
        Node next;

        Node (int num) {
            this.num = num;
            next = null;
        }

        Node (Node toCopy) {
            num = toCopy.num;
            next = null;
        }
    }
}
