package bridge;

public class PushChannel implements NotificationChannel {
    @Override
    public void sendNotification(String message) {
        System.out.println("[PUSH NOTIFICATION] " + message);
    }
}
