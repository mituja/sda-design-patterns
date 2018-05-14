package pl.sda.poznan.chor;

//bazowa klasa dla hanlderow, czyli obiektow umiejacych przetwarzac zadania
//kalsy rozszerzajace ta klase sa elementami lancucha zobowiazan
public abstract class PaymentHandler {

    protected PaymentHandler nextHandler;

    //sprawdzic czy mozemy przetworzyc zadanie, jesli ine to przekazac wyzej w chor
    public void processPayment(BankAccount bankAccount, double amount) {
        //jezeli dany handler potrafi obslucyc zadanie (canHandle zwraca true)
        //to wykonuje metode obsulgi zadania, w przeciwnym wypadku
        //sprawdza czy jest kolejny handler, jesli tak to przekazuje zadanie wyzej
        //kolejny handler sprawdza czy potrafi to zrobic itd
        if (canHandlePayment(amount)) {
            handle(bankAccount, amount);
        } else if (nextHandler != null) {
            nextHandler.processPayment(bankAccount, amount);
        }
    }

    private boolean canHandlePayment(double amount) {
        return amount < getMaxPrice();
    }

    //metoda jest abstrakcyjna, bo na tym etapie nie wiemmy jak przetwarzac platnosc
    protected abstract void handle(BankAccount account, double amount);

    //metoda zwraca max kwote, jaka moze obsluzyc dana metoda
    //np 50 zl dla zblizeniowej, 500 zl dla pin
    protected abstract double getMaxPrice();

    public void setNextHandler(PinPaymentHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
