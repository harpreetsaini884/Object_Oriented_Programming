import java.util.*;

// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    // Constructor
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Abstract method to calculate fare (to be implemented by subclasses)
    public abstract double calculateFare(double distance);

    // Concrete method to get vehicle details
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: $" + ratePerKm);
    }

    // Getter methods (encapsulation)
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    // Setter methods (encapsulation)
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }
}

// Interface GPS
interface GPS {
    void getCurrentLocation();
    void updateLocation(String newLocation);
}

// Car class (extends Vehicle and implements GPS)
class Car extends Vehicle implements GPS {
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Getting current location of Car...");
    }

    @Override
    public void updateLocation(String newLocation) {
        System.out.println("Updating location of Car to: " + newLocation);
    }
}

// Bike class (extends Vehicle and implements GPS)
class Bike extends Vehicle implements GPS {
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Getting current location of Bike...");
    }

    @Override
    public void updateLocation(String newLocation) {
        System.out.println("Updating location of Bike to: " + newLocation);
    }
}

// Auto class (extends Vehicle and implements GPS)
class Auto extends Vehicle implements GPS {
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Getting current location of Auto...");
    }

    @Override
    public void updateLocation(String newLocation) {
        System.out.println("Updating location of Auto to: " + newLocation);
    }
}

// Main class to test the Ride-Hailing Application
public class RideHailingApp {
    public static void main(String[] args) {
        // Create instances of different vehicles
        Vehicle car = new Car("V123", "John", 1.5);
        Vehicle bike = new Bike("V456", "Alex", 0.8);
        Vehicle auto = new Auto("V789", "Sam", 1.0);

        // Create a list of vehicles
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(auto);

        // Calculate and print the fare for all vehicles
        calculateFareForAllVehicles(vehicles, 10);  // For 10 km distance
    }

    // Method to calculate and print the fare for all vehicles dynamically
    public static void calculateFareForAllVehicles(List<Vehicle> vehicles, double distance) {
        for (Vehicle vehicle : vehicles) {
            vehicle.getVehicleDetails();
            double fare = vehicle.calculateFare(distance);
            System.out.println("Fare for " + vehicle.getClass().getSimpleName() + ": $" + fare);

            // Demonstrate GPS functionality
            if (vehicle instanceof GPS) {
                GPS gpsVehicle = (GPS) vehicle;
                gpsVehicle.getCurrentLocation();
                gpsVehicle.updateLocation("New Location");
            }
            System.out.println();  // Blank line for separation
        }
    }
}
