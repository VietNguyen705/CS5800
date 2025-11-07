package chatapp;

import java.time.LocalDateTime;

public class MessageMemento {
    private final Message message;
    private final LocalDateTime timestamp;

    public MessageMemento(Message message) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public Message getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
