import java.util.ArrayList;

class Book {
    private String title;
    private String author;

    // Constructor
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Setters and Getters
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    // Method to display book details
    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class Library {
    private String libraryName;
    private ArrayList<Book> books;

    // Constructor
    Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to display books in the library
    public void displayLibraryBooks() {
        System.out.println("Books in " + libraryName + ":");
        for (Book book : books) {
            book.display();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating Book objects
        Book book1 = new Book("Harry Potter", "J.K. Rowling");
        Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book3 = new Book("1984", "George Orwell");

        // Creating Library objects
        Library library1 = new Library("Central Library");
        Library library2 = new Library("Community Library");

        // Adding books to libraries
        library1.addBook(book1); // Adding Harry Potter to Central Library
        library1.addBook(book2); // Adding The Great Gatsby to Central Library

        library2.addBook(book3); // Adding 1984 to Community Library
        library2.addBook(book1); // Adding Harry Potter to Community Library (same book in different library)

        // Display books in both libraries
        library1.displayLibraryBooks();
        System.out.println();
        library2.displayLibraryBooks();
    }
}
