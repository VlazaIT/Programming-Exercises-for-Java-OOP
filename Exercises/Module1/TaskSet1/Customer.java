// Module 1. Task 3.

package Module1.TaskSet1;

public class Customer {
    private static int lastId = 0;
    private int id;
    private long startTime;
    private long endTime;

    public Customer() {
        lastId++;
        this.id = lastId;
        this.startTime = System.currentTimeMillis();
    }

    public int getId() {
        //System.out.println("The id of the following person is: " + id);
        return id;
    }

//    public long getStartTime() {
//        return startTime;
//    }
//
//    public void setStartTime(long startTime) {
//        this.startTime = startTime;
//    }
//
//    public long getEndTime() {
//        return endTime;
//    }

    public void setEndTime(long endTime) {
        this.endTime = System.currentTimeMillis();
    }

    public long timeSpent() {
        // System.out.println("Time spent is: " + (endTime - startTime) + " ms");
        return endTime - startTime;
    }
}


