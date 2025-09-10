import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private final List<Instructor> instructors = new ArrayList<>();
    private final List<Textbook> textbooks = new ArrayList<>();

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public void addInstructor(Instructor instructor) { instructors.add(instructor); }
    public void addTextbook(Textbook textbook) { textbooks.add(textbook); }

    public void print() {
        System.out.println("Course: " + courseName);
        if (!instructors.isEmpty()) {
            System.out.print("Instructors: ");
            for (int i = 0; i < instructors.size(); i++) {
                Instructor inst = instructors.get(i);
                System.out.print(inst.getFirstName() + " " + inst.getLastName());
                if (i < instructors.size() - 1) System.out.print(", ");
            }
            System.out.println();
        }
        if (!textbooks.isEmpty()) {
            System.out.print("Textbooks: ");
            for (int i = 0; i < textbooks.size(); i++) {
                Textbook t = textbooks.get(i);
                System.out.print(t.getTitle() + " by " + t.getAuthor());
                if (i < textbooks.size() - 1) System.out.print(", ");
            }
            System.out.println();
        }
    }
}
