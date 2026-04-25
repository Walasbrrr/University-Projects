public class StockLedger2 {
    private final DequeInterface<StockPurchase2> ledger = new MyDeque<>();

    public void buy(int shares, double pricePerShare) {
        if (shares <= 0) throw new IllegalArgumentException("shares must be > 0");
        ledger.enqueueRear(new StockPurchase2(shares, pricePerShare));
    }

    public double sell(int sharesToSell, double sellPrice) {
        if (sharesToSell <= 0) throw new IllegalArgumentException("sharesToSell must be > 0");
        double capitalGain = 0.0;

        while (sharesToSell > 0 && !ledger.isEmpty()) {
            StockPurchase2 lot = ledger.dequeueFront();
            int available = lot.getNumberOfShares();
            double cost = lot.getCostPerShare();

            if (available <= sharesToSell) {
                capitalGain += available * (sellPrice - cost);
                sharesToSell -= available;
            } else {
                capitalGain += sharesToSell * (sellPrice - cost);
                int remaining = available - sharesToSell;
                ledger.enqueueFront(new StockPurchase2(remaining, cost));
                sharesToSell = 0;
            }
        }
        return capitalGain;
    }

    public int remainingShares() {
        int count = 0;
        int n = ledger.size();
        for (int i = 0; i < n; i++) {
            StockPurchase2 x = ledger.dequeueFront();
            count += x.getNumberOfShares();
            ledger.enqueueRear(x);
        }
        return count;
    }
}
