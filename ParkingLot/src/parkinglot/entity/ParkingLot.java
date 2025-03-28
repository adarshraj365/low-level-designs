package parkinglot.entity;

public class ParkingLot {
    private int numberOfFloor;
    private ParkingFloor[] parkingFloors;

    public ParkingLot(final int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
        this.parkingFloors = new ParkingFloor[numberOfFloor];
        for(int i = 0; i < numberOfFloor; i++ ) {
            this.parkingFloors[i] = new ParkingFloor(i);
        }
    }

    public ParkingFloor getParkingFloor(int floor) {
        return this.parkingFloors[floor];
    }
}
