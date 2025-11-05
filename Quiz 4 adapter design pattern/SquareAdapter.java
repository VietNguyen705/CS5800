public class SquareAdapter implements PaymentProcessor {
    private SquareGateway squareGateway;
    private String locationID;

    public SquareAdapter(String locationID) {
        this.squareGateway = new SquareGateway();
        this.locationID = locationID;
    }

    @Override
    public void processPayment(double amount) {
        squareGateway.executeTransaction(amount, locationID);
    }
}
