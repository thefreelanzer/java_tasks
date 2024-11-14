package oops;

import abstractClass.Identity;

public class MainClass {
    public static void main(String[] args) {
        // Declaring abstract class reference equal to subclass objects.
        Person i = new Person();
        i.getName("DEEPAK");
        i.getGender("MALE");
        i.getCity("DHANBAD");
        i.getCountry("INDIA"); // Compile-time error because we cannot access newly added method in subclass using superclass reference.
    }
}
