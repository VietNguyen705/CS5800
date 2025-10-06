package macros;

import java.util.Objects;

public class Meal {
    private final FoodItem carb;
    private final FoodItem protein;
    private final FoodItem fat;

    public Meal(FoodItem carb, FoodItem protein, FoodItem fat) {
        this.carb = Objects.requireNonNull(carb, "carb");
        this.protein = Objects.requireNonNull(protein, "protein");
        this.fat = Objects.requireNonNull(fat, "fat");
    }

    public FoodItem getCarb() {
        return carb;
    }

    public FoodItem getProtein() {
        return protein;
    }

    public FoodItem getFat() {
        return fat;
    }

    public String describe() {
        return String.format("Carb: %s, Protein: %s, Fat: %s",
            carb.getDisplayName(),
            protein.getDisplayName(),
            fat.getDisplayName());
    }
}
