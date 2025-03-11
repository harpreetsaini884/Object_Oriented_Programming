import java.util.*;

// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Abstract method to calculate the total price
    public abstract double calculateTotalPrice();

    // Concrete method to display item details
    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
    }

    // Getter methods (encapsulation)
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setter methods (encapsulation)
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

// Interface Discountable
interface Discountable {
    void applyDiscount();
    String getDiscountDetails();
}

// VegItem class (extends FoodItem)
class VegItem extends FoodItem implements Discountable {
    private static final double DISCOUNT_RATE = 0.10; // 10% discount for veg items

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    // Calculate total price for veg item
    @Override
    public double calculateTotalPrice() {
        double totalPrice = getPrice() * getQuantity();
        return totalPrice - (totalPrice * DISCOUNT_RATE);
    }

    // Apply discount to veg item
    @Override
    public void applyDiscount() {
        double discount = calculateTotalPrice() * DISCOUNT_RATE;
        System.out.println("Discount applied: $" + discount);
    }

    // Get discount details for veg item
    @Override
    public String getDiscountDetails() {
        return "10% discount applied on veg items.";
    }
}

// NonVegItem class (extends FoodItem)
class NonVegItem extends FoodItem implements Discountable {
    private static final double DISCOUNT_RATE = 0.05; // 5% discount for non-veg items

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    // Calculate total price for non-veg item
    @Override
    public double calculateTotalPrice() {
        double totalPrice = getPrice() * getQuantity();
        return totalPrice - (totalPrice * DISCOUNT_RATE);
    }

    // Apply discount to non-veg item
    @Override
    public void applyDiscount() {
        double discount = calculateTotalPrice() * DISCOUNT_RATE;
        System.out.println("Discount applied: $" + discount);
    }

    // Get discount details for non-veg item
    @Override
    public String getDiscountDetails() {
        return "5% discount applied on non-veg items.";
    }
}

// Main class to test the Online Food Delivery System
public class FoodDeliverySystem {
    public static void main(String[] args) {
        // Create instances of food items
        FoodItem vegItem = new VegItem("Vegetable Curry", 12.99, 2);
        FoodItem nonVegItem = new NonVegItem("Chicken Biryani", 15.99, 1);

        // Create a list to store food items
        List<FoodItem> foodItems = new ArrayList<>();
        foodItems.add(vegItem);
        foodItems.add(nonVegItem);

        // Process each food item in the list
        double totalPrice = 0;

        for (FoodItem item : foodItems) {
            item.getItemDetails();
            double itemTotalPrice = item.calculateTotalPrice();
            System.out.println("Total Price after Discount: $" + itemTotalPrice);

            // If the item is Discountable, apply discount
            if (item instanceof Discountable) {
                Discountable discountableItem = (Discountable) item;
                discountableItem.applyDiscount();
                System.out.println(discountableItem.getDiscountDetails());
            }
            totalPrice += itemTotalPrice;
            System.out.println(); // Blank line for separation
        }

        System.out.println("Total Price for all items: $" + totalPrice);
    }
}
