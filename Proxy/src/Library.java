import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Document> documents;

    public Library() {
        documents = new HashMap<>();
    }

    public void addDocument(String identifier, Document document) {
        documents.put(identifier, document);
    }

    public Document getDocument(String identifier) {
        return documents.get(identifier);
    }
}
