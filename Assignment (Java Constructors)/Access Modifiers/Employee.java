public class Employee {
    public int employeeId;
    protected String department;
    private double salary;

    Employee(int employeeId,String department,double salary){
        this.employeeId=employeeId;
        this.department=department;
        this.salary=salary;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
    public double getSalary(){
        return salary;
    }
    public void Salary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary must be positive.");
        }
    }
    void Display(){
        System.out.println("EmployeeId "+employeeId);
        System.out.println("Department "+department);
        System.out.println("Salary "+salary);
    }
    class Manager extends Employee{
        Manager(int employeeId,String department,double salary){
            super(employeeId, department, salary);
        }
        void Display(){
            super.Display();
        }
    }
    public static void main(String[] args){
        Employee ep=new Employee(23,"SDE",5000);
        ep.Display();
        ep.setSalary(55000.0);
        System.out.println("Updated Salary: " + ep.getSalary());

        ep.getSalary();

    }
}
