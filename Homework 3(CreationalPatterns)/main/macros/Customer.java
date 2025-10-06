package macros;

import java.util.Objects;

public class Customer {
    private final String name;
    private final DietPlan dietPlan;

    public Customer(String name, DietPlan dietPlan) {
        this.name = Objects.requireNonNull(name, "name");
        this.dietPlan = Objects.requireNonNull(dietPlan, "dietPlan");
    }

    public String getName() {
        return name;
    }

    public DietPlan getDietPlan() {
        return dietPlan;
    }
}
