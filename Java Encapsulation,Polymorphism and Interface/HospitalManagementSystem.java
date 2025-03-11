import java.util.*;

// Abstract class Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    // Constructor
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Abstract method to calculate the bill (to be implemented by subclasses)
    public abstract double calculateBill();

    // Concrete method to display patient details
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Getter methods (encapsulation)
    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Setter methods (encapsulation)
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

// Interface MedicalRecord
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// InPatient class (extends Patient and implements MedicalRecord)
class InPatient extends Patient implements MedicalRecord {
    private double dailyRate;
    private int daysAdmitted;
    private String medicalRecords = "";

    public InPatient(String patientId, String name, int age, double dailyRate, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyRate = dailyRate;
        this.daysAdmitted = daysAdmitted;
    }

    // Calculate the bill for an inpatient (based on daily rate and days admitted)
    @Override
    public double calculateBill() {
        return dailyRate * daysAdmitted;
    }

    // Implement addRecord() from MedicalRecord interface
    @Override
    public void addRecord(String record) {
        medicalRecords += record + "\n";
    }

    // Implement viewRecords() from MedicalRecord interface
    @Override
    public void viewRecords() {
        if (medicalRecords.isEmpty()) {
            System.out.println("No medical records available.");
        } else {
            System.out.println("Medical Records for " + getName() + ":");
            System.out.println(medicalRecords);
        }
    }
}

// OutPatient class (extends Patient and implements MedicalRecord)
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String medicalRecords = "";

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    // Calculate the bill for an outpatient (based on consultation fee)
    @Override
    public double calculateBill() {
        return consultationFee;
    }

    // Implement addRecord() from MedicalRecord interface
    @Override
    public void addRecord(String record) {
        medicalRecords += record + "\n";
    }

    // Implement viewRecords() from MedicalRecord interface
    @Override
    public void viewRecords() {
        if (medicalRecords.isEmpty()) {
            System.out.println("No medical records available.");
        } else {
            System.out.println("Medical Records for " + getName() + ":");
            System.out.println(medicalRecords);
        }
    }
}

// Main class to test the Hospital Patient Management System
public class HospitalManagementSystem {
    public static void main(String[] args) {
        // Create instances of InPatient and OutPatient
        Patient inPatient = new InPatient("IP123", "John Doe", 45, 200.0, 5);
        Patient outPatient = new OutPatient("OP456", "Jane Smith", 30, 50.0);

        // Create a list to store patient references
        List<Patient> patients = new ArrayList<>();
        patients.add(inPatient);
        patients.add(outPatient);

        // Process each patient in the list
        double totalBill = 0;

        for (Patient patient : patients) {
            patient.getPatientDetails();
            double bill = patient.calculateBill();
            System.out.println("Total Bill: $" + bill);

            // If the patient has medical records, manage them
            if (patient instanceof MedicalRecord) {
                MedicalRecord medicalRecordPatient = (MedicalRecord) patient;
                medicalRecordPatient.addRecord("Diagnosis: Healthy");
                medicalRecordPatient.viewRecords();
            }

            totalBill += bill;
            System.out.println(); // Blank line for separation
        }

        System.out.println("Total Bill for all patients: $" + totalBill);
    }
}
