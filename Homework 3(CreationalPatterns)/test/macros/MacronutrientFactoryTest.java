package macros;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MacronutrientFactoryTest {

    @Test
    void testCarbFactoryReturnsCarbItems() {
        FoodFactory carbFactory = CarbFactory.getInstance();

        for (int i = 0; i < 10; i++) {
            FoodItem item = carbFactory.create(DietPlan.NO_RESTRICTION);
            assertEquals(FoodCategory.CARB, item.getCategory());
        }
    }

    @Test
    void testProteinFactoryReturnsProteinItems() {
        FoodFactory proteinFactory = ProteinFactory.getInstance();

        for (int i = 0; i < 10; i++) {
            FoodItem item = proteinFactory.create(DietPlan.NO_RESTRICTION);
            assertEquals(FoodCategory.PROTEIN, item.getCategory());
        }
    }

    @Test
    void testFatFactoryReturnsFatItems() {
        FoodFactory fatFactory = FatFactory.getInstance();

        for (int i = 0; i < 10; i++) {
            FoodItem item = fatFactory.create(DietPlan.NO_RESTRICTION);
            assertEquals(FoodCategory.FAT, item.getCategory());
        }
    }

    @Test
    void testCarbFactorySingleton() {
        FoodFactory factory1 = CarbFactory.getInstance();
        FoodFactory factory2 = CarbFactory.getInstance();
        assertSame(factory1, factory2);
    }

    @Test
    void testProteinFactorySingleton() {
        FoodFactory factory1 = ProteinFactory.getInstance();
        FoodFactory factory2 = ProteinFactory.getInstance();
        assertSame(factory1, factory2);
    }

    @Test
    void testFatFactorySingleton() {
        FoodFactory factory1 = FatFactory.getInstance();
        FoodFactory factory2 = FatFactory.getInstance();
        assertSame(factory1, factory2);
    }

    @Test
    void testPaleoDietCarbs() {
        FoodFactory carbFactory = CarbFactory.getInstance();
        FoodItem item = carbFactory.create(DietPlan.PALEO);
        assertEquals(FoodItem.PISTACHIO, item);
    }

    @Test
    void testPaleoDietProtein() {
        FoodFactory proteinFactory = ProteinFactory.getInstance();

        for (int i = 0; i < 20; i++) {
            FoodItem item = proteinFactory.create(DietPlan.PALEO);
            assertFalse(item.isDairy());
            assertFalse(item.isTofu());
        }
    }

    @Test
    void testPaleoDietFat() {
        FoodFactory fatFactory = FatFactory.getInstance();

        for (int i = 0; i < 20; i++) {
            FoodItem item = fatFactory.create(DietPlan.PALEO);
            assertFalse(item.isDairy());
        }
    }

    @Test
    void testVeganDietProtein() {
        FoodFactory proteinFactory = ProteinFactory.getInstance();

        for (int i = 0; i < 20; i++) {
            FoodItem item = proteinFactory.create(DietPlan.VEGAN);
            assertFalse(item.isMeat());
            assertFalse(item.isDairy());
        }
    }

    @Test
    void testVeganDietFat() {
        FoodFactory fatFactory = FatFactory.getInstance();

        for (int i = 0; i < 20; i++) {
            FoodItem item = fatFactory.create(DietPlan.VEGAN);
            assertFalse(item.isDairy());
        }
    }

    @Test
    void testNutAllergyCarbs() {
        FoodFactory carbFactory = CarbFactory.getInstance();
        FoodItem item = carbFactory.create(DietPlan.NUT_ALLERGY);
        assertEquals(FoodItem.BREAD, item);
    }

    @Test
    void testNutAllergyFat() {
        FoodFactory fatFactory = FatFactory.getInstance();

        for (int i = 0; i < 20; i++) {
            FoodItem item = fatFactory.create(DietPlan.NUT_ALLERGY);
            assertFalse(item.isNut());
        }
    }

    @Test
    void testAbstractFactoryProvider() {
        MacronutrientAbstractFactory provider = MacronutrientFactoryProvider.getInstance();

        assertNotNull(provider.carbFactory());
        assertNotNull(provider.proteinFactory());
        assertNotNull(provider.fatFactory());
    }

    @Test
    void testAbstractFactoryProviderSingleton() {
        MacronutrientAbstractFactory provider1 = MacronutrientFactoryProvider.getInstance();
        MacronutrientAbstractFactory provider2 = MacronutrientFactoryProvider.getInstance();
        assertSame(provider1, provider2);
    }

    @Test
    void testMealService() {
        MacronutrientAbstractFactory factory = MacronutrientFactoryProvider.getInstance();
        MealService mealService = new MealService(factory);

        Customer customer = new Customer("Test", DietPlan.NO_RESTRICTION);
        Meal meal = mealService.createMeal(customer);

        assertNotNull(meal.getCarb());
        assertNotNull(meal.getProtein());
        assertNotNull(meal.getFat());
        assertEquals(FoodCategory.CARB, meal.getCarb().getCategory());
        assertEquals(FoodCategory.PROTEIN, meal.getProtein().getCategory());
        assertEquals(FoodCategory.FAT, meal.getFat().getCategory());
    }

    @Test
    void testMealServiceWithPaleo() {
        MacronutrientAbstractFactory factory = MacronutrientFactoryProvider.getInstance();
        MealService mealService = new MealService(factory);

        Customer customer = new Customer("Paleo Customer", DietPlan.PALEO);
        Meal meal = mealService.createMeal(customer);

        assertEquals(FoodItem.PISTACHIO, meal.getCarb());
        assertFalse(meal.getProtein().isDairy());
        assertFalse(meal.getFat().isDairy());
    }

    @Test
    void testMealServiceWithVegan() {
        MacronutrientAbstractFactory factory = MacronutrientFactoryProvider.getInstance();
        MealService mealService = new MealService(factory);

        Customer customer = new Customer("Vegan Customer", DietPlan.VEGAN);
        Meal meal = mealService.createMeal(customer);

        assertFalse(meal.getProtein().isMeat());
        assertFalse(meal.getProtein().isDairy());
        assertFalse(meal.getFat().isDairy());
    }

    @Test
    void testMealServiceWithNutAllergy() {
        MacronutrientAbstractFactory factory = MacronutrientFactoryProvider.getInstance();
        MealService mealService = new MealService(factory);

        Customer customer = new Customer("Nut Allergy Customer", DietPlan.NUT_ALLERGY);
        Meal meal = mealService.createMeal(customer);

        assertEquals(FoodItem.BREAD, meal.getCarb());
        assertFalse(meal.getFat().isNut());
    }

    @Test
    void testMealDescribe() {
        Meal meal = new Meal(FoodItem.BREAD, FoodItem.CHICKEN, FoodItem.CHEESE);
        String description = meal.describe();

        assertTrue(description.contains("Bread"));
        assertTrue(description.contains("Chicken"));
        assertTrue(description.contains("Cheese"));
    }
}
