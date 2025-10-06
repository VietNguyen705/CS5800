package pizza;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PizzaBuilderTest {

    @Test
    void testPizzaHutBuilder() {
        PizzaBuilder builder = new PizzaHutBuilder();
        Pizza pizza = builder
            .setSize(PizzaSize.LARGE)
            .addTopping(Topping.PEPPERONI)
            .addTopping(Topping.MUSHROOMS)
            .build();

        assertEquals("Pizza Hut", pizza.getChainName());
        assertEquals(PizzaSize.LARGE, pizza.getSize());
        assertEquals(2, pizza.getToppings().size());
        assertTrue(pizza.getToppings().contains(Topping.PEPPERONI));
        assertTrue(pizza.getToppings().contains(Topping.MUSHROOMS));
    }

    @Test
    void testLittleCaesarsBuilder() {
        PizzaBuilder builder = new LittleCaesarsBuilder();
        Pizza pizza = builder
            .setSize(PizzaSize.MEDIUM)
            .addTopping(Topping.SAUSAGE)
            .build();

        assertEquals("Little Caesars", pizza.getChainName());
        assertEquals(PizzaSize.MEDIUM, pizza.getSize());
        assertEquals(1, pizza.getToppings().size());
    }

    @Test
    void testDominosBuilder() {
        PizzaBuilder builder = new DominosBuilder();
        Pizza pizza = builder
            .setSize(PizzaSize.SMALL)
            .addTopping(Topping.BACON)
            .build();

        assertEquals("Dominos", pizza.getChainName());
        assertEquals(PizzaSize.SMALL, pizza.getSize());
    }

    @Test
    void testAddMultipleToppings() {
        PizzaBuilder builder = new PizzaHutBuilder();
        Pizza pizza = builder
            .setSize(PizzaSize.LARGE)
            .addToppings(Topping.PEPPERONI, Topping.SAUSAGE, Topping.MUSHROOMS)
            .build();

        assertEquals(3, pizza.getToppings().size());
        assertTrue(pizza.getToppings().contains(Topping.PEPPERONI));
        assertTrue(pizza.getToppings().contains(Topping.SAUSAGE));
        assertTrue(pizza.getToppings().contains(Topping.MUSHROOMS));
    }

    @Test
    void testPizzaWithNoToppings() {
        PizzaBuilder builder = new PizzaHutBuilder();
        Pizza pizza = builder
            .setSize(PizzaSize.MEDIUM)
            .build();

        assertEquals(0, pizza.getToppings().size());
        assertTrue(pizza.getToppings().isEmpty());
    }

    @Test
    void testAllSizes() {
        PizzaBuilder builder = new PizzaHutBuilder();

        Pizza small = builder.setSize(PizzaSize.SMALL).build();
        assertEquals(PizzaSize.SMALL, small.getSize());

        builder = new PizzaHutBuilder();
        Pizza medium = builder.setSize(PizzaSize.MEDIUM).build();
        assertEquals(PizzaSize.MEDIUM, medium.getSize());

        builder = new PizzaHutBuilder();
        Pizza large = builder.setSize(PizzaSize.LARGE).build();
        assertEquals(PizzaSize.LARGE, large.getSize());
    }

    @Test
    void testBuilderThrowsExceptionWhenSizeNotSet() {
        PizzaBuilder builder = new PizzaHutBuilder();
        builder.addTopping(Topping.PEPPERONI);

        assertThrows(IllegalStateException.class, builder::build);
    }

    @Test
    void testFluentInterface() {
        PizzaBuilder builder = new PizzaHutBuilder();

        assertSame(builder, builder.setSize(PizzaSize.LARGE));
        assertSame(builder, builder.addTopping(Topping.PEPPERONI));
        assertSame(builder, builder.addToppings(Topping.SAUSAGE, Topping.MUSHROOMS));
    }

    @Test
    void testPizzaImmutability() {
        PizzaBuilder builder = new PizzaHutBuilder();
        Pizza pizza = builder
            .setSize(PizzaSize.LARGE)
            .addTopping(Topping.PEPPERONI)
            .build();

        assertThrows(UnsupportedOperationException.class, () -> {
            pizza.getToppings().add(Topping.SAUSAGE);
        });
    }

    @Test
    void testNullSizeThrowsException() {
        PizzaBuilder builder = new PizzaHutBuilder();
        assertThrows(NullPointerException.class, () -> builder.setSize(null));
    }

    @Test
    void testNullToppingThrowsException() {
        PizzaBuilder builder = new PizzaHutBuilder();
        assertThrows(NullPointerException.class, () -> builder.addTopping(null));
    }
}
