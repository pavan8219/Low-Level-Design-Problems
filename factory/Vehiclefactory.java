package factory;

import enums.VehicleType;
import models.BikeVehicle;
import models.Car;
import models.Vehicle;

public class Vehiclefactory {
    public static Vehicle getVehicle(String number,VehicleType vehicleType){
        switch (vehicleType) {
            case BIKE:
                return new BikeVehicle(number,vehicleType) ;
            case CAR:
                return new Car(number,vehicleType);
            default:
                return null;
        }
    }
}
