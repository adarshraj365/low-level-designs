package parkinglot.component;

import parkinglot.entity.Customer;
import parkinglot.entity.ParkingDetails;
import parkinglot.entity.ParkingLot;
import parkinglot.entity.ParkingSlot;

public class ParkingManagementAdminComponent {
    private final int TOTAL_FLOOR = 2;
    private ParkingLot parkingLot = new ParkingLot(TOTAL_FLOOR);

    public ParkingSlot assignSlotToCustomer(Customer customer) {
        ParkingSlot parkingSlot = null;
        int floor = 0;
        for(int i = 0; i < TOTAL_FLOOR; i++) {
             parkingSlot = parkingLot.getParkingFloor(i)
                    .getParkingSlots(customer.getVehicleType());
            if(parkingSlot != null) {
                floor = i;
                break;
            }
        }
        if(parkingSlot == null) {
            System.out.println("No Parking Slots available at the moment.");
        } {
            ParkingDetails parkingDetails = new ParkingDetails(floor, parkingSlot.getId());
            customer.setParkingDetails(parkingDetails);
            parkingSlot.assignCustomer(customer);
        }
        return parkingSlot;
    }

    public void exitForCustomer(Customer customer) {
        int floor = customer.getParkingDetails().getFloorId();
        int parkingSlotIndex = customer.getParkingDetails().getParkingSlotId();
        ParkingSlot parkingSlot = this.parkingLot.getParkingFloor(floor).getParkingSlot(parkingSlotIndex);
        parkingSlot.unParkCustomer();
        customer.setParkingDetails(null);
    }
}
