package cs665.termproject.paone;
import java.util.Collection;
import java.util.Map;

public abstract class UndergraduateProgram extends DegreeProgram {

    public UndergraduateProgram(){
        setCoreCoursesNeeded(8);
        setElecCoursesNeeded(8);
        setDegreeName();
    }

    public String award() {
        return "Congrats UnderGrad!";
    }

    @Override
    public void setDegreeName() {
        super.degreeName = "UnderGraduate Degree";
    }

    public static Instructor getUndergraduateAdvisor(){
        return FullTimeFaculty.getUndergraduateAdvisor();
    }

    public void addCoreCourse(Course coreCourse){
        coreCourses.put(coreCourse.getCourseAbbrev(), coreCourse);
    }

    public Collection<Course> printCoreCourses(){
        return coreCourses.values();
    }

    public void addElectiveCourse(Course elecCourse){
        elecCourses.put(elecCourse.getCourseAbbrev(), elecCourse);
    }

    public Collection<Course> printElecCourses(){
        return elecCourses.values();
    }

    public String toString(){
        return degreeName;
    }

    public static void getAdvisees(int year){
        System.out.println("Advisees of " + getUndergraduateAdvisor()+ ":");
        for(Map.Entry<String, Student> entry : CSProgram.getCSProgramInstance(year).studentMap.entrySet()){
            if (entry.getValue().getDegreeProgram().degreeName.contains("Undergraduate Degree")){
                System.out.println(entry.getValue().getStudentName());
            }
        }

    }

}
