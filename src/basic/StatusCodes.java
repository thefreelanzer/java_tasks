package basic;

import java.util.Scanner;

public class StatusCodes {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] arr) {
        int number;
        while ((number = scanNumber()) != 0) {
            String response = getStatus(number);
            System.out.println(response);
        }
        System.out.println("Exiting program.");
    }

    private static int scanNumber() {
        System.out.print("Enter the code(Enter 0 to Exit):");
        return sc.nextInt();
    }

    private static String getStatus(int number) {
        return switch (number) {
            case 200 -> {
                yield "Ok";
            }
            case 400 -> {
                yield "Bad Request";
            }
            case 403 -> {
                yield "Forbidden";
            }
            case 500 -> {
                yield "Internal Server Error";
            }
            default -> {
                yield "Nothing found with this code";
            }
        };
    }
}
