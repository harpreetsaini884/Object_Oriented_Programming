package Class_Object_SequenceDiagram.SchoolResultsApplication;
import java.util.ArrayList;
import java.util.List;


class Subject {
    String name;
    int marks;

    public Subject(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }
}


class Student {
    String name;
    List<Subject> subjects;

    public Student(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public String calculateGrade() {
        return GradeCalculator.calculateGrade(this);
    }
}


class GradeCalculator {
    public static String calculateGrade(Student student) {
        int totalMarks = 0;
        for (Subject subject : student.subjects) {
            totalMarks += subject.getMarks();
        }
        int avg = totalMarks / student.subjects.size();

        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }
}


public class SchoolResultsApplication {
    public static void main(String[] args) {
        Student student = new Student("John");
        student.addSubject(new Subject("Maths", 90));
        student.addSubject(new Subject("Science", 85));

        System.out.println("Student: " + student.name);
        System.out.println("Grade: " + student.calculateGrade());
    }
}
