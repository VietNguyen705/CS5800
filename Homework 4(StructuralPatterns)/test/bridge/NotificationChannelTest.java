package bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class NotificationChannelTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testEmailChannelSendNotification() {
        NotificationChannel email = new EmailChannel();
        email.sendNotification("Test message");
        assertTrue(outContent.toString().contains("[EMAIL] Test message"));
    }

    @Test
    public void testSmsChannelSendNotification() {
        NotificationChannel sms = new SmsChannel();
        sms.sendNotification("Test SMS");
        assertTrue(outContent.toString().contains("[SMS] Test SMS"));
    }

    @Test
    public void testPushChannelSendNotification() {
        NotificationChannel push = new PushChannel();
        push.sendNotification("Test push");
        assertTrue(outContent.toString().contains("[PUSH NOTIFICATION] Test push"));
    }
}
