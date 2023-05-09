package cs665.termproject.paone;import java.util.Collection;
import java.util.Map;

public abstract class GraduateProgram extends DegreeProgram{

    public GraduateProgram(){
        setCoreCoursesNeeded(5);
        setElecCoursesNeeded(3);
        setDegreeName();
    }

    public String toString(){
        return degreeName;
    }

    public static Instructor getGraduateAdvisor(){
        return FullTimeFaculty.getGraduateAdvisor();
    }

    public void setDegreeName(){
        super.degreeName = "Graduate Degree";
    }

    public void addCoreCourse(Course coreCourse){
        coreCourses.put(coreCourse.getCourseAbbrev(), coreCourse);
    }

    public Collection<Course> printCoreCourses(){ return coreCourses.values();}

    public void addElectiveCourse(Course course){
        elecCourses.put(course.getCourseAbbrev(), course);
    }

    public Collection<Course> printElecCourses(){
        return elecCourses.values();
    }

    public String award() {
        return "Congrats Graduate!";
    }

    public static void getAdvisees(int year){
        System.out.println("Advisees of " + getGraduateAdvisor()+ ":");
        for(Map.Entry<String, Student> entry : CSProgram.getCSProgramInstance(year).studentMap.entrySet()){
            if (entry.getValue().getDegreeProgram().degreeName.contains("Graduate Degree")){
                System.out.println(entry.getValue().getStudentName());
            }
        }
    }

}
