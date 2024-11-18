package lms;

public class StudentMain {
    public static void main(String[] args) {
        StudentActivity studentActivity = new StudentActivity("John Doe");

        // Create functional interface references
        StudentTask learnTask = studentActivity::learningNote;
        StudentTask quizTask = studentActivity::attendingQuiz;
        StudentTask assignmentTask = studentActivity::submittingAssignment;

        learnTask.executeTask();
        quizTask.executeTask();
        assignmentTask.executeTask();

        StudentActivity.displayStudentStatus();
    }
}
