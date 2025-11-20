import java.util.Random;

public class StockDriver {
    public static void main(String[] args) {
        Stock stock = new Stock("AAPL", 150.00);

        StockObserver trader1 = new StockObserver("Trader 1");
        StockObserver trader2 = new StockObserver("Trader 2");

        stock.addObserver(trader1);
        stock.addObserver(trader2);

        System.out.println("Starting price: $150.00\n");

        Random rand = new Random();

        for (int i = 0; i < 6; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}

            double change = (rand.nextDouble() * 20) - 10;
            double newPrice = stock.getCurrentPrice() + change;

            if (newPrice < 100) {
                newPrice = 100 + rand.nextDouble() * 50;
            }

            System.out.println("\nUpdate " + (i + 1) + ":");
            stock.setPrice(newPrice);
        }
    }
}
