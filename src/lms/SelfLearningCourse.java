package lms;

public class SelfLearningCourse extends Courses {
    public SelfLearningCourse(String id, String courseName, int duration, double fee) {
        super(id, courseName, duration, fee);
    }

    @Override
    public void displayCourseStructure() {
        System.out.println("Self-Learning Course Details:");
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
        System.out.println("Fee: $" + fee + "\n");
    }
}
