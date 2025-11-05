public class PayPalGateway {
    public void sendPayment(double paymentAmount, String userEmail) {
        System.out.println("Processing PayPal payment: $" + paymentAmount + " to " + userEmail);
    }
}
