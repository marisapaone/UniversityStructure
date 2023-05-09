package cs665.termproject.paone;import java.util.ArrayList;
import java.util.List;

public class FullTimeFaculty implements Instructor{

    public int coursesCountFall;
    public int coursesCountSpring;
    public int coursesCountSummer;

    public String instructorName;

    public String instructorId;

    public Course course;

    public static Instructor graduateAdvisor;

    public static Instructor undergraduateAdvisor;

    public static List<SectionCreator> coursesTaught = new ArrayList<SectionCreator>();

    public FullTimeFaculty(String instructorName, String instructorId){
        this.instructorName = instructorName;
        this.instructorId = instructorId;
    }

    //***********COMMAND PATTERN*****************
    @Override
    public void receiveQuery(String query) {
        System.out.println("Receiving message to " + getName() + ", MESSAGE: " + query);
    }

    //************OBSERVER PATTERN***************

    @Override
    public void update(SectionCreator section) {
        System.out.println("To: " + getName() + ", this class: " + section.getCourseAbbrevSection() +
                " is full. Cannot enroll any more students!");
    }

    //******************************************

    public void addToCoursesTaught (SectionCreator course){
        coursesTaught.add(course);
    }

    @Override
    public List<SectionCreator> printCoursesTaught() {
        return coursesTaught;
    }

    @Override
    public boolean isPartTime() {
        return false;
    }

    public String toString(){
        return instructorName;
    }

    @Override
    public boolean isFullTime() {
        return true;
    }

    //Setters and Getters

    public static void setGraduateAdvisor(Instructor gradAdvisor, String instructorId){
        graduateAdvisor = new FullTimeFaculty(gradAdvisor.getName(), gradAdvisor.getInstructorId());
    }
    public static Instructor getGraduateAdvisor(){
        return graduateAdvisor;
    }

    public static void setUndergraduateAdvisor(Instructor undergradAdvisor, String instructorId){
        undergraduateAdvisor = new FullTimeFaculty(undergradAdvisor.getName(), undergradAdvisor.getInstructorId());
    }
    public static Instructor getUndergraduateAdvisor (){
        return undergraduateAdvisor;
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

    @Override
    public int getCoursesCountFall() {return coursesCountFall;}

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



}
