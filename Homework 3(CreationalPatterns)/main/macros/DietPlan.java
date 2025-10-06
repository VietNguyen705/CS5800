package macros;

public enum DietPlan {
    NO_RESTRICTION("No Restriction") {
        @Override
        public boolean allows(FoodItem item) {
            return true;
        }
    },
    PALEO("Paleo") {
        @Override
        public boolean allows(FoodItem item) {
            if (item.getCategory() == FoodCategory.CARB && item != FoodItem.PISTACHIO) {
                return false;
            }
            if (item.isTofu()) {
                return false;
            }
            return !item.isDairy();
        }
    },
    VEGAN("Vegan") {
        @Override
        public boolean allows(FoodItem item) {
            if (item.isMeat()) {
                return false;
            }
            return !item.isDairy();
        }
    },
    NUT_ALLERGY("Nut Allergy") {
        @Override
        public boolean allows(FoodItem item) {
            return !item.isNut();
        }
    };

    private final String displayName;

    DietPlan(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public abstract boolean allows(FoodItem item);
}
