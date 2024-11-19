package basic;

import java.util.Scanner;

public class StudentGrade {
    // Create Scanner object for input
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] arr) {

        int marksObtained = readMark();

        // Calculate percentage
        double percentage = getPercentage(marksObtained);
        String grade = getGrade(percentage);

        System.out.println("Total Marks: " + marksObtained);
        System.out.println("Percentage: " + percentage);
        System.out.println("Grade: " + grade);
    }

    private static int readMark() {
        while (true) {
            System.out.print("Enter the marks obtained by the student (out of 500): ");
            String input = sc.nextLine();

            try {
                int marksObtained = Integer.parseInt(input);
                if (marksObtained < 0 || marksObtained > 500) {
                    throw new IllegalArgumentException("Marks must be between 0 and 500.");
                }
                return marksObtained; // Return valid marks
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static double getPercentage(int marksObtained) {
        return (marksObtained / 500.0) * 100;
    }

    private static String getGrade(double percentage) {
        int range = (int) (percentage / 10);
        return switch (range) {
            case 10, 9, 8 -> "A+";
            case 7 -> "A";
            case 6 -> "B+";
            case 5 -> "B";
            case 4 -> "C";
            default -> "D";
        };
    }
}
