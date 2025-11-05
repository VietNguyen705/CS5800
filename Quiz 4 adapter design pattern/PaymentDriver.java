public class PaymentDriver {
    public static void main(String[] args) {
        System.out.println("=== Payment Gateway Adapter Pattern Demo ===\n");

        // Create PayPal adapter
        System.out.println("--- PayPal Payment ---");
        PaymentProcessor paypalProcessor = new PayPalAdapter("customer@email.com");
        paypalProcessor.processPayment(150.00);

        System.out.println("\n--- Stripe Payment ---");
        PaymentProcessor stripeProcessor = new StripeAdapter("John Doe", "4532123456789012", "12/25");
        stripeProcessor.processPayment(200.00);

        System.out.println("\n--- Square Payment ---");
        PaymentProcessor squareProcessor = new SquareAdapter("LOC123456");
        squareProcessor.processPayment(75.50);

        System.out.println("\n=== All payments processed successfully! ===");
    }
}
