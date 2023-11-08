// Module 1. Task 3.

package Module1.TaskSet1;

public class CustomerMain {
    public static void main(String[] args) {
        Customer person1 = new Customer();
        Customer person2 = new Customer();

        person1.getId();
        System.out.println("The first person id is " + person1.getId());
        person2.getId();
        System.out.println("The second person id is " + person2.getId());

        // Simulation of the time spent
        try {
            Thread.sleep(1000); // 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        person1.setEndTime(System.currentTimeMillis());

        System.out.println("Person " + person1.getId() + " spent " + person1.timeSpent() + " ms.");
    }
}
