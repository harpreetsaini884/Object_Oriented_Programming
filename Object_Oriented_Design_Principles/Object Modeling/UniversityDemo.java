import java.util.ArrayList;
import java.util.List;


class University {
    private String name;
    private List<Department> departments; 

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName)); 
    }

    public void displayDetails() {
        System.out.println("University: " + name);
        for (Department dept : departments) {
            dept.displayDepartment();
        }
    }

    public void closeUniversity() {
        System.out.println("\nClosing University: " + name);
        departments.clear(); 
    }
}


class Department {
    private String name;
    private List<Faculty> facultyList; 

    public Department(String name) {
        this.name = name;
        this.facultyList = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        facultyList.add(faculty); 
    }

    public void displayDepartment() {
        System.out.println("  Department: " + name);
        System.out.println("    Faculty Members:");
        for (Faculty faculty : facultyList) {
            System.out.println("      " + faculty.getName());
        }
    }
}


class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class UniversityDemo {
    public static void main(String[] args) {
        
        University uni = new University("Oxford University");

        
        uni.addDepartment("Computer Science");
        uni.addDepartment("Physics");

        
        Faculty profJohn = new Faculty("Prof. John");
        Faculty profEmily = new Faculty("Prof. Emily");

        
        Department csDept = new Department("Computer Science");
        csDept.addFaculty(profJohn);

        Department physicsDept = new Department("Physics");
        physicsDept.addFaculty(profEmily);

        
        uni.displayDetails();

        
        uni.closeUniversity();

        
        System.out.println("\nIndependent Faculty Members:");
        System.out.println("  " + profJohn.getName());
        System.out.println("  " + profEmily.getName());
    }
}
