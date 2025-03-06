import java.util.ArrayList;
import java.util.List;


class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}


class Order {
    private int orderId;
    private Customer customer;
    private List<Product> products;
    private double totalAmount;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.totalAmount = 0;
    }

    public void addProduct(Product product) {
        products.add(product);
        totalAmount += product.getPrice();
    }

    public void displayOrderDetails() {
        System.out.println("\nOrder ID: " + orderId);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println("  - " + product.getName() + " ($" + product.getPrice() + ")");
        }
        System.out.println("Total Amount: $" + totalAmount);
    }
}


class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void viewOrders() {
        System.out.println("\nOrders for " + name + ":");
        for (Order order : orders) {
            order.displayOrderDetails();
        }
    }
}


public class EcommercePlatform {
    public static void main(String[] args) {
        
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        
        Product product1 = new Product("Laptop", 1200.00);
        Product product2 = new Product("Smartphone", 800.00);
        Product product3 = new Product("Headphones", 150.00);

        
        Order order1 = new Order(101, customer1);
        order1.addProduct(product1);
        order1.addProduct(product3);
        customer1.placeOrder(order1);

        Order order2 = new Order(102, customer2);
        order2.addProduct(product2);
        customer2.placeOrder(order2);

        
        customer1.viewOrders();
        customer2.viewOrders();
    }
}
