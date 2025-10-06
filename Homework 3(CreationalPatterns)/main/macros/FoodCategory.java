package macros;

public enum FoodCategory {
    CARB("Carb"),
    PROTEIN("Protein"),
    FAT("Fat");

    private final String displayName;

    FoodCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
