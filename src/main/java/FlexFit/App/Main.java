package FlexFit.App;

import FlexFit.nutrition.FoodFactory;
import FlexFit.nutrition.FoodManager;
import FlexFit.training.FatLossWorkout;
import FlexFit.training.MuscleGainWorkout;
import FlexFit.training.WorkoutFactory;
import FlexFit.training.WorkoutManager;
import FlexFit.user.User;
import FlexFit.nutrition.Food;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {

        //making workout manager
        WorkoutManager workouts = new WorkoutManager();
        FoodFactory foodFactory = new FoodFactory();
        FoodManager foods = FoodManager.getInstance();
        WorkoutFactory workoutFactory = new WorkoutFactory();



        workouts.addMuscleGainWorkouts(WorkoutFactory.createMuscleGainWorkout("Chest Day", 60, "Chest", 4, 8, 100.0));
        workouts.addMuscleGainWorkouts(WorkoutFactory.createMuscleGainWorkout("Legs for Days", 75, "Legs", 5, 10, 120.0));
        workouts.addMuscleGainWorkouts(WorkoutFactory.createMuscleGainWorkout("Back and Biceps", 70, "Back", 4, 12, 95.0));
        workouts.addMuscleGainWorkouts(WorkoutFactory.createMuscleGainWorkout("Shoulder Sculpt", 50, "Shoulders", 3, 15, 40.0));
        workouts.addMuscleGainWorkouts(WorkoutFactory.createMuscleGainWorkout("Tricep Tear", 45, "Arms", 3, 10, 30.0));
        workouts.addMuscleGainWorkouts(WorkoutFactory.createMuscleGainWorkout("Total Core", 30, "Core", 4, 20, 0.0)); // Bodyweight
        workouts.addMuscleGainWorkouts(WorkoutFactory.createMuscleGainWorkout("Powerlifting Prep", 90, "Full Body", 5, 5, 150.0));
        workouts.addMuscleGainWorkouts(WorkoutFactory.createMuscleGainWorkout("Calves and Cardio", 40, "Legs", 4, 15, 50.0));
        workouts.addMuscleGainWorkouts(WorkoutFactory.createMuscleGainWorkout("Fast Arms", 30, "Arms", 5, 15, 20.0));
        workouts.addMuscleGainWorkouts(WorkoutFactory.createMuscleGainWorkout("Glute Gains", 60, "Legs", 4, 12, 80.0));



        workouts.addFatLossWorkout(WorkoutFactory.createFatLossWorkout("Morning Run", 30, "Running", "High", 300));
        workouts.addFatLossWorkout(WorkoutFactory.createFatLossWorkout("Bike to Work", 45, "Cycling", "Medium", 350));
        workouts.addFatLossWorkout(WorkoutFactory.createFatLossWorkout("Pool Laps", 30, "Swimming", "High", 400));
        workouts.addFatLossWorkout(WorkoutFactory.createFatLossWorkout("Evening Walk", 60, "Walking", "Low", 200));
        workouts.addFatLossWorkout(WorkoutFactory.createFatLossWorkout("Speed Cycling", 30, "Cycling", "High", 500));
        workouts.addFatLossWorkout(WorkoutFactory.createFatLossWorkout("Stair Climber", 20, "Stair Climbing", "Medium", 250));
        workouts.addFatLossWorkout(WorkoutFactory.createFatLossWorkout("Rowing Session", 25, "Rowing", "Medium", 300));
        workouts.addFatLossWorkout(WorkoutFactory.createFatLossWorkout("Trail Hiking", 90, "Hiking", "Medium", 600));
        workouts.addFatLossWorkout(WorkoutFactory.createFatLossWorkout("Zumba Class", 60, "Dancing", "High", 450));
        workouts.addFatLossWorkout(WorkoutFactory.createFatLossWorkout("Elliptical Trainer", 45, "Elliptical", "Medium", 400));



        foods.addWeightLossFood( foodFactory.createFood("Broccoli", 31, 6.0, 0.4, 2.5));
        foods.addWeightLossFood(foodFactory.createFood("Oats", 389, 66.3, 6.9, 16.9));
        foods.addWeightLossFood(foodFactory.createFood("Greek Yogurt", 59, 3.6, 0.4, 10));
        foods.addWeightLossFood(foodFactory.createFood("Apple", 52, 14, 0.2, 0.3));




        foods.addMuscleGrowthFood(foodFactory.createFood("Chicken Breast", 165, 0, 3.6, 31));
        foods.addMuscleGrowthFood(foodFactory.createFood("Eggs", 155, 1.1, 11, 13));
        foods.addMuscleGrowthFood(foodFactory.createFood("Salmon", 208, 0, 13, 20));
        foods.addMuscleGrowthFood(foodFactory.createFood("Greek Yogurt", 59, 3.6, 0.4, 10));
        foods.addMuscleGrowthFood(foodFactory.createFood("Quinoa", 120, 21.3, 1.9, 4.4));


        User user = new User();
        System.out.println(user);



        user.promptUserType();
        Menu menu = new Menu( workouts, foods, user);

        // Start the menu interaction
        menu.displayMenu();


        System.out.println("Nice work today, See you tomorrow!");



    }


}