import java.util.ArrayList;
import java.util.List;

class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addEmployeeToDepartment(String deptName, String empName) {
        for (Department dept : departments) {
            if (dept.getName().equals(deptName)) {
                dept.addEmployee(empName);
                return;
            }
        }
        System.out.println("Department " + deptName + " not found in " + name);
    }

    public void displayCompanyStructure() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            dept.displayEmployees();
        }
    }

    
    public void deleteCompany() {
        departments.clear();
        System.out.println("Company " + name + " and all its departments/employees have been deleted.");
    }
}

class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addEmployee(String empName) {
        employees.add(new Employee(empName));
    }

    public void displayEmployees() {
        System.out.println("  Department: " + name);
        for (Employee emp : employees) {
            System.out.println("    Employee: " + emp.getName());
        }
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class CompanyDemo {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");

        company.addDepartment("Engineering");
        company.addDepartment("HR");

        company.addEmployeeToDepartment("Engineering", "Alice");
        company.addEmployeeToDepartment("Engineering", "Bob");
        company.addEmployeeToDepartment("HR", "Charlie");

        company.displayCompanyStructure();

        
        company.deleteCompany();
    }
}
