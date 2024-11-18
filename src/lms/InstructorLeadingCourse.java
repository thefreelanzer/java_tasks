package lms;

public class InstructorLeadingCourse extends Courses {
    private String instructorName;
    private String classSchedule;

    public InstructorLeadingCourse(String id, String courseName, int duration, double fee, String instructorName, String classSchedule) {
        super(id, courseName, duration, fee);
        this.instructorName = instructorName;
        this.classSchedule = classSchedule;
    }

    @Override
    public void displayCourseStructure() {
        System.out.println("Instructor-Led Course Details:");
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
        System.out.println("Fee: $" + fee);
        System.out.println("Instructor: " + instructorName);
        System.out.println("Class Schedule: " + classSchedule + "\n");
    }
}
