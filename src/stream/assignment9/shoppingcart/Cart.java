package stream.assignment9.shoppingcart;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    // product, price
    private Map<String, Double> cart;

    public Cart() {
        cart = new HashMap<>();
    }

    /**
     * adding product to cart
     *
     * @param productName name of product
     * @param price       price for the product
     */
    public void addProduct(String productName, double price) {
        cart.put(productName, price);
        System.out.println(productName + " added to the cart with price " + price);
    }

    /**
     * print all the products in the cart.
     */
    public void getAllProducts() {
        System.out.println("\nProducts in Cart:");
        cart.forEach((product, price) -> System.out.println(product + "(" + price + ")"));
    }

    /**
     * remove product from the cart if exist
     *
     * @param product - product name
     */
    public void removeProduct(String product) {
        String message = cart.remove(product) != null ? " deleted successfully." : " not found!";
        System.out.println("\n" + product + message);
    }

    /**
     * finding total of cart using reduce
     */
    public void getTotal() {
        double total = cart.values().stream().reduce(0.0, Double::sum);
        //double total = cart.values().stream().reduce(0.0, (s,c) -> s+c );
        System.out.println("\nCart Total = " + total);
    }

    /**
     * return products with same price
     *
     * @param price product price
     */
    public void getProduct(double price) {
        System.out.println("\nSearching product with:" + price);
        cart.entrySet().stream().filter(i -> i.getValue().equals(price)).forEach(p -> System.out.println(p.getKey()));
    }

    /**
     * finding product price with its name
     *
     * @param product product name
     */
    public void getPrice(String product) {
        System.out.println("\nSearching price of:" + product);
        Double price = cart.get(product);
        if (price != null)
            System.out.println("Price of: " + product + " is " + price);
        else
            System.out.println("Product not found!");
    }

    public static void main(String[] args) {
        Cart cart = new Cart();

        // adding products
        cart.addProduct("Laptop", 15000);
        cart.addProduct("Tab", 15000);
        cart.addProduct("Mobile", 20000);
        cart.addProduct("Charger", 1000);

        // remove product
        cart.removeProduct("Charger");

        cart.getAllProducts();

        cart.getTotal();

        cart.getProduct(15000);
        cart.getPrice("Laptop");
    }
}
