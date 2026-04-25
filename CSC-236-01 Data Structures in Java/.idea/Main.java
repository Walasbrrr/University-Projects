public class Main {

    public static void main(String[] args) {
        StockLedger ledger = new StockLedger();
        ledger.buy(20,45);
        ledger.buy(20,75);
        double gain = ledger.sell(30,65);
        System.out.println("Resultado: " + gain);
    }


}