package lms;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    // Create Scanner object for input
    private static final Scanner sc = new Scanner(System.in);
    // A static map to store users, with the username as the key and the User object as the value.
    private static Map<String, User> users = new HashMap<>();
    private static final Map<String, Courses> courses = new HashMap<>();

    public static void main(String[] args) {
        printMessage("Welcome to the Learning Management System!");
        // Initialize the default admin
        createAdmin();
        createCourses();

        handleUserInput();
    }

    /**
     * Method to handle user input by reading an option and processing it.
     */
    private static void handleUserInput() {
        int inputOption = readInput();
        processInput(inputOption);
    }

    /**
     * Displays a message on the terminal.
     *
     * @param message - The message to be displayed.
     */
    private static void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Reads input from the user and returns the selected option.
     *
     * @return user input as an integer.
     */
    private static int readInput() {
        int option;
        while (true) {
            printMessage("1. Register");
            printMessage("2. Login");
            printMessage("3. Exit");
            printMessage("Please choose an option:");

            // Check if input is an integer
            if (sc.hasNextInt()) {
                option = sc.nextInt();

                // Validate input
                if (option == 1 || option == 2 || option == 3) {
                    return option;  // Valid option
                } else {
                    printMessage("Invalid option. Please choose 1, 2, or 3.");
                }
            } else {
                printMessage("Invalid input. Please enter a number.");
                sc.next();  // Clear the invalid input
            }
        }
    }

    /**
     * Processes the user's input option.
     *
     * @param option - The option selected by the user.
     */
    private static void processInput(int option) {
        switch (option) {
            case 1 -> {
                registerUser();
            }
            case 2 -> {
                loginUser();
            }
            case 3 -> {
                printMessage("Exiting the system. Goodbye!");
                System.exit(0);
            }
        }
    }

    private static void registerUser() {
        // Consume the newline left over after reading the name
        sc.nextLine();

        printMessage("Please enter name:");
        String name = sc.nextLine();

        printMessage("Please enter username:");
        String username = sc.nextLine();

        printMessage("Please enter password:");
        String password = sc.nextLine();

        printMessage("Select user type:\n1. Student  \n2. Instructor  \n3. Admin");
        int userType = sc.nextInt();
        sc.nextLine();

        User user = User.createUser(userType, name, username, password);

        if (user != null) {
            users.put(username, user);
            System.out.println("User registered successfully!");
            System.out.println(users);
        } else {
            System.out.println("Invalid user type selected.");
        }
        handleUserInput();
    }

    /**
     * method to performs login functionality
     */
    private static void loginUser() {
        // Consume the newline left over after reading the name
        sc.nextLine();

        printMessage("Please enter username:");
        String username = sc.nextLine();

        printMessage("Please enter password:");
        String password = sc.nextLine();

        // get user using username
        User user = users.get(username);

        // If the user exists, print their details
        if (user != null && user.password.equals(password)) {
            printMessage(user.getUserType());
            switch (user.getUserType()) {
                case "Student" -> {
                    printMessage("You are a Student!");
                    studentMenus((Student) user);
                }
                case "Instructor" -> {
                    printMessage("You are a Instructor!");
                    instructorMenus((Instructor) user);
                }
                case "Admin" -> {
                    printMessage("You are a Admin!");
                    adminMenus();
                }
            }
        } else {
            System.out.println("User not found! If you are not registered, please sign up.");
            handleUserInput();
        }
    }

    /**
     * creating admin
     */
    private static void createAdmin() {
        //userType 3 - Admin
        User user = User.createUser(3, "admin", "admin", "1234");
        users.put("admin", user);
        System.out.println(users);
    }

    /**
     * Method used to add 10 courses
     */
    private static void createCourses() {
        String[] courseNames = {
                "Introduction to Java",
                "Data Structures",
                "Web Development",
                "Database Systems",
                "Software Engineering",
                "Python Programming",
                "Cloud Computing",
                "Machine Learning",
                "Cybersecurity Basics",
                "Mobile App Development"
        };
        for (int i = 0; i < courseNames.length; i++) {
            String courseId = "C" + (i + 1);
            Courses course = new SelfLearningCourse(courseId, courseNames[i], 10, 2000);
            courses.put(courseId, course);
        }
    }

    private static void listAllCourses() {
        if (courses.isEmpty()) {
            printMessage("No courses available.");
            return;
        }

        // Loop through the courses map and print each course
        int i = 1;
        for (Map.Entry<String, Courses> entry : courses.entrySet()) {
            String courseId = entry.getKey();
            Courses course = entry.getValue();
            printMessage(i + "-> Course ID: " + courseId + ", Name: " + course.getCourseName());
            i++;
        }
    }

    private static void adminMenus() {
        printMessage("1. Students:");
        printMessage("2. Instructors:");
        printMessage("3. Admins:");
        printMessage("4. Courses:");
        printMessage("5. Logout:");
        printMessage("Please choose an option:");
        int option = sc.nextInt();

        switch (option) {
            case 1 -> {
                User.listAllStudents();
            }
            case 2 -> {
                User.listAllInstructors();
            }
            case 3 -> {
                User.listAllAdmins();
            }
            case 4 -> {
                listAllCourses();
                showCourseDetails();
            }
            case 5 -> {
                handleUserInput();
            }
        }
        adminMenus();
    }

    private static void studentMenus(Student student) {
        printMessage("1. My Details:");
        printMessage("2. Enroll Course:");
        printMessage("3. Logout:");
        printMessage("Please choose an option:");
        int option = sc.nextInt();

        switch (option) {
            case 1 -> {
                printMessage("Name: " + student.getName());
                printMessage("Username: " + student.getUserName());
                printMessage("Enrolled Courses: " + student.getEnrolledCourses() + "\n");
            }
            case 2 -> {
                String selectedCourse = setCourse();
                student.enrollCourse(selectedCourse);
                printMessage("You have successfully enrolled in: " + selectedCourse);

                //process payment
                printMessage("\nPlease choose payment method:");
                printMessage("1. Credit Card:");
                printMessage("2. Upi:");
                printMessage("Please choose an option:");
                int paymentOption = sc.nextInt();
                handlePayment(paymentOption);
            }
            case 3 -> {
                handleUserInput();
            }
        }
        studentMenus(student);
    }

    private static void instructorMenus(Instructor instructor) {
        printMessage("1. My Details:");
        printMessage("2. Enroll Course:");
        printMessage("3. Logout:");
        printMessage("Please choose an option:");
        int option = sc.nextInt();
        switch (option) {
            case 1 -> {
                printMessage("Name: " + instructor.getName());
                printMessage("Username: " + instructor.getUserName());
                printMessage("Enrolled Courses: " + instructor.getEnrolledCourses() + "\n");
            }
            case 2 -> {
                String selectedCourse = setCourse();
                instructor.enrollCourse(selectedCourse);
                printMessage("You have successfully enrolled in: " + selectedCourse);
            }
            case 3 -> {
                handleUserInput();
            }
        }
    }

    private static String setCourse() {
        printMessage("Available Courses:");
        List<Map.Entry<String, Courses>> courseList = new ArrayList<>(courses.entrySet());

        // Display all available courses
        for (int i = 0; i < courseList.size(); i++) {
            Map.Entry<String, Courses> entry = courseList.get(i);
            Courses course = entry.getValue();
            printMessage((i + 1) + ". " + course.getCourseName());
        }

        while (true) { // Validation loop
            printMessage("Enter the number of the course you want to enroll in:");
            int selectedCourseNumber = sc.nextInt();

            if (selectedCourseNumber > 0 && selectedCourseNumber <= courseList.size()) {
                Courses selectedCourse = courseList.get(selectedCourseNumber - 1).getValue();
                return selectedCourse.getCourseName();
            } else {
                printMessage("Invalid selection. Please try again.");
            }
        }
    }

    public static void handlePayment(int paymentOption) {
        switch (paymentOption) {
            case 1 -> {
                Student.processPayment(new CreditCardPayment(), 2000);
            }
            case 2 -> {
                Student.processPayment(new UpiPayment(), 2000);
            }
            default -> {
                System.out.println("Unable to process payment!!");
            }
        }
    }

    private static void showCourseDetails() {
        printMessage("Choose course:");
        int course = sc.nextInt();
        List<Map.Entry<String, Courses>> courseList = new ArrayList<>(courses.entrySet());

        printMessage("1. Basic Details:");
        printMessage("2. Instructor:");
        printMessage("Choose choose an option:");
        int selectedCourseNumber = sc.nextInt();
        switch (selectedCourseNumber) {
            case 1 -> {
                if (selectedCourseNumber <= courseList.size()) {
                    Courses selectedCourse = courseList.get(selectedCourseNumber - 1).getValue();
                    SelfLearningCourse selfLearningCourse = new SelfLearningCourse(selectedCourse.getId(), selectedCourse.getCourseName(), selectedCourse.getDuration(), selectedCourse.getFee());
                    selfLearningCourse.displayCourseStructure();
                } else {
                    printMessage("Invalid selection. Please try again.");
                }
            }
            case 2 -> {

            }
        }
    }
}
