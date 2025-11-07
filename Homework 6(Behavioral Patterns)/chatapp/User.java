package chatapp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class User {
    private final String name;
    private final ChatHistory chatHistory;
    private ChatServer chatServer;
    private MessageMemento lastSentMessageMemento;
    private final Set<User> blockedUsers;

    public User(String name) {
        this.name = name;
        this.chatHistory = new ChatHistory();
        this.blockedUsers = new HashSet<>();
    }

    public void setChatServer(ChatServer chatServer) {
        this.chatServer = chatServer;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(List<User> recipients, String content) {
        if (chatServer == null) {
            System.out.println("Error: User not registered with a chat server");
            return;
        }
        Message message = new Message(this, recipients, content);
        chatServer.sendMessage(message);
        // Save memento for undo
        lastSentMessageMemento = new MessageMemento(message);
    }

    public void sendMessage(User recipient, String content) {
        List<User> recipients = new ArrayList<>();
        recipients.add(recipient);
        sendMessage(recipients, content);
    }

    public void receiveMessage(Message message) {
        // Check if sender is blocked
        if (blockedUsers.contains(message.getSender())) {
            System.out.println(name + " has blocked messages from " + message.getSender().getName());
            return;
        }
        chatHistory.addMessage(message);
        System.out.println(name + " received: " + message);
    }

    public void undoLastMessage() {
        if (lastSentMessageMemento == null) {
            System.out.println("No message to undo");
            return;
        }
        Message messageToUndo = lastSentMessageMemento.getMessage();
        chatHistory.removeLastMessage();
        // Notify server to remove from all recipients
        if (chatServer != null) {
            chatServer.undoMessage(messageToUndo);
        }
        System.out.println(name + " undid message: \"" + messageToUndo.getContent() + "\"");
        lastSentMessageMemento = null;
    }

    public void blockUser(User user) {
        blockedUsers.add(user);
        System.out.println(name + " blocked " + user.getName());
    }

    public void unblockUser(User user) {
        blockedUsers.remove(user);
        System.out.println(name + " unblocked " + user.getName());
    }

    public boolean isBlocked(User user) {
        return blockedUsers.contains(user);
    }

    public void printChatHistory() {
        System.out.println("\n" + name + "'s Chat History:");
        System.out.println("=".repeat(50));
        List<Message> messages = chatHistory.getMessages();
        if (messages.isEmpty()) {
            System.out.println("No messages");
        } else {
            for (Message message : messages) {
                System.out.println(message);
            }
        }
        System.out.println("=".repeat(50));
    }

    public Iterator<Message> iterator(User userToSearchWith) {
        return chatHistory.iterator(userToSearchWith);
    }

    public ChatHistory getChatHistory() {
        return chatHistory;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
