package cs665.termproject.paone;import java.util.List;

//Course class that imlements ICourse for the Decorator Pattern
public class Course implements ICourse{

    private final String courseName;

    private final String courseAbbrev;

    private String description;

    private String syllabus;

    SectionCreator sections;

    protected Course(String courseName, String courseAbbrev, String description, String syllabus) {
        this.courseName = courseName;
        this.courseAbbrev = courseAbbrev;
        this.description = description;
        this.syllabus = syllabus;
    }

    public List<SectionCreator> getSections (){
        return sections.getAllSections(this);
    }

    public String getCourseName(){
        return courseName;
    }

    public String getCourseAbbrev(){
        return courseAbbrev;
    }

    public String toString()
    {
        return courseAbbrev + ": " + courseName;
    }

    //Format method that is overrided with a html format decorator pattern
    public String format(){
        return  getCourseAbbrev()+ ", " + getDescription() + ", " + getSyllabus();
    }

    public String getDescription() {
        return description;
    }

    public String getSyllabus(){
        return syllabus;
    }


}
