package lms;

import java.util.ArrayList;
import java.util.List;

abstract class Courses {
    private List<String> coursesList = new ArrayList<>();
    protected String id;
    protected String courseName;
    protected double fee;
    protected int duration;

    public Courses(String id, String courseName, int duration, double fee) {
        this.id = id;
        this.courseName = courseName;
        this.fee = fee;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getFee() {
        return fee;
    }

    public int getDuration() {
        return duration;
    }

    public List<String> getCoursesList() {
        return coursesList;
    }

    public abstract void displayCourseStructure();
}
