import FlexFit.training.FatLossWorkout;
import FlexFit.training.WorkoutManager;
import FlexFit.training.MuscleGainWorkout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class trainingTest {

    private FatLossWorkout fatLossWorkout;
    private MuscleGainWorkout muscleGainWorkout;

    private WorkoutManager workoutManager;



    @BeforeEach
    void setUp() {
        // Initialize the workouts with sample data
        workoutManager = new WorkoutManager();
        fatLossWorkout = new FatLossWorkout("Morning Run", 30, "Running", "High", 300);
        muscleGainWorkout = new MuscleGainWorkout("Leg Day", 60, "Legs", 4, 12, 120.0);
    }

    @Test
    void testFatLossWorkoutCreation() {
        assertEquals("Morning Run", fatLossWorkout.getWorkoutName());
        assertEquals(30, fatLossWorkout.getDurationInMinutes());
        assertEquals("Running", fatLossWorkout.getCardioType());
        assertEquals("High", fatLossWorkout.getIntensityLevel());
        assertEquals(300, fatLossWorkout.getCaloriesBurned());
    }

    @Test
    void testMuscleGainWorkoutCreation() {
        assertEquals("Leg Day", muscleGainWorkout.getWorkoutName());
        assertEquals(60, muscleGainWorkout.getDurationInMinutes());
        assertEquals("Legs", muscleGainWorkout.getMuscleGroup());
        assertEquals(4, muscleGainWorkout.getSets());
        assertEquals(12, muscleGainWorkout.getRepsPerSet());
        assertEquals(120.0, muscleGainWorkout.getWeightUsed());
    }

    @Test
    void testSetWorkoutName() {
        fatLossWorkout.setWorkoutName("Evening Run");
        assertEquals("Evening Run", fatLossWorkout.getWorkoutName());

        muscleGainWorkout.setWorkoutName("Arm Day");
        assertEquals("Arm Day", muscleGainWorkout.getWorkoutName());
    }

    @Test
    void testSetDuration() {
        fatLossWorkout.setDurationInMinutes(45);
        assertEquals(45, fatLossWorkout.getDurationInMinutes());

        muscleGainWorkout.setDurationInMinutes(90);
        assertEquals(90, muscleGainWorkout.getDurationInMinutes());
    }

    @Test
    void testFatLossWorkoutSetters() {
        fatLossWorkout.setWorkoutName("Evening Swim");
        assertEquals("Evening Swim", fatLossWorkout.getWorkoutName());

        fatLossWorkout.setDurationInMinutes(45);
        assertEquals(45, fatLossWorkout.getDurationInMinutes());

        fatLossWorkout.setCardioType("Swimming");
        assertEquals("Swimming", fatLossWorkout.getCardioType());

        fatLossWorkout.setIntensityLevel("Medium");
        assertEquals("Medium", fatLossWorkout.getIntensityLevel());

        fatLossWorkout.setCaloriesBurned(400);
        assertEquals(400, fatLossWorkout.getCaloriesBurned());
    }

    @Test
    void testMuscleGainWorkoutSetters() {
        muscleGainWorkout.setWorkoutName("Arm Blast");
        assertEquals("Arm Blast", muscleGainWorkout.getWorkoutName());

        muscleGainWorkout.setDurationInMinutes(75);
        assertEquals(75, muscleGainWorkout.getDurationInMinutes());

        muscleGainWorkout.setMuscleGroup("Arms");
        assertEquals("Arms", muscleGainWorkout.getMuscleGroup());

        muscleGainWorkout.setSets(5);
        assertEquals(5, muscleGainWorkout.getSets());

        muscleGainWorkout.setRepsPerSet(15);
        assertEquals(15, muscleGainWorkout.getRepsPerSet());

        muscleGainWorkout.setWeightUsed(135.5);
        assertEquals(135.5, muscleGainWorkout.getWeightUsed());
    }
    @Test

    void testPrintRandomFatLossWorkout() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        workoutManager.printRandomFatLossWorkout();
        assertEquals("No fat loss workouts available.\n", outContent.toString());

        workoutManager.addFatLossWorkout(fatLossWorkout);
        outContent.reset();
        workoutManager.printRandomFatLossWorkout();
        String expectedOutput = "Random Fat Loss Workout: " + fatLossWorkout + "\n";
        assertTrue(outContent.toString().contains(expectedOutput));

        System.setOut(System.out);
    }




}
