public class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypalGateway;
    private String userEmail;

    public PayPalAdapter(String userEmail) {
        this.paypalGateway = new PayPalGateway();
        this.userEmail = userEmail;
    }

    @Override
    public void processPayment(double amount) {
        paypalGateway.sendPayment(amount, userEmail);
    }
}
