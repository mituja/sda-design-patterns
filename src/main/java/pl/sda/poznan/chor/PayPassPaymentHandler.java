package pl.sda.poznan.chor;

//platnosc paypass do 50 zl
public class PayPassPaymentHandler extends PaymentHandler {

    private static final int MAX_PRICE_TO_HANDLE = 50;

    @Override
    protected void handle(BankAccount account, double amountToPay) {
        System.out.println("platnosc znlizenioa jest realizowana...");
        account.setAmount(account.getAmount() - amountToPay);
        System.out.println("zaplacono zblizeniowo");
    }

    @Override
    protected double getMaxPrice() {
        return MAX_PRICE_TO_HANDLE;
    }
}
