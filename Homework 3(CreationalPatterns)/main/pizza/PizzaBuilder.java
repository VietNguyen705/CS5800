package pizza;

public interface PizzaBuilder {
    PizzaBuilder setSize(PizzaSize size);

    PizzaBuilder addTopping(Topping topping);

    PizzaBuilder addToppings(Topping... toppings);

    Pizza build();
}
