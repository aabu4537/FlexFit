package FlexFit.nutrition;

public class Food {
    // Attributes to store the food's name, calories, and macronutrients
    private String name;
    private int calories;
    private double carbs;
    private double fats;
    private double proteins;

    // Constructor to initialize the food item
    public Food(String name, int calories, double carbs, double fats, double proteins) {
        this.name = name;
        this.calories = calories;
        this.carbs = carbs;
        this.fats = fats;
        this.proteins = proteins;
    }

    // Getter methods for each attribute
    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public double getCarbs() {
        return carbs;
    }

    public double getFats() {
        return fats;
    }

    public double getProteins() {
        return proteins;
    }

    // A method to display food information
    public String toString() {
        return "Food: " + name + "\nCalories: " + calories +
                "\nCarbs: " + carbs + "g" +
                "\nFats: " + fats + "g" +
                "\nProteins: " + proteins + "g";
    }
}