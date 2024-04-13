package FlexFit.training;

public class MuscleGainWorkout {
    // Attributes to store information about the workout
    private String workoutName;
    private int durationInMinutes;
    private String muscleGroup;  // E.g., "Legs", "Arms", "Back", "Chest"
    private int sets;
    private int repsPerSet;
    private double weightUsed; // Weight in kilograms or pounds

    // Constructor to initialize the MuscleGainWorkout object
    public MuscleGainWorkout(String workoutName, int durationInMinutes, String muscleGroup,
                             int sets, int repsPerSet, double weightUsed) {
        this.workoutName = workoutName;
        this.durationInMinutes = durationInMinutes;
        this.muscleGroup = muscleGroup;
        this.sets = sets;
        this.repsPerSet = repsPerSet;
        this.weightUsed = weightUsed;
    }

    // Getter and setter methods for each attribute
    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getRepsPerSet() {
        return repsPerSet;
    }

    public void setRepsPerSet(int repsPerSet) {
        this.repsPerSet = repsPerSet;
    }

    public double getWeightUsed() {
        return weightUsed;
    }

    public void setWeightUsed(double weightUsed) {
        this.weightUsed = weightUsed;
    }

    // Method to display details about the workout
    public void displayWorkoutDetails() {
        System.out.println("Workout Name: " + workoutName);
        System.out.println("Duration: " + durationInMinutes + " minutes");
        System.out.println("Muscle Group: " + muscleGroup);
        System.out.println("Sets: " + sets);
        System.out.println("Reps per Set: " + repsPerSet);
        System.out.println("Weight Used: " + weightUsed + " kg");
    }

    public String displayWorkoutDetailsString() {
        // Creating a StringBuilder for efficient string concatenation
        StringBuilder details = new StringBuilder();
        details.append("Workout Name: ").append(workoutName).append("\n");
        details.append("Duration: ").append(durationInMinutes).append(" minutes\n");
        details.append("Muscle Group: ").append(muscleGroup).append("\n");
        details.append("Sets: ").append(sets).append("\n");
        details.append("Reps per Set: ").append(repsPerSet).append("\n");
        details.append("Weight Used: ").append(weightUsed).append(" kg\n");
        return details.toString();
    }
}
