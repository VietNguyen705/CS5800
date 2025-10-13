package bridge;

public class BitcoinPayment extends PaymentNotification {
    public BitcoinPayment(NotificationChannel channel) {
        super(channel);
    }

    @Override
    public void notifyPayment(double amount) {
        String message = String.format("Your Bitcoin payment of $%.2f has been confirmed on the blockchain.", amount);
        channel.sendNotification(message);
    }
}
