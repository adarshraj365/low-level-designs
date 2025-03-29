package flipmed.service;

import flipmed.exception.DoctorsNotRegistered;
import flipmed.exception.InvalidBookingIdException;
import flipmed.exception.PatientAlreadyBookCurrentSlotException;
import flipmed.exception.PatientNotExist;
import flipmed.model.Booking;
import flipmed.model.Doctor;
import flipmed.model.Patient;
import flipmed.model.Slot;
import flipmed.repository.DoctorRepository;
import flipmed.repository.PatientRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingService {
    PatientRepository patientRepository;
    DoctorRepository doctorRepository;
    Map<Integer, Booking> bookingsMap;
    Map<Integer, List<Slot>> patientsBookedSlots;
    int bookingId = 1;

    public BookingService(PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        bookingsMap = new HashMap<>();
        patientsBookedSlots = new HashMap<>();
    }

    public void addBooking(Patient patient, Doctor doctor, Slot slotToBook) {
        //check if patient doesn't exist.
        if(!patientRepository.isPatientRegistered(patient.getId())) {
            throw new PatientNotExist();
        }
        if(!doctorRepository.isDoctorRegistered(doctor.getId())) {
            throw new DoctorsNotRegistered();
        }
        Slot slot = checkIfDoctorHasEmptySlotToBook(doctor, slotToBook);
        if(slot == null) {
            System.out.println("Doctor doesn't have empty slot to book");
        }
        // check if for that slot booking is already done.
        if(!patientsBookedSlots.containsKey(patient.getId())) {
            patientsBookedSlots.put(patient.getId(), new ArrayList<>());
        }
        if(checkIfSlotIsAlreadyBooked(patientsBookedSlots.get(patient.getId()), slot)) {
            System.out.println("Patient has already booked current slot.");
            throw new PatientAlreadyBookCurrentSlotException();
        }
        // Add logic to book.
        Booking booking = new Booking(bookingId++, doctor, slot, patient);
        bookingsMap.put(booking.getBookingId(), booking);
        patientsBookedSlots.get(patient.getId()).add(slot);
        System.out.println("Booking successful with bookingId : " + booking.getBookingId());
    }

    public void cancelBooking(Integer bookingId) {
        if(!bookingsMap.containsKey(bookingId)){
            throw new InvalidBookingIdException();
        }
        Booking booking = bookingsMap.get(bookingId);
        doctorRepository.freeSlot(booking.getDoctor().getId(), booking.getSlot());
        bookingsMap.remove(bookingId);
        System.out.println("Booking Cancelled");
        patientsBookedSlots.get(booking.getPatient().getId()).remove(booking.getSlot());
    }

    private Slot checkIfDoctorHasEmptySlotToBook(Doctor doctor, Slot slot) {
        for(Slot sl : doctor.getSlotList()) {
            if(sl.getStartTime() == slot.getStartTime()  && sl.getEndTime() == slot.getEndTime() && sl.isAvailable()) {
                return sl;
            }
        }
        return null;
    }

    private boolean checkIfSlotIsAlreadyBooked(List<Slot> bookedSlot, Slot newSlot) {
        for(Slot slot : bookedSlot) {
            if(slot.getStartTime().equals(newSlot.getStartTime()) && slot.getEndTime().equals(newSlot.getEndTime())) {
                return true;
            }
        }
        return false;
    }
}
