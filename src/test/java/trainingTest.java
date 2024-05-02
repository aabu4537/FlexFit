import FlexFit.training.FatLossWorkout;
import FlexFit.training.WorkoutFactory;
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
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;



    @BeforeEach
    void setUp() {
        // Initialize the workouts with sample data
        workoutManager = new WorkoutManager();
        fatLossWorkout = new FatLossWorkout("Morning Run", 30, "Running", "High", 300);
        muscleGainWorkout = new MuscleGainWorkout("Leg Day", 60, "Legs", 4, 12, 120.0);
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
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

    @Test
    void testAddingMultipleWorkouts() {
        WorkoutManager manager = new WorkoutManager();
        manager.addFatLossWorkout(fatLossWorkout);
        manager.addFatLossWorkout(new FatLossWorkout("Cycling", 45, "Biking", "Moderate", 350));
        assertEquals(2, manager.getFatLossWorkouts().size(), "Should have two fat loss workouts stored");

        manager.addMuscleGainWorkouts(muscleGainWorkout);
        manager.addMuscleGainWorkouts(new MuscleGainWorkout("Chest Day", 55, "Chest", 5, 10, 150.0));
        assertEquals(2, manager.getMuscleGainWorkouts().size(), "Should have two muscle gain workouts stored");
    }

    @Test
    void testAddAndRetrieveMuscleGainWorkouts() {
        workoutManager.addMuscleGainWorkouts(muscleGainWorkout);
        assertEquals(1, workoutManager.getMuscleGainWorkouts().size(), "Should have added one muscle gain workout");
        assertEquals(muscleGainWorkout, workoutManager.getMuscleGainWorkouts().get(0), "The added workout should be retrievable");
    }

    @Test
    void testAddAndRetrieveFatLossWorkouts() {
        workoutManager.addFatLossWorkout(fatLossWorkout);
        assertEquals(1, workoutManager.getFatLossWorkouts().size(), "Should have added one fat loss workout");
        assertEquals(fatLossWorkout, workoutManager.getFatLossWorkouts().get(0), "The added workout should be retrievable");
    }

    @Test
    void testCreateMuscleGainWorkout() {
        // Create a muscle gain workout using the factory
        MuscleGainWorkout workout = WorkoutFactory.createMuscleGainWorkout("Bench Press", 45, "Chest", 3, 10, 80.0);

        // Assert that all properties are set correctly
        assertEquals("Bench Press", workout.getWorkoutName());
        assertEquals(45, workout.getDurationInMinutes());
        assertEquals("Chest", workout.getMuscleGroup());
        assertEquals(3, workout.getSets());
        assertEquals(10, workout.getRepsPerSet());
        assertEquals(80.0, workout.getWeightUsed(), 0.001, "Weight used should match the input value");
    }

    @Test
    void testCreateFatLossWorkout() {
        // Create a fat loss workout using the factory
        FatLossWorkout workout = WorkoutFactory.createFatLossWorkout("Morning Jog", 30, "Running", "Low", 250);

        // Assert that all properties are set correctly
        assertEquals("Morning Jog", workout.getWorkoutName());
        assertEquals(30, workout.getDurationInMinutes());
        assertEquals("Running", workout.getCardioType());
        assertEquals("Low", workout.getIntensityLevel());
        assertEquals(250, workout.getCaloriesBurned());
    }









}
