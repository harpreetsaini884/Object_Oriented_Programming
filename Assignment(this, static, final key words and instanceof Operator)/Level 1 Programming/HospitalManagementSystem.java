class Patient {
    private static String hospitalName = "City Hospital"; // Static variable shared across all patients
    private static int totalPatients = 0; // Static counter for total patients
    private final int patientID; // Final variable (Unique ID for each patient)
    private String name;
    private int age;
    private String ailment;

    // Constructor using 'this' to resolve ambiguity
    public Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++; // Increment patient count
    }

    // Method to display patient details
    public void displayPatientDetails() {
        if (this instanceof Patient) { // Using instanceof
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }

    // Static method to display total number of patients
    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }
}

// Main class to test the Patient class
public class HospitalManagementSystem {
    public static void main(String[] args) {
        // Creating patient objects
        Patient patient1 = new Patient(101, "Aman", 22, "Fever");
        Patient patient2 = new Patient(102, "Adarsh", 23, "Cold");

        // Displaying patient details
        patient1.displayPatientDetails();
        System.out.println();
        patient2.displayPatientDetails();

        // Displaying total patients admitted
        Patient.getTotalPatients();
    }
}
