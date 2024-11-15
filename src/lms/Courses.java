package lms;

import java.util.ArrayList;
import java.util.List;

class Courses {
    private List<String> coursesList = new ArrayList<>();
    protected String id;
    protected String courseName;

    public Courses(String id, String courseName) {
        this.id = id;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public List<String> getCoursesList() {
        return coursesList;
    }
}
