public class Item {
    int itemCode;
    String itemName;
    double price;
    Item(int itemCode,String itemName,double price){
        this.itemCode=itemCode;
        this.itemName=itemName;
        this.price=price;

    }
    void DisplayDetails(){
        System.out.println("ItemCode->"+itemCode);
        System.out.println("ItemName->"+itemName);
        System.out.println("Price->"+price);
    }

    public static void main(String[] args){
        Item item=new Item(22,"Harry",3000);
        item.DisplayDetails();
    }
}
