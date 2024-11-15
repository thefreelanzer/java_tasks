package lms;

abstract class User {
    protected String name;
    protected String username;
    protected String password;

    /**
     * constructor
     *
     * @param name
     * @param username
     * @param password
     */
    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    /**
     * Getter for return name of user
     *
     * @return name
     */
    public String getUserName() {
        return this.username;
    }

    public String getName() {
        return this.name;
    }

    /**
     * created abstract method in common this will be overridden
     */
    public abstract void displayCourses();


    /**
     * Static factory method to create a User based on type
     */
    public static User createUser(int userType, String name, String username, String password) {
        return switch (userType) {
            case 1 -> new Student(name, username, password);
            case 2 -> new Instructor(name, username, password);
            default -> null;
        };
    }
}

