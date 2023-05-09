package cs665.termproject.paone;//Part of the composite pattern
public interface Concentration {

    void printSubConcentrations();

    void printRequiredCourses();

    void addCourseToConcentration(Course course);

    void removeCourseFromConcentration(Course course);

    boolean checkFullTimeFaculty(Instructor faculty);
}
