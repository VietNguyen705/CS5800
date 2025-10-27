package flyweight;

public class Character {
    private final char symbol;
    private final CharacterProperties properties;

    public Character(char symbol, CharacterProperties properties) {
        this.symbol = symbol;
        this.properties = properties;
    }

    public char getSymbol() {
        return symbol;
    }

    public CharacterProperties getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return symbol + "[" + properties + "]";
    }

    public String toFileFormat() {
        return symbol + ";" + properties.toString();
    }
}
