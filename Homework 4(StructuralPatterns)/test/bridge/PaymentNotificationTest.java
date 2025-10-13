package bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PaymentNotificationTest {
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
    public void testOnlinePaymentNotificationWithEmail() {
        PaymentNotification payment = new OnlinePaymentNotification(new EmailChannel());
        payment.notifyPayment(100.00);
        String output = outContent.toString();
        assertTrue(output.contains("[EMAIL]"));
        assertTrue(output.contains("online payment"));
        assertTrue(output.contains("$100.00"));
    }

    @Test
    public void testOnlinePaymentNotificationWithSms() {
        PaymentNotification payment = new OnlinePaymentNotification(new SmsChannel());
        payment.notifyPayment(250.50);
        String output = outContent.toString();
        assertTrue(output.contains("[SMS]"));
        assertTrue(output.contains("online payment"));
    }

    @Test
    public void testCashOnDeliveryPaymentWithEmail() {
        PaymentNotification payment = new CashOnDeliveryPayment(new EmailChannel());
        payment.notifyPayment(75.00);
        String output = outContent.toString();
        assertTrue(output.contains("[EMAIL]"));
        assertTrue(output.contains("cash on delivery"));
    }

    @Test
    public void testCashOnDeliveryPaymentWithSms() {
        PaymentNotification payment = new CashOnDeliveryPayment(new SmsChannel());
        payment.notifyPayment(99.99);
        String output = outContent.toString();
        assertTrue(output.contains("[SMS]"));
        assertTrue(output.contains("$99.99"));
    }

    @Test
    public void testBitcoinPaymentWithEmail() {
        PaymentNotification payment = new BitcoinPayment(new EmailChannel());
        payment.notifyPayment(500.00);
        String output = outContent.toString();
        assertTrue(output.contains("[EMAIL]"));
        assertTrue(output.contains("Bitcoin payment"));
    }

    @Test
    public void testBitcoinPaymentWithSms() {
        PaymentNotification payment = new BitcoinPayment(new SmsChannel());
        payment.notifyPayment(1200.00);
        String output = outContent.toString();
        assertTrue(output.contains("[SMS]"));
        assertTrue(output.contains("blockchain"));
    }

    @Test
    public void testOnlinePaymentWithPushChannel() {
        PaymentNotification payment = new OnlinePaymentNotification(new PushChannel());
        payment.notifyPayment(89.99);
        String output = outContent.toString();
        assertTrue(output.contains("[PUSH NOTIFICATION]"));
        assertTrue(output.contains("online payment"));
    }

    @Test
    public void testBitcoinPaymentWithPushChannel() {
        PaymentNotification payment = new BitcoinPayment(new PushChannel());
        payment.notifyPayment(3500.00);
        String output = outContent.toString();
        assertTrue(output.contains("[PUSH NOTIFICATION]"));
        assertTrue(output.contains("Bitcoin"));
    }
}
