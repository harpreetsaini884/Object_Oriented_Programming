class Vehicle {
    private static double registrationFee = 500; // Static variable
    private final String registrationNumber; // Final variable
    private String ownerName;
    private String vehicleType;

    public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        if (this instanceof Vehicle) { // Using instanceof
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Fee: Rs." + registrationFee);
        }
    }
}

// Main class
public class VehicleSystem {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("XYZ123", "Aman", "Car");
        Vehicle vehicle2 = new Vehicle("ABC789", "Raj", "Motorcycle");

        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
    }
}