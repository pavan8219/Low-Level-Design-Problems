package strategy;

import models.Ticket;

public class CashPaymentStrategy implements PaymentStrategy {

    @Override
    public boolean pay(double amount, Ticket ticket) {
       System.out.println("Amount :" +amount + "for ticket id:"+ticket.getId() +"via cash");
       return true;
    }
    
}
