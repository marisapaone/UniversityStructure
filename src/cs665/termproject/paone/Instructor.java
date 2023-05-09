package cs665.termproject.paone;import java.util.List;

public interface Instructor extends Observer{

    public String getName();

    public void setName(String name);

    public String getInstructorId();

    public boolean isFullTime();

    public boolean isPartTime();

    public int getCoursesCountFall();

    public void setCoursesCountFall(int coursesCountFall);

    public int getCoursesCountSpring();

    public void setCoursesCountSpring(int coursesCountSpring);

    public int getCoursesCountSummer();

    public void setCoursesCountSummer(int coursesCountSummer);

    public String toString();

    public void addToCoursesTaught (SectionCreator course);

    public List<SectionCreator> printCoursesTaught();

    public void receiveQuery(String query);

    public void update(SectionCreator section);

}
