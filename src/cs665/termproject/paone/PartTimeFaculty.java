package cs665.termproject.paone;import java.util.ArrayList;
import java.util.List;

public class PartTimeFaculty implements Instructor{

    public String instructorName;
    public String instructorId;

    public int coursesCountFall;
    public int coursesCountSpring;
    public int coursesCountSummer;

    public List<SectionCreator> coursesTaught = new ArrayList<SectionCreator>();

    public PartTimeFaculty(String instructorName, String instructorId){
        this.instructorName = instructorName;
        this.instructorId = instructorId;
    }

    //*****OBSERVER PATTERN*********
    @Override
    public void update(SectionCreator section) {
        System.out.println("To: " + getName() + ", this class: " + section.getCourseAbbrevSection() +
                " is full. Cannot enroll any more students!");
    }
    //******************************

    public String toString(){
        return instructorName;
    }

    @Override
    public void addToCoursesTaught(SectionCreator course) {
        coursesTaught.add(course);
    }

    @Override
    public List<SectionCreator> printCoursesTaught() {
        return coursesTaught;
    }

    @Override
    public void receiveQuery(String query) {
        System.out.println("Receiving message to " + getName() + ", MESSAGE: " + query);
    }

    @Override
    public boolean isPartTime() {
        return true;
    }

    @Override
    public boolean isFullTime() {
        return false;
    }

    @Override
    public int getCoursesCountFall() {
        return coursesCountFall;
    }

    @Override
    public int getCoursesCountSpring() {
        return coursesCountSpring;
    }

    @Override
    public int getCoursesCountSummer() {
        return coursesCountSummer;
    }

    @Override
    public void setCoursesCountFall(int coursesCountFall) {
        this.coursesCountFall = coursesCountFall;
    }

    @Override
    public void setCoursesCountSpring(int coursesCountSpring) {
        this.coursesCountSpring = coursesCountSpring;
    }

    @Override
    public void setCoursesCountSummer(int coursesCountSummer){
        this.coursesCountSummer = coursesCountSummer;
    }

    @Override
    public String getName() {
        return instructorName;
    }

    @Override
    public void setName(String name) {
        this.instructorName = name;
    }

    @Override
    public String getInstructorId() {
        return instructorId;
    }


}
