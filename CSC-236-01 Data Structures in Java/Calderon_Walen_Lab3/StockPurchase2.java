public class StockPurchase2 {
    private int shares;
    private final double costPerShare;

    public StockPurchase2(int shares, double costPerShare) {
        if (shares <= 0) throw new IllegalArgumentException("shares must be > 0");
        this.shares = shares;
        this.costPerShare = costPerShare;
    }

    public int getNumberOfShares() { return shares; }
    public void setNumberOfShares(int s) { this.shares = s; }
    public double getCostPerShare() { return costPerShare; }
}
