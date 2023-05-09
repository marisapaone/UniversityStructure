package cs665.termproject.paone;import java.util.*;

public class SectionCreator extends Course{

    private Semester semester;

    public int enrollmentLimit;

    public int enrolled;

    public String sectionName;

    public List<Student> studentsEnrolled = new ArrayList<Student>();

    public HashMap<Student, Grade> grades = new HashMap<>();

    public HashMap<Student, Grade> getGrades(){
        return grades;
    }

    protected static List<SectionCreator> sections;

    public Map<Student, SectionCreator> waitlist;

    protected static List<SectionCreator> coursesPerSemester;

    public Instructor instructor;

    public SectionCreator(Course course,String sectionName, Semester semester, int enrollmentLimit, Instructor instructor ){
        super(course.getCourseName(), course.getCourseAbbrev(), course.getDescription(), course.getSyllabus());
        this.sectionName = sectionName;
        this.semester = semester;
        this.enrollmentLimit = enrollmentLimit;
        //if the instructor is available to teach this section, add the section to the arraylist of the specific course
        if (checkInstructor(instructor, semester) == true){
            this.instructor = instructor;
            getAllSections(course);
            sections.add(this);
            instructor.addToCoursesTaught(this);
        }

    }

    //The waitlist for a course section is involved with the observer design pattern
    //If the course section is full and over the enrollment limit, then the student is put on the waitlist.
    public  Map<Student, SectionCreator> addToWaitlist(SectionCreator section, Student student){
        if (waitlist == null){
            waitlist = new LinkedHashMap<>();
            waitlist.put(student, section);
            System.out.println(student.studentName + ", you are on the waitlist for " + section.getCourseAbbrevSection());
        }
        else{
            waitlist.put(student, section);
            System.out.println(student.studentName + ", you are on the waitlist for " + section.getCourseAbbrevSection());
        }
        return waitlist;
    }

    public void printWaitlist(){
        System.out.println(waitlist);
    }

    //Strategy pattern - Sets the grade for the student when they complete the course, checks if the student exists in the class section.
    public void setGrade(Student student, Grade grade){
        if (studentsEnrolled.contains(student)){
            grades.put(student,grade);
            student.completedCourse(this);
        }
        else{
            System.out.println(student.studentName + " is not enrolled in " + this.getCourseName());
        }
    }

    //This method prints specific course sections and the semester they are offered
    public static void printSpecificCourseSections(Course course){
        for (SectionCreator x: sections){
            if (course.getCourseAbbrev() == x.getCourseAbbrev()){
                System.out.print(x );
                System.out.println(" - " + x.getSemester());
            }
        }
    }

    public void setEnrolled(int enrolled){
        this.enrolled = enrolled;
    }

    public int getEnrolled(){
        return enrolled;
    }

    public String toString()
    {
        return getCourseAbbrev() + sectionName + ": " + getCourseName() ;
    }

    //Gets all course sections every created from the class
    public static List<SectionCreator> getAllSections(Course course){
        if (sections == null){
            sections = new ArrayList<SectionCreator>();
        }
        return sections;
    }

    //Checks if the instructor is available
    public boolean checkInstructor(Instructor instructor, Semester semester){
        //If the instructor is full time teaching more than 3 courses a semester, the course section will not be added!
        if (instructor.isFullTime() && ((semester == semester.Fall1) || (semester == semester.Fall2))){
            instructor.setCoursesCountFall(instructor.getCoursesCountFall()+1);
            if (instructor.getCoursesCountFall() > 3){
                System.out.println(instructor.getName() + " is already teaching 3 courses this semester: " +
                        semester.name() + ". This course: " + this.getCourseAbbrevSection() + " will not be added");
                return false;
            }
            else{
                return true;
            }
        }
        else if (instructor.isFullTime() && ((semester == semester.Spring1) || (semester == semester.Spring2))){
            instructor.setCoursesCountSpring(instructor.getCoursesCountSpring()+1);
            if (instructor.getCoursesCountSpring() > 3){
                System.out.println(instructor.getName() + " is already teaching 3 courses this semester: " + semester.name());
                return false;
            }
            else{
                return true;
            }
        }
        else if (instructor.isFullTime() && ((semester == semester.Summer1) || (semester == semester.Summer2))){
            instructor.setCoursesCountSummer(instructor.getCoursesCountSummer()+1);
            if (instructor.getCoursesCountSummer() > 3){
                System.out.println(instructor.getName() + " is already teaching 3 courses this semester: " + semester.name());
                return false;
            }
            else{
                return true;
            }
        }
        //If the instructor is part time and teaching more than 1 course section a semester then the course section will not be added.
        else if (instructor.isPartTime() && ((semester == semester.Fall1) || (semester == semester.Fall2))){
            instructor.setCoursesCountFall(instructor.getCoursesCountFall()+1);
            if (instructor.getCoursesCountFall() > 1){
                System.out.println(instructor.getName() + " is already teaching a course this semester: " + semester.name());
                return false;
            }
            else{
                return true;
            }
        }
        else if (instructor.isPartTime() && ((semester == semester.Spring1) || (semester == semester.Spring2))){
            instructor.setCoursesCountSpring(instructor.getCoursesCountSpring()+1);
            if (instructor.getCoursesCountSpring() > 1){
                System.out.println(instructor.getName() + " is already teaching a course this semester: " + semester.name());
                return false;
            }
            else{
                return true;
            }
        }
        else if (instructor.isPartTime() && ((semester == semester.Summer1) || (semester == semester.Summer2))){
            instructor.setCoursesCountSummer(instructor.getCoursesCountSummer()+1);
            if (instructor.getCoursesCountSummer() > 1){
                System.out.println(instructor.getName() + " is already teaching a course this semester: " + semester.name());
                return false;
            }
            else{
                return true;
            }
        }
        else{
            return false;
        }

    }

    //Setters and getters
    public void setSemester(Semester semester){
        this.semester=semester;
    }

    public Semester getSemester(){
        return semester;
    }

    public String getCourseAbbrevSection() {
        return getCourseAbbrev() + sectionName;
    }

    public void setEnrollmentLimit (int enrollmentLimit) {
        this.enrollmentLimit = enrollmentLimit;
    }

    public int getEnrollmentLimit(){
        return enrollmentLimit;
    }

    public Instructor getInstructor(){
        return instructor;
    }

    public static List<SectionCreator> getCoursesFromSemester(Semester semester){
        coursesPerSemester = new ArrayList<>();
        for (SectionCreator s: sections){

            if (s.getSemester() == semester){
                coursesPerSemester.add(s);
            }

        }
        return coursesPerSemester;
    }


}
