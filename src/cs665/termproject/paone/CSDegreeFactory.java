package cs665.termproject.paone;//Part of the abstract factory pattern
public class CSDegreeFactory implements DegreeFactory{

    //Create CS undergrad degree
    //Create CS grad degree
    @Override
    public GraduateProgram createGraduateDegree() {
        return new CSGraduateDegree();
    }

    @Override
    public UndergraduateProgram createUndergraduateDegree() {
        return new CSUndergraduateDegree();
    }
}
