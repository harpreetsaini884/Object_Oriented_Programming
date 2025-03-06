package Class_Object_SequenceDiagram.GroceryStoreBill;

import java.util.ArrayList;
import java.util.List;

class Product {
    String name;
    double quantity;
    double pricePerUnit;

    public Product(String name, double quantity, double pricePerUnit) {
        this.name = name;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public double calculateTotalPrice() {
        return quantity * pricePerUnit;
    }
}


class Customer {
    String name;
    List<Product> purchasedProducts;

    public Customer(String name) {
        this.name = name;
        this.purchasedProducts = new ArrayList<>();
    }

    public void addProduct(Product product) {
        purchasedProducts.add(product);
    }

    public double generateBill() {
        return BillGenerator.calculateTotal(this);
    }
}


class BillGenerator {
    public static double calculateTotal(Customer customer) {
        double total = 0;
        for (Product product : customer.purchasedProducts) {
            total += product.calculateTotalPrice();
        }
        return total;
    }
}


public class GroceryStoreApplication {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice");
        customer.addProduct(new Product("Apples", 2, 3.0));
        customer.addProduct(new Product("Milk", 1, 2.0));

        System.out.println("Customer: " + customer.name);
        System.out.println("Total Bill: $" + customer.generateBill());
    }
}
