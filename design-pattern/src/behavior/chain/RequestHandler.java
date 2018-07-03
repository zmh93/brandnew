package behavior.chain;

/**
 * RequestHandler
 */
public abstract class RequestHandler {

    private RequestHandler next;

    public RequestHandler(RequestHandler next) {
        this.next = next;
    }

    /**
     * Request handler
     */
    public void handleRequest(Request req) {
        if (next != null) {
            next.handleRequest(req);
        }
    }

    protected void printHandling(Request req) {
        System.out.printf("%s handling request %s \n", this, req);
    }

    @Override
    public abstract String toString();
}
