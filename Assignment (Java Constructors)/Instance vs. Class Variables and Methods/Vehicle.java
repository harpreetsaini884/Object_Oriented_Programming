public class Vehicle {
    String customerName;
    int carModel;
    double rentalDays;
    double dailyRate=50.0;
    Vehicle(String customerName,int carModel,double rentalDays){
        this.customerName=customerName;
        this.carModel=carModel;
        this.rentalDays=rentalDays;
    }
    double rent(double rentalDays){
        return rentalDays*dailyRate;
    }

    void Display(){
        System.out.println("Name of the Customer "+customerName);
        System.out.println("Model of the car "+carModel);
        System.out.println("Car rent for "+rentalDays);
        System.out.println("Total cost will be "+rent(5));
    }
    public static void main(String[] args){
        Vehicle cr=new Vehicle("Bunty", 2011, 5);
        cr.Display();
    }
}
