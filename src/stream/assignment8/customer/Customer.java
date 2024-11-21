package stream.assignment8.customer;

public class Customer {
    int id;
    String name;
    String email;
    String address;
    String password;
    boolean active;

    public Customer(int id, String name, String email, String address, String password, boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return active;
    }
}
