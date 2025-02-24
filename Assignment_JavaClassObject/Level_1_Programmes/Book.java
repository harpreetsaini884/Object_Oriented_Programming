public class Book {
    String title;
    String Author;
    double price;
    Book(String title,String Author,double price){
        this.title=title;
        this.Author=Author;
        this.price=price;
    }
    void DisplayData(){
        System.out.println("title->"+title+" Author->"+Author+" price->"+price);
    }
    public static void main(String[] args){
        Book book=new Book("Flamingo","Martos",500);
        book.DisplayData();
    }
}
