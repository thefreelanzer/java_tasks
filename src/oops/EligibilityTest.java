package oops;

public class EligibilityTest {
    public static void main(String[] arr) {
        Student student = new Student(1, "John", "Computer Engineering", 2.5);
        String msg = student.isEligibleforAdmission() ? "eligible" : "not eligible";
        System.out.printf("%s is %s for Higher Studies.%n", student.getName(), msg);
    }
}
