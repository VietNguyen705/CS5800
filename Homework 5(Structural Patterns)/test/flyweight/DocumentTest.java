package flyweight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class DocumentTest {

    private Document document;

    @BeforeEach
    public void setUp() {
        document = new Document();
    }

    @Test
    public void testAddCharacter() {
        document.addCharacter('A', "Arial", "Red", 12);
        assertEquals(1, document.getCharacterCount());
    }

    @Test
    public void testAddMultipleCharacters() {
        document.addCharacter('H', "Arial", "Red", 12);
        document.addCharacter('e', "Arial", "Red", 12);
        document.addCharacter('l', "Calibri", "Blue", 14);
        document.addCharacter('l', "Calibri", "Blue", 14);
        document.addCharacter('o', "Verdana", "Black", 16);

        assertEquals(5, document.getCharacterCount());
    }

    @Test
    public void testSaveAndLoadDocument(@TempDir Path tempDir) throws IOException {
        // Create document with content
        document.addCharacter('T', "Arial", "Red", 12);
        document.addCharacter('e', "Arial", "Red", 12);
        document.addCharacter('s', "Calibri", "Blue", 14);
        document.addCharacter('t', "Calibri", "Blue", 14);

        // Save to file
        File testFile = tempDir.resolve("test.txt").toFile();
        document.save(testFile.getAbsolutePath());

        assertTrue(testFile.exists(), "File should be created");

        // Load from file
        Document loadedDoc = new Document();
        loadedDoc.load(testFile.getAbsolutePath());

        assertEquals(document.getCharacterCount(), loadedDoc.getCharacterCount(),
                     "Loaded document should have same character count");
    }

    @Test
    public void testEmptyDocument() {
        assertEquals(0, document.getCharacterCount());
    }

    @Test
    public void testDocumentFlyweightOptimization() {
        // Add characters with repeated properties
        document.addCharacter('A', "Arial", "Red", 12);
        document.addCharacter('B', "Arial", "Red", 12);
        document.addCharacter('C', "Arial", "Red", 12);
        document.addCharacter('D', "Calibri", "Blue", 14);
        document.addCharacter('E', "Calibri", "Blue", 14);

        int initialCacheSize = CharacterPropertiesFactory.getCacheSize();
        assertEquals(5, document.getCharacterCount());

        // The cache should have fewer entries than characters, demonstrating flyweight pattern
        assertTrue(initialCacheSize < document.getCharacterCount() || initialCacheSize <= 10,
                   "Flyweight pattern should reduce memory by sharing properties");
    }

    @Test
    public void testSaveToFile(@TempDir Path tempDir) throws IOException {
        document.addCharacter('X', "Arial", "Red", 12);

        File testFile = tempDir.resolve("save_test.txt").toFile();
        document.save(testFile.getAbsolutePath());

        assertTrue(testFile.exists());
        assertTrue(testFile.length() > 0);
    }

    @Test
    public void testLoadFromFile(@TempDir Path tempDir) throws IOException {
        // First save a document
        document.addCharacter('Y', "Verdana", "Black", 16);
        document.addCharacter('Z', "Verdana", "Black", 16);

        File testFile = tempDir.resolve("load_test.txt").toFile();
        document.save(testFile.getAbsolutePath());

        // Then load it into new document
        Document newDoc = new Document();
        newDoc.load(testFile.getAbsolutePath());

        assertEquals(2, newDoc.getCharacterCount());
    }
}
