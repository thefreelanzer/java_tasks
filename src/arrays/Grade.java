package arrays;


import java.util.Arrays;

public class Grade {
    private static String students[] = {"Ethan", "Sophia", "Liam", "Isabella", "Noah"};
    private static String subjects[] = {"Mathematics", "Biology", "Chemistry", "History", "Literature"};
    private static int marks[][] = {
            {50, 71, 99, 55, 59},
            {55, 72, 49, 65, 69},
            {59, 73, 89, 75, 79},
            {58, 78, 99, 85, 89},
            {90, 99, 99, 99, 100},
    };

    public static void main(String[] arr) {

        getIndividualgrades();
        getSubjectavg();
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

    private static void getIndividualgrades() {
        String grade;
        int marksObtained;
        double percentage;
        for (int i = 0; i < 5; i++) {
            marksObtained = Arrays.stream(marks[i]).sum();
            // Calculate percentage
            percentage = getPercentage(marksObtained);
            grade = getGrade(percentage);
            System.out.println(
                    "Student: " + students[i] +
                            ". Total Marks Obtained: " + marksObtained +
                            ". Percentage: " + percentage +
                            ". Grade: " + grade);
        }
    }

    /**
     * Finding Total marks in each subject and average
     */
    private static void getSubjectavg() {
        int sum = 0;
        int numberOfSubjects = subjects.length;
        float avg;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                sum += marks[i][j];
            }
            System.out.println("\n");
            System.out.println("Class Total in " + subjects[i] + "is " + sum);
            avg = (float) sum / numberOfSubjects;
            System.out.println("Average in " + subjects[i] + "is " + avg);
            sum = 0;
        }
    }
}
