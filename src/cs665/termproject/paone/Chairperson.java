package cs665.termproject.paone;
import java.util.ArrayList;
import java.util.List;

public class Chairperson implements Instructor {

    private String instructorName;

    public String instructorId;

    public int coursesCountFall;

    public int coursesCountSpring;

    public int coursesCountSummer;

    public static List<SectionCreator> coursesTaught = new ArrayList<SectionCreator>();

    @Override
    public boolean isFullTime() {
        return false;
    }

    @Override
    public boolean isPartTime() {
        return true;
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
        System.out.println("Receiving message to the chairperson " + getName() + ", MESSAGE: " + query);
    }

    //*******OBSERVER PATTERN*********

    //Notification update for the chairperson
    @Override
    public void update(SectionCreator section) {
        System.out.println("To: " + getName() + ", this class: " + section.getCourseAbbrevSection() +
                " is full. Cannot enroll any more students!");
    }

    private static Subject instructorSubject;

    public static Subject getInstructorService(){
        return instructorSubject;
    }

    public static void sectionIsFull(SectionCreator section){
        instructorSubject.notifySubscribers(section);
    }


    //*******SINGLETON PATTERN********

    //static chairperson instance to ensure there is only one instance of this class
    private static volatile Chairperson instance;

    private Chairperson(String instructorName, String instructorId) {
        this.instructorName = instructorName;
        this.instructorId = instructorId;
        instructorSubject = new NotificationService();
        //Part of observer pattern - when a chairperson is created (there is only one per year) then they
        //will be subscribed to the Instructor Notification Service to be notified when a class is full.
        getInstructorService().subscribe(this);
    }

    //static method to ensure there is only one instance
    public static Chairperson getInstance(String instructorName, String instructorId) {
        //limiting synchronization
        if (instance == null) {
            //synchronized block in case there are multithreads
            synchronized (Chairperson.class) {
                if (instance == null) {
                    instance = new Chairperson(instructorName, instructorId);
                }
            }
        }
        return instance;
    }

    //Getters and setter methods

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
    public void setCoursesCountSummer(int coursesCountSummer) {
        this.coursesCountSummer = coursesCountSummer;
    }

}
