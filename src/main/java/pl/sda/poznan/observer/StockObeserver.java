package pl.sda.poznan.observer;

public class StockObeserver implements Observer<Stock> {

    private Stock stockToObserve;

    public StockObeserver(Stock stockToObserve) {
        this.stockToObserve = stockToObserve;
        this.stockToObserve.subscribe(this);
    }

    @Override
    public void handle(PropertyChangedEventArgs<Stock> args) {
        //Tutaj logika przetwarzajaca zdarzenia, np wysylanie maila do powiadamiajacego
        System.out.println("Wartosc sie zmienila: " + args.getPropertyName());
        System.out.println("Stara wartosc: " + args.getOldValue());
        System.out.println("Nowa wartosc: "+ args.getNewValue());

    }
}
