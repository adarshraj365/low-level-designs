package parkinglot.entity;

public class ParkingDetails {
    int floorId;
    int parkingSlotId;

    public int getFloorId() {
        return floorId;
    }

    public int getParkingSlotId() {
        return parkingSlotId;
    }

    public ParkingDetails(int floorId, int parkingSlotId) {
        this.floorId = floorId;
        this.parkingSlotId = parkingSlotId;
    }
}
