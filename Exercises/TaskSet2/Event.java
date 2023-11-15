package TaskSet2;

// Task 2

public class Event implements Comparable<Event> {
    private long eventTime;
    private EventType eventType;

    public Event(long eventTime, EventType eventType) {
        this.eventTime = eventTime;
        this.eventType = eventType;
    }

    public long getEventTime() {
        return eventTime;
    }

    public EventType getEventType() {
        return eventType;
    }

    @Override
    public int compareTo(Event other) {
        return Long.compare(this.eventTime, other.eventTime);
    }
}