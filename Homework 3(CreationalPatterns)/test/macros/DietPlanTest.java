package macros;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DietPlanTest {

    @Test
    void testNoRestrictionAllowsAllFoods() {
        DietPlan plan = DietPlan.NO_RESTRICTION;

        assertTrue(plan.allows(FoodItem.BREAD));
        assertTrue(plan.allows(FoodItem.PISTACHIO));
        assertTrue(plan.allows(FoodItem.CHICKEN));
        assertTrue(plan.allows(FoodItem.BEEF));
        assertTrue(plan.allows(FoodItem.FISH));
        assertTrue(plan.allows(FoodItem.TUNA));
        assertTrue(plan.allows(FoodItem.TOFU));
        assertTrue(plan.allows(FoodItem.LENTILS));
        assertTrue(plan.allows(FoodItem.CHEESE));
        assertTrue(plan.allows(FoodItem.SOUR_CREAM));
        assertTrue(plan.allows(FoodItem.AVOCADO));
        assertTrue(plan.allows(FoodItem.PEANUTS));
    }

    @Test
    void testPaleoRestrictsBread() {
        DietPlan plan = DietPlan.PALEO;
        assertFalse(plan.allows(FoodItem.BREAD));
    }

    @Test
    void testPaleoAllowsPistachio() {
        DietPlan plan = DietPlan.PALEO;
        assertTrue(plan.allows(FoodItem.PISTACHIO));
    }

    @Test
    void testPaleoRestrictsDairy() {
        DietPlan plan = DietPlan.PALEO;
        assertFalse(plan.allows(FoodItem.CHEESE));
        assertFalse(plan.allows(FoodItem.SOUR_CREAM));
    }

    @Test
    void testPaleoRestrictsTofu() {
        DietPlan plan = DietPlan.PALEO;
        assertFalse(plan.allows(FoodItem.TOFU));
    }

    @Test
    void testPaleoAllowsMeat() {
        DietPlan plan = DietPlan.PALEO;
        assertTrue(plan.allows(FoodItem.CHICKEN));
        assertTrue(plan.allows(FoodItem.BEEF));
        assertTrue(plan.allows(FoodItem.FISH));
        assertTrue(plan.allows(FoodItem.TUNA));
    }

    @Test
    void testVeganRestrictsMeat() {
        DietPlan plan = DietPlan.VEGAN;
        assertFalse(plan.allows(FoodItem.CHICKEN));
        assertFalse(plan.allows(FoodItem.BEEF));
        assertFalse(plan.allows(FoodItem.FISH));
        assertFalse(plan.allows(FoodItem.TUNA));
    }

    @Test
    void testVeganRestrictsDairy() {
        DietPlan plan = DietPlan.VEGAN;
        assertFalse(plan.allows(FoodItem.CHEESE));
        assertFalse(plan.allows(FoodItem.SOUR_CREAM));
    }

    @Test
    void testVeganAllowsTofu() {
        DietPlan plan = DietPlan.VEGAN;
        assertTrue(plan.allows(FoodItem.TOFU));
    }

    @Test
    void testVeganAllowsLentils() {
        DietPlan plan = DietPlan.VEGAN;
        assertTrue(plan.allows(FoodItem.LENTILS));
    }

    @Test
    void testVeganAllowsBread() {
        DietPlan plan = DietPlan.VEGAN;
        assertTrue(plan.allows(FoodItem.BREAD));
    }

    @Test
    void testVeganAllowsAvocado() {
        DietPlan plan = DietPlan.VEGAN;
        assertTrue(plan.allows(FoodItem.AVOCADO));
    }

    @Test
    void testNutAllergyRestrictsNuts() {
        DietPlan plan = DietPlan.NUT_ALLERGY;
        assertFalse(plan.allows(FoodItem.PISTACHIO));
        assertFalse(plan.allows(FoodItem.PEANUTS));
    }

    @Test
    void testNutAllergyAllowsNonNutFoods() {
        DietPlan plan = DietPlan.NUT_ALLERGY;
        assertTrue(plan.allows(FoodItem.BREAD));
        assertTrue(plan.allows(FoodItem.CHICKEN));
        assertTrue(plan.allows(FoodItem.CHEESE));
        assertTrue(plan.allows(FoodItem.AVOCADO));
        assertTrue(plan.allows(FoodItem.TOFU));
    }

    @Test
    void testDietPlanDisplayNames() {
        assertEquals("No Restriction", DietPlan.NO_RESTRICTION.getDisplayName());
        assertEquals("Paleo", DietPlan.PALEO.getDisplayName());
        assertEquals("Vegan", DietPlan.VEGAN.getDisplayName());
        assertEquals("Nut Allergy", DietPlan.NUT_ALLERGY.getDisplayName());
    }

    @Test
    void testCustomerCreation() {
        Customer customer = new Customer("Alice", DietPlan.NO_RESTRICTION);
        assertEquals("Alice", customer.getName());
        assertEquals(DietPlan.NO_RESTRICTION, customer.getDietPlan());
    }

    @Test
    void testCustomerNullNameThrowsException() {
        assertThrows(NullPointerException.class, () -> {
            new Customer(null, DietPlan.NO_RESTRICTION);
        });
    }

    @Test
    void testCustomerNullDietPlanThrowsException() {
        assertThrows(NullPointerException.class, () -> {
            new Customer("Alice", null);
        });
    }
}
