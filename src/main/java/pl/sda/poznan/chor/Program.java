package pl.sda.poznan.chor;

public class Program {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("konto 1", 4000);
        bankAccount.setPin("1234");

        //utworzenie handlerow i ustawienie w kolejnosci
        PayPassPaymentHandler payPassPaymentHandler = new PayPassPaymentHandler();
        PinPaymentHandler pinPaymentHandler = new PinPaymentHandler();
        payPassPaymentHandler.setNextHandler(pinPaymentHandler);

        //prosba utworzenia zadania - zlecamy zadanie handlerowi stojacemu najnizej w hierarchii
        payPassPaymentHandler.processPayment(bankAccount, 200);
    }
}
