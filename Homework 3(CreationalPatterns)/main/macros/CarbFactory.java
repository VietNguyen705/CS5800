package macros;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public final class CarbFactory implements FoodFactory {
    private static final CarbFactory INSTANCE = new CarbFactory();
    private static final List<FoodItem> CARB_ITEMS = List.of(
        FoodItem.BREAD,
        FoodItem.PISTACHIO
    );

    private CarbFactory() {
    }

    public static CarbFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public FoodItem create(DietPlan dietPlan) {
        List<FoodItem> allowedItems = CARB_ITEMS.stream()
            .filter(dietPlan::allows)
            .collect(Collectors.toList());
        if (allowedItems.isEmpty()) {
            throw new IllegalStateException("No carb options available for diet plan " + dietPlan);
        }
        int index = ThreadLocalRandom.current().nextInt(allowedItems.size());
        return allowedItems.get(index);
    }
}
