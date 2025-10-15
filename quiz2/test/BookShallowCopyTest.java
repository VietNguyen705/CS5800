import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class BookShallowCopyTest {
    private BookShallowCopy book;
    private List<String> chapters;

    @BeforeEach
    public void setUp() {
        chapters = new ArrayList<>();
        chapters.add("Chapter 1");
        chapters.add("Chapter 2");
        chapters.add("Chapter 3");
        book = new BookShallowCopy("Test Book", "Test Author", chapters);
    }

    @Test
    public void testGetTitle() {
        assertEquals("Test Book", book.getTitle());
    }

    @Test
    public void testSetTitle() {
        book.setTitle("New Title");
        assertEquals("New Title", book.getTitle());
    }

    @Test
    public void testGetAuthor() {
        assertEquals("Test Author", book.getAuthor());
    }

    @Test
    public void testSetAuthor() {
        book.setAuthor("New Author");
        assertEquals("New Author", book.getAuthor());
    }

    @Test
    public void testGetChapters() {
        assertEquals(3, book.getChapters().size());
        assertEquals("Chapter 1", book.getChapters().get(0));
    }

    @Test
    public void testSetChapters() {
        List<String> newChapters = new ArrayList<>();
        newChapters.add("New Chapter");
        book.setChapters(newChapters);
        assertEquals(1, book.getChapters().size());
    }

    @Test
    public void testCloneNotNull() {
        BookShallowCopy cloned = (BookShallowCopy) book.clone();
        assertNotNull(cloned);
    }

    @Test
    public void testCloneCreatesDifferentObject() {
        BookShallowCopy cloned = (BookShallowCopy) book.clone();
        assertNotSame(book, cloned);
    }

    @Test
    public void testCloneCopiesTitle() {
        BookShallowCopy cloned = (BookShallowCopy) book.clone();
        assertEquals(book.getTitle(), cloned.getTitle());
    }

    @Test
    public void testCloneCopiesAuthor() {
        BookShallowCopy cloned = (BookShallowCopy) book.clone();
        assertEquals(book.getAuthor(), cloned.getAuthor());
    }

    @Test
    public void testShallowCopySharesChaptersList() {
        BookShallowCopy cloned = (BookShallowCopy) book.clone();
        assertSame(book.getChapters(), cloned.getChapters());
    }

    @Test
    public void testShallowCopyModificationAffectsBoth() {
        BookShallowCopy cloned = (BookShallowCopy) book.clone();
        book.getChapters().add("Chapter 4");
        assertEquals(4, cloned.getChapters().size());
        assertEquals("Chapter 4", cloned.getChapters().get(3));
    }

    @Test
    public void testToString() {
        String result = book.toString();
        assertTrue(result.contains("Test Book"));
        assertTrue(result.contains("Test Author"));
        assertTrue(result.contains("Chapter 1"));
    }
}
