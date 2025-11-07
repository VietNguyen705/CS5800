package chatapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ChatHistoryTest {
    private ChatHistory chatHistory;
    private User alice;
    private User bob;
    private User charlie;

    @BeforeEach
    public void setUp() {
        chatHistory = new ChatHistory();
        alice = new User("Alice");
        bob = new User("Bob");
        charlie = new User("Charlie");
    }

    @Test
    public void testAddMessage() {
        List<User> recipients = Arrays.asList(bob);
        Message message = new Message(alice, recipients, "Test message");
        chatHistory.addMessage(message);

        assertEquals(1, chatHistory.getMessages().size());
        assertEquals(message, chatHistory.getMessages().get(0));
    }

    @Test
    public void testGetLastMessage() {
        List<User> recipients = Arrays.asList(bob);
        Message message1 = new Message(alice, recipients, "First message");
        Message message2 = new Message(bob, Arrays.asList(alice), "Second message");

        chatHistory.addMessage(message1);
        chatHistory.addMessage(message2);

        assertEquals(message2, chatHistory.getLastMessage());
    }

    @Test
    public void testGetLastMessageEmpty() {
        assertNull(chatHistory.getLastMessage());
    }

    @Test
    public void testRemoveLastMessage() {
        List<User> recipients = Arrays.asList(bob);
        Message message1 = new Message(alice, recipients, "First");
        Message message2 = new Message(alice, recipients, "Second");

        chatHistory.addMessage(message1);
        chatHistory.addMessage(message2);
        chatHistory.removeLastMessage();

        assertEquals(1, chatHistory.getMessages().size());
        assertEquals(message1, chatHistory.getLastMessage());
    }

    @Test
    public void testIteratorByUser() {
        Message msg1 = new Message(alice, Arrays.asList(bob), "Alice to Bob 1");
        Message msg2 = new Message(charlie, Arrays.asList(bob), "Charlie to Bob");
        Message msg3 = new Message(alice, Arrays.asList(bob), "Alice to Bob 2");

        chatHistory.addMessage(msg1);
        chatHistory.addMessage(msg2);
        chatHistory.addMessage(msg3);

        Iterator<Message> iterator = chatHistory.iterator(alice);
        int count = 0;
        while (iterator.hasNext()) {
            Message msg = iterator.next();
            assertTrue(msg.getSender().equals(alice) || msg.getRecipients().contains(alice));
            count++;
        }
        assertEquals(2, count);
    }
}
