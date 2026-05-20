package strategy;

import java.time.LocalDateTime;

import enums.VehicleType;

public interface PricingStrategy {
    double calculateParkingFee(VehicleType vehicleType,LocalDateTime entryTime,LocalDateTime exitTime);
}
