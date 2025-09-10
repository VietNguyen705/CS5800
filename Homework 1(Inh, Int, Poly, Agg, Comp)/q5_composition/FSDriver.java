public class FSDriver {
    public static void main(String[] args) {
        Folder root = new Folder("demo1");
        root.addSubFolder("Include Path");
        root.addSubFolder("Remote Files");
        Folder source = root.addSubFolder("Source Files");
        Folder phalcon = source.addSubFolder(".phalcon");
        Folder app = source.addSubFolder("app");
        
        app.addSubFolder("config");
        app.addSubFolder("controllers");
        app.addSubFolder("library");
        app.addSubFolder("migrations");
        app.addSubFolder("models");
        app.addSubFolder("views");

        source.addSubFolder("cache");
        Folder publicFolder = source.addSubFolder("public");
        publicFolder.addFile(new FSFile(".htaccess"));
        publicFolder.addFile(new FSFile(".htrouter.php"));
        publicFolder.addFile(new FSFile("index.html"));

        root.print();
        System.out.println();

        source.deleteSubFolder("app");
        root.print();
        System.out.println();

        source.deleteSubFolder("public");
        root.print();
    }
}
