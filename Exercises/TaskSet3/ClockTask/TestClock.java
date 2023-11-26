package TaskSet3.ClockTask;

// Task 5

public class TestClock {
    public static void main(String[] args) {
        Clock clock = Clock.getInstance();
        System.out.println("Initial Time: " + clock.getTime());

        clock.setTime(123456789L);
        System.out.println("Updated Time: " + clock.getTime());

        Clock anotherClockReference = Clock.getInstance();
        System.out.println("Time from another reference: " + anotherClockReference.getTime());
    }
}