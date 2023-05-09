package cs665.termproject.paone;

//Part of the abstract factory pattern
public interface DegreeFactory {

    public abstract GraduateProgram createGraduateDegree();
    public abstract UndergraduateProgram createUndergraduateDegree();

}
