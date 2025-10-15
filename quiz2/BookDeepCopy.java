import java.util.ArrayList;
import java.util.List;

public class BookDeepCopy implements Cloneable {
    private String title;
    private String author;
    private List<String> chapters;

    public BookDeepCopy(String title, String author, List<String> chapters) {
        this.title = title;
        this.author = author;
        this.chapters = chapters;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getChapters() {
        return chapters;
    }

    public void setChapters(List<String> chapters) {
        this.chapters = chapters;
    }

    @Override
    public Object clone() {
        try {
            // Deep copy - clone the object and create a new chapters list
            BookDeepCopy cloned = (BookDeepCopy) super.clone();
            cloned.chapters = new ArrayList<>(this.chapters);
            return cloned;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", chapters=" + chapters +
                '}';
    }
}
