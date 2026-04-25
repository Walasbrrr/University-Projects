public class Driver_Part3 {
    public static void main(String[] args) {
        StockLedger2 myStocks = new StockLedger2();

        myStocks.buy(20, 45);
        myStocks.buy(20, 75);

        double gain = myStocks.sell(30, 65);
        System.out.println("Capital Gain: " + gain);

        System.out.println("Remaining shares: " + myStocks.remainingShares());

        myStocks.buy(5, 70);
        double loss = myStocks.sell(5, 60);
        System.out.println("Capital Gain (loss case): " + loss);
    }
}
