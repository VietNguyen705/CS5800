package pizza;

import java.util.List;

public class PizzaDriver {
    public static void main(String[] args) {
        System.out.println("=== Pizza Builder Pattern Demo ===");
        System.out.println("-- Pizza Hut builder: one pizza per size with 3, 6, and 9 toppings --");

        List<Pizza> pizzaHutShowcase = List.of(
            createPizza(new PizzaHutBuilder(), PizzaSize.SMALL,
                Topping.PEPPERONI, Topping.MUSHROOMS, Topping.ONIONS),
            createPizza(new PizzaHutBuilder(), PizzaSize.MEDIUM,
                Topping.SAUSAGE, Topping.BACON, Topping.EXTRA_CHEESE,
                Topping.PEPPERS, Topping.OLIVES, Topping.SPINACH),
            createPizza(new PizzaHutBuilder(), PizzaSize.LARGE,
                Topping.PEPPERONI, Topping.SAUSAGE, Topping.MUSHROOMS,
                Topping.BACON, Topping.ONIONS, Topping.EXTRA_CHEESE,
                Topping.PEPPERS, Topping.OLIVES, Topping.TOMATO_AND_BASIL)
        );
        pizzaHutShowcase.forEach(Pizza::eat);

        System.out.println();
        System.out.println("-- Multi-chain pizzas after expansion --");
        List<Pizza> chainPizzas = List.of(
            createPizza(new PizzaHutBuilder(), PizzaSize.LARGE,
                Topping.BEEF, Topping.HAM, Topping.PESTO),
            createPizza(new LittleCaesarsBuilder(), PizzaSize.MEDIUM,
                Topping.SPICY_PORK, Topping.SAUSAGE, Topping.BACON,
                Topping.CHICKEN, Topping.EXTRA_CHEESE, Topping.OLIVES,
                Topping.SPINACH, Topping.HAM_AND_PINEAPPLE),
            createPizza(new DominosBuilder(), PizzaSize.SMALL,
                Topping.TOMATO_AND_BASIL),
            createPizza(new PizzaHutBuilder(), PizzaSize.SMALL,
                Topping.SPINACH, Topping.TOMATO_AND_BASIL),
            createPizza(new LittleCaesarsBuilder(), PizzaSize.SMALL,
                Topping.PEPPERONI, Topping.SAUSAGE, Topping.MUSHROOMS,
                Topping.BACON, Topping.ONIONS, Topping.EXTRA_CHEESE),
            createPizza(new DominosBuilder(), PizzaSize.LARGE,
                Topping.CHICKEN, Topping.PEPPERS, Topping.OLIVES)
        );
        chainPizzas.forEach(Pizza::eat);
    }

    private static Pizza createPizza(PizzaBuilder builder, PizzaSize size, Topping... toppings) {
        builder.setSize(size);
        if (toppings != null && toppings.length > 0) {
            builder.addToppings(toppings);
        }
        return builder.build();
    }
}
