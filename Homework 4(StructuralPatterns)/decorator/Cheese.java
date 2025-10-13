package decorator;

public class Cheese extends ToppingDecorator {
    public Cheese(FoodItem foodItem) {
        super(foodItem);
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return foodItem.getCost() + 0.50;
    }
}
