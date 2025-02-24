public class MobilePhone {
    String brand;
    String model;
    double price;

    MobilePhone(String brand,String model,double price){
        this.brand=brand;
        this.model=model;
        this.price=price;
    }
    void DisplayDetails(){
        System.out.println("Brand->"+brand);
        System.out.println("model->"+model);
        System.out.println("Price->"+price);
    }
    public static void main(String[] args){
        MobilePhone mp=new MobilePhone("Apple","HACHD456",3000);
        mp.DisplayDetails();
    }
}
