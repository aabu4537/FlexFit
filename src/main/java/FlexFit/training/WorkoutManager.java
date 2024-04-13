package FlexFit.training;

import FlexFit.nutrition.Food;
import FlexFit.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorkoutManager {
    private List<FatLossWorkout> fatLossWorkouts;
    private List<MuscleGainWorkout> muscleGainWorkouts;
    private Random random;  // Random object for selecting workouts

    public WorkoutManager() {
        this.fatLossWorkouts = new ArrayList<>();
        this.muscleGainWorkouts = new ArrayList<>();
        this.random = new Random();  // Initialize the random object
    }

    // Method to add muscle gain workout
    public void addMuscleGainWorkouts(MuscleGainWorkout workout) {
        muscleGainWorkouts.add(workout);
    }

    // Method to add fat loss workout
    public void addFatLossWorkout(FatLossWorkout workout) {
        fatLossWorkouts.add(workout);
    }

    // Method to get all muscle gain workouts
    public List<MuscleGainWorkout> getMuscleGainWorkouts() {
        return new ArrayList<>(muscleGainWorkouts); // Return a copy of the list to prevent external modifications
    }

    // Method to get all fat loss workouts
    public List<FatLossWorkout> getFatLossWorkouts() {
        return new ArrayList<>(fatLossWorkouts); // Return a copy of the list to prevent external modifications
    }

    // Method to choose and print a random muscle gain workout
    public void printRandomMuscleGainWorkout() {
        if (!muscleGainWorkouts.isEmpty()) {
            MuscleGainWorkout randomWorkout = muscleGainWorkouts.get(random.nextInt(muscleGainWorkouts.size()));
            System.out.println("Random Muscle Gain Workout: " + randomWorkout);
        } else {
            System.out.println("No muscle gain workouts available.");
        }
    }

    // Method to choose and print a random fat loss workout
    public void printRandomFatLossWorkout() {
        if (!fatLossWorkouts.isEmpty()) {
            FatLossWorkout randomWorkout = fatLossWorkouts.get(random.nextInt(fatLossWorkouts.size()));
            System.out.println("Random Fat Loss Workout: " + randomWorkout);
        } else {
            System.out.println("No fat loss workouts available.");
        }
    }

    public void getSuggestions(User user){
        System.out.println("Here are some suggested workouts");
        if(user.getWorkoutType() == 1){
            for (FatLossWorkout workout : fatLossWorkouts) {
                System.out.println(workout.displayWorkoutDetailsString());
               System.out.println("");
            }
                }
        else if(user.getWorkoutType() == 2){
            for (MuscleGainWorkout workout : muscleGainWorkouts) {
                System.out.println(workout.displayWorkoutDetailsString());
                System.out.println("");
            }

        }

    }



}

