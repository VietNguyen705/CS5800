package macros;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public final class FatFactory implements FoodFactory {
    private static final FatFactory INSTANCE = new FatFactory();
    private static final List<FoodItem> FAT_ITEMS = List.of(
        FoodItem.CHEESE,
        FoodItem.SOUR_CREAM,
        FoodItem.AVOCADO,
        FoodItem.PEANUTS
    );

    private FatFactory() {
    }

    public static FatFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public FoodItem create(DietPlan dietPlan) {
        List<FoodItem> allowedItems = FAT_ITEMS.stream()
            .filter(dietPlan::allows)
            .collect(Collectors.toList());
        if (allowedItems.isEmpty()) {
            throw new IllegalStateException("No fat options available for diet plan " + dietPlan);
        }
        int index = ThreadLocalRandom.current().nextInt(allowedItems.size());
        return allowedItems.get(index);
    }
}
