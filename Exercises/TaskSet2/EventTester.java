package TaskSet2;

// Task 2

public class EventTester {
    public static void main(String[] args) {
        EventList eventList = new EventList();

        eventList.addEvent(new Event(1000, EventType.ARRIVAL));
        eventList.addEvent(new Event(500, EventType.EXIT));
        eventList.addEvent(new Event(1500, EventType.ARRIVAL));
        eventList.addEvent(new Event(1900, EventType.EXIT));

        // Remove the first sequential event
        eventList.getNextEvent();

        // Print remaining events
        Event event;
        while ((event = eventList.getNextEvent()) != null) {
            System.out.println("Event Time: " + event.getEventTime() + ", Type: " + event.getEventType());
        }
    }
}
