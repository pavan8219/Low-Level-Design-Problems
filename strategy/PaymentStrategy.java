package strategy;

import models.Ticket;

public interface PaymentStrategy {
    boolean pay(double amount,Ticket ticket);
}
