package enums;

import java.util.Scanner;

public class StatusCodes {
    public static void main(String[] arr) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the code: ");
        int code = scanner.nextInt();

        String description = HttpStatusCode.getDescription(code);
        System.out.println("Description: " + description);
    }
}
