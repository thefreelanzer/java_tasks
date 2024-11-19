package records;

import java.util.ArrayList;
import java.util.List;

public record Course(String id, String courseName, List<Student> enrolledStudent) {
    public Course enrollStudent(Student student) {
        List<Student> students = new ArrayList<>(enrolledStudent);
        students.add(student);
        return new Course(id, courseName, students);
    }
}
