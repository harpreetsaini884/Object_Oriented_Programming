public class Book {
    public String ISBN;
    protected String title;
    private String author;  
    Book(String ISBN,String title,String author){
        this.ISBN=ISBN;
        
        this.title=title;
        this.author=author;
    }
    public void setAuthor(String author){
        this.author=author;
    }

    public String getAuthor(){
        return author;
    }
    public void display() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
    class Ebook extends Book{
        public Ebook(String ISBN,String title,String author){
            super(ISBN,title,author);
        }

        @Override
        public void display() {
            System.out.println("EBook Details:");
            super.display();  
        }
    }
    public static void main(String[] args){
        Book book = new Book("978-3-16-148410-0", "Java Programming", "John Doe");
        book.display();
    }
}
