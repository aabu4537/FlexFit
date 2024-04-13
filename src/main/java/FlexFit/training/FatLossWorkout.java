package FlexFit.training;

public class FatLossWorkout {

        // Attributes to store information about the cardio workout
        private String workoutName;
        private int durationInMinutes;  // Duration of the workout in minutes
        private String cardioType;      // E.g., "Running", "Cycling", "Swimming"
        private String intensityLevel;  // E.g., "Low", "Medium", "High"
        private int caloriesBurned;     // Estimated calories burned during the workout

        // Constructor to initialize the FatLossWorkout object
        public FatLossWorkout(String workoutName, int durationInMinutes, String cardioType,
                              String intensityLevel, int caloriesBurned) {
            this.workoutName = workoutName;
            this.durationInMinutes = durationInMinutes;
            this.cardioType = cardioType;
            this.intensityLevel = intensityLevel;
            this.caloriesBurned = caloriesBurned;
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

        public String getCardioType() {
            return cardioType;
        }

        public void setCardioType(String cardioType) {
            this.cardioType = cardioType;
        }

        public String getIntensityLevel() {
            return intensityLevel;
        }

        public void setIntensityLevel(String intensityLevel) {
            this.intensityLevel = intensityLevel;
        }

        public int getCaloriesBurned() {
            return caloriesBurned;
        }

        public void setCaloriesBurned(int caloriesBurned) {
            this.caloriesBurned = caloriesBurned;
        }

        // Method to display details about the workout
        public void displayWorkoutDetails() {
            System.out.println("Workout Name: " + workoutName);
            System.out.println("Duration: " + durationInMinutes + " minutes");
            System.out.println("Cardio Type: " + cardioType);
            System.out.println("Intensity Level: " + intensityLevel);
            System.out.println("Calories Burned: " + caloriesBurned + " kcal");
        }

    public String displayWorkoutDetailsString() {
        // Creating a StringBuilder for efficient string concatenation
        StringBuilder details = new StringBuilder();
        details.append("Workout Name: ").append(workoutName).append("\n");
        details.append("Duration: ").append(durationInMinutes).append(" minutes\n");
        details.append("Cardio Type: ").append(cardioType).append("\n");
        details.append("Intensity Level: ").append(intensityLevel).append("\n");
        details.append("Calories Burned: ").append(caloriesBurned).append(" kcal\n");

        // Returning the complete string
        return details.toString();
    }
    }


