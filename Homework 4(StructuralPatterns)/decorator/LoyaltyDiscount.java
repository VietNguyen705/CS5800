package decorator;

public class LoyaltyDiscount {
    private String status;
    private double discountRate;

    public LoyaltyDiscount(String status, double discountRate) {
        this.status = status;
        this.discountRate = discountRate;
    }

    public double applyDiscount(double totalCost) {
        double discount = totalCost * discountRate;
        double finalCost = totalCost - discount;
        System.out.printf("Loyalty Status: %s (%.0f%% discount)%n", status, discountRate * 100);
        System.out.printf("Discount: -$%.2f%n", discount);
        System.out.printf("Final Total: $%.2f%n", finalCost);
        return finalCost;
    }

    public String getStatus() {
        return status;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}
