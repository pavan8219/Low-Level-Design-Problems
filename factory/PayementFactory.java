package factory;

import enums.PaymentMethods;
import strategy.CashPaymentStrategy;
import strategy.CreditCardPaymentStrategy;
import strategy.PaymentStrategy;
import strategy.UpiPaymentStrategy;

public class PayementFactory {
    public static PaymentStrategy getPaymentMode(PaymentMethods paymentMethod){
        switch (paymentMethod) {
            case PaymentMethods.UPI:
                return new UpiPaymentStrategy();
            case PaymentMethods.CASH:
                return new CashPaymentStrategy();
            case PaymentMethods.CEDIT_CARD:
                return new CreditCardPaymentStrategy();
            default:
                return null;
        }
    }
}
