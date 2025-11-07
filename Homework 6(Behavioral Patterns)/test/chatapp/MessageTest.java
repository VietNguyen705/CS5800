package chatapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class MessageTest {
    private User alice;
    private User bob;
    private User charlie;

    @BeforeEach
    public void setUp() {
        alice = new User("Alice");
        bob = new User("Bob");
        charlie = new User("Charlie");
    }

    @Test
    public void testMessageCreation() {
        List<User> recipients = Arrays.asList(bob);
        Message message = new Message(alice, recipients, "Hello Bob!");

        assertEquals(alice, message.getSender());
        assertEquals(1, message.getRecipients().size());
        assertEquals(bob, message.getRecipients().get(0));
        assertEquals("Hello Bob!", message.getContent());
        assertNotNull(message.getTimestamp());
    }

    @Test
    public void testMessageWithMultipleRecipients() {
        List<User> recipients = Arrays.asList(bob, charlie);
        Message message = new Message(alice, recipients, "Hello everyone!");

        assertEquals(alice, message.getSender());
        assertEquals(2, message.getRecipients().size());
        assertTrue(message.getRecipients().contains(bob));
        assertTrue(message.getRecipients().contains(charlie));
    }

    @Test
    public void testMessageToString() {
        List<User> recipients = Arrays.asList(bob);
        Message message = new Message(alice, recipients, "Test message");

        String messageString = message.toString();
        assertTrue(messageString.contains("Alice"));
        assertTrue(messageString.contains("Bob"));
        assertTrue(messageString.contains("Test message"));
    }
}
