package stream.assignment9;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        multiplyList();
        applyToUpperCase();
        getLengthOfElements();
    }

    private static void multiplyList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().map(n -> n * 3).forEach(System.out::println);
    }

    private static void applyToUpperCase() {
        System.out.println("\nString to Uppercase\n");
        List<String> words = Arrays.asList("java", "php", "angular", "react", "node");
        words.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    private static void getLengthOfElements() {
        System.out.println("\nLength of elements\n");
        List<String> words = Arrays.asList("java", "php", "angular", "react", "node");
        words.stream().map(String::length).forEach(System.out::println);
    }
}