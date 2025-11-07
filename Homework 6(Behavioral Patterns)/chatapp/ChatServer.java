package chatapp;

import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private final List<User> registeredUsers;

    public ChatServer() {
        this.registeredUsers = new ArrayList<>();
    }

    public void registerUser(User user) {
        if (!registeredUsers.contains(user)) {
            registeredUsers.add(user);
            user.setChatServer(this);
            System.out.println("ChatServer: " + user.getName() + " has been registered");
        }
    }

    public void unregisterUser(User user) {
        if (registeredUsers.remove(user)) {
            user.setChatServer(null);
            System.out.println("ChatServer: " + user.getName() + " has been unregistered");
        }
    }

    public void sendMessage(Message message) {
        User sender = message.getSender();

        // Add message to sender's history
        sender.getChatHistory().addMessage(message);

        // Send message to all recipients
        for (User recipient : message.getRecipients()) {
            if (registeredUsers.contains(recipient)) {
                recipient.receiveMessage(message);
            } else {
                System.out.println("ChatServer: Cannot send message to " +
                                 recipient.getName() + " (not registered)");
            }
        }
    }

    public void undoMessage(Message message) {
        // Remove the message from all recipients' chat histories
        for (User recipient : message.getRecipients()) {
            recipient.getChatHistory().removeLastMessage();
        }
        System.out.println("ChatServer: Message undone for all recipients");
    }

    public List<User> getRegisteredUsers() {
        return new ArrayList<>(registeredUsers);
    }
}
