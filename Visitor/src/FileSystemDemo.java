public class FileSystemDemo {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        root.addElement(new File("file1.txt", 1.5));
        root.addElement(new File("file2.doc", 2.0));

        Directory subDir = new Directory("subDir");
        subDir.addElement(new File("file3.txt", 2.5));
        root.addElement(subDir);

        // Using the SizeCalculatorVisitor
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total Size: " + sizeVisitor.getTotalSize() + " MB");

        // Using the SearchVisitor
        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        root.accept(searchVisitor);
        System.out.println("Found files:");
        for (File file : searchVisitor.getFoundFiles()) {
            System.out.println(file.getName());
        }
    }
}
