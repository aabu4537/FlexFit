import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import FlexFit.Observer.iObserver;
import FlexFit.Observer.Subject;
import FlexFit.Observer.LoggerObserver;
import FlexFit.nutrition.DailyNutrients;
public class observerTest {
    private DailyNutrients dailyNutrients;
    private LoggerObserver loggerObserver;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        dailyNutrients = new DailyNutrients();
        loggerObserver = new LoggerObserver();
        dailyNutrients.registerObserver(loggerObserver);
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    // Helper method to count occurrences of a substring
    private int countOccurrences(String str, String findStr) {
        int lastIndex = 0;
        int count = 0;
        while (lastIndex != -1) {
            lastIndex = str.indexOf(findStr, lastIndex);
            if (lastIndex != -1) {
                count++;
                lastIndex += findStr.length();
            }
        }
        return count;
    }

    @Test
    void testObserverAdditionAndRemoval() {
        LoggerObserver secondObserver = new LoggerObserver();
        dailyNutrients.registerObserver(secondObserver);
        dailyNutrients.addMeal("Salad", 250);
        assertEquals(2, countOccurrences(outContent.toString(), "Logger: Daily Nutrients updated.\n"), "Both observers should be notified.");

        dailyNutrients.removeObserver(secondObserver);
        outContent.reset();
        dailyNutrients.addMeal("Chicken Rice", 350);
        assertEquals(1, countOccurrences(outContent.toString(), "Logger: Daily Nutrients updated.\n"), "Only one observer should be notified after removal.");
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
    }
}
