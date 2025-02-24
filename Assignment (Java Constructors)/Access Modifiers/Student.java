public class Student {
    public int rollNumber;        
    protected String name;         
    private double CGPA;       

    
    public Student(String name, int rollNumber, double CGPA) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.CGPA = CGPA;
    }


    public double getCGPA() {
        return CGPA;
    }

    
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("CGPA: " + CGPA);
    }

    public static void main(String[] args) {
    
        Student student = new Student("Harpreet", 22, 8.5);
        student.display();

    
        student.setCGPA(9.2);
        System.out.println("Updated CGPA: " + student.getCGPA());
    }
}


class PostgraduateStudent extends Student {


    public PostgraduateStudent(String name, int rollNumber, double CGPA) {
        super(name, rollNumber, CGPA);  
    }

    
    @Override
    public void display() {
        super.display();  
        System.out.println("Postgraduate Student");
    }

    public static void main(String[] args) {
        
        PostgraduateStudent pgStudent = new PostgraduateStudent("Rahul", 101, 8.9);
        pgStudent.display();
    }
}
