package stream.assignment8.customer;

import stream.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();

        Supplier<Customer> customerSupplier = () -> new Customer(101, "John  Doe", "john@gmail.com", "street, City", "123", false);
        Customer customer = customerSupplier.get();
        customers.add(customer);


        List<CustomerDto> customerDtos = customers.stream()
                .map(c -> createCustomerDtoSupplier(c).get())
                .toList();
        customerDtos.forEach(dto -> System.out.println(dto.toString()));
    }

    public static Supplier<CustomerDto> createCustomerDtoSupplier(Customer customer) {
        return () -> new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
