/**
 * Created by arredon on 10/1/2016.
 */
public class FeatureList {
    private FeatureNode head;

    public FeatureList() {
        head = null;
    }

    public FeatureList(Feature feature) {
        head = null;
        insert(feature);
    }

    public FeatureList(FeatureList toCopy) {
        head = null;
        copyList(toCopy);
    }

    public void display() {
        if (head == null)
            System.out.println("No Features");
        else {
            FeatureNode current = head;
            while (current != null) {
                current.display();
                current = current.getNext();
            }
        }
    }

    public int getCost() {
        if (head == null)
            return 0;
        else {
            FeatureNode current = head;
            int cost = 0;
            while (current != null) {
                cost += current.getCost();
                current = current.getNext();
            }
            return cost;
        }
    }

    public void insert(Feature feature) {
        if (head == null)
            head = new FeatureNode(feature);
        else {
            FeatureNode temp = new FeatureNode(feature);
            temp.setNext(head);
            head = temp;
        }
    }

    public void copyList(FeatureList toCopy) {
        if (toCopy.head == null)
            head = null;
        else {
            head = new FeatureNode(toCopy.head);
            FeatureNode prevNode = head;
            FeatureNode thisCurrent;
            FeatureNode copyCurrent = toCopy.head;
            copyCurrent = copyCurrent.getNext();

            while (copyCurrent != null) {
                thisCurrent = new FeatureNode(copyCurrent);
                prevNode.setNext(thisCurrent);
                prevNode = prevNode.getNext();
                copyCurrent = copyCurrent.getNext();
            }
        }
    }
}
