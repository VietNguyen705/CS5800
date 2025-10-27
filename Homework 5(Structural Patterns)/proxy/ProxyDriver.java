package proxy;

import java.util.List;

public class ProxyDriver {
    public static void main(String[] args) {
        System.out.println("=== Proxy Pattern - Music Streaming Service ===\n");

        SongService songService = new SongServiceProxy();

        // Test 1: Search by ID
        System.out.println("--- Test 1: Search by ID ---");
        long startTime = System.currentTimeMillis();
        Song song = songService.searchById(1);
        long endTime = System.currentTimeMillis();
        System.out.println("Result: " + song);
        System.out.println("Time: " + (endTime - startTime) + "ms\n");

        // Test 2: Search same ID again (should be cached)
        System.out.println("--- Test 2: Search same ID again (cached) ---");
        startTime = System.currentTimeMillis();
        song = songService.searchById(1);
        endTime = System.currentTimeMillis();
        System.out.println("Result: " + song);
        System.out.println("Time: " + (endTime - startTime) + "ms\n");

        // Test 3: Search by Title
        System.out.println("--- Test 3: Search by Title ---");
        startTime = System.currentTimeMillis();
        List<Song> songs = songService.searchByTitle("Bohemian");
        endTime = System.currentTimeMillis();
        System.out.println("Results:");
        for (Song s : songs) {
            System.out.println("  " + s);
        }
        System.out.println("Time: " + (endTime - startTime) + "ms\n");

        // Test 4: Search same title again (should be cached)
        System.out.println("--- Test 4: Search same title again (cached) ---");
        startTime = System.currentTimeMillis();
        songs = songService.searchByTitle("Bohemian");
        endTime = System.currentTimeMillis();
        System.out.println("Results:");
        for (Song s : songs) {
            System.out.println("  " + s);
        }
        System.out.println("Time: " + (endTime - startTime) + "ms\n");

        // Test 5: Search by Album
        System.out.println("--- Test 5: Search by Album ---");
        startTime = System.currentTimeMillis();
        songs = songService.searchByAlbum("Thriller");
        endTime = System.currentTimeMillis();
        System.out.println("Results:");
        for (Song s : songs) {
            System.out.println("  " + s);
        }
        System.out.println("Time: " + (endTime - startTime) + "ms\n");

        // Test 6: Search same album again (should be cached)
        System.out.println("--- Test 6: Search same album again (cached) ---");
        startTime = System.currentTimeMillis();
        songs = songService.searchByAlbum("Thriller");
        endTime = System.currentTimeMillis();
        System.out.println("Results:");
        for (Song s : songs) {
            System.out.println("  " + s);
        }
        System.out.println("Time: " + (endTime - startTime) + "ms\n");

        // Test 7: Multiple ID searches
        System.out.println("--- Test 7: Multiple ID searches ---");
        for (int id = 2; id <= 5; id++) {
            startTime = System.currentTimeMillis();
            song = songService.searchById(id);
            endTime = System.currentTimeMillis();
            System.out.println("[" + (endTime - startTime) + "ms] " + song);
        }
        System.out.println();

        // Test 8: Repeat ID searches (all should be cached)
        System.out.println("--- Test 8: Repeat ID searches (all cached) ---");
        for (int id = 2; id <= 5; id++) {
            startTime = System.currentTimeMillis();
            song = songService.searchById(id);
            endTime = System.currentTimeMillis();
            System.out.println("[" + (endTime - startTime) + "ms] " + song);
        }

        System.out.println("\n=== Proxy Pattern Demonstration Complete ===");
        System.out.println("Notice: First requests take ~1000ms (server delay)");
        System.out.println("        Cached requests take <10ms (instant retrieval)");
    }
}
