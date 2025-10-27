package flyweight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Document {
    private List<Character> characters;

    public Document() {
        this.characters = new ArrayList<>();
    }

    public void addCharacter(char symbol, String font, String color, int size) {
        CharacterProperties properties = CharacterPropertiesFactory.getProperties(font, color, size);
        characters.add(new Character(symbol, properties));
    }

    public void save(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Character ch : characters) {
                writer.write(ch.toFileFormat());
                writer.newLine();
            }
        }
        System.out.println("Document saved to " + filename);
    }

    public void load(String filename) throws IOException {
        characters.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    char symbol = parts[0].charAt(0);
                    String[] props = parts[1].split(",");
                    if (props.length == 3) {
                        String font = props[0];
                        String color = props[1];
                        int size = Integer.parseInt(props[2]);
                        addCharacter(symbol, font, color, size);
                    }
                }
            }
        }
        System.out.println("Document loaded from " + filename);
    }

    public void display() {
        System.out.println("\nDocument Content:");
        for (Character ch : characters) {
            System.out.print(ch.getSymbol());
        }
        System.out.println("\n\nDetailed View:");
        for (Character ch : characters) {
            System.out.println(ch);
        }
    }

    public int getCharacterCount() {
        return characters.size();
    }
}
