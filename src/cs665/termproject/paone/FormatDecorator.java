package cs665.termproject.paone;import java.util.ArrayList;
import java.util.List;

//Part of Decorator Pattern
public class FormatDecorator extends BaseCourseDecorator{
    List<String> components = new ArrayList<>();

    FormatDecorator(ICourse wrapped) {
        super(wrapped);
        components.add(super.getCourseAbbrev());
    }
    @Override
    public String format(){
        StringBuilder htmlBuilder = new StringBuilder();
        for (String elements : components){
            htmlBuilder.append("<html>" + super.format() + "</html>");
        }

        String html = htmlBuilder.toString();
        return html;
    }

}
