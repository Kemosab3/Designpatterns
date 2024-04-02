import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private List<File> foundFiles = new ArrayList<>();
    private String searchCriterion;

    public SearchVisitor(String searchCriterion) {
        this.searchCriterion = searchCriterion;
    }

    public List<File> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(searchCriterion)) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        // Searching within directories is handled through their files
    }
}
