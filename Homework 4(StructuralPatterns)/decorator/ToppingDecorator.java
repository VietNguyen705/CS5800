package decorator;

public abstract class ToppingDecorator implements FoodItem {
    protected FoodItem foodItem;

    public ToppingDecorator(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    @Override
    public abstract String getDescription();

    @Override
    public abstract double getCost();
}
