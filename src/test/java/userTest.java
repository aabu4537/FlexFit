import FlexFit.user.Adult;
import FlexFit.user.Child;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;
public class userTest {

    private final InputStream originalIn = System.in;

    @BeforeEach
    public void restoreSystemInputOutput() {
        System.setIn(originalIn);
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    public void testAdultInitialization() {
        // Simulate input for name, age, sex, weight, height
        String input = "Jane Doe\n28\nFemale\n130\n65\n";
        provideInput(input);

        Adult adult = new Adult();
        adult.promptUserInfo();

        assertEquals("Jane Doe", adult.getName());
        assertEquals(28, adult.getAge());
        assertEquals("Female", adult.getSex());
        assertEquals(130, adult.getWeight());
        assertEquals(65.0, adult.getHeight());
    }

    @Test
    public void testChildInitialization() {
        // Simulate input for name, age, sex, weight, height
        String input = "Little Tim\n8\nMale\n50\n48\n";
        provideInput(input);

        Child child = new Child();
        child.promptUserInfo();

        assertEquals("Little Tim", child.getName());
        assertEquals(8, child.getAge());
        assertEquals("Male", child.getSex());
        assertEquals(50, child.getWeight());
        assertEquals(48.0, child.getHeight());
    }
}
