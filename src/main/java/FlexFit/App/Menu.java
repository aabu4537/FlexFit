package FlexFit.App;

import FlexFit.Observer.LoggerObserver;
import FlexFit.nutrition.DailyNutrients;


import java.util.Scanner;
import FlexFit.nutrition.FoodManager;
import FlexFit.training.WorkoutManager;
import FlexFit.user.User;

public class Menu {
    private Scanner scanner;
    private DailyNutrients dailyNutrients;
    private WorkoutManager workoutManager;
    private FoodManager foodManager;
    private User user;


    public Menu(WorkoutManager workoutManager, FoodManager foodManager, User user) {
        scanner = new Scanner(System.in);
        dailyNutrients = new DailyNutrients();
        this.workoutManager = workoutManager;
        this.foodManager = foodManager;
        this.user = user;
        LoggerObserver loggerObserver = new LoggerObserver();
        dailyNutrients.registerObserver(loggerObserver);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Record a Meal");
            System.out.println("2. Record a Workout");
            System.out.println("3. Get a Suggested Meal");
            System.out.println("4. Get a Suggested Workout");
            System.out.println("5. Get Daily Summary");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    option1();
                    break;
                case 2:
                    option2();
                    break;
                case 3:
                    option3();
                    break;
                case 4:
                    option4();
                    break;
                case 5:
                    dailyNutrients.displayDailySummary();
                    System.out.println("Your Maintenance Calories: " + user.getMaintenanceCalories());
                    System.out.println("Difference from Maintenance Calories: " + differenceFromMaintenence());
                    break;
                case 6:
                System.out.println("Exiting...");
                return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    public int differenceFromMaintenence(){
        return (int) (dailyNutrients.getTotalCaloriesEaten() - dailyNutrients.getCaloriesBurned() );
    }

    private void option1() {
        System.out.println("Enter the meal name:");
        String mealName = scanner.nextLine();
        System.out.println("Enter the calories:");
        int calories = scanner.nextInt();
        scanner.nextLine();
        dailyNutrients.addMeal(mealName, calories);
    }

    private void option2() {
        System.out.println("Enter the workout name:");
        String workoutName = scanner.nextLine();
        System.out.println("Enter the calories burned:");
        int calories = scanner.nextInt();
        scanner.nextLine();
        dailyNutrients.addWorkout(workoutName, calories);
    }



    private void option3() {
        System.out.println("Here is your meal suggestion:");
        this.foodManager.getSuggestions(this.user);


    }

    private void option4() {
        System.out.println("Here is your workout suggestion:");
        this.workoutManager.getSuggestions(this.user);


    }




}
