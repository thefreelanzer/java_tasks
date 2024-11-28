package executorservice;

public class Employee {
    private int id;
    private String name;
    private double hourlyRate;
    private int hoursWorked;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public Employee(int id, String name, double hourlyRate, int hoursWorked) {
        this.id = id;
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
}
