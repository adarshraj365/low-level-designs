package flipmed.service;

import flipmed.enums.Speciality;
import flipmed.model.Doctor;
import flipmed.model.Slot;
import flipmed.repository.DoctorRepository;

import java.util.List;
import java.util.Map;

public class DoctorService {
    DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void registerDoctor(Doctor doctor) {
        doctorRepository.registerDoctor(doctor);
        System.out.println("Welcome Doc " + doctor.getName() + " !");
    }

    public void getAvailableSlotsForDoctorsBySpeciality(Speciality speciality) {
        Map<Doctor, List<Slot>> doctorsForSpeciality = doctorRepository
                .getAvailableSlotsForAllDoctorsForSpeciality(speciality);

        for(Doctor doctor : doctorsForSpeciality.keySet()) {
            for(Slot slot : doctorsForSpeciality.get(doctor)) {
                System.out.println(doctor.getName() + ": ( " + slot.getStartTime() +"-" + slot.getEndTime()+ " )");
            }
        }
    }

    public void addAvailability(Integer doctorId, Slot slot) {
        doctorRepository.makeSlotsAvailable(doctorId, slot);
        System.out.println("Done Doc!");
    }
}
