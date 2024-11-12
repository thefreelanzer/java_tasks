package basic;

import java.util.Scanner;
import java.util.Random;


public class NumberGame {
    private static Scanner sc = new Scanner(System.in);
    private static int attempt = 0;
    private static int score = 0;

    public static void main(String[] arr) {
        int tempNumber;
        int currentInput;
        while (attempt < 5) {
            tempNumber = generateRandomNumber();
            currentInput = scanNumber();
            System.out.println("tempNumber:" + tempNumber);
            System.out.println("currentInput:" + currentInput);
            if (tempNumber == currentInput) {
                score += 5;
            }
            attempt++;
        }
        System.out.println("Score:" + score);
    }

    /**
     * Generate random number in between 1-100
     *
     * @return Random generated number
     */
    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    /**
     * Receiving user input
     *
     * @return a number that user entered
     */
    private static int scanNumber() {
        int number = 0;
        System.out.print("Enter a random number 1-100:");
        number = sc.nextInt();
        if (number < 1 || number > 100) {
            scanNumber();
        }
        return number;
    }
}