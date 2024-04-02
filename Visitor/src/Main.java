public class Main {
    public static void main(String[] args) {
        // Create the root directory
        Directory root = new Directory("root");
        root.addElement(new File("file1.txt", 1.5));
        root.addElement(new File("file2.doc", 2.0));

        // Create and add a subdirectory with a file
        Directory subDir = new Directory("subDir");
        subDir.addElement(new File("file3.txt", 2.5));
        root.addElement(subDir);

        // Instantiate and apply the SizeCalculatorVisitor to calculate total file size
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total Size: " + sizeVisitor.getTotalSize() + " MB");

        // Instantiate and apply the SearchVisitor to find files with the .txt extension
        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        root.accept(searchVisitor);
        System.out.println("Found files:");
        for (File file : searchVisitor.getFoundFiles()) {
            System.out.println(file.getName());
        }
    }
}
