package cs665.termproject.paone;import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Part of the Composite Pattern
public class CompositeConcentration implements Concentration {

    private String concentrationName;
    private String concentrationId;
    private Instructor faculty;

    private List<Concentration> subConcentration;
    private Map<String, Course> concentrationCourses;

    public CompositeConcentration(String concentrationName, String concentrationId, Instructor faculty){
        this.concentrationName = concentrationName;
        this.concentrationId = concentrationId;
        if (checkFullTimeFaculty(faculty)){
            this.faculty = faculty;
        }
        this.subConcentration = new ArrayList<>();
    }

    //Checks if the faculty is fulltime so that it can be determined if they can coordinate a concentration
    public boolean checkFullTimeFaculty(Instructor faculty) {
        if (faculty.isFullTime()){
            return true;
        }
        else{
            System.out.println (faculty.getName() + " is not full time so they can't coordinate a concentration");
            return false;
        }
    }

    @Override
    public void printSubConcentrations() {
        System.out.println(concentrationName + ": ");
        subConcentration.forEach(Concentration::printRequiredCourses);
    }

    @Override
    public void printRequiredCourses() {
        System.out.println("This subconcentration has no required courses added.");
    }

    public void addConcentration (Concentration concentration){
        subConcentration.add(concentration);
    }

    public void removeConcentration(Concentration concentration){
        subConcentration.remove(concentration);
    }

    public void addCourseToConcentration(Course course){
        if (concentrationCourses.containsKey(course.getCourseAbbrev())){
            System.out.println("This course already exists in this concentration");
        }
        else {
            concentrationCourses.put(course.getCourseAbbrev(), course);
        }
    }

    public void removeCourseFromConcentration(Course course){
        if (!concentrationCourses.containsKey(course.getCourseAbbrev())){
            System.out.println("This course does not exist in this concentration");
        }
        else {
            concentrationCourses.remove(course.getCourseAbbrev(), course);
        }
    }

}
