import java.util.*;

// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Abstract method to calculate rental cost
    public abstract double calculateRentalCost(int days);

    // Getter and setter methods for encapsulation
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    // Method to display vehicle details
    public void displayVehicleDetails(int days) {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Type: " + type);
        System.out.println("Rental Rate per Day: " + rentalRate);
        System.out.println("Rental Cost for " + days + " days: " + calculateRentalCost(days));
    }
}

// Interface Insurable
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Car subclass
class Car extends Vehicle implements Insurable {
    private static final double INSURANCE_RATE = 10.0;

    // Constructor
    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;  // Simple rental cost calculation for car
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * INSURANCE_RATE / 100;  // Insurance based on rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Car insurance rate: " + INSURANCE_RATE + "% of rental rate";
    }
}

// Bike subclass
class Bike extends Vehicle implements Insurable {
    private static final double INSURANCE_RATE = 5.0;

    // Constructor
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;  // Simple rental cost calculation for bike
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * INSURANCE_RATE / 100;  // Insurance based on rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike insurance rate: " + INSURANCE_RATE + "% of rental rate";
    }
}

// Truck subclass
class Truck extends Vehicle implements Insurable {
    private static final double INSURANCE_RATE = 15.0;

    // Constructor
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;  // Simple rental cost calculation for truck
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * INSURANCE_RATE / 100;  // Insurance based on rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck insurance rate: " + INSURANCE_RATE + "% of rental rate";
    }
}

// Main class to test the system
public class VehicleRentalSystem {
    public static void main(String[] args) {
        // Create instances of vehicles
        Vehicle car = new Car("CAR123", 100);
        Vehicle bike = new Bike("BIKE456", 50);
        Vehicle truck = new Truck("TRUCK789", 200);

        // Create a list of vehicles
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(truck);

        // Calculate and display rental cost and insurance cost for each vehicle
        int rentalDays = 5;
        for (Vehicle vehicle : vehicles) {
            vehicle.displayVehicleDetails(rentalDays);
            if (vehicle instanceof Insurable) {
                Insurable insurableVehicle = (Insurable) vehicle;
                System.out.println(insurableVehicle.getInsuranceDetails());
                System.out.println("Insurance Cost: " + insurableVehicle.calculateInsurance());
            }
            System.out.println();  // Add a line break between vehicle details
        }
    }
}
