package strategy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;

import enums.VehicleType;

public class EventBasedPricingStrategy implements PricingStrategy {

    private static final Map<VehicleType, Double> EVENT_HOURLY_RATES = Map.of(
            VehicleType.CAR, 50.0,
            VehicleType.BIKE, 30.0,
            VehicleType.AUTO, 40.0,
            VehicleType.BUS,100.0
    );
    @Override
    public double calculateParkingFee(VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime) {

       long durationMinutes=Duration.between(entryTime, exitTime).toMinutes();
       long durationHours=(long)Math.ceil(durationMinutes/60);
       return durationHours*EVENT_HOURLY_RATES.get(vehicleType);
       
    }
    
}
