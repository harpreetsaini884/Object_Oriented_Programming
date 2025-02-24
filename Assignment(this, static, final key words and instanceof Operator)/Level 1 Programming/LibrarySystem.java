class Book {
    private static String libraryName = "City Library"; 
    private final String isbn; 
    private String title;
    private String author;

    
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public void displayBookDetails() {
        if (this instanceof Book) { // Using instanceof
            System.out.println("Library: " + libraryName);
            System.out.println("ISBN: " + isbn);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
        }
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
}


public class LibrarySystem {
    public static void main(String[] args) {
        Book book1 = new Book("978-3-16-148410-0", "Java Programming", "RK Singh");
        Book book2 = new Book("978-0-262-13472-9", "Data Structures", "SP Shukla");

        book1.displayBookDetails();
        book2.displayBookDetails();
        Book.displayLibraryName();
    }
}
