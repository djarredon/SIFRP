/**
 * Created by arredon on 9/30/2016.
 */
public class HouseList {
    private HouseNode head;
    private HouseNode current;
    private int num;

    public HouseList() {
        head = null;
        current = null;
    }

    public HouseList(HouseNode head) {
        head = new HouseNode(head);
    }

    public HouseList(HouseList toCopy) {
        head = null;
        if (toCopy != null)
            copyList(toCopy);
    }

    public String printCurrent() {
        if (current != null)
            return current.printAll();
        return "No Houses in list.";
    }

    public HouseNode getCurrent() {
        return current;
    }

    public void moveNext() {
        if (current != null)
            if (current.getNext() != null)
                current = current.getNext();
    }

    public void movePrev() {
        if (current != null)
            if (current.getPrev() != null)
                current = current.getPrev();
    }


    public void copyList(HouseList toCopy){
        if (toCopy.head == null) {
            head = current = null;
            num = 0;
        }
        else {
            head = new HouseNode(toCopy.head);
            current = head;
            ++num;
            HouseNode copyCurrent = toCopy.head.getNext();
            HouseNode prevNode = head;

            while (copyCurrent != null) {
                current = new HouseNode(copyCurrent);
                current.setPrev(prevNode);
                prevNode.setNext(current);
                prevNode = prevNode.getNext();
                copyCurrent = copyCurrent.getNext();
                ++num;
            }
        }
    }
/*
    public void copyList(HouseList toCopy) {
        if (toCopy.head == null) {
            head = null;
            current = null;
            num = 0;
        }
        else {
            head = new HouseNode(toCopy.head);
            current = head;
            ++num;
            HouseNode prevNode = head;
            HouseNode thisCurrent;
            HouseNode copyCurrent = toCopy.head;
            copyCurrent = copyCurrent.getNext();

            while (copyCurrent != null) {
                thisCurrent = new HouseNode(copyCurrent);
                prevNode.setNext(thisCurrent);
                prevNode = prevNode.getNext();
                copyCurrent = copyCurrent.getNext();
                ++num;
            }
        }
    }
    */

    public void insert(HouseNode toAdd) {
        if (head == null) {
            head = new HouseNode(toAdd);
            current = head;
            num = 1;
        }
        else {
            HouseNode temp = new HouseNode(toAdd);
            HouseNode trail = head;
            HouseNode current = head;
            while (current != null) {
                trail = current;
                current = current.getNext();
            }
            trail.setNext(temp);
            temp.setPrev(trail);
            ++num;
        }
    }

    /*
    public void insert(HouseNode toAdd) {
        if (head == null) {
            head = new HouseNode(toAdd);
            num = 1;
        }
        else {
            HouseNode temp = new HouseNode(toAdd);
            temp.setNext(head);
            head = temp;
            ++num;
        }
    }
    */

    public int getNum() {
        return num;
    }

    public String printList() {
        String toReturn = new String();
        if (head == null)
            toReturn = "No Houses to display.";
        else {
            HouseNode current = head;
            while (current != null) {
                if (current.getIsBanner())
                    toReturn = toReturn.concat("----------------------------------------");
                toReturn = toReturn.concat(current.printAll() + "\n");
                current = current.getNext();
            }
        }
        return toReturn;
    }

    public void display() {
        if (head == null)
            System.out.println("No Houses to display.");
        else {
            HouseNode current = head;
            while (current != null) {
                if (current.getIsBanner())
                    System.out.println("----------------------------------------");
                current.displayAll();
                current = current.getNext();
            }
        }
    }
}
