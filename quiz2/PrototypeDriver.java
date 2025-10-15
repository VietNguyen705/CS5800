import java.util.ArrayList;
import java.util.List;

public class PrototypeDriver {
    public static void main(String[] args) {
        System.out.println("=== Part 2: BookShallowCopy Demo ===\n");

        // Create original book with shallow copy
        List<String> chapters1 = new ArrayList<>();
        chapters1.add("Chapter 1: Introduction");
        chapters1.add("Chapter 2: Getting Started");
        chapters1.add("Chapter 3: Advanced Topics");

        BookShallowCopy originalShallow = new BookShallowCopy(
            "Java Programming",
            "John Doe",
            chapters1
        );

        // Clone the book
        BookShallowCopy clonedShallow = (BookShallowCopy) originalShallow.clone();

        System.out.println("Before modification:");
        System.out.println("Original: " + originalShallow);
        System.out.println("Cloned:   " + clonedShallow);

        // Modify chapters of original book only
        originalShallow.getChapters().add("Chapter 4: Conclusion");
        originalShallow.getChapters().set(0, "Chapter 1: Updated Introduction");

        System.out.println("\nAfter modifying original book's chapters:");
        System.out.println("Original: " + originalShallow);
        System.out.println("Cloned:   " + clonedShallow);
        System.out.println("\nNote: Both books share the same chapters list (shallow copy)\n");

        System.out.println("\n=== Part 3: BookDeepCopy Demo ===\n");

        // Create original book with deep copy
        List<String> chapters2 = new ArrayList<>();
        chapters2.add("Chapter 1: Introduction");
        chapters2.add("Chapter 2: Getting Started");
        chapters2.add("Chapter 3: Advanced Topics");

        BookDeepCopy originalDeep = new BookDeepCopy(
            "Java Programming",
            "John Doe",
            chapters2
        );

        // Clone the book
        BookDeepCopy clonedDeep = (BookDeepCopy) originalDeep.clone();

        System.out.println("Before modification:");
        System.out.println("Original: " + originalDeep);
        System.out.println("Cloned:   " + clonedDeep);

        // Modify chapters of original book only
        originalDeep.getChapters().add("Chapter 4: Conclusion");
        originalDeep.getChapters().set(0, "Chapter 1: Updated Introduction");

        System.out.println("\nAfter modifying original book's chapters:");
        System.out.println("Original: " + originalDeep);
        System.out.println("Cloned:   " + clonedDeep);
        System.out.println("\nNote: Each book has its own independent chapters list (deep copy)\n");
    }
}
