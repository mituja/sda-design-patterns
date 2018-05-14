package pl.sda.poznan.observer;

public class Stock extends Observable<Stock> {

    private double price;
    private String name;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        //Zmienna pomocnicza do przechowania aktualnej/starej ceny sprzed wywolania setera
        double oldPrice = this.price;
        //Teraz this.price przechowuje nowa wartosc podana jako argument setera
        this.price = price;
        //Wykonuj tylko jezeli cena sie zmienila
        if (oldPrice != this.price) {
            //powiadamiamy obserwatorow
            propertyChanged(new PropertyChangedEventArgs<>(this, "price", this.price, oldPrice));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
