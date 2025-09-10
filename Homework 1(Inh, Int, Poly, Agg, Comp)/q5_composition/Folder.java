import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Folder {
    private String name;
    private final List<Folder> subFolders = new ArrayList<>();
    private final List<FSFile> files = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Folder addSubFolder(String name) {
        Folder f = new Folder(name);
        subFolders.add(f);
        return f;
    }

    public void addFile(FSFile file) { files.add(file); }

    public Folder findSubFolder(String name) {
        for (Folder f : subFolders) {
            if (f.getName().equals(name)) return f;
        }
        return null;
    }

    public boolean deleteSubFolder(String name) {
        Iterator<Folder> it = subFolders.iterator();
        while (it.hasNext()) {
            Folder f = it.next();
            if (f.getName().equals(name)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public void print() {
        print("");
    }

    private void print(String indent) {
        System.out.println(indent + name + "/");
        String childIndent = indent + "  ";
        for (Folder f : subFolders) {
            f.print(childIndent);
        }
        for (FSFile file : files) {
            file.print(childIndent);
        }
    }
}
