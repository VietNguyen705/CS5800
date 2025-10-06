package macros;

public final class MacronutrientFactoryProvider implements MacronutrientAbstractFactory {
    private static final MacronutrientFactoryProvider INSTANCE = new MacronutrientFactoryProvider();

    private MacronutrientFactoryProvider() {
    }

    public static MacronutrientFactoryProvider getInstance() {
        return INSTANCE;
    }

    @Override
    public FoodFactory carbFactory() {
        return CarbFactory.getInstance();
    }

    @Override
    public FoodFactory proteinFactory() {
        return ProteinFactory.getInstance();
    }

    @Override
    public FoodFactory fatFactory() {
        return FatFactory.getInstance();
    }
}
