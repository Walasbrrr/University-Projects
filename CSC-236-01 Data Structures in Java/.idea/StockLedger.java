import java.util.LinkedList;
import java.util.Queue;

public class StockLedger {
    private final Queue<StockPurchase> purchases = new LinkedList<>();

    // Buy N shares: enqueue one StockPurchase per share
    public void buy(int shares, double price) {
        if (shares < 0) throw new IllegalArgumentException("shares < 0");
        while (shares-- > 0) purchases.add(new StockPurchase(price));
    }

    // Sell N shares FIFO; return capital gain (can be negative = loss)
    public double sell(int shares, double sellPrice) {
        if (shares < 0) throw new IllegalArgumentException("shares < 0");
        if (shares > purchases.size()) throw new IllegalStateException("Not enough shares to sell");
        double capitalGain = 0.0;
        while (shares-- > 0) {
            StockPurchase sold = purchases.remove(); // FIFO
            capitalGain += (sellPrice - sold.getCostPerShare());
        }
        return capitalGain;
    }

    public int remainingShares() {
        return purchases.size();
    }
}
