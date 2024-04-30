package FlexFit.nutrition;

import java.util.ArrayList;
import FlexFit.Observer.Subject;
import FlexFit.Observer.iObserver;
import FlexFit.user.User;
import java.util.List;

public class DailyNutrients implements Subject{
    private List<String> mealsEaten;

    private List<String> workouts;
    private int totalCaloriesEaten;
    private int caloriesBurned;
    private List<iObserver> observers;
    private User user;

    public DailyNutrients() {
        mealsEaten = new ArrayList<>();
        workouts = new ArrayList<>();
        observers = new ArrayList<>();
        totalCaloriesEaten = 0;
        caloriesBurned = 0;
    }

    public void addMeal(String mealName, int calories) {
        mealsEaten.add(mealName + " - " + calories + " calories");
        totalCaloriesEaten += calories;
        notifyObservers();
    }

    public void addWorkout(String workoutName, int calories) {
        workouts.add(workoutName + "-" + calories + " calories");
        caloriesBurned += calories;
        notifyObservers();
    }

    @Override
    public void registerObserver(iObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(iObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (iObserver observer : observers) {
            observer.update();
        }
    }

    public int getTotalCaloriesEaten() {
        return totalCaloriesEaten;
    }

    public int getCaloriesBurned(){
        return caloriesBurned;
    }



    public void displayDailySummary() {
        System.out.println("Daily Summary:");
        System.out.println("Meals Eaten:");
        for (String meal : mealsEaten) {
            System.out.println(meal);
        }
        System.out.println("Total Calories Eaten: " + totalCaloriesEaten);
        System.out.println("Workouts performed:");
        for (String workout : workouts) {
            System.out.println(workout);
        }
        System.out.println("Calories Burned from Workouts: " + caloriesBurned);

    }
}
