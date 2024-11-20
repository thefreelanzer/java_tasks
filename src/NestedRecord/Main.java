package NestedRecord;

import records.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        addEmployees();
        listEmployees(employees);
    }

    private static void addEmployees() {
        // create instanceof address and salary details
        Employee.Address address1 = new Employee.Address("street1", "Tvm", "Kerala", "12345");
        Employee.SalaryDetails salaryDetails1 = new Employee.SalaryDetails(20000, 2000, 1000);
        employees.add(new Employee("1001", "John Doe", address1, salaryDetails1));

        Employee.Address address2 = new Employee.Address("street1", "Tvm", "Kerala", "12345");
        Employee.SalaryDetails salaryDetails2 = new Employee.SalaryDetails(25000, 5000, 5000);
        employees.add(new Employee("1002", "James", address2, salaryDetails2));
    }

    private static void listEmployees(List<Employee> employees) {
        System.out.println("\nList of all Employees:");
        for (Employee employee : employees) {
            employee.displayEmployeeInfo();
        }
    }
}
