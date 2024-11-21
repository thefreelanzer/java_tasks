package stream.assignment8.customer;

import stream.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();

        Supplier<Customer> customerSupplier = () -> new Customer(101, "John  Doe", "john@gmail.com", "street, City", "123", false);
        Customer customer = customerSupplier.get();
        customers.add(customer);


        List<CustomerDto> customerDtos = customers.stream()
                .map(c -> new CustomerDto(
                        c.getId(),
                        c.getName(),
                        c.getEmail(),
                        c.getAddress()))
                .collect(Collectors.toList());
        customerDtos.forEach(dto -> System.out.println(dto.toString()));

        List<Integer> numbers = Arrays.asList(101, 21, 30, 48, 54, 30, 21, 64, 74, 54, 81);
        Set<Integer> uniqueNumbers = numbers.stream()
                .collect(Collectors.toSet());
        System.out.println(uniqueNumbers);
    }
}
