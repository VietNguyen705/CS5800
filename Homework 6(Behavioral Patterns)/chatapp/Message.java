package chatapp;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class Message {
    private final User sender;
    private final List<User> recipients;
    private final LocalDateTime timestamp;
    private final String content;

    public Message(User sender, List<User> recipients, String content) {
        this.sender = sender;
        this.recipients = recipients;
        this.timestamp = LocalDateTime.now();
        this.content = content;
    }

    public User getSender() {
        return sender;
    }

    public List<User> getRecipients() {
        return Collections.unmodifiableList(recipients);
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        StringBuilder recipientNames = new StringBuilder();
        for (int i = 0; i < recipients.size(); i++) {
            recipientNames.append(recipients.get(i).getName());
            if (i < recipients.size() - 1) {
                recipientNames.append(", ");
            }
        }
        return String.format("[%s] %s -> %s: %s",
                timestamp.toString().substring(11, 19),
                sender.getName(),
                recipientNames.toString(),
                content);
    }
}
