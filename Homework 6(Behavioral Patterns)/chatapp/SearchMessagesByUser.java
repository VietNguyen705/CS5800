package chatapp;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchMessagesByUser implements Iterator<Message> {
    private final List<Message> messages;
    private final User userToSearch;
    private int currentIndex;

    public SearchMessagesByUser(List<Message> messages, User userToSearch) {
        this.messages = messages;
        this.userToSearch = userToSearch;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < messages.size()) {
            Message message = messages.get(currentIndex);
            if (isMessageRelatedToUser(message)) {
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    @Override
    public Message next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return messages.get(currentIndex++);
    }

    private boolean isMessageRelatedToUser(Message message) {
        // Check if user is the sender
        if (message.getSender().equals(userToSearch)) {
            return true;
        }
        // Check if user is one of the recipients
        for (User recipient : message.getRecipients()) {
            if (recipient.equals(userToSearch)) {
                return true;
            }
        }
        return false;
    }
}
