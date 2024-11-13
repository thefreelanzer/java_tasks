package basic;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] arr) {
        // Create Scanner object for input
        Scanner sc = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter the number to find factorial: ");
        int number = sc.nextInt();
        int result = getFactorial(number);

        System.out.println(String.format("Entered Number is: %d",number));
        System.out.println(String.format("Factorial is: %d",result));
    }

    private static int getFactorial(int number) {
        int f = 1;
        for (int i = 1; i <= number; i++) {
            f = f * i;
        }
        return f;
    }
}