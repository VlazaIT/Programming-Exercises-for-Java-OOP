package TaskSet3.ClockTask;

// Task 5

public class Clock {
    private static Clock instance;
    private long time;

    private Clock() {
        time = System.currentTimeMillis();
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