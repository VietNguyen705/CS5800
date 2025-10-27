package flyweight;

import java.io.IOException;

public class FlyweightDriver {
    public static void main(String[] args) {
        System.out.println("=== Flyweight Pattern - Text Editor ===\n");

        Document doc = new Document();

        // "HelloWorldCS5800" with at least 4 variations in character properties
        // Variation 1: Arial, Red, 12 - "Hello"
        doc.addCharacter('H', "Arial", "Red", 12);
        doc.addCharacter('e', "Arial", "Red", 12);
        doc.addCharacter('l', "Arial", "Red", 12);
        doc.addCharacter('l', "Arial", "Red", 12);
        doc.addCharacter('o', "Arial", "Red", 12);

        // Variation 2: Calibri, Blue, 14 - "World"
        doc.addCharacter('W', "Calibri", "Blue", 14);
        doc.addCharacter('o', "Calibri", "Blue", 14);
        doc.addCharacter('r', "Calibri", "Blue", 14);
        doc.addCharacter('l', "Calibri", "Blue", 14);
        doc.addCharacter('d', "Calibri", "Blue", 14);

        // Variation 3: Verdana, Black, 16 - "CS"
        doc.addCharacter('C', "Verdana", "Black", 16);
        doc.addCharacter('S', "Verdana", "Black", 16);

        // Variation 4: Arial, Blue, 14 - "5800"
        doc.addCharacter('5', "Arial", "Blue", 14);
        doc.addCharacter('8', "Arial", "Blue", 14);
        doc.addCharacter('0', "Arial", "Blue", 14);
        doc.addCharacter('0', "Arial", "Blue", 14);

        System.out.println("\n--- Document Statistics ---");
        System.out.println("Total characters: " + doc.getCharacterCount());
        System.out.println("Unique character properties (Flyweights): " +
                           CharacterPropertiesFactory.getCacheSize());
        System.out.println("Memory saved: " + (doc.getCharacterCount() -
                           CharacterPropertiesFactory.getCacheSize()) + " property objects");

        // Display document
        doc.display();

        // Save to file
        try {
            String filename = "HelloWorldCS5800.txt";
            doc.save(filename);

            // Demonstrate loading from file
            System.out.println("\n--- Loading Document from File ---");
            Document loadedDoc = new Document();
            loadedDoc.load(filename);
            loadedDoc.display();

            System.out.println("\n--- Loaded Document Statistics ---");
            System.out.println("Total characters: " + loadedDoc.getCharacterCount());
            System.out.println("Unique character properties (Flyweights): " +
                               CharacterPropertiesFactory.getCacheSize());

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
