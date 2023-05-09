package cs665.termproject.paone;
import java.util.*;

public class Student implements Observer{

    public String studentName;

    public static List<Grade> studentGradeList = new ArrayList<>();

    public static List<SectionCreator> sectionList = new ArrayList<>();

    public static Instructor thesisAdvisor;

    public String thesis;

    private String studentID;

    public HashMap<SectionCreator, Semester> coursesTaken = new HashMap<>();

    public DegreeProgram degreeProgram;

    public Student (DegreeProgram degreeProgram, String studentName, String studentID){
        this.studentName = studentName;
        this.degreeProgram = degreeProgram;
        this.studentID = studentID;
        waitlistStudentSubject = new NotificationService();
        System.out.println("New Student Created : " + studentName + " enrolled in " + degreeProgram.degreeName);

    }

    //************Command Pattern**************

    public Command command;

    public void setCommand (Command command){
        this.command = command;
    }

    public void executeCommand(String query){
        command.execute(query);
        System.out.println("Message is from " + getStudentName());
        System.out.println();
    }

    //**************OBSERVER PATTERN**************

    private static Subject waitlistStudentSubject;

    public static Subject getStudentService() {
        return waitlistStudentSubject;
    }

    //Goes to NotificationService class and notifies each subscriber on the waitlist, using the update method below
    public void sectionIsOpen(SectionCreator section){
        waitlistStudentSubject.notifySubscribers(section);
    }

    //If someone drops from the course where there is a waitlist, then this update will be sent to all subscribers,
    //also automatically enrolls next student on the waitlist.
    @Override
    public void update(SectionCreator section) {
        System.out.println("Notifcation to: " + this.getStudentName() + ", a seat in " +  section.getCourseAbbrevSection() +
                " just became available. The waitlist will be updated.");
        //If you are first on the waitlist, you will be enrolled.
        //If the course sections enrollments limit is greater than the students actually enrolled, then this student
        //will be added to the course section.
        if (section.enrollmentLimit > section.enrolled) {
            this.addCourse(section);//student enrolls
        }
    }

    //***********STRATEGY PATTERN******************

    public GPACalc gpaCalc;

    public void setStrategy (GPACalc gpaCalc){
        this.gpaCalc  = gpaCalc;
    }

    public void calculateStrategy(){
        System.out.println(gpaCalc.calculate(this));
    }

    public List<Grade> fetchGrade(){
        //If the students grade list is empty,
        if (studentGradeList.isEmpty()) {
            //System.out.println("Grade list is empty");
            //for all the courses taken by this student(keys), add grades where student key == student from courses
            //Iterating through the student's courses taken (hashmap coursesTaken)...
            for (Map.Entry<SectionCreator, Semester> courses : coursesTaken.entrySet()) {
                //course section = the key in this map
                SectionCreator sectionKey = courses.getKey(); //example cs521a
                //get the grade from cs521a where student is the key
                studentGradeList.add(sectionKey.getGrades().get(this));
                //add the course section key to the list of course sections
                sectionList.add(courses.getKey());
            }
        }
        //If a class was added after you fetched grades
        else if (studentGradeList.size() < coursesTaken.size()){
            //For all of the courses taken
            for (Map.Entry<SectionCreator, Semester> courses : coursesTaken.entrySet()) {
                // if the course taken, is not in the grades hashmap,
                if (!courses.getKey().grades.containsKey(coursesTaken.keySet())){
                    //if the courses taken is not in the sectionList
                    if (!sectionList.contains(courses.getKey())){
                        //Then add the new courses
                        SectionCreator sectionKey = courses.getKey(); //cs521a
                        //get the grade from cs521a where student is the key
                        studentGradeList.add(sectionKey.getGrades().get(this));
                        sectionList.add(courses.getKey());
                        System.out.println("Course was added");
                    }

                }

            }
        }
        return studentGradeList;
    }

    //***********Getters and setter methods***************

    public void setThesis (String thesis){
        this.thesis = thesis;
    }

    public void setThesisAdvisor(Instructor advisor){
        thesisAdvisor = advisor;
    }

    public Instructor getThesisAdvisor(){
        return thesisAdvisor;
    }

    public String getThesis (){
        return thesis;
    }

    public String award() {
        return null;
    }

    public void setStudentName(String studentName){
        this.studentName = studentName;
    }

    public String getStudentName(){
        return studentName;
    }

    public void setDegreeProgram (DegreeProgram degreeProgram){
        this.degreeProgram = degreeProgram;
    }

    public DegreeProgram getDegreeProgram(){
        return degreeProgram;
    }

    public Student getStudent(){
        return this;
    }

    public HashMap<SectionCreator, Semester> printCoursesTaken(){
        return coursesTaken;
    }

    public String getStudentID() {
        return studentID;
    }

    @Override
    public String toString() {
        return studentName;
    }

    //Add Course method

