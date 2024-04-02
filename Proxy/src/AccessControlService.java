import java.util.HashMap;
import java.util.Map;

public class AccessControlService {
    private static AccessControlService instance = new AccessControlService();
    private Map<String, String> accessMap; // Maps username to document identifier

    private AccessControlService() {
        accessMap = new HashMap<>();
    }

    public static AccessControlService getInstance() {
        return instance;
    }

    public boolean isAllowed(String username, String documentId) {
        return accessMap.containsKey(username) && accessMap.get(username).equals(documentId);
    }

    public void grantAccess(String username, String documentId) {
        accessMap.put(username, documentId);
    }
}
