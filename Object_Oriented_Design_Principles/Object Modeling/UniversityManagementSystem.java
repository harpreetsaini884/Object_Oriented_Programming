import java.util.ArrayList;
import java.util.List;
    

class Course {
    private String courseName;
    private Professor professor;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
        professor.addCourse(this);
    }

    public void enrollStudent(Student student) {
        students.add(student);
        student.addCourse(this);
    }

    public void displayCourseDetails() {
        System.out.println("\nCourse: " + courseName);
        System.out.println("Professor: " + (professor != null ? professor.getName() : "Not Assigned"));
        System.out.println("Enrolled Students:");
        for (Student student : students) {
            System.out.println("  - " + student.getName());
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

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void viewEnrolledCourses() {
        System.out.println("\n" + name + " is enrolled in:");
        for (Course course : courses) {
            System.out.println("  - " + course.getCourseName());
        }
    }
}


class Professor {
    private String name;
    private List<Course> courses;

    public Professor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void viewAssignedCourses() {
        System.out.println("\nProfessor " + name + " is teaching:");
        for (Course course : courses) {
            System.out.println("  - " + course.getCourseName());
        }
    }
}


public class UniversityManagementSystem {
    public static void main(String[] args) {
        
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        
        Professor professor1 = new Professor("Dr. Smith");
        Professor professor2 = new Professor("Dr. Johnson");

        
        Course course1 = new Course("Computer Science");
        Course course2 = new Course("Mathematics");

        
        course1.assignProfessor(professor1);
        course2.assignProfessor(professor2);

        
        course1.enrollStudent(student1);
        course1.enrollStudent(student2);
        course2.enrollStudent(student1);

        
        course1.displayCourseDetails();
        course2.displayCourseDetails();

        
        student1.viewEnrolledCourses();
        student2.viewEnrolledCourses();

        
        professor1.viewAssignedCourses();
        professor2.viewAssignedCourses();
    }
}
