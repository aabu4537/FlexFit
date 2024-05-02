package FlexFit.nutrition;
import FlexFit.training.FatLossWorkout;
import FlexFit.training.MuscleGainWorkout;
import FlexFit.user.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class FoodManager extends FoodFactory {
    // Static variable to hold the single instance of FoodManager
    private static FoodManager instance;

    private List<Food> muscleFoods = new ArrayList<>();
    private List<Food> weightLossFoods = new ArrayList<>();

    // Private constructor to prevent external instantiation
    private FoodManager() {
    }

    // Public method to get the instance of FoodManager
    public static FoodManager getInstance() {
        if (instance == null) {
            synchronized (FoodManager.class) {
                if (instance == null) {
                    instance = new FoodManager();
                }
            }
        }
        return instance;
    }

    public void addMuscleGrowthFood(Food food) {
        this.muscleFoods.add(food);
    }

    public void addWeightLossFood(Food food) {
        this.weightLossFoods.add(food);
    }

    public List<Food> getMuscleGrowthFoods() {
        return new ArrayList<>(this.muscleFoods);
    }

    public List<Food> getWeightLossFoods() {
        return new ArrayList<>(this.weightLossFoods);
    }

    public void listMuscleGrowthFoods() {
        if (this.muscleFoods.isEmpty()) {
            System.out.println("No muscle growth foods added yet.");
        } else {
            Iterator<Food> var1 = this.muscleFoods.iterator();

            while(var1.hasNext()) {
                Food food = var1.next();
                System.out.println(food);
            }
        }
    }

    public void listWeightLossFoods() {
        if (this.weightLossFoods.isEmpty()) {
            System.out.println("No weight loss foods added yet.");
        } else {
            Iterator<Food> var1 = this.weightLossFoods.iterator();

            while(var1.hasNext()) {
                Food food = var1.next();
                System.out.println(food);
            }
        }
    }

    public void getSuggestions(User user) {
        Random random = new Random();
        System.out.println("Here is a suggested food:");
        int index;
        if (user.getWorkoutType() == 1) {
            if (!this.weightLossFoods.isEmpty()) {
                index = random.nextInt(this.weightLossFoods.size());
                System.out.println(this.weightLossFoods.get(index).toString());
            } else {
                System.out.println("No foods to suggest for weight loss.");
            }
        } else if (user.getWorkoutType() == 2) {
            if (!this.muscleFoods.isEmpty()) {
                index = random.nextInt(this.muscleFoods.size());
                System.out.println(this.muscleFoods.get(index).toString());
            } else {
                System.out.println("No foods to suggest for muscle gain.");
            }
        } else {
            System.out.println("Unrecognized workout type: " + user.getWorkoutType());
        }
    }
}