    public void addCourse(SectionCreator course){
        //If the student already took the course...
        if (coursesTaken.containsKey(course)){
            System.out.println (this.studentName + " has already taken this course");
        }
        //If not, then lets try to enroll
        else {
            //If the course the student is trying to add is a core course in their degreeprogram, then try to enroll.
            if(this.degreeProgram.coreCourses.containsKey(course.getCourseAbbrev())){
                if (enroll(course)) {
                    System.out.println(this.studentName + " has sucessfully enrolled in a core course for their program " +
                            "they are enrolled in: " + course.getCourseAbbrev());
                }
            }
            //If the course is one of the student's degree program's electives...
            else if (this.degreeProgram.elecCourses.containsKey(course.getCourseAbbrev())){
                //if the coreCoursesTaken count is equal to that required of the students degree program, (meaning they
                //have been enrolled in all of their core courses), then the student is allowed to
                //take electives because they are on their last year of the program.
                if ((checkCoreCoursesTaken() == getStudent().degreeProgram.coreCoursesNeeded)){
                    if (enroll(course)){
                        System.out.println(this.studentName + " has sucessfully enrolled in an elective course for their program: " + course.getCourseAbbrev());
                    }
                }
                else{
                        System.out.println(this.studentName + " cannot enroll in this elective course for their program, *" +
                                this.degreeProgram + "*. The student must finish all core courses.");
                }
            }
            else {
                //If the course is neither a core course or elective in the students degree program, they can still take it,
                //but it won't count towards their degree.
                if (enroll(course)) {
                    System.out.println(this.studentName + " has sucessfully enrolled in a course for the program that is " +
                            "not an elective or a core course in their program. They are enrolled in: " + course.getCourseAbbrev());
                }
            }
        }
    }

    //Checks if the Course Section has open seats (before enrolling)!
    //Enrolls the student if the enrollment limit doesn't equal the count of students actually enrolled.
    public boolean enroll (SectionCreator course){
        //when the students actually enrolled equals the enrollment limit, meaning the class is already full, the Chairperson is notified.
        if (course.enrollmentLimit == course.enrolled){
            //Observer pattern comes in here
            Chairperson.sectionIsFull(course);
            //Then the student is added to the waitlist for the particular course section.
            course.addToWaitlist(course, this);
            //Automatically subscribes the student to the waitlist notification service when they are put on the waitlist.
            getStudentService().subscribe(this);
            return false;
        }
        //If the class has seats available, this course section is added to the student's courseTaken map,
        //the actual enrolled count is incremented, and the student is added to the course sections studentsEnrolled list.
        else {
            coursesTaken.put(course, course.getSemester());
            course.enrolled++;
            course.studentsEnrolled.add(this);
            return true;
        }
    }

    public void dropCourse(SectionCreator course) {
        //Making sure that the student is actually enrolled in this specific section before dropping...
        if (coursesTaken.containsKey(course)) {
            System.out.println(this.studentName + " has sucessfully dropped course: " + course.getCourseAbbrev());
            //Removing the course section from the Map coursesTaken
            coursesTaken.remove(course, course.getSemester());
            //decrementing the enrolled count of the course section.
            course.enrolled--;
            //Removing the student from the studentsEnrolled List in the course section (SectionCreator) object.
            course.studentsEnrolled.remove(this);

            //If the course section's enrollment limit is greater than the actual enrolled count...
            if (course.enrollmentLimit > course.enrolled) {
                //And if the course sections waitlist has this particular course section on it (since its full)...
                if (course.waitlist.containsValue(course)) {
                    //It will unsubscribe this student from the waitlist/observerlist since the section now
                    //has one spot open.
                    getStudentService().unsubscribe(this);
                    //Notifies the students on the waitlist for this course section
                    sectionIsOpen(course);

                }
            }
            else if (course.enrollmentLimit == course.enrolled){
                System.out.println("Sorry, you are still on the waitlist.");
            }

        }
        else{
            System.out.println(this.studentName + " is not enrolled in this course: " + course.getCourseAbbrev());
        }
    }

    public int coreCourseCount = 0;
    //This method goes through each course taken by the student, if the course matches the core courses
    //for the students degreeprogram, then the coreCourseCount is incremented.
    public int checkCoreCoursesTaken(){
        Set<SectionCreator> list =  coursesTaken.keySet();
        //System.out.println(list);
        for (SectionCreator x : list){
            String course = x.getCourseAbbrev();
            if(this.degreeProgram.coreCourses.containsKey(course)){
                coreCourseCount = coreCourseCount+1;
                //System.out.println(coreCourseCount);
            }
        }
        return coreCourseCount;
    }

    public Set<String> completedCourses = new HashSet<>();

    //After the setGrade method of the SectionCreator class is called and a grade is inputted for the student,
    //this method is called - which adds the course abbreviation to a set of Strings.
    public void completedCourse(SectionCreator section) {
        completedCourses.add(section.getCourseAbbrev());
        //If the completed courses set is greater than or equal to 4 (since 4 courses is a minimum for a certificate)
        //then the student will be checked to see if they took the right courses for a certificate.
        if (completedCourses.size() >= 4){
            checkCertificate();
        }
    }

    //For each of the certificate programs, if the required courses contains all of the students completed courses,
    //they will get awarded the particular certificate.
    public void checkCertificate(){
        for (CertificateProgram certificatePrograms : CertificateProgram.certificatePrograms){
            if (certificatePrograms.reqCourseStrings.containsAll(completedCourses)){
                System.out.println(this.studentName + ": " + certificatePrograms.award());
            }
        }
    }
}
