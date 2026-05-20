package service;

import enums.PaymentStatus;
import models.Ticket;
import strategy.PaymentStrategy;

public class PaymentProcessor {

    public final PaymentStrategy paymentStrategy;
    public PaymentProcessor(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }
    public boolean pay(Ticket ticket,double fee){
        boolean isPaid=paymentStrategy.pay(fee, ticket);

        if(isPaid){
            ticket.setPaymentStatus(PaymentStatus.SUCCESS);
        }else{
            ticket.setPaymentStatus(PaymentStatus.FAILED);
            System.out.println("Payment Failed for ticket "+ ticket.getId());
        }

        return isPaid;
    }
}
