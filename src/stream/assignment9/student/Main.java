package stream.assignment9.student;

import com.sun.jdi.ArrayReference;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("John", 20),
                new Student("James", 22),
                new Student("Jacob", 25),
                new Student("John", 23) // Duplicate key (name)
        );

        Map<String, Integer> studentMap = students.stream()
                .collect(Collectors.toMap(
                        Student::getName,     // Key
                        Student::getAge,      // Value
                        (oldValue, newValue) -> oldValue // Preserve old value for duplicates
                ));
        studentMap.forEach((name, age) -> System.out.println(name + " -> " + age));
    }

}
