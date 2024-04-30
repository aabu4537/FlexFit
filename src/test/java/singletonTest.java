import FlexFit.nutrition.FoodManager;
public class singletonTest {
    public static void main(String[] args) {
        FoodManager manager1 = FoodManager.getInstance();
        FoodManager manager2 = FoodManager.getInstance();

        if (manager1 == manager2) {
            System.out.println("There is only one instance of the FoodManager class.");
        } else {
            System.out.println("There are multiple instances of the FoodManager class.");
        }
    }
}