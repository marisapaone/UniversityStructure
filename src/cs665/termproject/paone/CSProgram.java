package cs665.termproject.paone;import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CSProgram {

    // map of courses
    // map of students
    // map of instructors
    final Map<String, Student> studentMap;
    final Map<String, Instructor> instructorMap;
    final Map<String, Course> courseMap;
    final Map<String, SectionCreator> sectionMap;

    private static CSProgram csProgramInstance;

    private final int year;

    private CSProgram(int year){
        studentMap = new HashMap<>();
        instructorMap = new HashMap<>();
        courseMap = new LinkedHashMap<>();
        sectionMap = new HashMap<>();
        this.year = year;
    }


    //************SINGLETON PATTERN****************
    public static synchronized CSProgram getCSProgramInstance(int year) {
        if (csProgramInstance == null){
            if (year > 0) {
                //No if statement is used for if the year is valid here, in case a university wants to input students/grades
                //from a while ago. So there is no limitation on year besides that it cannot be negative.
                csProgramInstance = new CSProgram(year);
            }
            else{
                System.out.println("Instance was not created because the year inputted is negative. Run the program again.");
            }
        }
        return csProgramInstance;
    }


    public synchronized Student createStudent(DegreeProgram degreeProgram, String studentName, String studentID)
    throws Exception{
        Student student = new Student(degreeProgram, studentName, studentID);

        if (studentMap.containsKey(student.getStudentID())){
            throw new Exception("Student already exists");
        }
        else {
            studentMap.put(studentID, student);
        }
        return student;
    }

    public synchronized Instructor createChairperson(String instructorName, String instructorId) throws Exception{
        Instructor instructor = Chairperson.getInstance(instructorName, instructorId);
        if(instructorMap.containsKey(instructor.getInstructorId())){
            throw new Exception("Instructor already exists");
        }
        else{
            instructorMap.put(instructorId, instructor);
        }
        return instructor;
    }

    public synchronized Instructor createFullTimeFaculty(String instructorName, String instructorId) throws Exception{
        Instructor instructor = new FullTimeFaculty(instructorName, instructorId);
        if(instructorMap.containsKey(instructor.getInstructorId())){
            throw new Exception("Instructor already exists");
        }
        else{
            instructorMap.put(instructorId, instructor);
        }
        return instructor;
    }
    public synchronized Instructor createPartTimeFaculty(String instructorName, String instructorId) throws Exception{
        Instructor instructor = new PartTimeFaculty(instructorName, instructorId);
        if(instructorMap.containsKey(instructor.getInstructorId())){
            throw new Exception("Instructor already exists");
        }
        else{
            instructorMap.put(instructorId, instructor);
        }
        return instructor;
    }

    public synchronized Course createCourse(String courseName, String courseAbbrev, String description, String syllabus)throws Exception {
        Course course = new Course(courseName, courseAbbrev, description, syllabus);
        if (courseMap.containsKey(course.getCourseAbbrev())){
            throw new Exception("Course already exists");
        }
        else{
            courseMap.put(courseAbbrev,course);
        }
        return course;
    }

    public synchronized SectionCreator createSection(Course course,String sectionName, Semester semester, int enrollmentLimit, Instructor instructor)throws Exception {
        SectionCreator section = new SectionCreator(course, sectionName, semester, enrollmentLimit, instructor);
        if (sectionMap.containsKey(section.getCourseAbbrevSection())){
            throw new Exception("Section already exists");
        }
        else{
            sectionMap.put(section.getCourseAbbrevSection(), section);
        }
        return section;
    }

    public Map<String, Course> getCourseMap(int year){
        return getCSProgramInstance(year).courseMap;
    }
    public void printCourseMap(){
        for (Map.Entry<String, Course> entry : courseMap.entrySet()){
            System.out.println(entry.getValue());
        }

    }

    public int getYear(){
        return year;
    }


}
