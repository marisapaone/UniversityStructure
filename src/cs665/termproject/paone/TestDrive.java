package cs665.termproject.paone;
//MARISA PAONE - BOSTON UNIVERSITY - CS665 TERM PROJECT
public class TestDrive {

    public static void main (String [] args) throws Exception {

        //Creating an instance of the CS Program
        //**********SINGLETON PATTERN************

        CSProgram csProgram = CSProgram.getCSProgramInstance(2023);

        //Creating Faculty Members
        Instructor joshG = csProgram.createFullTimeFaculty("Josh Giardino", "100");
        Instructor kalar = csProgram.createPartTimeFaculty("Suresh Kalathur", "101");
        Instructor lou = csProgram.createPartTimeFaculty("Luciano Francesco", "102");

        //Adding courses to CS Department
        Course cs201 = csProgram.createCourse("Introduction to Programming", "CS 201", "Introduction " +
                "to problem-solving methods and algorithm development.", "CS 201 Syllabus...");
        Course cs231 = csProgram.createCourse("Programming with C++", "CS 231", "Covers the " +
                "elements of object-oriented programming and the C++ language.", "CS 231 Syllabus...");
        Course cs232 = csProgram.createCourse("Programming with Java", "CS 232", "This course " +
                "covers the elements of object-oriented programming and the Java Programming Language.", "CS 232 Syllabus...");
        Course cs248 = csProgram.createCourse("Discrete Mathematics", "CS 248", "Fundamentals of " +
                "logic (the laws of logic, rules of inferences, quantifiers, proofs of theorems)", "CS 248 Syllabus...");
        Course cs341 = csProgram.createCourse("Data Structures with C++", "CS 341", "Covers data structures, " +
                "using the C++ language.", "CS 341 Syllabus...");
        Course cs342 = csProgram.createCourse("Data Structures with Java", "CS 342", "This course " +
                "covers data structures using the Java Programming Language.", "CS 342 Syllabus...");
        Course cs401 = csProgram.createCourse("Introduction to Web Application Development", "CS 401",
                "This course focuses on building core competencies in web design and development. ", "CS 401 Syllabus...");
        Course cs422 = csProgram.createCourse("Advanced Programming Concepts", "CS 422",
                "Comprehensive coverage of object-oriented programming with cooperating classes. ", "CS 422 Syllabus...");
        Course cs472 = csProgram.createCourse("Computer Architecture", "CS 472",
                "Computer organization with emphasis on processors, memory, and input/output.", "CS 472 Syllabus...");
        Course cs520 = csProgram.createCourse("Information Structures with Python", "CS 520",
                "This course covers the concepts of object-oriented approach to software design and " +
                        "development using the Java programming language.", "CS 520 Syllabus...");
        Course cs521 = csProgram.createCourse("Information Structures with Java", "CS 521", "This " +
                "course covers the concepts of the object-oriented approach to software design and development " +
                "using Python. ", "CS 521 Syllabus...");
        Course cs526 = csProgram.createCourse("Data Structures and Algorithms", "CS 526", "Students" +
                " use various data structures to solve computational problems, and implement data structures using a " +
                "high-level programming language.", "CS 526 Syllabus...");
        Course cs532 = csProgram.createCourse("Computer Graphics", "CS 532", "This course is " +
                "primarily the study of design of graphic algorithms.", "CS 532 Syllabus...");
        Course cs535 = csProgram.createCourse("Computer Networks", "CS 535", "This course provides " +
                "a robust understanding of networking.", "CS 535 Syllabus...");
        Course cs544 = csProgram.createCourse("Foundations of Analytics and Data Visualization", "CS 544",
                "The goal of this course is to provide students with the mathematical and practical " +
                        "background required in the field of data analytics.", "CS 544 Syllabus...");
        Course cs550 = csProgram.createCourse("Computational Mathematics for Data Analytics","CS 550",
                "This course reviews essential mathematical concepts and procedures which are fundamental. ","CS 550 Syllabus...");
        Course cs555 = csProgram.createCourse("Foundations of Machine Learning", "CS 555","This " +
                "course provides an overview of the statistical tools most commonly used to process, analyze, and " +
                "visualize data. ","CS 555 Syllabus...");
        Course cs561 = csProgram.createCourse("Financial Informatics","CS 561", "This course presents " +
                "financial algorithms used in applications of computer science in financial decision analysis, risk management, " +
                "data mining and market analysis, and other modern business processes. ", "CS 561 Syllabus...");
        Course cs566 = csProgram.createCourse( "Analysis of Algorithms", "CS 566", "Discusses " +
                "basic methods for designing and analyzing efficient algorithms emphasizing methods used in practice.",
                "CS 566 Syllabus...");
        Course cs570 = csProgram.createCourse("Biomedical Sciences and Health IT", "CS 570",
                "This course is designed for IT professionals, and those training to be IT professionals, who are" +
                        " preparing for careers in healthcare-related IT ", "CS 570 Syllabus...");
        Course cs575 = csProgram.createCourse("Operating Systems", "CS 575", "Overview of operating" +
                " system characteristics, design objectives, and structures.", "CS 575 Syllabus...");
        Course cs579 = csProgram.createCourse("Database Management", "CS 579", "This course provides " +
                "a theoretical yet modern presentation of database topics ranging from Data and Object Modeling", "CS 579 Syllabus...");
        Course cs580 = csProgram.createCourse("Health Informatics", "CS 580", "This course " +
                "presents the technological fundamentals and integrated clinical applications of modern Biomedical IT.", "CS 580 Syllabus...");
        Course cs625 = csProgram.createCourse("Business Data Communication and Networks", "CS 625", "This course" +
                " presents the foundations of data communications and takes a bottom-up approach to computer networks", "CS 625 Syllabus...");
        Course cs662 = csProgram.createCourse("Computer Language Theory", "CS 662", "Theory of " +
                "finite automata and regular expressions and properties of regular sets. ", "CS 662 Syllabus...");
        Course cs669 = csProgram.createCourse("Database Design and Implementation for Business", "CS 669",
                "Students learn the latest relational and object-relational tools and techniques for " +
                        "persistent data and object modeling and management.", "CS 669 Syllabus...");
        Course cs673 = csProgram.createCourse("Software Engineering", "CS 673", "Overview of " +
                "techniques and tools to develop high quality software.", "CS 673 Syllabus...");
        Course cs677 = csProgram.createCourse("Data Science with Python", "CS 677", "Students " +
                "will learn major Python tools and techniques for data analysis.", "CS 677 Syllabus...");
        Course cs682 = csProgram.createCourse("Information Systems Analysis and Design", "CS 682",
                "Object-oriented methods of information systems analysis and design for organizations " +
                        "with data- processing needs", "CS 682 Syllabus...");
        Course cs688 = csProgram.createCourse("Web Mining and Graph Analytics", "CS 688",
                "The Web Mining and Graph Analytics course covers the areas of web mining, machine learning " +
                        "fundamentals, text mining, clustering, and graph analytics.", "CS 688 Syllabus...");
        Course cs689 = csProgram.createCourse("Designing and Implementing a Data Warehouse", "CS 689",
                "This course surveys state-of-the art technologies in DW and Big Data.", "CS 689 Syllabus...");
        Course cs699 = csProgram.createCourse("Data Mining", "CS 699", "The goal of this course" +
                " is to study basic concepts and techniques of data mining.", "CS 699 Syllabus...");
        Course cs767 = csProgram.createCourse("Advanced Machine Learning and Neural Networks", "CS 767",
                "The course covers a variety of approaches, including Supervised and Unsupervised Learning, " +
                        "Neural Nets and Deep Learning, Adversarial Learning, Bayesian Learning, and Genetic Algorithms.", "CS 767 Syllabus...");
        Course cs777 = csProgram.createCourse("Big Data Analytics", "CS 777", "This course is an " +
                "introduction to large-scale data analytics.", "CS 777 Syllabus...");
        Course cs779 = csProgram.createCourse("Advanced Database Management", "CS 779", "This course " +
                "covers advanced aspects of database management including normalization and denormalization, " +
                "query optimization, distributed databases, data warehousing, and big data. ", "CS 779 Syllabus...");
        Course cs782 = csProgram.createCourse("IT Strategy and Management", "CS 782", "This course" +
                " describes and compares contemporary and emerging information technology and its management.", "CS 782 Syllabus...");

        //Creating sections of the courses offered
        SectionCreator cs248a = csProgram.createSection(cs248, "A", Semester.Summer2, 2, joshG);
        SectionCreator cs520a = csProgram.createSection(cs520, "A", Semester.Fall1, 20, joshG);
        SectionCreator cs520b = csProgram.createSection(cs520, "B", Semester.Summer1, 25, joshG);
        SectionCreator cs521a = csProgram.createSection(cs521, "A", Semester.Fall1, 100, joshG);
        SectionCreator cs521c = csProgram.createSection(cs521, "C", Semester.Fall1, 50, kalar);
        SectionCreator cs532b = csProgram.createSection(cs532, "B", Semester.Fall1, 25, joshG);
        //The below course is not sucessfully added because JoshG is teaching 3 courses in Fall 1.
        SectionCreator cs782a = csProgram.createSection(cs782, "A", Semester.Fall1, 10, joshG);

        SectionCreator cs544a = csProgram.createSection(cs544, "A", Semester.Spring1, 2, joshG);
        SectionCreator cs555a = csProgram.createSection(cs555, "A", Semester.Spring1, 50, lou);
        SectionCreator cs566b = csProgram.createSection(cs566, "B", Semester.Spring2, 50, joshG);
        SectionCreator cs677c = csProgram.createSection(cs677, "C", Semester.Spring2, 20, kalar);
        SectionCreator cs688b = csProgram.createSection(cs688, "B", Semester.Summer2, 15, kalar);
        SectionCreator cs767a = csProgram.createSection(cs767, "A", Semester.Summer2, 5, lou);

        //Printing out all sections of every course offered
        System.out.println("Printing all course sections offered: " + SectionCreator.getAllSections(cs520));

        System.out.println();

        //Printing specific sections of courses
        System.out.println("All of the sections of CS 520: ");
        SectionCreator.printSpecificCourseSections(cs520);
        System.out.println("All of the sections of CS 521: ");
        SectionCreator.printSpecificCourseSections(cs521);

        System.out.println();

        System.out.println(joshG.getName() + " teaches: " + joshG.printCoursesTaught());

        System.out.println();

        //****** ABSTRACT FACTORY PATTERN *******

        DegreeFactory cisDegreeFactory = new CISDegreeFactory();
        GraduateProgram cisGradDegree = cisDegreeFactory.createGraduateDegree();
        UndergraduateProgram cisUndergradDegree = cisDegreeFactory.createUndergraduateDegree();

        DegreeFactory csDegreeFactory = new CSDegreeFactory();
        UndergraduateProgram csUndergradDegree = csDegreeFactory.createUndergraduateDegree();
        GraduateProgram csGradDegree = csDegreeFactory.createGraduateDegree();

        DegreeFactory daDegreeFactory = new DADegreeFactory();
        GraduateProgram daGradDegree = daDegreeFactory.createGraduateDegree();

        //Adding Core Classes
        cisGradDegree.addCoreCourse(cs520);
        cisGradDegree.addCoreCourse(cs625);
        cisGradDegree.addCoreCourse(cs669);
        cisGradDegree.addCoreCourse(cs682);
        cisGradDegree.addCoreCourse(cs782);

        cisGradDegree.addElectiveCourse(cs526);
        cisGradDegree.addElectiveCourse(cs532);
        cisGradDegree.addElectiveCourse(cs544);
        cisGradDegree.addElectiveCourse(cs555);
        cisGradDegree.addElectiveCourse(cs561);

        System.out.println("Printing out core courses for the CIS Grad Degree: " + cisGradDegree.printCoreCourses());

        csGradDegree.addCoreCourse(cs535);
        csGradDegree.addCoreCourse(cs566);
        csGradDegree.addCoreCourse(cs575);
        csGradDegree.addCoreCourse(cs662);
        csGradDegree.addCoreCourse(cs673);

        csGradDegree.addElectiveCourse(cs532);
        csGradDegree.addElectiveCourse(cs544);
        csGradDegree.addElectiveCourse(cs550);
        csGradDegree.addElectiveCourse(cs555);
        csGradDegree.addElectiveCourse(cs561);

        daGradDegree.addCoreCourse(cs544);
        daGradDegree.addCoreCourse(cs555);
        daGradDegree.addCoreCourse(cs566);
        daGradDegree.addCoreCourse(cs677);
        daGradDegree.addCoreCourse(cs688);

        daGradDegree.addElectiveCourse(cs550);
        daGradDegree.addElectiveCourse(cs689);
        daGradDegree.addElectiveCourse(cs767);
        daGradDegree.addElectiveCourse(cs777);
        daGradDegree.addElectiveCourse(cs779);

        cisUndergradDegree.addCoreCourse(cs231);
        cisUndergradDegree.addCoreCourse(cs341);
        cisUndergradDegree.addCoreCourse(cs201);
        cisUndergradDegree.addCoreCourse(cs248);
        cisUndergradDegree.addCoreCourse(cs422);
        cisUndergradDegree.addCoreCourse(cs472);
        cisUndergradDegree.addCoreCourse(cs535);
        cisUndergradDegree.addCoreCourse(cs575);

        cisUndergradDegree.addElectiveCourse(cs532);
        cisUndergradDegree.addElectiveCourse(cs544);
        cisUndergradDegree.addElectiveCourse(cs535);
        cisUndergradDegree.addElectiveCourse(cs520); //cs520 is an elective for undergrad
        cisUndergradDegree.addElectiveCourse(cs566);
        cisUndergradDegree.addElectiveCourse(cs555);
        cisUndergradDegree.addElectiveCourse(cs561);
        cisUndergradDegree.addElectiveCourse(cs550);

        csUndergradDegree.addCoreCourse(cs232);
        csUndergradDegree.addCoreCourse(cs248);
        csUndergradDegree.addCoreCourse(cs401);
        csUndergradDegree.addCoreCourse(cs422);
        csUndergradDegree.addCoreCourse(cs472);
        csUndergradDegree.addCoreCourse(cs579);
        csUndergradDegree.addCoreCourse(cs535);
        csUndergradDegree.addCoreCourse(cs575);

        csUndergradDegree.addElectiveCourse(cs532);
        csUndergradDegree.addElectiveCourse(cs544);
        csUndergradDegree.addElectiveCourse(cs535);
        csUndergradDegree.addElectiveCourse(cs520); //cs520 is an elective for undergrad
        csUndergradDegree.addElectiveCourse(cs566);
        csUndergradDegree.addElectiveCourse(cs555);
        csUndergradDegree.addElectiveCourse(cs561);
        csUndergradDegree.addElectiveCourse(cs550);

        System.out.println();

        System.out.println("Core Courses for CIS Undergraduate degree: " + cisUndergradDegree.printCoreCourses());

        System.out.println();

        System.out.println("Core Courses for CS Grad degree: " + csGradDegree.printCoreCourses());

        System.out.println();

        System.out.println("Course Catalog: ");

        CSProgram.getCSProgramInstance(2023).printCourseMap();

        //Creating Students

        System.out.println();

        System.out.println("***Creating students***");

        Student student1 = csProgram.createStudent(cisGradDegree, "Marisa Paone", "001-001");
        Student student2 = csProgram.createStudent(csGradDegree, "Nicole Paone", "001-002");
        Student student3 = csProgram.createStudent(cisUndergradDegree, "Julie Paone", "001-003");
        Student student4 = csProgram.createStudent(daGradDegree, "Lou Paone", "001-004");

        System.out.println();

        System.out.println("***Enrolling Students in classes***");
        student1.addCourse(cs520a);
        student2.addCourse(cs520a); //Since student 3 is an undergrad CIS major, and cs520 is an elective for that degree, they cannot enroll in cs520
        student3.addCourse(cs520a);//However, they can enroll in cs521 since that is not an elective for their degree.
        student3.addCourse(cs521a);
        student3.addCourse(cs520b); //Student 3 can't add cs520 still because of reason above
        student3.addCourse(cs248a);
        student3.addCourse(cs532b);


        System.out.println();

        student4.addCourse(cs544a);
        student4.addCourse(cs555a);
        student4.addCourse(cs566b);
        student4.addCourse(cs677c);
        student4.addCourse(cs688b);

        //Student 4 tries to enroll in an elective...
        student4.addCourse(cs767a);//Works since they completed all core courses

        System.out.println();

        System.out.println(student3.getStudentName() + " is taking these classes: " + student3.coursesTaken);

        System.out.println("These students are enrolled in " + cs520a.getCourseAbbrevSection() + cs520a.studentsEnrolled);

        System.out.println(cs520a.getCourseAbbrevSection() + " has " + cs520a.enrolled + " students enrolled");

        //Setting a graduate program advisor
        FullTimeFaculty.setGraduateAdvisor(joshG, joshG.getInstructorId());

        System.out.println("Graduate Program Advisor of " + CSProgram.getCSProgramInstance(2023).getYear() + ": " + FullTimeFaculty.getGraduateAdvisor());

        //Department keeping track of the courses offered each semester
        System.out.println("Course sections offered in Fall 1: " + SectionCreator.getCoursesFromSemester(Semester.Fall1));

        //********* STRATEGY DESIGN PATTERN *********

        //check if student is enrolled in class (before setting grade???)
        System.out.println();
        cs520a.setGrade(student1, Grade.A);
        cs520a.setGrade(student2, Grade.B);
        cs520a.setGrade(student3, Grade.F); //Doesn't work because not enrolled
        cs521a.setGrade(student3, Grade.A);
        cs520b.setGrade(student3, Grade.B); //Doesn't work because not enrolled
        cs521a.setGrade(student3, Grade.C);
        cs248a.setGrade(student3, Grade.A);
        cs532b.setGrade(student3, Grade.C);

        System.out.println();
        student3.setStrategy(new NormalGPA());
        //calc gpa for student 3
        student3.calculateStrategy();

        System.out.println();
        student3.addCourse(cs521c);
        System.out.println();

        cs521c.setGrade(student3, Grade.H);
        student3.calculateStrategy();

        student3.addCourse(cs532b); //Doesn't work because it is an elective and student3 didn't finish all core courses

        System.out.println();
        student3.setStrategy(new HonorsGPA());
        student3.calculateStrategy();

        //Getting the graduate advisor
        System.out.println("CIS Graduate Advisor: " + cisGradDegree.getGraduateAdvisor());
        //Setting undergrad advisor
        FullTimeFaculty.setUndergraduateAdvisor(lou, "112");

        //********* COMMAND PATTERN *********

        student3.setCommand(new SendQueryCommand(joshG));
        student3.executeCommand("Hi Josh, When is assignment 1 due?");
        System.out.println(student3.getDegreeProgram());
        System.out.println(student4.getDegreeProgram());
        student3.setCommand(new SendQueryCommand(cisUndergradDegree.getUndergraduateAdvisor()));
        student3.executeCommand("Hey Advisor, where is my class?");

        //********* SINGLETON PATTERN *********

        Instructor jessica = csProgram.createChairperson("Jessica Letz", "103");
        //Instructor monica = csProgram.createChairperson("Monica Monit", "104");
        System.out.println("Chairperson: " + jessica.getName());
        //System.out.println("Chairperson: " + monica.getName());

        //Creating monica as a chairperson throws an exception because of the singleton pattern
        //There can only be one chairperson!

        //********** COMPOSITE DESIGN PATTERN ***********

        System.out.println();
        Concentration proceduralLanguages = new LeafConcentration("Procedural Languages", "1", joshG);
        Concentration objectOrientedLanguages = new LeafConcentration("Object Oriented Languages", "2", joshG);
        Concentration functionalLanguages = new LeafConcentration("Functional Languages", "3", joshG);

        CompositeConcentration programmingLangauages = new CompositeConcentration("Programming Languages", "4", joshG);

        programmingLangauages.addConcentration(proceduralLanguages);
        programmingLangauages.addConcentration(objectOrientedLanguages);
        programmingLangauages.addConcentration(functionalLanguages);

        Concentration systems = new LeafConcentration("Systems", "5", joshG);
        Concentration databases = new LeafConcentration("Databases", "6", joshG);
        //Doesn't work because Kalarthur isn't full time
        Concentration softwareEngineering = new LeafConcentration("Software Engineering", "7", kalar);

        System.out.println();

        proceduralLanguages.addCourseToConcentration(cs231);
        proceduralLanguages.addCourseToConcentration(cs232);
        objectOrientedLanguages.addCourseToConcentration(cs341);
        objectOrientedLanguages.addCourseToConcentration(cs342);

        programmingLangauages.printSubConcentrations();
        programmingLangauages.printRequiredCourses();

        System.out.println();

        systems.addCourseToConcentration(cs575);
        systems.printRequiredCourses();

        System.out.println();

        //********** Observer Design Pattern ***********

        //When the Chairman is created (instantiated) they are automatically subscribed to the Instructor Service
        //as part of their constructor.

        //cs248 has 2 seats total, student 3 was added before, so when student 4 is added the section will become full.
        student4.addCourse(cs248a);
        student1.addCourse(cs248a); //Waitlisted!
        student2.addCourse(cs248a); //Waitlisted!
        System.out.println();
        System.out.print("Waitlist: ");
        //When a student can't be added to a course, they are put on a waitlist, and added as a subscriber
        cs248a.printWaitlist(); //To view the waitlist for course 248a

        System.out.println();
        student4.dropCourse(cs248a); //When the course is dropped, the next student on the waitlist - student 1 (Marisa Paone) is notified.
        System.out.println();
        student1.dropCourse(cs248a);
        System.out.println();

        //To display advisees of both grad and undergrad advisors
        GraduateProgram.getAdvisees(2023);
        UndergraduateProgram.getAdvisees(2023);

        //Setting and getting student 4's thesis advisor
        System.out.println();
        student4.setThesisAdvisor(kalar);
        System.out.println(student4 + "'s thesis advisor = " + student4.getThesisAdvisor());

        //****************DECORATOR PATTERN**********************
        //I am using my existing courses of the Course class, and decorating them with the format() method that will recursively
        //return an HTML format output of the course.
        ICourse course = new FormatDecorator(cs201);
        System.out.println(course.format());
        //ICourse course2 = new FormatDecorator(cs201);

        System.out.println(cs201.format());
        System.out.println();

        //***************SIMPLE FACTORY*********************

        SimpleCertificateFactory certificateFactory = new SimpleCertificateFactory();
        CertificateProgram securityCert = certificateFactory.createCertificate("Security Certificate");
        CertificateProgram webTechCert = certificateFactory.createCertificate("Web Technology Certificate");
        CertificateProgram analyticsCert = certificateFactory.createCertificate("Analytics Certificate");


        securityCert.addRequiredCourse(cs544);
        securityCert.addRequiredCourse(cs555);
        securityCert.addRequiredCourse(cs566);
        securityCert.addRequiredCourse(cs677);
        securityCert.printRequiredCourses();

        //Student 4 (Lou paone) is completing these courses for the Security Certificate, so the instructor is inputting his grades.

        cs544a.setGrade(student4, Grade.A);
        cs555a.setGrade(student4, Grade.A);
        cs566b.setGrade(student4, Grade.B);
        cs677c.setGrade(student4, Grade.A); //After this setGrade, Lou is awarded the Security Cert.
        cs688b.setGrade(student4, Grade.F);

        webTechCert.addRequiredCourse(cs520);
        webTechCert.addRequiredCourse(cs521);
        webTechCert.addRequiredCourse(cs248);
        webTechCert.addRequiredCourse(cs532);


    }


}
