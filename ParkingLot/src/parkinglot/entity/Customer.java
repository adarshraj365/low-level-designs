package parkinglot.entity;

import parkinglot.emum.VehicleType;

public class Customer {
    private String name;
    private int id;
    private VehicleType vehicleType;
    private boolean exitedParkingLot;
    private int totalHrsOfServiceUsed;
    private int moneyPaid;
    private ParkingDetails parkingDetails;

    public Customer(String name, int id, VehicleType vehicleType) {
        this.name = name;
        this.id =id;
        this.vehicleType = vehicleType;
        this.exitedParkingLot = false;
        this.totalHrsOfServiceUsed = 0;
        this.moneyPaid  = 0;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setParkingDetails(ParkingDetails parkingDetails) {
        this.parkingDetails = parkingDetails;
    }

    public ParkingDetails getParkingDetails() {
        return this.parkingDetails;
    }
}
