package designpatterns.creational_design_pattern.Singleton;

import java.util.ArrayList;
import java.util.List;

public class JDBCSingleton {
    // Singleton instance
    private static JDBCSingleton instance;

    // List to store user data
    private List<User> userData;

    // Private constructor
    private JDBCSingleton() {
        userData = new ArrayList<>();
    }

    // Public method to get the singleton instance
    public static JDBCSingleton getInstance() {
        if (instance == null) {
            instance = new JDBCSingleton();
        }
        return instance;
    }

    // Method to add a user
    public boolean insert(String name, String password) {
        User user = new User(name, password);
        return userData.add(user);
    }

    // Method to view user data by name
    public void view(String name) {
        boolean found = false;
        for (User user : userData) {
            if (user.getName().equals(name)) {
                System.out.println("Name: " + user.getName() + "\tPassword: " + user.getPassword());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("User not found.");
        }
    }

    // Method to update user password
    public boolean update(String name, String newPassword) {
        for (User user : userData) {
            if (user.getName().equals(name)) {
                user.setPassword(newPassword);
                return true;
            }
        }
        return false; // User not found
    }

    // Method to delete a user by name
    public boolean delete(String name) {
        return userData.removeIf(user -> user.getName().equals(name));
    }

    // Inner class to represent a User
    private static class User {
        private String name;
        private String password;

        public User(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
