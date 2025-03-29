package flipmed.repository;

import flipmed.enums.Speciality;
import flipmed.exception.DoctorAlreadyRegistered;
import flipmed.exception.DoctorsNotRegistered;
import flipmed.exception.SlotNotAvailableForDoctor;
import flipmed.model.Doctor;
import flipmed.model.Slot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DoctorRepository {

    Map<Integer, Doctor> doctors = new HashMap<>();
    Map<Speciality, List<Doctor>> doctorsForSpeciality = new HashMap<>();

    // Register a new Doctor.
    public void registerDoctor(Doctor doctor) {
        // Check if Doctors are already registered and throw exception.
        if(doctors.containsKey(doctor.getId())) {
            throw new DoctorAlreadyRegistered();
        }
        doctors.put(doctor.getId(), doctor);
        if(!doctorsForSpeciality.containsKey(doctor.getSpeciality())) {
            doctorsForSpeciality.put(doctor.getSpeciality(), new ArrayList<>());
        }
        doctorsForSpeciality.get(doctor.getSpeciality()).add(doctor);
    }

    // Add a particular slot for a doctor and make those slots available to be booked by patient.
    public void makeSlotsAvailable(Integer doctorId, Slot slot) {
        if(!doctors.containsKey(doctorId)) {
            throw new DoctorsNotRegistered();
        }
        Doctor doctor = doctors.get(doctorId);
        // Add this slot to the doctor.
        doctor.addSlot(slot);
    }

    // get all available slots for a particular doctor.
    public List<Slot> getAllAppointmentsForDoctor(Integer doctorId) {
        return doctors.get(doctorId).getSlotList().stream()
                .filter(Slot::isAvailable).collect(Collectors.toList());
    }

    // get all available slots for all doctors specialized in a particular specialization.
    public Map<Doctor, List<Slot>> getAvailableSlotsForAllDoctorsForSpeciality(Speciality speciality) {
        List<Doctor> listOfDoctorsForSpeciality = doctorsForSpeciality.get(speciality);
        Map<Doctor, List<Slot>> allAvailableSlotsForSpecializedDoctors = new HashMap<>();
        for(Doctor doctor : listOfDoctorsForSpeciality) {
            allAvailableSlotsForSpecializedDoctors.put(doctor, doctor.getSlots()
                    .stream().filter(Slot::isAvailable).collect(Collectors.toList()));
        }
        return allAvailableSlotsForSpecializedDoctors;
    }

    // Get Doctor details.
    public Doctor getDoctorDetails(Integer doctorId) {
        return doctors.get(doctorId);
    }

    // Free slots for a doctor.
    public void freeSlot(Integer doctorId, Slot slotToFree) {
        Doctor doctor = doctors.get(doctorId);
        Slot tempSlot = null;
        for(Slot slot : doctor.getSlotList()) {
            if(slot.getStartTime() == slotToFree.getStartTime() && slot.getEndTime() == slotToFree.getEndTime()) {
                tempSlot = slot;
                break;
            }
        }
        if(tempSlot == null) {
            throw new SlotNotAvailableForDoctor();
        }
        tempSlot.setAvailable(true);
    }

    public boolean isDoctorRegistered(Integer doctorId) {
        return doctors.containsKey(doctorId);
    }
}
