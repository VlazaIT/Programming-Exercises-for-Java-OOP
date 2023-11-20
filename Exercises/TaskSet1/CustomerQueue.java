// Module 1. Task 4.

package TaskSet1;

import java.util.LinkedList;
import java.util.Scanner;

public class CustomerQueue {
    private static final LinkedList<Customer> queue = new LinkedList<>();

    private static void enqueueCustomer() {
        Customer customer = new Customer();
        queue.addFirst(customer);
        System.out.println("Customer with ID: " + customer.getId() + " has entered the queue.");
    }

    private static void dequeueCustomer() {
        if (!queue.isEmpty()) {
            Customer customer = queue.removeLast();
            customer.setEndTime(System.nanoTime());
            long timeSpent = customer.timeSpent();
            System.out.println("Customer with ID: " + customer.getId() + " has been served.");
            System.out.println("Time spent in queue: " + timeSpent + " ms");
        } else {
            System.out.println("The queue is empty. No customers to serve.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("\nChoose an action: (enqueue, dequeue, exit) ");
            input = scanner.nextLine().trim();

            switch (input) {
                case "enqueue":
                    enqueueCustomer();
                    break;
                case "dequeue":
                    dequeueCustomer();
                    break;
                case "exit":
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid input. Please type 'enqueue', 'dequeue', or 'exit'.");
                    break;
            }
        }
    }

}
