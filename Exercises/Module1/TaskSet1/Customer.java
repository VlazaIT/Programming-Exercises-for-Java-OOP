// Module 1. Task 3.

package Module1.TaskSet1;

public class Customer {
    private static int lastId = 0;
    private int id;
    private long startTime;
    private long endTime;

    private Customer() {
        lastId++;
        this.id = lastId;
        this.startTime = System.currentTimeMillis();
    }

    private int getId() {
        System.out.println("The id of the following person is: " + id);
        return id;
    }
    private long getStartTime() {
        return startTime;
    }

    private void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long timeSpent() {
        System.out.println("Time spent is: " + (endTime - startTime) + " ms");
        return endTime - startTime;
    }

    public static void main(String[] args) {
        Customer person1 = new Customer();
        Customer person2 = new Customer();

        person1.getId();
        person2.getId();

        // Simulation of the time spent
        try {
            Thread.sleep(1000); // 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        person1.setEndTime(System.currentTimeMillis());

        person1.timeSpent();

    }
}
