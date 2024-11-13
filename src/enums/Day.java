package enums;

public enum Day {
    SUNDAY("Non-working"),
    MONDAY("Working"),
    TUESDAY("Working"),
    WEDNESDAY("Working"),
    THURSDAY("Working"),
    FRIDAY("Working"),
    SATURDAY("Non-working");

    private String typeOfDay;

    // Constructor
    Day(String typeOfDay) {
        this.typeOfDay = typeOfDay;
    }

    // Method to get type of day
    public String getTypeOfDay() {
        return typeOfDay;
    }
}

