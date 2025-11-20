abstract class SnackDispenseHandler {
    protected SnackDispenseHandler next;

    public void setNext(SnackDispenseHandler next) {
        this.next = next;
    }

    public abstract void handleRequest(String snackName, VendingMachine machine);
}
