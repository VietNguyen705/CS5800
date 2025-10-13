package decorator;

public class DecoratorDriver {
    public static void main(String[] args) {
        System.out.println("=== Decorator Pattern Demo: Restaurant Order System ===\n");

        // Create order 1: Simple items
        System.out.println("--- Order 1: Basic items with no toppings ---");
        Order order1 = new Order();
        order1.addItem(new Burger());
        order1.addItem(new Fries());
        order1.printOrder();
        System.out.println();

        // Create order 2: Items with toppings
        System.out.println("--- Order 2: Items with toppings ---");
        Order order2 = new Order();

        // Burger with cheese and ketchup
        FoodItem burger = new Burger();
        burger = new Cheese(burger);
        burger = new Ketchup(burger);
        order2.addItem(burger);

        // Hot dog with onions, ketchup, and cheese
        FoodItem hotDog = new HotDog();
        hotDog = new Onions(hotDog);
        hotDog = new Ketchup(hotDog);
        hotDog = new Cheese(hotDog);
        order2.addItem(hotDog);

        // Fries with cheese
        FoodItem fries = new Fries();
        fries = new Cheese(fries);
        order2.addItem(fries);

        order2.printOrder();
        System.out.println();

        // Create order 3: Complex order with loyalty discount
        System.out.println("--- Order 3: Full order with loyalty discount ---");
        Order order3 = new Order();

        // Burger with double cheese and onions
        FoodItem deluxeBurger = new Burger();
        deluxeBurger = new Cheese(deluxeBurger);
        deluxeBurger = new Cheese(deluxeBurger);
        deluxeBurger = new Onions(deluxeBurger);
        order3.addItem(deluxeBurger);

        // Hot dog with all toppings
        FoodItem loadedHotDog = new HotDog();
        loadedHotDog = new Cheese(loadedHotDog);
        loadedHotDog = new Ketchup(loadedHotDog);
        loadedHotDog = new Onions(loadedHotDog);
        order3.addItem(loadedHotDog);

        // Regular fries
        order3.addItem(new Fries());

        order3.printOrder();

        // Apply loyalty discount
        LoyaltyDiscount goldMember = new LoyaltyDiscount("Gold", 0.15);
        goldMember.applyDiscount(order3.calculateTotal());
        System.out.println();

        // Create order 4: Another loyalty example
        System.out.println("--- Order 4: Silver member discount ---");
        Order order4 = new Order();

        FoodItem simpleBurger = new Burger();
        simpleBurger = new Ketchup(simpleBurger);
        order4.addItem(simpleBurger);
        order4.addItem(new Fries());
        order4.addItem(new HotDog());

        order4.printOrder();

        LoyaltyDiscount silverMember = new LoyaltyDiscount("Silver", 0.10);
        silverMember.applyDiscount(order4.calculateTotal());

        System.out.println("\n=== Demonstration Complete ===");
    }
}
