import java.util.*;

// Superclass Vehicle
class Vehicle {
    private int maxSpeed;
    private String fuelType;

    // Constructor
    public Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    // Method to display vehicle info
    public void displayInfo() {
        System.out.println("Max Speed: " + maxSpeed);
        System.out.println("Fuel Type: " + fuelType);
    }
}

// Subclass Car
class Car extends Vehicle {
    private int seatCapacity;

    // Constructor
    public Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    // Overriding displayInfo method
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

// Subclass Truck
class Truck extends Vehicle {
    private int loadCapacity;

    // Constructor
    public Truck(int maxSpeed, String fuelType, int loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    // Overriding displayInfo method
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity);
    }
}

// Subclass Motorcycle
class Motorcycle extends Vehicle {
    private String type;

    // Constructor
    public Motorcycle(int maxSpeed, String fuelType, String type) {
        super(maxSpeed, fuelType);
        this.type = type;
    }

    // Overriding displayInfo method
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Motorcycle Type: " + type);
    }
}

// Main class to test the hierarchy
public class VehicleTest {
    public static void main(String[] args) {
        Vehicle car = new Car(200, "Gasoline", 5);
        Vehicle truck = new Truck(120, "Diesel", 5000);
        Vehicle motorcycle = new Motorcycle(150, "Gasoline", "Sport");

        Vehicle[] vehicles = {car, truck, motorcycle};

        // Polymorphism in action: calling displayInfo on different types of vehicles
        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
            System.out.println();
        }
    }
}
