package executorservice;

import java.util.concurrent.Callable;

public class calculateSalary implements Callable<String> {
    private Employee employee;

    public calculateSalary(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String call() throws Exception {
        double salary = employee.getHourlyRate() * employee.getHoursWorked();
        return "Employee ID: " + employee.getId() +
                ", Name: " + employee.getName() +
                ", Salary: " + salary;
    }
}
