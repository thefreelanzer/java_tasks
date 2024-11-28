package executorservice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SalaryCalculator {
    public static void main(String[] args) {
        /**
         * Create employee
         */
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", 20.0, 40),
                new Employee(2, "Jacob", 15.5, 35),
                new Employee(3, "James", 25.0, 45),
                new Employee(4, "Jose", 30.0, 40)
        );

        /**
         * This creates an ExecutorService with a fixed thread pool of 2 threads
         *
         * The thread pool can execute up to 2 tasks concurrently.
         * If more than 2 tasks are submitted, they are placed in a queue and will wait until a thread becomes available
         */
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // List to store Future results from the submitted tasks
        List<Future<String>> results;

        try {

            results = executor.invokeAll(
                    employees.stream()
                            .map(calculateSalary::new) // Map each Employee to a new calculateSalary
                            .toList()
            );

            // Print results
            for (Future<String> result : results) {
                try {
                    System.out.println(result.get()); // Get and print the task result
                } catch (ExecutionException e) {
                    System.err.println("Task execution failed: " + e.getMessage());
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Task execution interrupted: " + e.getMessage());
        } finally {
            // Shut down the executor
            executor.shutdown();
        }
    }
}
