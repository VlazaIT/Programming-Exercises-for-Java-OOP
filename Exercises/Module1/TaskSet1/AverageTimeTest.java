// Module 1. Task 6.

package Module1.TaskSet1;

public class AverageTimeTest {
    public static void main(String[] args) {
        final int runs = 5;

        for (int i = 0; i < runs; i++) {
            ServicePoint servicePoint = new ServicePoint();
            ServicePoint.CustomerGenerator.generateCustomers(servicePoint, 5);
            servicePoint.serve();

            long averageServiceTime = servicePoint.getAverageServiceTime();
            System.out.println("Run " + (i + 1) + ": Average Service Time = " + averageServiceTime + " ms");
        }
    }
}
