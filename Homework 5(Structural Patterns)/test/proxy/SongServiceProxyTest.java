package proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SongServiceProxyTest {

    private SongServiceProxy proxy;

    @BeforeEach
    public void setUp() {
        proxy = new SongServiceProxy();
    }

    @Test
    public void testSearchByIdFirstCall() {
        Song song = proxy.searchById(1);

        assertNotNull(song);
        assertEquals(1, song.getId());
        assertEquals("Bohemian Rhapsody", song.getTitle());
    }

    @Test
    public void testSearchByIdCachingBehavior() {
        // First call - cache miss
        long startTime1 = System.currentTimeMillis();
        Song song1 = proxy.searchById(2);
        long duration1 = System.currentTimeMillis() - startTime1;

        assertNotNull(song1);
        assertTrue(duration1 >= 900, "First call should take at least 900ms (server delay)");

        // Second call - cache hit
        long startTime2 = System.currentTimeMillis();
        Song song2 = proxy.searchById(2);
        long duration2 = System.currentTimeMillis() - startTime2;

        assertNotNull(song2);
        assertSame(song1, song2, "Should return same cached instance");
        assertTrue(duration2 < 100, "Cached call should take less than 100ms");
    }

    @Test
    public void testSearchByTitleCachingBehavior() {
        // First call - cache miss
        long startTime1 = System.currentTimeMillis();
        List<Song> songs1 = proxy.searchByTitle("Hotel");
        long duration1 = System.currentTimeMillis() - startTime1;

        assertNotNull(songs1);
        assertTrue(duration1 >= 900, "First call should take at least 900ms");

        // Second call - cache hit
        long startTime2 = System.currentTimeMillis();
        List<Song> songs2 = proxy.searchByTitle("Hotel");
        long duration2 = System.currentTimeMillis() - startTime2;

        assertNotNull(songs2);
        assertSame(songs1, songs2, "Should return same cached list");
        assertTrue(duration2 < 100, "Cached call should be fast");
    }

    @Test
    public void testSearchByAlbumCachingBehavior() {
        // First call - cache miss
        long startTime1 = System.currentTimeMillis();
        List<Song> songs1 = proxy.searchByAlbum("Nevermind");
        long duration1 = System.currentTimeMillis() - startTime1;

        assertNotNull(songs1);
        assertTrue(duration1 >= 900, "First call should take at least 900ms");

        // Second call - cache hit
        long startTime2 = System.currentTimeMillis();
        List<Song> songs2 = proxy.searchByAlbum("Nevermind");
        long duration2 = System.currentTimeMillis() - startTime2;

        assertNotNull(songs2);
        assertSame(songs1, songs2, "Should return same cached list");
        assertTrue(duration2 < 100, "Cached call should be fast");
    }

    @Test
    public void testSearchByIdNotFound() {
        Song song = proxy.searchById(999);
        assertNull(song);
    }

    @Test
    public void testSearchByTitleNotFound() {
        List<Song> songs = proxy.searchByTitle("Nonexistent");
        assertNotNull(songs);
        assertEquals(0, songs.size());
    }

    @Test
    public void testSearchByAlbumNotFound() {
        List<Song> songs = proxy.searchByAlbum("Nonexistent Album");
        assertNotNull(songs);
        assertEquals(0, songs.size());
    }

    @Test
    public void testCacheCaseInsensitivity() {
        // Search with lowercase
        List<Song> songs1 = proxy.searchByTitle("imagine");

        // Search with uppercase - should use cache
        long startTime = System.currentTimeMillis();
        List<Song> songs2 = proxy.searchByTitle("IMAGINE");
        long duration = System.currentTimeMillis() - startTime;

        assertSame(songs1, songs2, "Cache should be case-insensitive");
        assertTrue(duration < 100, "Should use cached result");
    }

    @Test
    public void testMultipleDifferentSearches() {
        Song song1 = proxy.searchById(1);
        Song song2 = proxy.searchById(2);
        Song song3 = proxy.searchById(3);

        assertNotNull(song1);
        assertNotNull(song2);
        assertNotNull(song3);

        assertNotEquals(song1.getId(), song2.getId());
        assertNotEquals(song2.getId(), song3.getId());
    }

    @Test
    public void testProxyImplementsSongServiceInterface() {
        assertTrue(proxy instanceof SongService, "Proxy should implement SongService interface");
    }
}
