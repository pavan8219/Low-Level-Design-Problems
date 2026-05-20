package strategy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import enums.VehicleType;

public class TimeBasedPricingStrategy implements PricingStrategy {

    private final LocalTime PEAK_START = LocalTime.of(8, 00);
    private final LocalTime PEAK_END = LocalTime.of(17, 00);

    public boolean isPeak(LocalTime time) {
        return time.isAfter(PEAK_START) && time.isBefore(PEAK_END);
    }

    @Override
    public double calculateParkingFee(VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime) {

        System.out.println("details" + vehicleType + " " + entryTime + " "+ exitTime );
        if (exitTime.isBefore(entryTime))
            throw new IllegalArgumentException("Exit time can't be before entrytime");

        long durationMinutes = Duration.between(entryTime, exitTime).toMinutes();
        long durationHoures = (long) Math.ceil(durationMinutes / 60.0);

        LocalDateTime cursor = entryTime.truncatedTo(ChronoUnit.HOURS);
        int peakHours = 0;
        int nonPeakHours = 0;

        for (int i = 0; i < durationHoures; i++) {
            LocalTime start = cursor.toLocalTime();
            if (this.isPeak(start)) {
                peakHours++;
            } else {
                nonPeakHours++;
            }
            cursor=cursor.plusHours(1);
        }

        // System.out.println("total peak hours vehicle parked :"+peakHours);
        // System.out.println("total non peak hours vehicle parked :"+nonPeakHours);

        double peakPrice = 0;

        switch (vehicleType) {
            case BIKE:
                peakPrice = 30;
                break;
            case CAR:
                peakPrice = 50;
                break;
            case BUS:
                peakPrice = 100;
                break;
            case AUTO:
                peakPrice = 40;
                break;
            default:
                break;
        }

        double nonPeakPrice = 0;

        switch (vehicleType) {
            case BIKE:
                nonPeakPrice = 10;
                break;
            case CAR:
                nonPeakPrice = 30;
                break;
            case BUS:
                nonPeakPrice = 50;
                break;
            case AUTO:
                nonPeakPrice = 20;
                break;
            default:
                break;
        }

        double totalFee = peakHours * peakPrice + nonPeakHours * nonPeakPrice;

        return totalFee;

    }

}
