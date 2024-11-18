package lms;

public class StudentActivity {

    protected static String studentName;
    protected static boolean learning;
    protected static boolean quiz;
    protected static boolean assignment;

    public StudentActivity(String studentName) {
        this.studentName = studentName;
    }

    public void learningNote() {
        System.out.printf("%s attended the class!%n", studentName);
        learning = true;
    }

    public void attendingQuiz() {
        System.out.printf("%s is submitted the quiz!%n", studentName);
        quiz = true;
    }

    public void submittingAssignment() {
        System.out.printf("%s is completed assignment!%n", studentName);
        assignment = true;
    }

    public static void displayStudentStatus() {
        System.out.printf(
                "\nStudent Status!\n" + "Name: %s\n" + "Learning Completed: %s\n" + "Quiz Completed: %s\n" + "Assignment Submitted: %s\n",
                studentName,
                learning ? "Yes" : "No",
                quiz ? "Yes" : "No",
                assignment ? "Yes" : "No"
        );
    }
}
