package pizza;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Pizza {
    private final String chainName;
    private final PizzaSize size;
    private final List<Topping> toppings;

    Pizza(String chainName, PizzaSize size, List<Topping> toppings) {
        this.chainName = chainName;
        this.size = size;
        this.toppings = List.copyOf(toppings);
    }

    public String getChainName() {
        return chainName;
    }

    public PizzaSize getSize() {
        return size;
    }

    public List<Topping> getToppings() {
        return Collections.unmodifiableList(toppings);
    }

    public void eat() {
        String toppingsDescription = toppings.isEmpty()
            ? "No Toppings"
            : toppings.stream()
                .map(Topping::getDisplayName)
                .collect(Collectors.joining(", "));
        System.out.printf("%s %s pizza with toppings: %s%n",
            chainName,
            size.getDisplayName(),
            toppingsDescription);
    }
}
