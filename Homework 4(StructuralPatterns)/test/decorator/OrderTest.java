package decorator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    private Order order;

    @BeforeEach
    public void setUp() {
        order = new Order();
    }

    @Test
    public void testAddItem() {
        order.addItem(new Burger());
        assertEquals(1, order.getItems().size());
    }

    @Test
    public void testCalculateTotalWithSingleItem() {
        order.addItem(new Burger());
        assertEquals(5.99, order.calculateTotal(), 0.01);
    }

    @Test
    public void testCalculateTotalWithMultipleItems() {
        order.addItem(new Burger());
        order.addItem(new Fries());
        order.addItem(new HotDog());
        assertEquals(12.97, order.calculateTotal(), 0.01);
    }

    @Test
    public void testCalculateTotalWithToppings() {
        FoodItem burger = new Burger();
        burger = new Cheese(burger);
        burger = new Ketchup(burger);
        order.addItem(burger);

        FoodItem fries = new Fries();
        fries = new Cheese(fries);
        order.addItem(fries);

        // Burger (5.99) + Cheese (0.50) + Ketchup (0.25) = 6.74
        // Fries (2.99) + Cheese (0.50) = 3.49
        // Total = 10.23
        assertEquals(10.23, order.calculateTotal(), 0.01);
    }

    @Test
    public void testEmptyOrderTotal() {
        assertEquals(0.0, order.calculateTotal(), 0.01);
    }

    @Test
    public void testGetItems() {
        order.addItem(new Burger());
        order.addItem(new Fries());
        assertNotNull(order.getItems());
        assertEquals(2, order.getItems().size());
    }
}
