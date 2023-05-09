package cs665.termproject.paone;//Part of OBSERVER PATTERN
public interface Subject {

    public void subscribe(Observer subscriber);

    public void unsubscribe(Observer subscriber);

    public void notifySubscribers (SectionCreator section);

}
