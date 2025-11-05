public class SquareGateway {
    public void executeTransaction(double paymentAmount, String locationID) {
        System.out.println("Processing Square payment: $" + paymentAmount + " at location " + locationID);
    }
}
