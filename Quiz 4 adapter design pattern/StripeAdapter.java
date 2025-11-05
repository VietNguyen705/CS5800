public class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;
    private String cardholderName;
    private String cardNumber;
    private String expirationDate;

    public StripeAdapter(String cardholderName, String cardNumber, String expirationDate) {
        this.stripeGateway = new StripeGateway();
        this.cardholderName = cardholderName;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    @Override
    public void processPayment(double amount) {
        stripeGateway.chargeCard(amount, cardholderName, cardNumber, expirationDate);
    }
}
