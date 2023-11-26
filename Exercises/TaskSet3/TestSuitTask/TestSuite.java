package TaskSet3.TestSuitTask;

// Task 7

import java.util.LinkedList;
import java.util.Queue;
import TaskSet3.ArrivalProcessTask.eduni.distributions.*;

class Customer {
    long arrivalTime;

    Customer(long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}

class Clock {
    private static Clock instance;
    private long time;

    private Clock() {
        time = 0;
    }

    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    public void setTime(long newTime) {
        time = newTime;
    }

    public long getTime() {
        return time;
    }
}

class Event {
    long time;
    String type;

    Event(long time, String type) {
        this.time = time;
        this.type = type;
    }
}

class ArrivalProcess {
    private ContinuousGenerator generator;
    private String eventType;

    ArrivalProcess(ContinuousGenerator generator, String eventType) {
        this.generator = generator;
        this.eventType = eventType;
    }

    void generateArrival(Queue<Event> eventList, Clock clock) {
        double interval = generator.sample();
        long newEventTime = clock.getTime() + (long) interval;
        eventList.add(new Event(newEventTime, eventType));
    }
}

class ServicePoint {
    Queue<Customer> queue = new LinkedList<>();

    void addCustomer(Customer customer) {
        queue.add(customer);
    }

    Customer serveCustomer() {
        return queue.poll();
    }
}

public class TestSuite {
    public static void main(String[] args) {
        Queue<Event> eventList = new LinkedList<>();
        Clock clock = Clock.getInstance();
        ContinuousGenerator generator = new Negexp(10); // Example generator
        ArrivalProcess arrivalProcess = new ArrivalProcess(generator, "Arrival");
        ServicePoint servicePoint = new ServicePoint();

        // Generate and process arrival events
        for (int i = 0; i < 10; i++) {
            arrivalProcess.generateArrival(eventList, clock);
            clock.setTime(eventList.peek().time);
            servicePoint.addCustomer(new Customer(clock.getTime()));
            eventList.poll();
        }

        // Advance the clock
        clock.setTime(clock.getTime() + 5);

        // Serve customers and calculate time in system
        while (!servicePoint.queue.isEmpty()) {
            Customer customer = servicePoint.serveCustomer();
            long timeInSystem = clock.getTime() - customer.arrivalTime;
            System.out.println("Customer Time in System: " + timeInSystem);
        }
    }
}

