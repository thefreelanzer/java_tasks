package basic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello world!";
        System.out.println(supplier.get());

        List<String> list = Arrays.asList("1");

        System.out.println(list.stream().findAny().orElseGet(() -> "Empty!"));
    }
}
