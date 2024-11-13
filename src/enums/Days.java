package enums;

public class Days {
    public static void main(String[] args) {
        Day today = Day.FRIDAY;
        System.out.println("Today is " + today + " and it is a " + today.getTypeOfDay() + " day.");
    }
}
