package cs665.termproject.paone;import java.util.HashMap;
import java.util.Map;

//Part of the Composite Pattern
public class LeafConcentration implements Concentration {

    private String concentrationName;
    private String concentrationId;
    private Instructor faculty;

    Map<String, Course> concentrationCourses;

    public LeafConcentration(String concentrationName, String concentrationId, Instructor faculty){
        this.concentrationName = concentrationName;
        this.concentrationId = concentrationId;
        if (checkFullTimeFaculty(faculty)){
            this.faculty = faculty;
        }
        concentrationCourses = new HashMap<>();
    }

    @Override
    public void printSubConcentrations() {
        System.out.println(this.getName());
    }

    public void printRequiredCourses(){
        System.out.println("Subconcentration " + concentrationName + ": ");
        for(Map.Entry<String,Course> courses : concentrationCourses.entrySet()){
            System.out.println(courses.getValue().getCourseAbbrev() + ": " + courses.getValue().getCourseName());
        }
    }

    public String getName(){
        return concentrationName;
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

    @Override
    public boolean checkFullTimeFaculty(Instructor faculty) {
        if (faculty.isFullTime()){
            return true;
        }
        else{
            System.out.println (faculty.getName() + " is not full time so they can't coordinate a concentration");
            return false;
        }
    }



}
