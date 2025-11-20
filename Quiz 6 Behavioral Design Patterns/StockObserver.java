class StockObserver implements Observer {
    private String name;
    private double lastPrice;
    private boolean first;

    public StockObserver(String name) {
        this.name = name;
        this.first = true;
    }

    public void update(String symbol, double price) {
        System.out.println(name + ": " + symbol + " is now $" + String.format("%.2f", price));

        if (!first) {
            if (price > lastPrice) {
                System.out.println("Price went UP");
            } else if (price < lastPrice) {
                System.out.println("Price went DOWN");
            }
        }

        lastPrice = price;
        first = false;
    }
}
