package flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    @Test
    public void testCharacterCreation() {
        CharacterProperties props = new CharacterProperties("Arial", "Red", 12);
        Character ch = new Character('A', props);

        assertEquals('A', ch.getSymbol());
        assertEquals(props, ch.getProperties());
    }

    @Test
    public void testCharacterToString() {
        CharacterProperties props = new CharacterProperties("Calibri", "Blue", 14);
        Character ch = new Character('B', props);

        assertEquals("B[Calibri,Blue,14]", ch.toString());
    }

    @Test
    public void testCharacterToFileFormat() {
        CharacterProperties props = new CharacterProperties("Verdana", "Black", 16);
        Character ch = new Character('C', props);

        assertEquals("C;Verdana,Black,16", ch.toFileFormat());
    }

    @Test
    public void testMultipleCharactersShareProperties() {
        CharacterProperties props = CharacterPropertiesFactory.getProperties("Arial", "Red", 12);
        Character ch1 = new Character('X', props);
        Character ch2 = new Character('Y', props);

        assertSame(ch1.getProperties(), ch2.getProperties(), "Characters should share flyweight properties");
    }
}
