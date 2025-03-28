package parkinglot.entity;

import parkinglot.emum.VehicleType;

import static parkinglot.utils.Constants.NUMBER_OF_PARKING_SLOTS_IN_FLOOR;

public class ParkingFloor {
    private int floorId;
    private ParkingSlot [] parkingSlots;

    public ParkingFloor(int index) {
        this.floorId = index;
        parkingSlots = new ParkingSlot[NUMBER_OF_PARKING_SLOTS_IN_FLOOR];
        for(int i = 0 ; i < NUMBER_OF_PARKING_SLOTS_IN_FLOOR; i++) {
            if(i < 10) {
                parkingSlots[i] = new ParkingSlot(i, VehicleType.CAR);
            }
            else if(i < 15) {
                parkingSlots[i] = new ParkingSlot(i, VehicleType.BIKE);
            }
            else {
                parkingSlots[i] =  new ParkingSlot(i, VehicleType.TRUCK);
            }
        }
    }
    /*
    Check if there are any parking slots available at this floor, if yes return it else return NULL.
     */
    public ParkingSlot getParkingSlots(VehicleType vehicleType) {
        for(int i = 0 ; i  < NUMBER_OF_PARKING_SLOTS_IN_FLOOR; i++) {
            if(this.parkingSlots[i].getVehicleType().equals(vehicleType)
                    && this.parkingSlots[i].checkAvailability()) {
                return this.parkingSlots[i];
            }
        }
        return null;
    }

    public ParkingSlot getParkingSlot(int index) {
        return this.parkingSlots[index];
    }
}
