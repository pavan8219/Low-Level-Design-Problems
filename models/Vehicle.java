package models;

import enums.VehicleType;

public abstract class Vehicle {
    private final String number;
     private final VehicleType type;

     Vehicle(String number,VehicleType vehicleType){
          this.number=number;
          this.type=vehicleType;
     }
}
