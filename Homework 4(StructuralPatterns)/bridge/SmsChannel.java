package bridge;

public class SmsChannel implements NotificationChannel {
    @Override
    public void sendNotification(String message) {
        System.out.println("[SMS] " + message);
    }
}
