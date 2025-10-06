package macros;

import java.util.List;

public class MacronutrientDriver {
    public static void main(String[] args) {
        System.out.println("=== Macronutrient Abstract Factory Pattern Demo ===");

        MacronutrientAbstractFactory factory = MacronutrientFactoryProvider.getInstance();
        MealService mealService = new MealService(factory);

        List<Customer> customers = List.of(
            new Customer("Alice", DietPlan.NO_RESTRICTION),
            new Customer("Ben", DietPlan.PALEO),
            new Customer("Carla", DietPlan.VEGAN),
            new Customer("Diego", DietPlan.NUT_ALLERGY),
            new Customer("Elena", DietPlan.NO_RESTRICTION),
            new Customer("Felix", DietPlan.PALEO)
        );

        for (Customer customer : customers) {
            Meal meal = mealService.createMeal(customer);
            System.out.printf("%s (%s) -> %s%n",
                customer.getName(),
                customer.getDietPlan().getDisplayName(),
                meal.describe());
        }
    }
}
