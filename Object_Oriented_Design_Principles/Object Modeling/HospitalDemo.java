import java.util.ArrayList;
import java.util.List;


class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void displayHospitalDetails() {
        System.out.println("Hospital: " + name);
        System.out.println("Doctors:");
        for (Doctor doc : doctors) {
            System.out.println("  " + doc.getName());
        }
        System.out.println("Patients:");
        for (Patient pat : patients) {
            System.out.println("  " + pat.getName());
        }
    }
}


class Doctor {
    private String name;
    private List<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void consult(Patient patient) {
        patients.add(patient);
        patient.addDoctor(this);
        System.out.println("Dr. " + name + " is consulting " + patient.getName());
    }
}


class Patient {
    private String name;
    private List<Doctor> doctors;

    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }
}

public class HospitalDemo {
    public static void main(String[] args) {
        
        Hospital hospital = new Hospital("City General Hospital");

        
        Doctor doctorA = new Doctor("Alice");
        Doctor doctorB = new Doctor("Bob");

        
        Patient patientX = new Patient("Charlie");
        Patient patientY = new Patient("David");

        
        hospital.addDoctor(doctorA);
        hospital.addDoctor(doctorB);
        hospital.addPatient(patientX);
        hospital.addPatient(patientY);

        
        hospital.displayHospitalDetails();

        
        doctorA.consult(patientX);
        doctorB.consult(patientY);
        doctorA.consult(patientY); 

        System.out.println("\nConsultations completed.");
    }
}
