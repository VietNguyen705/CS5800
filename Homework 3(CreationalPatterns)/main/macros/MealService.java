package macros;

import java.util.Objects;

public class MealService {
    private final MacronutrientAbstractFactory factory;

    public MealService(MacronutrientAbstractFactory factory) {
        this.factory = Objects.requireNonNull(factory, "factory");
    }

    public Meal createMeal(Customer customer) {
        Objects.requireNonNull(customer, "customer");
        DietPlan dietPlan = customer.getDietPlan();
        FoodItem carb = factory.carbFactory().create(dietPlan);
        FoodItem protein = factory.proteinFactory().create(dietPlan);
        FoodItem fat = factory.fatFactory().create(dietPlan);
        return new Meal(carb, protein, fat);
    }
}
