import java.time.LocalDateTime;

import enums.PaymentMethods;
import enums.PricingStrategies;
import enums.VehicleType;
import factory.PricingStrategyFactory;
import models.EntryGate;
import models.ExitGate;
import models.ParkingFloor;
import models.ParkingSlot;
import models.Ticket;
import service.ParkingLotService;
import utils.DateTimeParser;

public class Main {
   public static void main(String[] args) {

      ParkingLotService parkingLot = ParkingLotService.getInstance();

      ParkingFloor floor1 = new ParkingFloor("floor1");
      floor1.addParkingSlot(new ParkingSlot("s1", VehicleType.BIKE));
      floor1.addParkingSlot(new ParkingSlot("s2", VehicleType.BIKE));
      floor1.addParkingSlot(new ParkingSlot("s3", VehicleType.CAR));
      floor1.addParkingSlot(new ParkingSlot("s4", VehicleType.AUTO));
      floor1.addParkingSlot(new ParkingSlot("s5", VehicleType.BUS));
      floor1.addParkingSlot(new ParkingSlot("s6", VehicleType.AUTO));
      parkingLot.addFloor(floor1);

      EntryGate entryGate = new EntryGate("eg1");
      ExitGate exitGate = new ExitGate("eg2");

      parkingLot.setPricingStrategy(PricingStrategyFactory.getPricingStrategy(PricingStrategies.EVENT_BASED));
      LocalDateTime entryTime = DateTimeParser.parse("21 May 7:30 AM 2025");
      Ticket ticket = entryGate.parkVehicle(VehicleType.BIKE, entryTime);

      LocalDateTime exitTime = DateTimeParser.parse("21 May 1:15 PM 2025");
      exitGate.unParkVehicle(ticket, exitTime, PaymentMethods.CEDIT_CARD);

   }
}