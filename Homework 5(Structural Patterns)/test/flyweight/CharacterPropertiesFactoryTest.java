package flyweight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterPropertiesFactoryTest {

    @BeforeEach
    public void setUp() {
        CharacterPropertiesFactory.clearCache();
    }

    @Test
    public void testFactoryReturnsSameInstance() {
        CharacterProperties props1 = CharacterPropertiesFactory.getProperties("Arial", "Red", 12);
        CharacterProperties props2 = CharacterPropertiesFactory.getProperties("Arial", "Red", 12);

        assertSame(props1, props2, "Factory should return same instance for identical properties");
    }

    @Test
    public void testFactoryReturnsDifferentInstances() {
        CharacterProperties props1 = CharacterPropertiesFactory.getProperties("Arial", "Red", 12);
        CharacterProperties props2 = CharacterPropertiesFactory.getProperties("Calibri", "Blue", 14);

        assertNotSame(props1, props2, "Factory should return different instances for different properties");
    }

    @Test
    public void testFactoryCacheSize() {
        int initialSize = CharacterPropertiesFactory.getCacheSize();

        CharacterPropertiesFactory.getProperties("Verdana", "Black", 16);
        int sizeAfterOne = CharacterPropertiesFactory.getCacheSize();

        assertTrue(sizeAfterOne >= initialSize + 1, "Cache size should increase after new property");

        // Request same properties again
        CharacterPropertiesFactory.getProperties("Verdana", "Black", 16);
        int sizeAfterDuplicate = CharacterPropertiesFactory.getCacheSize();

        assertEquals(sizeAfterOne, sizeAfterDuplicate, "Cache size should not increase for duplicate properties");
    }

    @Test
    public void testFactoryWithMultipleProperties() {
        CharacterProperties props1 = CharacterPropertiesFactory.getProperties("Arial", "Red", 12);
        CharacterProperties props2 = CharacterPropertiesFactory.getProperties("Calibri", "Blue", 14);
        CharacterProperties props3 = CharacterPropertiesFactory.getProperties("Arial", "Red", 12);
        CharacterProperties props4 = CharacterPropertiesFactory.getProperties("Verdana", "Green", 16);

        assertSame(props1, props3, "Should reuse cached instance");
        assertNotSame(props1, props2, "Different properties should have different instances");
        assertNotSame(props2, props4, "Different properties should have different instances");
    }
}
