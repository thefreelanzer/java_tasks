package arrays;


import java.util.Arrays;

public class Grade {
    public static void main(String[] arr) {

        int marks[] = {50, 78, 79, 65, 69};

        // Using Arrays.stream() to calculate the sum
        int marksObtained = Arrays.stream(marks).sum();

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
