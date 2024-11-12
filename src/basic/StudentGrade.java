package basic;

import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] arr) {
        // Create Scanner object for input
        Scanner sc = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter the marks obtained by the student (out of 500): ");
        int marksObtained = sc.nextInt();

        // Calculate percentage
        double percentage = getPercentage(marksObtained);
        String grade = getGrade(percentage);

        System.out.println("Total Marks: " + marksObtained);
        System.out.println("Percentage: " + percentage);
        System.out.println("Grade: " + grade);
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
