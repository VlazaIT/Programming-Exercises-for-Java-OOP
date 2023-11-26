package TaskSet3.ArrivalProcessTask;

import TaskSet3.ArrivalProcessTask.eduni.distributions.*;
import java.util.List;
import TaskSet3.ClockTask.*;

// Task 6

class Event {
    long time;
    String type;

    Event(long time, String type) {
        this.time = time;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Event{" + "time=" + time + ", type='" + type + '\'' + '}';
    }
}

class ArrivalProcess {
    private ContinuousGenerator generator;
    private String eventType;

    ArrivalProcess(ContinuousGenerator generator, String eventType) {
        this.generator = generator;
        this.eventType = eventType;
    }

    void generateArrival(List<Event> eventList, Clock clock) {
        double interval = generator.sample();
        long newEventTime = clock.getTime() + (long) interval;
        clock.setTime(newEventTime);
        eventList.add(new Event(newEventTime, eventType));
    }
}

