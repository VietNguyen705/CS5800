package decorator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToppingDecoratorTest {

    @Test
    public void testCheeseDecorator() {
        FoodItem burger = new Burger();
        burger = new Cheese(burger);
        assertEquals("Burger, Cheese", burger.getDescription());
        assertEquals(6.49, burger.getCost(), 0.01);
    }

    @Test
    public void testKetchupDecorator() {
        FoodItem hotDog = new HotDog();
        hotDog = new Ketchup(hotDog);
        assertEquals("Hot Dog, Ketchup", hotDog.getDescription());
        assertEquals(4.24, hotDog.getCost(), 0.01);
    }

    @Test
    public void testOnionsDecorator() {
        FoodItem fries = new Fries();
        fries = new Onions(fries);
        assertEquals("Fries, Onions", fries.getDescription());
        assertEquals(3.29, fries.getCost(), 0.01);
    }

    @Test
    public void testMultipleToppings() {
        FoodItem burger = new Burger();
        burger = new Cheese(burger);
        burger = new Ketchup(burger);
        burger = new Onions(burger);
        assertEquals("Burger, Cheese, Ketchup, Onions", burger.getDescription());
        assertEquals(7.04, burger.getCost(), 0.01);
    }

    @Test
    public void testDoubleCheese() {
        FoodItem burger = new Burger();
        burger = new Cheese(burger);
        burger = new Cheese(burger);
        assertEquals("Burger, Cheese, Cheese", burger.getDescription());
        assertEquals(6.99, burger.getCost(), 0.01);
    }

    @Test
    public void testAllToppingsOnHotDog() {
        FoodItem hotDog = new HotDog();
        hotDog = new Cheese(hotDog);
        hotDog = new Ketchup(hotDog);
        hotDog = new Onions(hotDog);
        assertEquals("Hot Dog, Cheese, Ketchup, Onions", hotDog.getDescription());
        assertEquals(5.04, hotDog.getCost(), 0.01);
    }
}
