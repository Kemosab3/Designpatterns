public class DocumentProxy implements Document {
    private DocumentImpl realDocument;
    private AccessControlService accessControlService;

    public DocumentProxy(DocumentImpl realDocument) {
        this.realDocument = realDocument;
        this.accessControlService = AccessControlService.getInstance();
    }

    @Override
    public String getIdentifier() {
        return realDocument.getIdentifier();
    }

    @Override
    public String getCreationDate() {
        return realDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (accessControlService.isAllowed(user.getUsername(), realDocument.getIdentifier())) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException("Access Denied for user: " + user.getUsername());
        }
    }
}
