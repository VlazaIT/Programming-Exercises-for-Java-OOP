package TaskSet3;

import java.util.HashMap;
import java.util.Map;

// Task 2

public class AgeDistributionSimulation {
    public static void main(String[] args) {
        final int SIMULATIONS = 1000; // Number of students to simulate
        final int MAXAGE = 35; // Maximum age to consider

        // Age distribution table: {cumulative percentage, age}
        int[][] ageDistribution = {
                {16, 20}, {34, 21}, {52, 22}, {68, 23}, {82, 24},
                {89, 25}, {94, 26}, {96, 28}, {98, 30}, {100, MAXAGE}
        };

        // HashMap to store the count of generated ages
        Map<Integer, Integer> generatedAges = new HashMap<>();

        // Generate ages according to the distribution
        for (int i = 0; i < SIMULATIONS; i++) {
            int randomPercentage = (int)(Math.random() * 100) + 1;
            int age = findAgeForPercentage(randomPercentage, ageDistribution);
            generatedAges.put(age, generatedAges.getOrDefault(age, 0) + 1);
        }

        // Output the result
        System.out.println("Age  Count    %-Share");
        for (int age = 0; age <= MAXAGE; age++) {
            if (generatedAges.containsKey(age)) {
                double percentage = (double)generatedAges.get(age) / SIMULATIONS * 100;
                System.out.printf("%-4d %-8d %-8.2f%%\n", age, generatedAges.get(age), percentage);
            }
        }
    }

    // Helper method to find age for a given random percentage
    private static int findAgeForPercentage(int percentage, int[][] ageDistribution) {
        for (int[] ageInfo : ageDistribution) {
            if (percentage <= ageInfo[0]) {
                return ageInfo[1];
            }
        }
        return -1; // Return -1 if no age matches the percentage
    }
}
