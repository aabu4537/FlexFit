package FlexFit.nutrition;

public class FoodFactory extends DailyNutrients {

    public Food createFood(String name, int calories, double carbs, double fats, double proteins){
        return new Food(name, calories, carbs, fats, proteins);

    }
}
