public class CourseDemo {
    public static void main(String[] args) {
        Course course = new Course("CS 5800 - Advanced OOP");
        Instructor nima = new Instructor("Nima", "Davarpanah", "3-2636");
        Textbook cleanCode = new Textbook("Clean Code", "Robert C. Martin", "Prentice Hall");
        course.addInstructor(nima);
        course.addTextbook(cleanCode);
        course.print();

        System.out.println();

        Instructor alex = new Instructor("Alex", "Nguyen", "4-1201");
        Textbook refactoring = new Textbook("Refactoring", "Martin Fowler", "Addison-Wesley");
        course.addInstructor(alex);
        course.addTextbook(refactoring);
        course.print();
    }
}
