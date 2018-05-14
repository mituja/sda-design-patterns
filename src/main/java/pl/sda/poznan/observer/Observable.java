package pl.sda.poznan.observer;
import java.util.ArrayList;
import java.util.List;

public class Observable<T> {

    //Lista obserwatorow
    private List<Observer<T>> observers = new ArrayList<>();

    //Metoda dodajaca nowego obserwatora
    public void subscribe(Observer<T> observer){
        this.observers.add(observer);
    }

    //Metoda powiadamiajaca wszystkich obserwatorow o wydarzeniu
    protected void propertyChanged(PropertyChangedEventArgs<T> eventArgs){
        for (Observer<T> o : observers){
            o.handle(eventArgs);
        }
    }
}
