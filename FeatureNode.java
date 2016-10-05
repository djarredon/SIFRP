/**
 * Created by arredon on 10/1/2016.
 */
public class FeatureNode extends Feature{
    private FeatureNode next;

    public FeatureNode() {
        super();
        next = null;
    }

    public FeatureNode(int featureType) {
        super(featureType);
        next = null;
    }

    public FeatureNode(Feature toCopy) {
        super(toCopy);
        next = null;
    }

    public void setNext(FeatureNode next) {
        this.next = next;
    }

    public FeatureNode getNext() {
        return next;
    }
}
