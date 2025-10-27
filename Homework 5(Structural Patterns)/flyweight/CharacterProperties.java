package flyweight;

public class CharacterProperties {
    private final String font;
    private final String color;
    private final int size;

    public CharacterProperties(String font, String color, int size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }

    public String getFont() {
        return font;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return font + "," + color + "," + size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CharacterProperties that = (CharacterProperties) obj;
        return size == that.size && font.equals(that.font) && color.equals(that.color);
    }

    @Override
    public int hashCode() {
        int result = font.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + size;
        return result;
    }
}
