public class FSFile {
    private String name;

    public FSFile(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public void print(String indent) {
        System.out.println(indent + "- " + name);
    }
}

