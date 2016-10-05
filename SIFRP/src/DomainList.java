/**
 * Created by arredon on 10/1/2016.
 */
public class DomainList {
    private DomainNode head;

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
            FeatureNode temp = new FeatureNode(domain);
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
