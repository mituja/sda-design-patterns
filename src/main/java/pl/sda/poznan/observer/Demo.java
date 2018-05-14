package pl.sda.poznan.observer;

public class Demo {

    public static void main(String[] args) {
        Stock stock = new Stock();
        stock.setPrice(10);
        new StockObeserver(stock);


        //symulacja
        stock.setPrice(20);
    }
}
