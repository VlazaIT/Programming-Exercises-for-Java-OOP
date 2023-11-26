package TaskSet3.ArrivalProcessTask;

import TaskSet3.ArrivalProcessTask.eduni.distributions.*;
import java.util.ArrayList;
import java.util.List;
import TaskSet3.ClockTask.*;

// Task 6

public class TestArrivalProcess {
    public static void main(String[] args) {
        List<Event> eventList = new ArrayList<>();
        Clock clock = Clock.getInstance();
        ContinuousGenerator generator = new Negexp(10); // For example, negative exponential distribution
        ArrivalProcess arrivalProcess = new ArrivalProcess(generator, "Arrival");

        for (int i = 0; i < 10; i++) {
            arrivalProcess.generateArrival(eventList, clock);
        }

        eventList.forEach(System.out::println);
    }
}