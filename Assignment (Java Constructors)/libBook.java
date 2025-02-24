public class libBook {
    String title;
    String Author;
    double price;
    int availability;
    libBook(String title,String Author,double price,int availability){
        this.title=title;
        this.Author=Author;
        this.price=price;
        this.availability=availability;
    }

    void BorrowBook(int availability){
        if(availability>0){
            availability--;
            System.out.println("The Title Of the Book "+title);
            System.out.println("Remaining copies of the Book are "+availability);
        }
        else{
            System.out.println("Sorry the book is not available");
        }
    }

    void returnBook(){
        availability++;
        System.out.println("The Title Of the Book "+title);
        System.out.println("Remaining copies of the Book are "+availability);
    }

    void DisplayData(){
        System.out.println("title->"+title+" Author->"+Author+" price->"+price);
        System.out.println("No. of copies that are available "+availability);
    }
    public static void main(String[] args){
        libBook libBook=new libBook("Flamingo","Martos",500,78);
        libBook.DisplayData();
        libBook.BorrowBook(78);
    }
}
