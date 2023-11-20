// Module 1. Task 5.

package TaskSet1;

import java.util.LinkedList;

public class ServicePoint {
    private LinkedList<Customer> queue = new LinkedList<>();
    private long totalServiceTime = 0;
    private int customersServed = 0;

    public void addToQueue(Customer customer) {
        queue.add(customer);
    }

    public Customer removeFromQueue() {
        if (!queue.isEmpty()) {
            return queue.removeFirst();
        } else {
            return null;
        }
    }

    public void serve() {
        while (!queue.isEmpty()) {
            Customer customer = removeFromQueue();
            if (customer != null) {
                // Simulate service time
                long sleeptime = (long) (Math.random() * 1000);
                try {
                    Thread.sleep(sleeptime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                customer.setEndTime(System.currentTimeMillis());
                long timeInService = sleeptime;
                long responseTime = customer.timeSpent() + sleeptime;
                System.out.println("Customer ID: " + customer.getId() +
                        " served with response time: " + responseTime + " ms and " +
                        "time in service: " + timeInService + " ms");
                totalServiceTime += timeInService;
                customersServed++;
            }
        }
    }

    public long getAverageServiceTime() {
        if (customersServed > 0) {
            return totalServiceTime / customersServed;
        } else {
            return 0; // In case there are no customers served
        }
    }

    public class CustomerGenerator {
        public static void generateCustomers(ServicePoint servicePoint, int numberOfCustomers) {
            for (int i = 0; i < numberOfCustomers; i++) {
                Customer customer = new Customer();
                servicePoint.addToQueue(customer);
            }
        }
    }

    public static void main(String[] args) {
        ServicePoint servicePoint = new ServicePoint();
        CustomerGenerator.generateCustomers(servicePoint, 5); // example to generate 5 customers
        servicePoint.serve();
    }
}
