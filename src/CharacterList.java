/**
 * Created by arredon on 10/9/2016.
 */
public class CharacterList {
    CharacterNode head;

    public CharacterList() {
        head = null;
    }

    public CharacterList(CharacterList characters) {
        copyList(characters);
    }

    public void displayAll() {
        if (head == null)
            System.out.println("No Characters");
        else {
            CharacterNode current = head;
            while (current != null) {
                current.displayAll();
                current = current.getNext();
            }
        }
    }

    public String printAll() {
        if (head == null)
            return "\nNo Characters";
        CharacterNode current = head;
        String toReturn = new String();
        while (current != null) {
            toReturn = toReturn.concat(current.getName());
            current = current.getNext();
        }
        return  toReturn;
    }

    public void displayNames() {
        if (head == null)
            System.out.println("No Characters");
        else {
            CharacterNode current = head;
            while (current != null) {
                current.displayName();
                current = current.getNext();
            }
        }
    }

    public String printNames() {
        if (head == null)
            return "No Characters";
        CharacterNode current = head;
        String toReturn = new String();
        while (current != null) {
            toReturn = toReturn.concat(current.getName() + "\n");
            current = current.getNext();
        }
        return toReturn;
    }

    public void insert(CharacterNode characters) {
        if (head == null)
            head = new CharacterNode(characters);
        else {
            CharacterNode temp = new CharacterNode(characters);
            temp.setNext(head);
            head = temp;
        }
    }

    public void insert(Character toAdd) {
        CharacterNode temp = new CharacterNode(toAdd);
        insert(temp);
    }

    public void copyList(CharacterList toCopy) {
        if (toCopy.head == null)
            head = null;
        else {
            head = new CharacterNode(toCopy.head);
            CharacterNode prevNode = head;
            CharacterNode thisCurrent;
            CharacterNode copyCurrent = toCopy.head;
            copyCurrent = copyCurrent.getNext();

            while (copyCurrent != null) {
                thisCurrent = new CharacterNode(copyCurrent);
                prevNode.setNext(thisCurrent);
                prevNode = prevNode.getNext();
                copyCurrent = copyCurrent.getNext();
            }
        }
    }
}
