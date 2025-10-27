package proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServiceProxy implements SongService {
    private RealSongService realService;
    private Map<Integer, Song> idCache;
    private Map<String, List<Song>> titleCache;
    private Map<String, List<Song>> albumCache;

    public SongServiceProxy() {
        this.realService = new RealSongService();
        this.idCache = new HashMap<>();
        this.titleCache = new HashMap<>();
        this.albumCache = new HashMap<>();
    }

    @Override
    public Song searchById(Integer songID) {
        if (idCache.containsKey(songID)) {
            System.out.println("[Proxy] Cache hit for ID: " + songID);
            return idCache.get(songID);
        }

        System.out.println("[Proxy] Cache miss for ID: " + songID);
        Song song = realService.searchById(songID);
        if (song != null) {
            idCache.put(songID, song);
        }
        return song;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        String key = title.toLowerCase();
        if (titleCache.containsKey(key)) {
            System.out.println("[Proxy] Cache hit for title: " + title);
            return titleCache.get(key);
        }

        System.out.println("[Proxy] Cache miss for title: " + title);
        List<Song> songs = realService.searchByTitle(title);
        titleCache.put(key, songs);
        return songs;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        String key = album.toLowerCase();
        if (albumCache.containsKey(key)) {
            System.out.println("[Proxy] Cache hit for album: " + album);
            return albumCache.get(key);
        }

        System.out.println("[Proxy] Cache miss for album: " + album);
        List<Song> songs = realService.searchByAlbum(album);
        albumCache.put(key, songs);
        return songs;
    }
}
