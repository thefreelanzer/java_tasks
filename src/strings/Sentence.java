package strings;

import java.util.Random;
import java.util.Scanner;

public class Sentence {
    public static void main(String[] args) {

        // Create Scanner object for input
        Scanner sc = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter the Length:");
        int length = sc.nextInt();

        String randomString = generateRandomString(length);
        System.out.println("Generated Random String: " + randomString);
    }

    /**
     * FUnction for creating random string
     *
     * @param length
     * @return string with length 10
     */
    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();

        // Generate random string of specified length
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            stringBuffer.append(randomChar); // Append random character to StringBuffer
        }

        // Convert StringBuffer to String and return it
        return stringBuffer.toString();
    }
}
