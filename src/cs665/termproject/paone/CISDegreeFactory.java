package cs665.termproject.paone;

//Part of the Abstract Factory Pattern
public class CISDegreeFactory implements DegreeFactory{

    //Creates CIS undergrad degree
    //Creates CIS grad degree
    @Override
    public GraduateProgram createGraduateDegree() {
        return new CISGraduateDegree();
    }

    @Override
    public UndergraduateProgram createUndergraduateDegree() {
        return new CISUndergraduateDegree();
    }
}
