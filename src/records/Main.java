package records;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a collection of students and courses
        List<Student> students = new ArrayList<>();
        List<Course> courses = new ArrayList<>();

        students.add(new Student("S1", "John doe"));
        students.add(new Student("S1", "James"));
        students.add(new Student("S1", "Jake"));

        // Print all students
        listAllStudents(students);

        courses.add(new Course("C1", "Introduction to Java", new ArrayList<>()));
        courses.add(new Course("C1", "Data Structures", new ArrayList<>()));
        courses.add(new Course("C1", "Web Development", new ArrayList<>()));

        // Print all courses
        listAllCourses(courses);

        Course selectedCourse = courses.getFirst(); // get first element
        selectedCourse.enrollStudent(students.get(1));

        // Print all courses
        listAllCourses(courses);
    }

    private static void listAllStudents(List<Student> students) {
        System.out.println("\nList of all students:");
        for (Student student : students) {
            System.out.println("ID: " + student.id() + ", Name: " + student.name());
        }
    }

    private static void listAllCourses(List<Course> courses) {
        System.out.println("\nList of all courses:");
        for (Course course : courses) {
            System.out.println(course.courseName());
            System.out.println("*---------------*");
            for (Student student : course.enrolledStudent()) {
                System.out.println(student.id() + ". " + student.name());
            }
            System.out.println("\n");
        }
    }
}
