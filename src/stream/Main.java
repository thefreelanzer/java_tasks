package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "John doe", 50000));
        employees.add(new Employee(2, "James", 15000));
        employees.add(new Employee(3, "Jacob", 18000));

        // Increment salary
        Consumer<Employee> incrementSalary = employee -> {
            double increment = employee.getSalary() * 0.05;
            employee.setSalary(employee.getSalary() + increment);
        };
        employees.forEach(incrementSalary);
        employees.forEach(n -> System.out.println(n.getId() + " " + n.getName() + ". Salary: " + n.getSalary()));

        // Filter employees with salary greater than 50000
        System.out.println("\nEmployees names with higher salary");
        Predicate<Employee> employeePredicate = employee -> employee.getSalary() > 50000;
        employees.stream().filter(employeePredicate).forEach(e -> System.out.println(e.getName()));
    }
}
