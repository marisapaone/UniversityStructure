package cs665.termproject.paone;import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class DegreeProgram {

    protected int coreCoursesNeeded;
    protected int elecCoursesNeeded;

    public String degreeName;

    public static int year;

    public Map<String, Course> coreCourses = new HashMap<>();
    public Map<String, Course> elecCourses = new HashMap<>();

    public void setCoreCoursesNeeded(Integer coreCoursesNeeded){ this.coreCoursesNeeded = coreCoursesNeeded; }
    public void setElecCoursesNeeded(Integer elecCoursesNeeded){ this.elecCoursesNeeded = elecCoursesNeeded; }

    public abstract void setDegreeName();

    public void addCoreCourse(Course coreCourse){
        coreCourses.put(coreCourse.getCourseAbbrev(), coreCourse);
    }

    public void addElectiveCourse(Course elecCourse){
        elecCourses.put(elecCourse.getCourseAbbrev(), elecCourse);
    }

    public void setYear(int year){
        this.year = year;
    }

    public static void getAdvisees() { }


}
