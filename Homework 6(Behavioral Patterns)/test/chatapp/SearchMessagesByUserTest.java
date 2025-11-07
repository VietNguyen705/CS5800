package chatapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchMessagesByUserTest {
    private User alice;
    private User bob;
    private User charlie;
    private List<Message> messages;

    @BeforeEach
    public void setUp() {
        alice = new User("Alice");
        bob = new User("Bob");
        charlie = new User("Charlie");
        messages = new ArrayList<>();
    }

    @Test
    public void testIteratorFiltersBySender() {
        Message msg1 = new Message(alice, Arrays.asList(bob), "Alice to Bob");
        Message msg2 = new Message(charlie, Arrays.asList(bob), "Charlie to Bob");
        Message msg3 = new Message(alice, Arrays.asList(charlie), "Alice to Charlie");

        messages.add(msg1);
        messages.add(msg2);
        messages.add(msg3);

        Iterator<Message> iterator = new SearchMessagesByUser(messages, alice);
        int count = 0;
        while (iterator.hasNext()) {
            Message msg = iterator.next();
            assertEquals(alice, msg.getSender());
            count++;
        }
        assertEquals(2, count);
    }

    @Test
    public void testIteratorFiltersByRecipient() {
        Message msg1 = new Message(alice, Arrays.asList(bob), "Alice to Bob");
        Message msg2 = new Message(charlie, Arrays.asList(alice), "Charlie to Alice");
        Message msg3 = new Message(bob, Arrays.asList(charlie), "Bob to Charlie");

        messages.add(msg1);
        messages.add(msg2);
        messages.add(msg3);

        Iterator<Message> iterator = new SearchMessagesByUser(messages, alice);
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        assertEquals(2, count); // Alice as sender and recipient
    }

    @Test
    public void testIteratorNoMatches() {
        Message msg1 = new Message(alice, Arrays.asList(bob), "Alice to Bob");
        Message msg2 = new Message(bob, Arrays.asList(alice), "Bob to Alice");

        messages.add(msg1);
        messages.add(msg2);

        Iterator<Message> iterator = new SearchMessagesByUser(messages, charlie);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testIteratorThrowsExceptionWhenEmpty() {
        Iterator<Message> iterator = new SearchMessagesByUser(messages, alice);
        assertThrows(NoSuchElementException.class, () -> iterator.next());
    }

    @Test
    public void testMultipleRecipients() {
        Message msg1 = new Message(alice, Arrays.asList(bob, charlie), "Alice to Bob and Charlie");
        Message msg2 = new Message(bob, Arrays.asList(alice), "Bob to Alice");

        messages.add(msg1);
        messages.add(msg2);

        Iterator<Message> iterator = new SearchMessagesByUser(messages, charlie);
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        assertEquals(1, count); // Charlie is recipient in msg1
    }
}
