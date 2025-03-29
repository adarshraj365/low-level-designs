package flipmed.model;

import java.util.List;

public class AvailableDoctor {
    public Doctor getDoctor() {
        return doctor;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    Doctor doctor;
    List<Slot> slots;
}
