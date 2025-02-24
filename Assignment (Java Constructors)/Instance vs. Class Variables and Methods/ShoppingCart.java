import java.util.*;

class CartItem {
    String itemName;
    double price;
    int quantity;

    // Constructor to initialize the item details
    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to calculate the total price of this item in the cart
    double totalCost() {
        return price * quantity;
    }

    // Method to display the item details
    void displayItemDetails() {
        System.out.println("Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity + ", Total Cost: $" + totalCost());
    }
}

public class ShoppingCart {
    // A list to store the items in the cart
    List<CartItem> cartItems;

    // Constructor to initialize the shopping cart
    ShoppingCart() {
        cartItems = new ArrayList<>();
    }

    // Method to add an item to the cart
    void addItem(String itemName, double price, int quantity) {
        CartItem newItem = new CartItem(itemName, price, quantity);
        cartItems.add(newItem);
        System.out.println("Item '" + itemName + "' added to the cart.");
    }

    // Method to remove an item from the cart
    void removeItem(String itemName) {
        Iterator<CartItem> iterator = cartItems.iterator();
        while (iterator.hasNext()) {
            CartItem item = iterator.next();
            if (item.itemName.equalsIgnoreCase(itemName)) {
                iterator.remove();
                System.out.println("Item '" + itemName + "' removed from the cart.");
                return;
            }
        }
        System.out.println("Item '" + itemName + "' not found in the cart.");
    }

    // Method to calculate the total cost of all items in the cart
    double calculateTotalCost() {
        double totalCost = 0;
        for (CartItem item : cartItems) {
            totalCost += item.totalCost();
        }
        return totalCost;
    }

    // Method to display the cart items
    void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("\nItems in your cart:");
            for (CartItem item : cartItems) {
                item.displayItemDetails();
            }
        }
    }

    public static void main(String[] args) {
        // Create a shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Scanner to take user input
        Scanner scanner = new Scanner(System.in);

        // Menu for cart operations
        while (true) {
            System.out.println("\nShopping Cart Operations:");
            System.out.println("1. Add item to cart");
            System.out.println("2. Remove item from cart");
            System.out.println("3. View cart items");
            System.out.println("4. Calculate total cost");
            System.out.println("5. Exit");
            System.out.print("Choose an operation: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    // Add item to cart
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter item quantity: ");
                    int quantity = scanner.nextInt();
                    cart.addItem(name, price, quantity);
                    break;

                case 2:
                    // Remove item from cart
                    System.out.print("Enter item name to remove: ");
                    String itemToRemove = scanner.nextLine();
                    cart.removeItem(itemToRemove);
                    break;

                case 3:
                    // View cart items
                    cart.displayCart();
                    break;

                case 4:
                    // Calculate total cost
                    double totalCost = cart.calculateTotalCost();
                    System.out.println("\nTotal cost of items in the cart: $" + totalCost);
                    break;

                case 5:
                    // Exit the program
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }
    }
}
