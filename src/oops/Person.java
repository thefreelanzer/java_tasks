package oops;

import abstractClass.Identity;

public class Person extends Identity {


    @Override
    protected void getName(String name) {
        System.out.println("Name: " + name);
    }

    @Override
    protected void getGender(String gender) {
        System.out.println("Gender: " + gender);
    }

    @Override
    protected void getCity(String city) {
        System.out.println("City: " + city);
    }

    // Newly added method in subclass.
    void getCountry(String country) {
        System.out.println("Country: " + country);
    }
}
