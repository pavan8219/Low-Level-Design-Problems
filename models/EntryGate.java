package models;

import java.time.LocalDateTime;

import enums.GateType;
import enums.VehicleType;
import service.ParkingLotService;

public class EntryGate extends Gate{

    public EntryGate(String id){
        super(id);
    }
    @Override
    public GateType getGateType() {
       return GateType.ENTRY;
    }

     public Ticket parkVehicle(VehicleType vehicleType,LocalDateTime entryTime){
        return ParkingLotService.getInstance().parkVehicle(vehicleType, entryTime);
    }

    
    
}
