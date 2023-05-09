package cs665.termproject.paone;//Part of the Command Pattern
public class SendQueryCommand implements Command{

    private Instructor instructor;

    public SendQueryCommand (Instructor instructor){
        this.instructor = instructor;
    }

    @Override
    public void execute(String query) {
        instructor.receiveQuery(query);
    }
}
