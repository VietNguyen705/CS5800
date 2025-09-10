import java.util.ArrayList;
import java.util.List;

public class PayableDriver {
    public static void main(String[] args) {
        List<Payable> payables = new ArrayList<>();

        payables.add(new Freelancer("Alex", "Chen", 60.0, 42.0));
        payables.add(new Freelancer("Priya", "Kumar", 55.0, 38.0));

        payables.add(new VendorInvoice("Acme Parts", "INV-1001", 1250.00));
        payables.add(new VendorInvoice("CloudCo", "INV-2002", 899.99));

        double totalPayout = 0.0;
        for (Payable p : payables) {
            if (p instanceof Freelancer) {
                ((Freelancer) p).print();
            } else if (p instanceof VendorInvoice) {
                ((VendorInvoice) p).print();
            }
            totalPayout += p.calculatePayment();
        }

        System.out.printf("Total payout this period: $%.2f%n", totalPayout);
    }
}
