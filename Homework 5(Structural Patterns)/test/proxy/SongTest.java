package proxy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SongTest {

    @Test
    public void testSongCreation() {
        Song song = new Song(1, "Test Song", "Test Artist", "Test Album", 200);

        assertEquals(1, song.getId());
        assertEquals("Test Song", song.getTitle());
        assertEquals("Test Artist", song.getArtist());
        assertEquals("Test Album", song.getAlbum());
        assertEquals(200, song.getDuration());
    }

    @Test
    public void testSongToString() {
        Song song = new Song(42, "Imagine", "John Lennon", "Imagine", 183);
        String expected = "Song{id=42, title='Imagine', artist='John Lennon', album='Imagine', duration=183s}";

        assertEquals(expected, song.toString());
    }

    @Test
    public void testSongWithNullId() {
        Song song = new Song(null, "No ID Song", "Unknown", "Unknown Album", 150);

        assertNull(song.getId());
        assertEquals("No ID Song", song.getTitle());
    }

    @Test
    public void testSongGetters() {
        Song song = new Song(99, "Test Title", "Test Artist", "Test Album", 300);

        assertNotNull(song.getId());
        assertNotNull(song.getTitle());
        assertNotNull(song.getArtist());
        assertNotNull(song.getAlbum());
        assertTrue(song.getDuration() > 0);
    }
}
