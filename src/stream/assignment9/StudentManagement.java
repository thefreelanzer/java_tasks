package stream.assignment9;

import stream.assignment9.student.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StudentManagement {
    public static void main(String[] args) {
        List<Students> students = Arrays.asList(
                new Students(1, "A", "Female", "10th", "A+"),
                new Students(2, "B", "Female", "10th", "C"),
                new Students(3, "C", "Male", "10th", "C"),
                new Students(4, "D", "Female", "10th", "A+") // Duplicate key (name)
        );

        Predicate<Students> females = (student) -> student.getGender().equals("Female");

        System.out.println("All girl students:");
        students.stream()
                .filter(females)
                .forEach(i -> System.out.println(i.getName()));

        Predicate<Students> gradesScenario = (student) -> Arrays.asList("A+", "A", "B").contains(student.getGrade());
        System.out.println("\nStudents with grades A+, A, and B:");
        students.stream()
                .filter(gradesScenario)
                .forEach(i -> System.out.println(i.getName()));
    }
}

