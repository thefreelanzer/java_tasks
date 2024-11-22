package stream.assignment10;

import java.util.*;
import java.util.stream.Collectors;

public class Employee {
    int id;
    String name;
    int age;
    String gender;
    String department;
    String yearOfJoining;
    Double Salary;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public String getYearOfJoining() {
        return yearOfJoining;
    }

    public Double getSalary() {
        return Salary;
    }

    public Employee(int id, String name, int age, String gender, String department, String yearOfJoining, Double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        Salary = salary;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John Doe", 30, "Female", "Development", "2020", 50000.00),
                new Employee(2, "James", 35, "Male", "SEO", "2023", 45000.00),
                new Employee(3, "Jake", 50, "Male", "Networking", "2019", 60000.00),
                new Employee(4, "Michelle", 25, "Female", "Networking", "2019", 35000.0)
        );

        // Departments
        System.out.println("Departments");
        System.out.println("------------");
        List<String> departments = employees.stream()
                .map(i -> i.getDepartment())
                .distinct()                   // Remove duplicates
                .collect(Collectors.toList());
        departments.forEach(d -> System.out.println(d));

        // Average age of male and female
        Map<String, Double> averageAgeByGender = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getGender,
                        Collectors.averagingDouble(Employee::getAge)
                ));
        System.out.println("\nAverage age by Gender:");
        averageAgeByGender.forEach((gender, averageAge) ->
                System.out.println(gender + ": " + averageAge));


        // Highest paid employee
        Optional<Employee> highestPaidEmployee = employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary));
        highestPaidEmployee.ifPresent(employee -> {
            System.out.println("\nHighest paid employee:");
            System.out.println(employee.getName() + ". Salary:" + employee.getSalary());
        });

        // Group employees by department
        Map<String, Long> employeesCountByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("\nNumber of employees in each department:");
        employeesCountByDepartment.forEach((department, count) ->
                System.out.println(department + ": " + count));

        // System.out.println("\nEmployees age > 25:");
        // employees.stream().filter(i -> i.getAge() > 25).forEach(i -> System.out.println(i.getName()));
        // System.out.println("\nEmployees age < 25:");
        // employees.stream().filter(i -> i.getAge() <= 25).forEach(i -> System.out.println(i.getName()));

        Map<Boolean, List<Employee>> partitionedEmployees = employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getAge() <= 25));

        System.out.println("\nEmployees aged 25 or younger:");
        partitionedEmployees.get(true).forEach(i -> System.out.println(i.getName()));

        System.out.println("\nEmployees older than 25:");
        partitionedEmployees.get(false).forEach(i -> System.out.println(i.getName()));
    }

}
