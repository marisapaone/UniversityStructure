package cs665.termproject.paone;//Part of the abstract factory pattern
public class DADegreeFactory implements DegreeFactory{

    //Create DA grad degree
    @Override
    public GraduateProgram createGraduateDegree() {
        return new DAGraduateDegree();
    }

    @Override
    public UndergraduateProgram createUndergraduateDegree() {
        //Returning null because BU does not offer a DA Undergrad degree.
        return null;
    }
}
