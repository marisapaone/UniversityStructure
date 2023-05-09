package cs665.termproject.paone;import java.util.List;

public interface ICourse {

    public List<SectionCreator> getSections ();

    public String getCourseName();

    public String getCourseAbbrev();

    public String getDescription();
    public String getSyllabus();

    public String format();
}
