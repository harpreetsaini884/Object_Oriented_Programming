public class MovieTicket {
    String movieName;
    String seatNumber;
    int price;
    MovieTicket(String movieName,String seatNumber,int price){
        this.movieName=movieName;
        this.seatNumber=seatNumber;
        this.price=price;
    }
    void BookTicket(String seatNumber,int price){
        this.seatNumber=seatNumber;
        this.price=price;
        System.out.println("The Ticket Booked Successfully "+movieName);
        System.out.println("SeatNumber-"+seatNumber);
        System.out.println("Price "+price);
    }
    void DisplayDetail(){
        System.out.println("MovieName - "+movieName);
        System.out.println("SeatNumber - "+seatNumber);
        System.out.println("Price - "+price);
    }
    public static void main(String[] args){
        MovieTicket mt=new MovieTicket("Bunny", "A4", 5000);
        mt.DisplayDetail();   
    }
}
