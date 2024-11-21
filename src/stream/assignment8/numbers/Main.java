package stream.assignment8.numbers;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(18, 21, 30, 48, 54, 30, 21, 64, 74, 54, 81);

        /**
         * Grouping the numbers itself and get count
         */
        Map<Integer, Long> numberMap = numbers.stream()
                .collect(Collectors.groupingBy(
                        num -> num,
                        Collectors.counting()
                ));

        numberMap.forEach((num, count) ->
                System.out.println("Number: " + num + " occurs " + count + " times"));

        Optional<Integer> minValue = numbers.stream()
                .min(Comparator.naturalOrder());
        // Optional<Integer> minValue = numbers.stream()
                //.collect(Collectors.minBy(Comparator.naturalOrder()));
        System.out.println("\nMinimum value: " + minValue.get());
    }
}
