package flyweight;

import java.util.HashMap;
import java.util.Map;

public class CharacterPropertiesFactory {
    private static final Map<String, CharacterProperties> propertiesCache = new HashMap<>();

    public static CharacterProperties getProperties(String font, String color, int size) {
        String key = font + ":" + color + ":" + size;

        if (!propertiesCache.containsKey(key)) {
            propertiesCache.put(key, new CharacterProperties(font, color, size));
            System.out.println("Creating new CharacterProperties: " + key);
        }

        return propertiesCache.get(key);
    }

    public static int getCacheSize() {
        return propertiesCache.size();
    }

    public static void clearCache() {
        propertiesCache.clear();
    }
}
