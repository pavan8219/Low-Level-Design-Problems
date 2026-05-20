package models;

import java.time.LocalDateTime;

import enums.GateType;
import enums.PaymentMethods;
import service.ParkingLotService;

public class ExitGate extends Gate{

    public ExitGate(String id) {
        super(id);
    }

    @Override
    public GateType getGateType() {
       return GateType.EXIT;
    }

   public void unParkVehicle(Ticket ticket,LocalDateTime exitTime,PaymentMethods paymentMethod){
     ParkingLotService.getInstance().unParkVehicle(ticket,exitTime,paymentMethod);
   }
    
}
