package lms;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends User {
    /**
     * declares a private List<String> named teachingCourses and initializes it as a new empty ArrayList
     */
    private List<String> teachingCourses = new ArrayList<>();

    /**
     * defines the constructor for the Student
     *
     * @param name
     * @param username
     * @param password
     */
    public Instructor(String name, String username, String password) {
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
        System.out.println("Courses enrolled by " + name + ": " + teachingCourses);
    }

    public List<String> getEnrolledCourses() {
        return teachingCourses;
    }

    public void setEnrolledCourses(List<String> teachingCourses) {
        this.teachingCourses = teachingCourses;
    }

    public void enrollCourse(String course) {
        teachingCourses.add(course);
    }
}
