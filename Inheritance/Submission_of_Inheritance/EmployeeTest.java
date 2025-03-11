import java.util.*;

// Base class Employee
class Employee {
    private String name;
    private int id;
    private double salary;

    // Constructor
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }

    // Getters for name, id, and salary
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }
}

// Subclass Manager
class Manager extends Employee {
    private int teamSize;

    // Constructor
    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    // Overriding displayDetails method
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

// Subclass Developer
class Developer extends Employee {
    private String programmingLanguage;

    // Constructor
    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    // Overriding displayDetails method
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

// Subclass Intern
class Intern extends Employee {
    private String university;

    // Constructor
    public Intern(String name, int id, double salary, String university) {
        super(name, id, salary);
        this.university = university;
    }

    // Overriding displayDetails method
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("University: " + university);
    }
}

// Main class to test the hierarchy
public class EmployeeTest {
    public static void main(String[] args) {
        Employee manager = new Manager("Alice", 101, 80000, 10);
        Employee developer = new Developer("Bob", 102, 60000, "Java");
        Employee intern = new Intern("Charlie", 103, 15000, "XYZ University");

        manager.displayDetails();
        System.out.println();
        developer.displayDetails();
        System.out.println();
        intern.displayDetails();
    }
}
