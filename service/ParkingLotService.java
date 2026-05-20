package service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import enums.PaymentMethods;
import enums.PricingStrategies;
import enums.VehicleType;
import factory.PayementFactory;
import factory.PricingStrategyFactory;
import models.ParkingFloor;
import models.ParkingSlot;
import models.Ticket;
import strategy.PaymentStrategy;
import strategy.PricingStrategy;

public class ParkingLotService {
    private static final ParkingLotService INSTANCE = new ParkingLotService();

    private final Map<String, ParkingFloor> floors = new HashMap<>();
    private final Map<String, Ticket> activeTickets = new HashMap<>();

    private PricingStrategy pricingStrategy;

    public static ParkingLotService getInstance() {
        return INSTANCE;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy){
        System.out.println("Pricing Strategy Set To : "+ pricingStrategy);
        this.pricingStrategy=pricingStrategy;
    }

    public void addFloor(ParkingFloor floor){
        floors.put(floor.getId(), floor);
    }

    // private ParkingLotService() {
    //     this.pricingStrategy = PricingStrategyFactory.getPricingStrategy(PricingStrategies.EVENT_BASED);
    // }

    public Ticket parkVehicle(VehicleType vehicleType, LocalDateTime entryTime) {

        for (ParkingFloor floor : floors.values()) {
            ParkingSlot slot = floor.isParkingSlotAvailable(vehicleType);
            Ticket ticket = new Ticket.TicketBuilder()
                    .addId(UUID.randomUUID().toString())
                    .addEntryTime(entryTime)
                    .addFloor(floor.getId())
                    .addvehicle(vehicleType)
                    .addSlot(slot.getId())
                    .build();

            System.out.println(
                    "slot " + slot.getId() + " alloted to vehicle " + vehicleType + " with ticket id : " + ticket.getId());
            activeTickets.put(ticket.getId(), ticket);
            return ticket;
        }
        return null;
    }

    public void unParkVehicle(Ticket ticket,LocalDateTime exitTime,PaymentMethods paymentMethod ){
       
        double totalCharge=this.pricingStrategy.calculateParkingFee(ticket.getVehicleType(), ticket.getEntryTime(), exitTime);

        PaymentStrategy payment=PayementFactory.getPaymentMode(paymentMethod);
        PaymentProcessor processor=new PaymentProcessor(payment);
        boolean isPaid=processor.pay(ticket, totalCharge);

       if (!isPaid) {
            System.out.println("Vehicle cannot exit. Payment unsuccessful.");
            return;
        }

        ParkingFloor parkingFloor=floors.get(ticket.getFloor());
        ParkingSlot parkingSlot=parkingFloor.getParkingSlot(ticket.getSlot());
        parkingSlot.vacateSlot();
        activeTickets.remove(ticket.getId());
        System.out.println("Vehicle "+ticket.getVehicleType() +"successfully exited");  
    }
}
