package chatapp;

import java.util.Arrays;
import java.util.Iterator;

public class ChatDriver {
    public static void main(String[] args) {
        System.out.println("=".repeat(70));
        System.out.println("         BEHAVIORAL PATTERNS: Chat Application Demo");
        System.out.println("         (Mediator + Memento + Iterator Patterns)");
        System.out.println("=".repeat(70));

        // Create ChatServer (Mediator)
        ChatServer server = new ChatServer();

        // Create 3 users
        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");

        // Register users with server
        System.out.println("\n--- REGISTERING USERS ---");
        server.registerUser(alice);
        server.registerUser(bob);
        server.registerUser(charlie);

        // Demonstrate sending messages (Mediator Pattern)
        System.out.println("\n--- SENDING MESSAGES (MEDIATOR PATTERN) ---");
        alice.sendMessage(bob, "Hi Bob, how are you?");
        bob.sendMessage(alice, "I'm good Alice, thanks!");
        charlie.sendMessage(alice, "Hey Alice, want to grab lunch?");
        alice.sendMessage(Arrays.asList(bob, charlie), "Let's all meet up later!");

        // Print chat histories
        alice.printChatHistory();
        bob.printChatHistory();
        charlie.printChatHistory();

        // Demonstrate Undo functionality (Memento Pattern)
        System.out.println("\n--- UNDO LAST MESSAGE (MEMENTO PATTERN) ---");
        System.out.println("Alice is undoing her last message...");
        alice.undoLastMessage();

        alice.printChatHistory();
        bob.printChatHistory();
        charlie.printChatHistory();

        // Send more messages
        System.out.println("\n--- SENDING MORE MESSAGES ---");
        bob.sendMessage(charlie, "Charlie, did you finish the homework?");
        charlie.sendMessage(bob, "Yes, just submitted it!");
        alice.sendMessage(bob, "Bob, can you help me with the assignment?");

        // Demonstrate blocking functionality (Mediator Pattern)
        System.out.println("\n--- BLOCKING USERS (MEDIATOR PATTERN) ---");
        bob.blockUser(charlie);
        System.out.println("\nCharlie tries to send message to Bob (should be blocked):");
        charlie.sendMessage(bob, "Bob, are you there?");

        bob.printChatHistory();

        // Demonstrate Iterator Pattern
        System.out.println("\n--- ITERATOR PATTERN: Filtering Messages by User ---");
        System.out.println("\nAlice's messages involving Bob:");
        System.out.println("-".repeat(50));
        Iterator<Message> aliceIterator = alice.iterator(bob);
        while (aliceIterator.hasNext()) {
            Message message = aliceIterator.next();
            System.out.println(message);
        }

        System.out.println("\nBob's messages involving Alice:");
        System.out.println("-".repeat(50));
        Iterator<Message> bobIterator = bob.iterator(alice);
        while (bobIterator.hasNext()) {
            Message message = bobIterator.next();
            System.out.println(message);
        }

        System.out.println("\nCharlie's messages involving Bob:");
        System.out.println("-".repeat(50));
        Iterator<Message> charlieIterator = charlie.iterator(bob);
        while (charlieIterator.hasNext()) {
            Message message = charlieIterator.next();
            System.out.println(message);
        }

        // Unblock and send another message
        System.out.println("\n--- UNBLOCKING USER ---");
        bob.unblockUser(charlie);
        System.out.println("\nCharlie tries to send message to Bob again:");
        charlie.sendMessage(bob, "Bob, got my message now?");

        bob.printChatHistory();

        System.out.println("\n" + "=".repeat(70));
        System.out.println("                      Demo Complete!");
        System.out.println("=".repeat(70));
    }
}
