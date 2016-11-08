/**
 * Created by arredon on 10/9/2016.
 */
public class CharacterList {
    CharacterNode head;
    CharacterNode current;

    public CharacterList() {
        head = current = null;
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

    public int getCount() {
        int toReturn = 0;
        if (head == null)
            return toReturn;
        CharacterNode temp = head;
        while (temp != null) {
            ++toReturn;
            temp = temp.getNext();
        }
        return toReturn;
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
            head = current = new CharacterNode(characters);
        else {
            CharacterNode temp = new CharacterNode(characters);
            temp.setNext(head);
            head.setPrev(temp);
            head = temp;
        }
    }

    public void insert(Character toAdd) {
        CharacterNode temp = new CharacterNode(toAdd);
        insert(temp);
    }

    public void copyList(CharacterList toCopy) {
        if (toCopy.head == null)
            head = current = null;
        else {
            head = current = new CharacterNode(toCopy.head);

            CharacterNode copyCurrent = toCopy.head.getNext();
            CharacterNode prevNode = current;
            while (copyCurrent != null) {
                current = new CharacterNode(copyCurrent);
                current.setPrev(prevNode);
                prevNode.setNext(current);

                prevNode = current;
                copyCurrent = copyCurrent.getNext();
            }
            current = head;
        }
    }

    public void moveNext(){
        if (current.getNext() != null)
            current = current.getNext();
    }

    public void movePrevious() {
        if (current.getPrev() != null)
            current = current.getPrev();
    }

    public CharacterNode getCurrent() {
        return current;
    }
}
