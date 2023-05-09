package cs665.termproject.paone;import java.util.ArrayList;
import java.util.List;

//Part of Observer pattern
public class NotificationService implements Subject {

    private final List<Observer> subscriberList;

    public NotificationService(){
        subscriberList = new ArrayList<>();
    }

    public void subscribe(Observer subscriber){
        subscriberList.add(subscriber);
    }

    public void unsubscribe(Observer subscriber){
        subscriberList.remove(subscriber);
    }

    public void notifySubscribers (SectionCreator section){
        for (Observer observers : subscriberList) {
            observers.update(section);
        }
    }


}
