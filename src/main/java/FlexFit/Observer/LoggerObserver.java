package FlexFit.Observer;

public class LoggerObserver implements iObserver {
    @Override
    public void update() {
        System.out.println("Logger: Daily Nutrients updated.");
    }
}
