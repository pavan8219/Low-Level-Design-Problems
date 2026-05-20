package strategy;

import models.Ticket;

public class UpiPaymentStrategy implements PaymentStrategy{

    @Override
    public boolean pay(double amount, Ticket ticket) {
       System.out.println("Amount :" +amount + "for ticket id:"+ticket.getId() + "via upi");
       return true;
    }
    
}
