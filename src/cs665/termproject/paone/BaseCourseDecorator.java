package cs665.termproject.paone;import java.util.List;

//Part of the decorator pattern to decorate courses with the html format method
public abstract class BaseCourseDecorator implements ICourse {

    //creating a wrapper
    private final ICourse wrapped;

    BaseCourseDecorator(ICourse wrapped){
        this.wrapped = wrapped;
    }

    @Override
    public List<SectionCreator> getSections (){
        return wrapped.getSections();
    }

    @Override
    public String getCourseName(){
        return wrapped.getCourseName();
    }

    @Override
    public String getCourseAbbrev(){
        return wrapped.getCourseAbbrev();
    }

    @Override
    public String getDescription(){
        return wrapped.getDescription();
    }

    @Override
    public String getSyllabus(){
        return wrapped.getSyllabus();
    }

    @Override
    public String format(){
        return wrapped.format();
    }



}
