package bridge;

public class EmailChannel implements NotificationChannel {
    @Override
    public void sendNotification(String message) {
        System.out.println("[EMAIL] " + message);
    }
}
