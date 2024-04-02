public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        User user1 = new User("user1");
        User user2 = new User("user2");

        DocumentImpl doc1 = new DocumentImpl("doc1", "2023-01-01", "Content of Document 1");
        DocumentProxy docProxy1 = new DocumentProxy(doc1);

        AccessControlService accessControl = AccessControlService.getInstance();
        accessControl.grantAccess(user1.getUsername(), doc1.getIdentifier());

        library.addDocument(doc1.getIdentifier(), docProxy1);

        try {
            System.out.println("User1 accesses doc1: " + library.getDocument("doc1").getContent(user1));
            System.out.println("User2 accesses doc1: " + library.getDocument("doc1").getContent(user2));
        } catch (AccessDeniedException e) {
            System.err.println(e.getMessage());
        }
    }
}
