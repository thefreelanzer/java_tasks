package designpatterns.creational_design_pattern.Singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JDBCSingletonDemo {
    static int count = 1;
    static int choice;

    public static void main(String[] args) throws IOException {
        JDBCSingleton jdbc = JDBCSingleton.getInstance();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("DATA OPERATIONS");
            System.out.println("---------------------");
            System.out.println("1. Insertion");
            System.out.println("2. View");
            System.out.println("3. Delete");
            System.out.println("4. Update");
            System.out.println("5. Exit");

            System.out.print("\nPlease enter your choice: ");
            choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1: {
                    System.out.print("Enter the username: ");
                    String username = br.readLine();
                    System.out.print("Enter the password: ");
                    String password = br.readLine();

                    if (jdbc.insert(username, password)) {
                        System.out.println((count++) + " Data has been inserted successfully");
                    } else {
                        System.out.println("Data insertion failed");
                    }

                    System.out.println("Press Enter key to continue...");
                    System.in.read();
                }
                break;

                case 2: {
                    System.out.print("Enter the username to view: ");
                    String username = br.readLine();

                    jdbc.view(username);

                    System.out.println("Press Enter key to continue...");
                    System.in.read();
                }
                break;

                case 3: {
                    System.out.print("Enter the username you want to delete: ");
                    String username = br.readLine();

                    if (jdbc.delete(username)) {
                        System.out.println((count++) + " Data has been deleted successfully");
                    } else {
                        System.out.println("Data deletion failed");
                    }

                    System.out.println("Press Enter key to continue...");
                    System.in.read();
                }
                break;

                case 4: {
                    System.out.print("Enter the username to update: ");
                    String username = br.readLine();
                    System.out.print("Enter the new password: ");
                    String password = br.readLine();

                    if (jdbc.update(username, password)) {
                        System.out.println((count++) + " Data has been updated successfully");
                    } else {
                        System.out.println("Data update failed");
                    }

                    System.out.println("Press Enter key to continue...");
                    System.in.read();
                }
                break;

                case 5: {
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                }

                default: {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        } while (true);
    }
}
