package chatapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

public class UserTest {
    private ChatServer server;
    private User alice;
    private User bob;
    private User charlie;

    @BeforeEach
    public void setUp() {
        server = new ChatServer();
        alice = new User("Alice");
        bob = new User("Bob");
        charlie = new User("Charlie");
        server.registerUser(alice);
        server.registerUser(bob);
        server.registerUser(charlie);
    }

    @Test
    public void testUserCreation() {
        assertEquals("Alice", alice.getName());
        assertNotNull(alice.getChatHistory());
    }

    @Test
    public void testSendMessage() {
        alice.sendMessage(bob, "Hello Bob!");
        assertEquals(1, alice.getChatHistory().getMessages().size());
        assertEquals(1, bob.getChatHistory().getMessages().size());
    }

    @Test
    public void testReceiveMessage() {
        alice.sendMessage(bob, "Test message");
        Message received = bob.getChatHistory().getMessages().get(0);
        assertEquals("Test message", received.getContent());
        assertEquals(alice, received.getSender());
    }

    @Test
    public void testUndoMessage() {
        alice.sendMessage(bob, "Message to undo");
        alice.undoLastMessage();

        assertEquals(0, alice.getChatHistory().getMessages().size());
        assertEquals(0, bob.getChatHistory().getMessages().size());
    }

    @Test
    public void testBlockUser() {
        bob.blockUser(charlie);
        assertTrue(bob.isBlocked(charlie));

        charlie.sendMessage(bob, "This should be blocked");
        assertEquals(0, bob.getChatHistory().getMessages().size());
    }

    @Test
    public void testUnblockUser() {
        bob.blockUser(charlie);
        bob.unblockUser(charlie);
        assertFalse(bob.isBlocked(charlie));

        charlie.sendMessage(bob, "This should go through");
        assertEquals(1, bob.getChatHistory().getMessages().size());
    }

    @Test
    public void testIteratorByUser() {
        alice.sendMessage(bob, "Message 1");
        charlie.sendMessage(bob, "Message 2");
        alice.sendMessage(bob, "Message 3");

        Iterator<Message> iterator = bob.iterator(alice);
        int count = 0;
        while (iterator.hasNext()) {
            Message msg = iterator.next();
            assertEquals(alice, msg.getSender());
            count++;
        }
        assertEquals(2, count);
    }
}
