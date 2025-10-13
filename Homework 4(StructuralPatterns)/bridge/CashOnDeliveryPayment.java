package bridge;

public class CashOnDeliveryPayment extends PaymentNotification {
    public CashOnDeliveryPayment(NotificationChannel channel) {
        super(channel);
    }

    @Override
    public void notifyPayment(double amount) {
        String message = String.format("Your order has been confirmed. Please prepare $%.2f cash on delivery.", amount);
        channel.sendNotification(message);
    }
}
