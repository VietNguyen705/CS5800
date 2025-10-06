package pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class BasePizzaBuilder implements PizzaBuilder {
    private final String chainName;
    private PizzaSize size;
    private final List<Topping> toppings = new ArrayList<>();

    protected BasePizzaBuilder(String chainName) {
        this.chainName = Objects.requireNonNull(chainName, "chainName");
    }

    @Override
    public PizzaBuilder setSize(PizzaSize size) {
        this.size = Objects.requireNonNull(size, "size");
        return this;
    }

    @Override
    public PizzaBuilder addTopping(Topping topping) {
        toppings.add(Objects.requireNonNull(topping, "topping"));
        return this;
    }

    @Override
    public PizzaBuilder addToppings(Topping... toppings) {
        Objects.requireNonNull(toppings, "toppings");
        for (Topping topping : toppings) {
            addTopping(topping);
        }
        return this;
    }

    @Override
    public Pizza build() {
        if (size == null) {
            throw new IllegalStateException("Pizza size must be set before building.");
        }
        return new Pizza(chainName, size, toppings);
    }
}
