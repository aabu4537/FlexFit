import FlexFit.nutrition.Food;
import FlexFit.nutrition.FoodManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class foodTest {

    private FoodManager manager;
    private Food chickenBreast;
    private Food apple;

    @BeforeEach
    void setUp() {
        manager = FoodManager.getInstance();
        chickenBreast = new Food("Chicken Breast", 165, 0, 3.6, 31);
        apple = new Food("Apple", 95, 25, 0.3, 0.5);
    }

    @Test
    void testAddAndListMuscleGrowthFoods() {
        assertTrue(manager.getMuscleGrowthFoods().isEmpty());
        manager.addMuscleGrowthFood(chickenBreast);
        assertFalse(manager.getMuscleGrowthFoods().isEmpty());
        assertEquals(1, manager.getMuscleGrowthFoods().size());
        assertEquals(chickenBreast, manager.getMuscleGrowthFoods().get(0));
    }

    @Test
    void testAddAndListWeightLossFoods() {
        assertTrue(manager.getWeightLossFoods().isEmpty());
        manager.addWeightLossFood(apple);
        assertFalse(manager.getWeightLossFoods().isEmpty());
        assertEquals(1, manager.getWeightLossFoods().size());
        assertEquals(apple, manager.getWeightLossFoods().get(0));
    }

    @Test
    void testFoodConstructorAndGetters() {
        Food food = new Food("Chicken Breast", 165, 0, 3.6, 31);

        assertEquals("Chicken Breast", food.getName());
        assertEquals(165, food.getCalories());
        assertEquals(0, food.getCarbs(), 0.001);
        assertEquals(3.6, food.getFats(), 0.001);
        assertEquals(31, food.getProteins(), 0.001);
    }

    @Test
    void testToString() {
        Food food = new Food("Chicken Breast", 165, 0, 3.6, 31);
        String expectedOutput = "Food: Chicken Breast\nCalories: 165\nCarbs: 0.0g\nFats: 3.6g\nProteins: 31.0g";

        assertEquals(expectedOutput, food.toString());
    }


}
