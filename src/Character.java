/**
 * Created by arredon on 10/9/2016.
 */
public class Character {
    //name
    private String name;
    private String title;
    //bio stuff
    //stats

    public Character() {
        Data data = new Data();
        name = data.randName();
        title = null;
    }

    public Character(String name) {
        this.name = name;
        title = null;
    }

    public Character(Character toCopy) {
        copyCharacter(toCopy);
    }

    public void copyCharacter(Character toCopy) {
        this.name = toCopy.name;
        this.title = toCopy.title;
    }

    public void display() {
        if (title != null)
            System.out.print(title + " ");
        System.out.println(name);
    }
}
