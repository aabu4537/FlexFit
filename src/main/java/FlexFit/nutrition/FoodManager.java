package FlexFit.nutrition;
import FlexFit.training.FatLossWorkout;
import FlexFit.training.MuscleGainWorkout;
import FlexFit.user.User;

import java.util.ArrayList;
import java.util.List;
public class FoodManager {
    private List<Food> muscleFoods;
    private List <Food> weightLossFoods;

    public FoodManager() {
        this.muscleFoods = new ArrayList<>();
        this.weightLossFoods = new ArrayList<>();
    }

    // Method to add muscle growth food
    public void addMuscleGrowthFood(Food food) {
        muscleFoods.add(food);
    }

    // Method to add weight loss food
    public void addWeightLossFood(Food food) {
        weightLossFoods.add(food);
    }

    // Method to get all muscle growth foods
    public List<Food> getMuscleGrowthFoods() {
        return new ArrayList<>(muscleFoods); // Return a copy of the list to prevent external modifications
    }

    // Method to get all weight loss foods
    public List<Food> getWeightLossFoods() {
        return new ArrayList<>(weightLossFoods); // Return a copy of the list to prevent external modifications
    }

    // Method to list all foods for muscle growth
    public void listMuscleGrowthFoods() {
        if (muscleFoods.isEmpty()) {
            System.out.println("No muscle growth foods added yet.");
        } else {
            for (Food food : muscleFoods) {
                System.out.println(food);
            }
        }
    }

    // Method to list all foods for weight loss
    public void listWeightLossFoods() {
        if (weightLossFoods.isEmpty()) {
            System.out.println("No weight loss foods added yet.");
        } else {
            for (Food food : weightLossFoods) {
                System.out.println(food);
            }
        }
    }

    public void getSuggestions(User user){

        System.out.println("Here are some suggested foods");
        if(user.getWorkoutType() == 1){
            for (Food food : weightLossFoods) {
                System.out.println(food.toString());
                System.out.println("");
            }
        }
        else if(user.getWorkoutType() == 2){
            for (Food food: muscleFoods) {
                System.out.println(food.toString());
                System.out.println("");
            }

        }
        else{
            System.out.println(user.getWorkoutType());
        }
    }
}
