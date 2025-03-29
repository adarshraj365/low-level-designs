package flipmed.model;

import javax.print.Doc;

public class Booking {
    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    Integer bookingId;
    Doctor doctor;
    Slot slot;
    Patient patient;

    public Booking(Integer bookingId, Doctor doctor, Slot slot, Patient patient) {
        this.bookingId = bookingId;
        this.doctor = doctor;
        this.patient = patient;
        this.slot = slot;
    }
}
