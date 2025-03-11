import java.util.*;

// Abstract class Employee
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Abstract method to calculate salary
    public abstract double calculateSalary();

    // Concrete method to display details
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + calculateSalary());
    }

    // Getter and setter methods for encapsulation
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}

// FullTimeEmployee subclass
class FullTimeEmployee extends Employee {
    private double fixedSalary;

    // Constructor
    public FullTimeEmployee(int employeeId, String name, double baseSalary, double fixedSalary) {
        super(employeeId, name, baseSalary);
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double calculateSalary() {
        return fixedSalary; // Full-time employees have a fixed salary
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }
}

// PartTimeEmployee subclass
class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    // Constructor
    public PartTimeEmployee(int employeeId, String name, double baseSalary, double hourlyRate, int hoursWorked) {
        super(employeeId, name, baseSalary);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked; // Part-time salary based on hours worked
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}

// Department interface
interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

// Manager class implementing Department
class Manager implements Department {
    private String departmentName;

    @Override
    public void assignDepartment(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + departmentName;
    }
}

// Main class to test the system
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Create instances of employees
        Employee fullTimeEmployee = new FullTimeEmployee(101, "Alice", 50000, 60000);
        Employee partTimeEmployee = new PartTimeEmployee(102, "Bob", 0, 20, 100);

        // Display details of the employees
        List<Employee> employees = new ArrayList<>();
        employees.add(fullTimeEmployee);
        employees.add(partTimeEmployee);

        for (Employee employee : employees) {
            employee.displayDetails();
            System.out.println();  // Add a line break between employee details
        }

        // Create a manager and assign department
        Manager manager = new Manager();
        manager.assignDepartment("Human Resources");
        System.out.println(manager.getDepartmentDetails());
    }
}
