package basic;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class SteamDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 4, 2, 9, 7);

        Predicate<Integer> predicate = t -> t % 2 == 0;
        Function<Integer, Integer> mapCondition = n -> n + 2;
        numbers.stream()
                .filter(predicate)
                .sorted()
                .map(mapCondition)
                .forEach(System.out::println);

        int total = numbers.stream()
                .filter(predicate)
                .sorted()
                .map(mapCondition)
                .reduce(0, Integer::sum);
        System.out.println("Total: " + total);
    }
}
