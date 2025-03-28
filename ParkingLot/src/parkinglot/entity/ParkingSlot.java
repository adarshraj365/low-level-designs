package parkinglot.entity;

import parkinglot.emum.VehicleType;

public class ParkingSlot {
    private int id;
    private VehicleType vehicleType;
    private boolean isAvailable;
    private Customer allocatedCustomer;


    public ParkingSlot(int id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.isAvailable = true;
    }

    public boolean checkAvailability() {
        return this.isAvailable;
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    public int getId() {
        return id;
    }

    public Customer getAllocatedCustomer() {
        return allocatedCustomer;
    }

    public void assignCustomer(Customer customer) {
        this.allocatedCustomer = customer;
        this.isAvailable = false;
    }

    public void unParkCustomer() {
        this.allocatedCustomer = null;
        this.isAvailable = true;
    }
}

