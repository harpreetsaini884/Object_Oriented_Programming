import java.util.*;

// Abstract class Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Abstract method to calculate discount
    public abstract double calculateDiscount();

    // Getter and Setter methods for encapsulation
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Method to calculate the final price (price + tax - discount)
    public double calculateFinalPrice() {
        return (price + calculateTax()) - calculateDiscount();
    }

    // Method to display product details
    public void displayProductDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + name);
        System.out.println("Original Price: " + price);
        System.out.println("Discount: " + calculateDiscount());
        System.out.println("Tax: " + calculateTax());
        System.out.println("Final Price: " + calculateFinalPrice());
    }
}

// Interface Taxable
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Electronics subclass
class Electronics extends Product implements Taxable {
    private static final double DISCOUNT_PERCENTAGE = 10.0;
    private static final double TAX_PERCENTAGE = 18.0;

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return (getPrice() * DISCOUNT_PERCENTAGE) / 100;
    }

    @Override
    public double calculateTax() {
        return (getPrice() * TAX_PERCENTAGE) / 100;
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax rate: " + TAX_PERCENTAGE + "%";
    }
}

// Clothing subclass
class Clothing extends Product implements Taxable {
    private static final double DISCOUNT_PERCENTAGE = 15.0;
    private static final double TAX_PERCENTAGE = 5.0;

    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return (getPrice() * DISCOUNT_PERCENTAGE) / 100;
    }

    @Override
    public double calculateTax() {
        return (getPrice() * TAX_PERCENTAGE) / 100;
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax rate: " + TAX_PERCENTAGE + "%";
    }
}

// Groceries subclass
class Groceries extends Product implements Taxable {
    private static final double DISCOUNT_PERCENTAGE = 5.0;
    private static final double TAX_PERCENTAGE = 2.0;

    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return (getPrice() * DISCOUNT_PERCENTAGE) / 100;
    }

    @Override
    public double calculateTax() {
        return (getPrice() * TAX_PERCENTAGE) / 100;
    }

    @Override
    public String getTaxDetails() {
        return "Groceries Tax rate: " + TAX_PERCENTAGE + "%";
    }
}

// Main class to test the system
public class ECommercePlatform {
    public static void main(String[] args) {
        // Create product instances
        Product electronics = new Electronics(101, "Laptop", 80000);
        Product clothing = new Clothing(102, "Jacket", 5000);
        Product groceries = new Groceries(103, "Rice", 200);

        // Create a list of products
        List<Product> products = new ArrayList<>();
        products.add(electronics);
        products.add(clothing);
        products.add(groceries);

        // Display product details and calculate final price for each product
        for (Product product : products) {
            product.displayProductDetails();
            System.out.println();  // Add a line break between product details
        }
    }
}
