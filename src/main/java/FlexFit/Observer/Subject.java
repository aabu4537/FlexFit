package FlexFit.Observer;

public interface Subject {
    void registerObserver(iObserver o);
    void removeObserver(iObserver o);
    void notifyObservers();
}