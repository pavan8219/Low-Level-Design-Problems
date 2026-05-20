package models;

import java.util.HashMap;

import enums.VehicleType;

public class ParkingFloor {
    private String id;
    HashMap<String,ParkingSlot> parkingSlots=new HashMap<>();

    public ParkingFloor(String id){
        this.id=id;
    }

    public String getId(){
        return this.id;
    }

    public void addParkingSlot(ParkingSlot slot){
        parkingSlots.put(slot.getId(),slot);
    }

    public ParkingSlot getParkingSlot(String id){
        return parkingSlots.get(id);
    }

    public ParkingSlot isParkingSlotAvailable(VehicleType type){
       for(ParkingSlot parkingSlot:parkingSlots.values()){
            if(parkingSlot.getVehicleType()==type && parkingSlot.tryOccupySlot()){
                return parkingSlot;
            }
       }
       return null;
    }
}
