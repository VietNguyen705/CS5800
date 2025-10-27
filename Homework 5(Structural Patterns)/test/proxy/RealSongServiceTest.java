package proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RealSongServiceTest {

    private RealSongService service;

    @BeforeEach
    public void setUp() {
        service = new RealSongService();
    }

    @Test
    public void testSearchByIdExists() {
        Song song = service.searchById(1);

        assertNotNull(song);
        assertEquals(1, song.getId());
        assertEquals("Bohemian Rhapsody", song.getTitle());
    }

    @Test
    public void testSearchByIdNotExists() {
        Song song = service.searchById(999);

        assertNull(song);
    }

    @Test
    public void testSearchByTitleExists() {
        List<Song> songs = service.searchByTitle("Bohemian");

        assertNotNull(songs);
        assertEquals(1, songs.size());
        assertEquals("Bohemian Rhapsody", songs.get(0).getTitle());
    }

    @Test
    public void testSearchByTitleNotExists() {
        List<Song> songs = service.searchByTitle("Nonexistent Song");

        assertNotNull(songs);
        assertEquals(0, songs.size());
    }

    @Test
    public void testSearchByTitleCaseInsensitive() {
        List<Song> songs = service.searchByTitle("IMAGINE");

        assertNotNull(songs);
        assertEquals(1, songs.size());
        assertEquals("Imagine", songs.get(0).getTitle());
    }

    @Test
    public void testSearchByAlbumExists() {
        List<Song> songs = service.searchByAlbum("Thriller");

        assertNotNull(songs);
        assertEquals(1, songs.size());
        assertEquals("Thriller", songs.get(0).getAlbum());
    }

    @Test
    public void testSearchByAlbumNotExists() {
        List<Song> songs = service.searchByAlbum("Nonexistent Album");

        assertNotNull(songs);
        assertEquals(0, songs.size());
    }

    @Test
    public void testSearchByAlbumCaseInsensitive() {
        List<Song> songs = service.searchByAlbum("thriller");

        assertNotNull(songs);
        assertEquals(1, songs.size());
    }

    @Test
    public void testSearchByTitlePartialMatch() {
        List<Song> songs = service.searchByTitle("Heaven");

        assertNotNull(songs);
        assertTrue(songs.size() > 0);
        assertTrue(songs.get(0).getTitle().contains("Heaven"));
    }

    @Test
    public void testSearchByAlbumPartialMatch() {
        List<Song> songs = service.searchByAlbum("Imagine");

        assertNotNull(songs);
        assertTrue(songs.size() > 0);
    }
}
