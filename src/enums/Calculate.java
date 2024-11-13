package enums;

import java.util.Scanner;

public class Calculate {
    public static void main(String[] arr) {
        Scanner scanner = new Scanner(System.in);
        double result;

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter an operation (+, -, *, /): ");
        char symbol = scanner.next().charAt(0);

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        Operation op = Operation.checkSymbol(symbol);
        result = op.apply(num1, num2);
        System.out.println("Result: " + result);
    }
}
