package FlexFit.App;

import FlexFit.nutrition.FoodManager;
import FlexFit.training.FatLossWorkout;
import FlexFit.training.MuscleGainWorkout;
import FlexFit.training.WorkoutManager;
import FlexFit.user.User;
import FlexFit.nutrition.Food;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {

        //making workout manager
        WorkoutManager workouts = new WorkoutManager();

        //adding muscle gain workouts to workout manager
        MuscleGainWorkout workout0 = new MuscleGainWorkout("Chest Day", 60, "Chest", 4, 8, 100.0);
        MuscleGainWorkout workout20 = new MuscleGainWorkout("Legs for Days", 75, "Legs", 5, 10, 120.0);
        MuscleGainWorkout workout30 = new MuscleGainWorkout("Back and Biceps", 70, "Back", 4, 12, 95.0);
        MuscleGainWorkout workout40 = new MuscleGainWorkout("Shoulder Sculpt", 50, "Shoulders", 3, 15, 40.0);
        MuscleGainWorkout workout50 = new MuscleGainWorkout("Tricep Tear", 45, "Arms", 3, 10, 30.0);
        MuscleGainWorkout workout60 = new MuscleGainWorkout("Total Core", 30, "Core", 4, 20, 0.0); // Bodyweight
        MuscleGainWorkout workout70 = new MuscleGainWorkout("Powerlifting Prep", 90, "Full Body", 5, 5, 150.0);
        MuscleGainWorkout workout80 = new MuscleGainWorkout("Calves and Cardio", 40, "Legs", 4, 15, 50.0);
        MuscleGainWorkout workout90 = new MuscleGainWorkout("Fast Arms", 30, "Arms", 5, 15, 20.0);
        MuscleGainWorkout workout100 = new MuscleGainWorkout("Glute Gains", 60, "Legs", 4, 12, 80.0);

        workouts.addMuscleGainWorkouts(workout0);
        workouts.addMuscleGainWorkouts(workout20);
        workouts.addMuscleGainWorkouts(workout30);
        workouts.addMuscleGainWorkouts(workout40);
        workouts.addMuscleGainWorkouts(workout50);
        workouts.addMuscleGainWorkouts(workout60);
        workouts.addMuscleGainWorkouts(workout70);
        workouts.addMuscleGainWorkouts(workout80);
        workouts.addMuscleGainWorkouts(workout90);
        workouts.addMuscleGainWorkouts(workout100);


        FatLossWorkout workout1 = new FatLossWorkout("Morning Run", 30, "Running", "High", 300);
        FatLossWorkout workout2 = new FatLossWorkout("Bike to Work", 45, "Cycling", "Medium", 350);
        FatLossWorkout workout3 = new FatLossWorkout("Pool Laps", 30, "Swimming", "High", 400);
        FatLossWorkout workout4 = new FatLossWorkout("Evening Walk", 60, "Walking", "Low", 200);
        FatLossWorkout workout5 = new FatLossWorkout("Speed Cycling", 30, "Cycling", "High", 500);
        FatLossWorkout workout6 = new FatLossWorkout("Stair Climber", 20, "Stair Climbing", "Medium", 250);
        FatLossWorkout workout7 = new FatLossWorkout("Rowing Session", 25, "Rowing", "Medium", 300);
        FatLossWorkout workout8 = new FatLossWorkout("Trail Hiking", 90, "Hiking", "Medium", 600);
        FatLossWorkout workout9 = new FatLossWorkout("Zumba Class", 60, "Dancing", "High", 450);
        FatLossWorkout workout10 = new FatLossWorkout("Elliptical Trainer", 45, "Elliptical", "Medium", 400);

        workouts.addFatLossWorkout(workout1);
        workouts.addFatLossWorkout(workout2);
        workouts.addFatLossWorkout(workout3);
        workouts.addFatLossWorkout(workout4);
        workouts.addFatLossWorkout(workout5);
        workouts.addFatLossWorkout(workout6);
        workouts.addFatLossWorkout(workout7);
        workouts.addFatLossWorkout(workout8);
        workouts.addFatLossWorkout(workout9);
        workouts.addFatLossWorkout(workout10);

        Food broccoli = new Food("Broccoli", 31, 6.0, 0.4, 2.5); // per 100 grams
        Food chickenBreast = new Food("Chicken Breast", 165, 0, 3.6, 31); // per 100 grams
        Food oats = new Food("Oats", 389, 66.3, 6.9, 16.9); // per 100 grams
        Food greekYogurt = new Food("Greek Yogurt", 59, 3.6, 0.4, 10); // per 100 grams
        Food apples = new Food("Apple", 52, 14, 0.2, 0.3); // per 100 grams
        FoodManager foods = FoodManager.getInstance();

        foods.addWeightLossFood(broccoli);
        foods.addWeightLossFood(chickenBreast);
        foods.addWeightLossFood(oats);
        foods.addWeightLossFood(greekYogurt);
        foods.addWeightLossFood(apples);

        Food salmon = new Food("Salmon", 208, 0, 13, 20);  // per 100 grams
        Food eggs = new Food("Eggs", 155, 1.1, 11, 13);    // per 100 grams, assuming whole eggs
        Food quinoa = new Food("Quinoa", 120, 21.3, 1.9, 4.4); // per 100 grams, cooked
        Food leanBeef = new Food("Lean Beef", 250, 0, 15, 26); // per 100 grams

        foods.addMuscleGrowthFood(salmon);
        foods.addMuscleGrowthFood(eggs);
        foods.addMuscleGrowthFood(quinoa);
        foods.addMuscleGrowthFood(leanBeef);


        User user = new User();
        System.out.println(user);



        user.promptUserType();
        Menu menu = new Menu( workouts, foods, user);

        // Start the menu interaction
        menu.displayMenu();


        System.out.println("Nice work today, See you tomorrow!");



    }


}