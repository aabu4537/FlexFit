package FlexFit.Observer;

public abstract class LoggerObserver implements iObserver, Subject {
    @Override
    public void update() {
        System.out.println("Logger: Daily Nutrients updated.");
    }
}
