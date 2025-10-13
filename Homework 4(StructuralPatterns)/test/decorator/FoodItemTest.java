package decorator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FoodItemTest {

    @Test
    public void testBurgerGetDescription() {
        FoodItem burger = new Burger();
        assertEquals("Burger", burger.getDescription());
    }

    @Test
    public void testBurgerGetCost() {
        FoodItem burger = new Burger();
        assertEquals(5.99, burger.getCost(), 0.01);
    }

    @Test
    public void testFriesGetDescription() {
        FoodItem fries = new Fries();
        assertEquals("Fries", fries.getDescription());
    }

    @Test
    public void testFriesGetCost() {
        FoodItem fries = new Fries();
        assertEquals(2.99, fries.getCost(), 0.01);
    }

    @Test
    public void testHotDogGetDescription() {
        FoodItem hotDog = new HotDog();
        assertEquals("Hot Dog", hotDog.getDescription());
    }

    @Test
    public void testHotDogGetCost() {
        FoodItem hotDog = new HotDog();
        assertEquals(3.99, hotDog.getCost(), 0.01);
    }
}
