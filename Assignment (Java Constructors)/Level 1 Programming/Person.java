public class Person {
    String name;
    int age;
    String address;
    Person(){
        name="unknown";
        age=0;
        address=null;
    }
    Person(String name,int age,String address){
        this.name=name;
        this.age=age;
        this.address=address;
    }
    void Display(){
        System.out.println("Name->"+name);
        System.out.println("Age->"+age);
        System.out.println("Address->"+address);
    }
    public static void main(String[] args){
        Person p=new Person("John Wick",23,"DangerStreet");
        p.Display();
    }   
}
