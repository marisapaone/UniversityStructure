package cs665.termproject.paone;import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CertificateProgram {

    public int year;

    public String certificateName;

    public int coursesTotal = 4;

    public int coursesCount;

     Set<Course> requiredCourses = new HashSet<>();

     Set<String> reqCourseStrings = new HashSet<>();

    static Set<CertificateProgram> certificatePrograms = new HashSet<>();

    public CertificateProgram(String certificateName){
        this.certificateName = certificateName;
        certificatePrograms.add(this);
    }

    public String award() {
         return "Congratulations, you have been awarded the " + certificateName + "!!!";
    }

    public void addRequiredCourse(Course course){
        if (coursesCount < coursesTotal){
            coursesCount++;
            requiredCourses.add(course);
            reqCourseStrings.add(course.getCourseAbbrev());
        }
        else{
            System.out.println("This certificate already has 4 courses as a requirement.");
        }
    }

    public void printRequiredCourses(){
        System.out.println(certificateName + "'s Required Courses: " + requiredCourses);
    }

    //Setters and Getters

    public Set<Course> getRequiredCourses(){
        return requiredCourses;
    }

    public void setYear(int year){
        this.year = year;
    }

}
