package flyweight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterPropertiesTest {

    @Test
    public void testCharacterPropertiesCreation() {
        CharacterProperties props = new CharacterProperties("Arial", "Red", 12);
        assertEquals("Arial", props.getFont());
        assertEquals("Red", props.getColor());
        assertEquals(12, props.getSize());
    }

    @Test
    public void testCharacterPropertiesToString() {
        CharacterProperties props = new CharacterProperties("Calibri", "Blue", 14);
        assertEquals("Calibri,Blue,14", props.toString());
    }

    @Test
    public void testCharacterPropertiesEquals() {
        CharacterProperties props1 = new CharacterProperties("Arial", "Red", 12);
        CharacterProperties props2 = new CharacterProperties("Arial", "Red", 12);
        CharacterProperties props3 = new CharacterProperties("Calibri", "Blue", 14);

        assertEquals(props1, props2);
        assertNotEquals(props1, props3);
    }

    @Test
    public void testCharacterPropertiesHashCode() {
        CharacterProperties props1 = new CharacterProperties("Arial", "Red", 12);
        CharacterProperties props2 = new CharacterProperties("Arial", "Red", 12);

        assertEquals(props1.hashCode(), props2.hashCode());
    }
}
