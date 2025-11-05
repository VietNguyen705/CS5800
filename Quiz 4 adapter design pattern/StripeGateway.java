public class StripeGateway {
    public void chargeCard(double paymentAmount, String cardholderName, String cardNumber, String expirationDate) {
        System.out.println("Processing Stripe payment: $" + paymentAmount + " for " + cardholderName + " (Card: " + cardNumber + ", Expires: " + expirationDate + ")");
    }
}
