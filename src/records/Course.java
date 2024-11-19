package records;

import java.util.ArrayList;
import java.util.List;

public record Course(String id, String courseName, List<Student> enrolledStudent) {
    public void enrollStudent(Student student) {
        enrolledStudent.add(student);
    }
}
