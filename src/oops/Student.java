package oops;

public class Student {
    /**
     * Encapsulate all fields
     * Encapsulation - Hiding data (variables) inside a class
     */
    private int id;
    private String name;
    private String courseName;
    private double gpa;

    /**
     * A parameterized constructor is a type of constructor in Java (or other programming languages) that allows you to -
     * initialize an object with specific values when the object is created
     *
     * @param id         - student id
     * @param name       - student name
     * @param courseName - student course
     * @param gpa        - gpa obtained
     */
    public Student(int id, String name, String courseName, double gpa) {
        this.id = id;
        this.name = name;
        this.courseName = courseName;
        this.gpa = gpa;
    }

    /**
     * Getter methods to access the fields
     */
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getGpa() {
        return gpa;
    }

    /**
     * Setter methods to set the fields
     */
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setId(double gpa) {
        this.gpa = gpa;
    }

    /**
     * Checking student eligibility
     *
     * @return true if student gpa > 3 else return false
     */
    public boolean isEligibleforAdmission() {
        return this.gpa > 3;
    }
}
