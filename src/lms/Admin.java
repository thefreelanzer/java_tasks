package lms;

public class Admin extends User {
    public Admin(String name, String username, String password) {
        super(name, username, password);
    }

    @Override
    public void displayCourses() {
        System.out.println("Admin " + username + " manages all courses.");
    }

    @Override
    public String getUserType() {
        return "Admin";
    }
}
