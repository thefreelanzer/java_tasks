package lms;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    /**
     * declares a private List<String> named enrolledCourses and initializes it as a new empty ArrayList
     */
    private List<String> enrolledCourses = new ArrayList<>();

    /**
     * defines the constructor for the Student
     * @param name
     * @param username
     * @param password
     */
    public Student(String name, String username, String password) {
        /**
         * The super() method is called to invoke the constructor of the parent class (User)
         */
        super(name, username, password);
    }

    /**
     * Use the function to override
     * Display all the courses enrolled to Student
     */
    @Override
    public void displayCourses() {
        System.out.println("Courses enrolled by " + name + ": " + enrolledCourses);
    }

    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<String> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public void enrollCourse(String course) {
        enrolledCourses.add(course);
    }
}