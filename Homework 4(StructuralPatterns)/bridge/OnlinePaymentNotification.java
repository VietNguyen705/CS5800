package bridge;

public class OnlinePaymentNotification extends PaymentNotification {
    public OnlinePaymentNotification(NotificationChannel channel) {
        super(channel);
    }

    @Override
    public void notifyPayment(double amount) {
        String message = String.format("Your online payment of $%.2f has been processed successfully.", amount);
        channel.sendNotification(message);
    }
}
