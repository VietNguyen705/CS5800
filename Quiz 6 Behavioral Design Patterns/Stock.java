import java.util.ArrayList;
import java.util.List;

class Stock {
    private String symbol;
    private double currentPrice;
    private double previousPrice;
    private List<Observer> observers;

    public Stock(String symbol, double initialPrice) {
        this.symbol = symbol;
        this.currentPrice = initialPrice;
        this.previousPrice = initialPrice;
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void setPrice(double newPrice) {
        previousPrice = currentPrice;
        currentPrice = newPrice;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(symbol, currentPrice);
        }
    }

    public double getCurrentPrice() {
        return currentPrice;
    }
}
