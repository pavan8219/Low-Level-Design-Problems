package models;

import enums.VehicleType;
import java.util.concurrent.atomic.AtomicBoolean;

public class ParkingSlot {
    private String id;
    private VehicleType vehicleTypeSupperted;

    private AtomicBoolean isOccupied=new AtomicBoolean(false);

    public ParkingSlot(String id,VehicleType supprtedVehicle){
        this.id=id;
        this.vehicleTypeSupperted=supprtedVehicle;
    }

    public String getId(){
        return this.id;
    }

    public VehicleType getVehicleType(){
        return this.vehicleTypeSupperted;
    }

    public boolean tryOccupySlot(){
        return isOccupied.compareAndSet(false, true);
    }

    public void vacateSlot(){
        isOccupied.set(false);
    }


}
