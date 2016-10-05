import java.util.Random;

/**
 * Created by arredon on 9/28/2016.
 */
public class Event{
    private Random rand = new Random();
    private int eventType;
    private String event;

    public Event() {
        eventType = 0;
        event = null;
    }

    public Event(int a) {
        eventType = a;
        Data data = new Data();
        event = data.setEventType(eventType);
    }

    public Event(Event toCopy) {
        this.eventType = toCopy.eventType;
        this.event = new String(toCopy.event);
    }

    public void createRandom() {
        Data data = new Data();
        eventType = rand.nextInt(16) +1;
        event = data.setEventType(eventType);
    }

    public void setEventType() {
        //work on this later (maybe)
    }

    public int getEventInt() {
        return eventType;
    }

    public String getEvent() {
        return event;
    }

    public void display() {
        System.out.println(event);
    }
}
