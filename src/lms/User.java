package lms;

import java.util.ArrayList;
import java.util.List;

abstract class User {
    protected String name;
    protected String username;
    protected String password;

    private static List<Student> students = new ArrayList<>();
    private static List<Instructor> instructors = new ArrayList<>();
    private static List<Admin> admins = new ArrayList<>();

    /**
     * constructor
     *
     * @param name
     * @param username
     * @param password
     */
    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    /**
     * Getter for return name of user
     *
     * @return name
     */
    public String getUserName() {
        return this.username;
    }

    public String getName() {
        return this.name;
    }

    /**
     * created abstract method in common this will be overridden
     */
    public abstract void displayCourses();


    /**
     * Static factory method to create a User based on type
     */
    public static User createUser(int userType, String name, String username, String password) {
        switch (userType) {
            case 1 -> {
                Student student = new Student(name, username, password);
                students.add(student);  // Add student to the list
                return student;
            }
            case 2 -> {
                Instructor instructor = new Instructor(name, username, password);
                instructors.add(instructor);  // Add instructor to the list
                return instructor;
            }
            case 3 -> {
                Admin admin = new Admin(name, username, password);
                admins.add(admin);  // Add admin to the list
                return admin;
            }
            default -> {
                return null;
            }
        }
    }

    /**
     * abstract method to return userType
     */
    public abstract String getUserType();


    // Methods to list users by type
    public static void listAllStudents() {
        for (Student student : students) {
            System.out.println(student);
            System.out.println(student.getName() + " (" + student.getUserName() + ") - " + student.getEnrolledCourses());
        }
    }

    public static void listAllInstructors() {
        for (Instructor instructor : instructors) {
            System.out.println(instructor.getName() + " (" + instructor.getUserName() + ") - " + instructor.getEnrolledCourses());
        }
    }

    public static void listAllAdmins() {
        for (Admin admin : admins) {
            System.out.println(admin.getName() + " (" + admin.getUserName() + ")");
        }
    }
}

