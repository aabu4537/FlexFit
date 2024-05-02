package FlexFit.training;

import FlexFit.nutrition.DailyNutrients;

public class WorkoutFactory extends DailyNutrients {
    public static MuscleGainWorkout createMuscleGainWorkout(String name, int duration, String muscleGroup, int sets, int reps, double weight) {
        return new MuscleGainWorkout(name, duration, muscleGroup, sets, reps, weight);
    }

    public static FatLossWorkout createFatLossWorkout(String name, int duration, String type, String intensity, int caloriesBurned) {
        return new FatLossWorkout(name, duration, type, intensity, caloriesBurned);
    }
}
