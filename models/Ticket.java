package models;

import java.time.LocalDateTime;

import enums.PaymentStatus;
import enums.VehicleType;

public class Ticket {

    private String id;
    private LocalDateTime entryTime;
    private VehicleType vehicle;
    private String floor;
    private String slot;
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    public Ticket(TicketBuilder ticketBuilder) {
        this.id = ticketBuilder.id;
        this.entryTime = ticketBuilder.entryTime;
        this.vehicle = ticketBuilder.vehicle;
        this.floor = ticketBuilder.floor;
        this.slot = ticketBuilder.slot;
    }

    public String getId(){
        return this.id;
    }

    public VehicleType getVehicleType(){
        return this.vehicle;
    }

    public void setPaymentStatus(PaymentStatus status){
        this.paymentStatus=status;
    }

    public String getFloor(){
        return this.floor;
    }
     public String getSlot(){
        return this.slot;
    }

    public LocalDateTime getEntryTime(){
        return this.entryTime;
    }

    public static class TicketBuilder {
        private String id;
        private LocalDateTime entryTime;
        private VehicleType vehicle;
        private String floor;
        private String slot;

        public TicketBuilder addId(String id) {
            this.id = id;
            return this;
        }

        public TicketBuilder addEntryTime(LocalDateTime entrytime) {
            this.entryTime = entrytime;
            return this;
        }

        public TicketBuilder addvehicle(VehicleType vehicleType) {
            this.vehicle = vehicleType;
            return this;
        }

        public TicketBuilder addFloor(String floor) {
            this.floor = floor;
            return this;
        }

        public TicketBuilder addSlot(String slot) {
            this.slot = slot;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }

    }

}
