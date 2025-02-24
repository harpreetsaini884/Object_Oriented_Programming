public class Course {
    String courseName;
    int duration;
    double fees;

    static String instituteName="Tech Academy";
    Course(String courseName,int duration,double fees){
        this.courseName=courseName;
        this.duration=duration;
        this.fees=fees;
    }
    void displayCourseDetail(){
        System.out.println("Name of the Course "+courseName);
        System.out.println("Duration of the Course "+duration);
        System.out.println("Fees for the Course "+fees);
        System.out.println("Institute "+instituteName);
    }
    static void updateInstituteName(String newinstituteName){
        instituteName=newinstituteName;
        System.out.println("The name of the Institute is "+instituteName);
    }
    public static void main(String[] args){
        Course c=new Course("BTech", 48, 82000);
        c.displayCourseDetail();
    }
}
