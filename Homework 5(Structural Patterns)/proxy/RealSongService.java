package proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RealSongService implements SongService {
    private Map<Integer, Song> songDatabase;

    public RealSongService() {
        songDatabase = new HashMap<>();
        initializeDatabase();
    }

    private void initializeDatabase() {
        songDatabase.put(1, new Song(1, "Bohemian Rhapsody", "Queen", "A Night at the Opera", 354));
        songDatabase.put(2, new Song(2, "Stairway to Heaven", "Led Zeppelin", "Led Zeppelin IV", 482));
        songDatabase.put(3, new Song(3, "Hotel California", "Eagles", "Hotel California", 391));
        songDatabase.put(4, new Song(4, "Imagine", "John Lennon", "Imagine", 183));
        songDatabase.put(5, new Song(5, "Sweet Child O' Mine", "Guns N' Roses", "Appetite for Destruction", 356));
        songDatabase.put(6, new Song(6, "Billie Jean", "Michael Jackson", "Thriller", 294));
        songDatabase.put(7, new Song(7, "Smells Like Teen Spirit", "Nirvana", "Nevermind", 301));
        songDatabase.put(8, new Song(8, "One", "Metallica", "...And Justice for All", 447));
    }

    @Override
    public Song searchById(Integer songID) {
        // Simulate server delay
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        System.out.println("[RealServer] Searching for song ID: " + songID);
        return songDatabase.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        // Simulate server delay
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        System.out.println("[RealServer] Searching for title: " + title);
        List<Song> results = new ArrayList<>();
        for (Song song : songDatabase.values()) {
            if (song.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(song);
            }
        }
        return results;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        // Simulate server delay
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        System.out.println("[RealServer] Searching for album: " + album);
        List<Song> results = new ArrayList<>();
        for (Song song : songDatabase.values()) {
            if (song.getAlbum().toLowerCase().contains(album.toLowerCase())) {
                results.add(song);
            }
        }
        return results;
    }
}
