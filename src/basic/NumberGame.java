package basic;

import java.util.Scanner;
import java.util.Random;


public class NumberGame {
    private static Scanner sc = new Scanner(System.in);
    private static int score = 0;
    private static int inputNumber = 0;

    public static void main(String[] arr) {
        int tempNumber;
        int currentInput;
        for (int i = 0; i < 5; i++) {
            tempNumber = generateRandomNumber();
            currentInput = scanNumber();
            System.out.println("tempNumber:" + tempNumber);
            System.out.println("currentInput:" + currentInput);
            if (tempNumber == currentInput) {
                score += 5;
            }
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
     * Receiving user input and checking the number is in between 1-100
     *
     * @return a number that user entered
     */
    private static int scanNumber() {
        System.out.print("Enter a random number 1-100:");
        inputNumber = sc.nextInt();
        if (inputNumber < 1 || inputNumber > 100) {
            scanNumber();
        }
        return inputNumber;
    }
}