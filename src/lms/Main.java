package lms;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // Create Scanner object for input
    private static final Scanner sc = new Scanner(System.in);
    // A static map to store users, with the username as the key and the User object as the value.
    private static Map<String, User> users = new HashMap<>();

    public static void main(String[] args) {
        printMessage("Welcome to the Learning Management System!");
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
            }
        }
    }

    private static void registerUser() {
        printMessage("Please enter name:");
        String name = sc.nextLine();

        // Consume the newline left over after reading the name
        sc.nextLine();

        printMessage("Please enter username:");
        String username = sc.nextLine();

        printMessage("Please enter password:");
        String password = sc.nextLine();

        printMessage("Select user type:\n1. Student  \n2. Instructor  \n3. Admin");
        int userType = sc.nextInt();
        sc.nextLine();

        User user = switch (userType) {
            case 1 -> new Student(name, username, password);
            default -> null;
        };

        if (user != null) {
            users.put(username, user);
            System.out.println("User registered successfully!");
            System.out.println(users);
            handleUserInput();
        } else {
            System.out.println("Invalid user type selected.");
        }
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

        System.out.println("Username: " + username);
        // get user using username
        User user = users.get(username);

        // If the user exists, print their details
        if (user != null && user.password.equals(password)) {
            System.out.println("User found: " + user);
        } else {
            System.out.println("User not found.");
        }
    }
}
