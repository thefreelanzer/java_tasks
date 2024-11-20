package basic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> consumer = t -> System.out.println("Printing " + t);
        consumer.accept("Hello world!");

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.forEach(t -> System.out.println("Print: " + t));
    }

}
