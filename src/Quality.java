/**
 * Created by arredon on 10/13/2016.
 */
public class Quality {
    private String name;
    private String requirement;
    private String effect;

    public Quality() {
        name = requirement = effect = null;
    }

    public Quality(String name) {
        this.name = name;
        this.requirement = null;
        this.effect = null;
    }

    public Quality(Quality toCopy) {
        copyQuality(toCopy);
    }

    public void copyQuality(Quality toCopy) {
        if (toCopy != null) {
            name = toCopy.name;
            requirement = toCopy.requirement;
            effect = toCopy.effect;
        }
    }
}
