package macros;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public final class ProteinFactory implements FoodFactory {
    private static final ProteinFactory INSTANCE = new ProteinFactory();
    private static final List<FoodItem> PROTEIN_ITEMS = List.of(
        FoodItem.CHICKEN,
        FoodItem.BEEF,
        FoodItem.FISH,
        FoodItem.TUNA,
        FoodItem.TOFU,
        FoodItem.LENTILS
    );

    private ProteinFactory() {
    }

    public static ProteinFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public FoodItem create(DietPlan dietPlan) {
        List<FoodItem> allowedItems = PROTEIN_ITEMS.stream()
            .filter(dietPlan::allows)
            .collect(Collectors.toList());
        if (allowedItems.isEmpty()) {
            throw new IllegalStateException("No protein options available for diet plan " + dietPlan);
        }
        int index = ThreadLocalRandom.current().nextInt(allowedItems.size());
        return allowedItems.get(index);
    }
}
