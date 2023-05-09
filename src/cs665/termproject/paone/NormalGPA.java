package cs665.termproject.paone;import java.util.ArrayList;
import java.util.List;

//Part of STRATEGY PATTERN
public class NormalGPA implements GPACalc{

    double gpa;

    double number;
    int courseCount = 0;

    SectionCreator course;

    List<Grade> gradeList = new ArrayList<>();

    public NormalGPA(){
        System.out.println("Calculating GPA normally...");
    }
    @Override
    public double calculate(Student student) {
        //resets gpa
        gpa = 0;
        gradeList = student.fetchGrade();
        System.out.println(student.fetchGrade());
        for (Grade g: gradeList){
            courseCount = gradeList.size();
            switch (g){
                case H -> {
                    number = 4;
                    gpa += number;
                    break;
                }
                case A -> {
                    number = 4;
                    gpa += number;
                    break;
                }
                case B -> {
                    number = 3.0;
                    gpa += number;
                    break;
                }
                case C -> {
                    number = 2;
                    gpa += number;
                    break;
                }
                case D -> {
                    number = 1;
                    gpa += number;
                    break;
                }
                case F -> {
                    number = 0;
                    gpa += number;
                    break;
                }
                //if a course was added but a grade wasn't set.
                case null -> {
                    courseCount--;
                    break;
                }

            }
        }
        gpa = (gpa / courseCount);
        System.out.println("Course count: " + courseCount);


        return gpa;

    }
}
