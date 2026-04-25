public class StockPurchase {
    private final double costPerShare;

    public StockPurchase(double costPerShare) {
        if (costPerShare < 0) throw new IllegalArgumentException("Cost cannot be negative");
        this.costPerShare = costPerShare;
    }

    public double getCostPerShare() {
        return costPerShare;
    }
}
