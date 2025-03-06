import java.util.ArrayList;
import java.util.List;

class School {
    private String name;
    private List<Student> students; 

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student); 
    }

    public void displayStudents() {
        System.out.println("School: " + name);
        for (Student student : students) {
            System.out.println("  Student: " + student.getName());
            student.displayEnrolledCourses();
        }
    }
}

class Student {
    private String name;
    private List<Course> courses; 

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollInCourse(Course course) {
        courses.add(course);
        course.addStudent(this); 
    }

    public void displayEnrolledCourses() {
        System.out.println("    Enrolled Courses:");
        for (Course course : courses) {
            System.out.println("      " + course.getCourseName());
        }
    }
}

class Course {
    private String courseName;
    private List<Student> students; 

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayEnrolledStudents() {
        System.out.println("Course: " + courseName);
        System.out.println("  Enrolled Students:");
        for (Student student : students) {
            System.out.println("    " + student.getName());
        }
    }
}

public class SchoolDemo {
    public static void main(String[] args) {
        
        School school = new School("Springfield High");

        
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        
        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        
        alice.enrollInCourse(math);
        alice.enrollInCourse(science);
        bob.enrollInCourse(math);

        
        school.addStudent(alice);
        school.addStudent(bob);

        
        school.displayStudents();

        
        math.displayEnrolledStudents();
        science.displayEnrolledStudents();
    }
}
