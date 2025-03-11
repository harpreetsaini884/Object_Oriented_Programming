import java.util.*;

// Abstract class LibraryItem
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    // Constructor
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Abstract method for loan duration (to be implemented by subclasses)
    public abstract int getLoanDuration();

    // Concrete method for getting item details
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    // Getter methods for encapsulation
    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

// Interface Reservable
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Book subclass
class Book extends LibraryItem implements Reservable {
    private static final int LOAN_DURATION = 14; // Loan duration for books is 14 days

    // Constructor
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return LOAN_DURATION;
    }

    @Override
    public void reserveItem() {
        System.out.println("The book '" + getTitle() + "' has been reserved.");
    }

    @Override
    public boolean checkAvailability() {
        // Assume that the book is always available for simplicity
        return true;
    }
}

// Magazine subclass
class Magazine extends LibraryItem implements Reservable {
    private static final int LOAN_DURATION = 7; // Loan duration for magazines is 7 days

    // Constructor
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return LOAN_DURATION;
    }

    @Override
    public void reserveItem() {
        System.out.println("The magazine '" + getTitle() + "' has been reserved.");
    }

    @Override
    public boolean checkAvailability() {
        // Assume that the magazine is available
        return true;
    }
}

// DVD subclass
class DVD extends LibraryItem implements Reservable {
    private static final int LOAN_DURATION = 3; // Loan duration for DVDs is 3 days

    // Constructor
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return LOAN_DURATION;
    }

    @Override
    public void reserveItem() {
        System.out.println("The DVD '" + getTitle() + "' has been reserved.");
    }

    @Override
    public boolean checkAvailability() {
        // Assume that the DVD is available
        return true;
    }
}

// Main class to test the Library System
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create instances of library items
        LibraryItem book = new Book("B123", "Java Programming", "John Doe");
        LibraryItem magazine = new Magazine("M456", "Tech World", "Jane Smith");
        LibraryItem dvd = new DVD("D789", "The Matrix", "Wachowski Brothers");

        // Create a list of library items
        List<LibraryItem> items = new ArrayList<>();
        items.add(book);
        items.add(magazine);
        items.add(dvd);

        // Demonstrate polymorphism by managing library items through a LibraryItem reference
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                if (reservableItem.checkAvailability()) {
                    reservableItem.reserveItem();
                } else {
                    System.out.println("Item is not available for reservation.");
                }
            }
            System.out.println(); // Blank line for separation
        }
    }
}
