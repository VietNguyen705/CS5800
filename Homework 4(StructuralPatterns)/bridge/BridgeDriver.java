package bridge;

public class BridgeDriver {
    public static void main(String[] args) {
        System.out.println("=== Bridge Pattern Demo: Payment Notification System ===\n");

        // Part 1: Original scenarios
        System.out.println("--- Part 1: Online and Cash payments with Email/SMS ---");

        PaymentNotification onlineEmail = new OnlinePaymentNotification(new EmailChannel());
        onlineEmail.notifyPayment(150.00);

        PaymentNotification onlineSms = new OnlinePaymentNotification(new SmsChannel());
        onlineSms.notifyPayment(250.50);

        PaymentNotification cashEmail = new CashOnDeliveryPayment(new EmailChannel());
        cashEmail.notifyPayment(75.00);

        PaymentNotification cashSms = new CashOnDeliveryPayment(new SmsChannel());
        cashSms.notifyPayment(99.99);

        // Part 2: Bitcoin payment scenarios
        System.out.println("\n--- Part 2: Bitcoin payments with Email/SMS ---");

        PaymentNotification bitcoinEmail = new BitcoinPayment(new EmailChannel());
        bitcoinEmail.notifyPayment(500.00);

        PaymentNotification bitcoinSms = new BitcoinPayment(new SmsChannel());
        bitcoinSms.notifyPayment(1200.00);

        // Part 3: Push notification scenarios
        System.out.println("\n--- Part 3: Payments with Push notifications ---");

        PaymentNotification onlinePush = new OnlinePaymentNotification(new PushChannel());
        onlinePush.notifyPayment(89.99);

        PaymentNotification bitcoinPush = new BitcoinPayment(new PushChannel());
        bitcoinPush.notifyPayment(3500.00);

        System.out.println("\n=== Demonstration Complete ===");
    }
}
