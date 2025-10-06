package macros;

public enum FoodItem {
    BREAD(FoodCategory.CARB, "Bread", false, false, false, false),
    PISTACHIO(FoodCategory.CARB, "Pistachio", false, false, true, false),
    CHICKEN(FoodCategory.PROTEIN, "Chicken", false, true, false, false),
    BEEF(FoodCategory.PROTEIN, "Beef", false, true, false, false),
    FISH(FoodCategory.PROTEIN, "Fish", false, true, false, false),
    TUNA(FoodCategory.PROTEIN, "Tuna", false, true, false, false),
    TOFU(FoodCategory.PROTEIN, "Tofu", false, false, false, true),
    LENTILS(FoodCategory.PROTEIN, "Lentils", false, false, false, false),
    CHEESE(FoodCategory.FAT, "Cheese", true, false, false, false),
    SOUR_CREAM(FoodCategory.FAT, "Sour cream", true, false, false, false),
    AVOCADO(FoodCategory.FAT, "Avocado", false, false, false, false),
    PEANUTS(FoodCategory.FAT, "Peanuts", false, false, true, false);

    private final FoodCategory category;
    private final String displayName;
    private final boolean dairy;
    private final boolean meat;
    private final boolean nut;
    private final boolean tofu;

    FoodItem(FoodCategory category, String displayName, boolean dairy, boolean meat, boolean nut, boolean tofu) {
        this.category = category;
        this.displayName = displayName;
        this.dairy = dairy;
        this.meat = meat;
        this.nut = nut;
        this.tofu = tofu;
    }

    public FoodCategory getCategory() {
        return category;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isDairy() {
        return dairy;
    }

    public boolean isMeat() {
        return meat;
    }

    public boolean isNut() {
        return nut;
    }

    public boolean isTofu() {
        return tofu;
    }
}
