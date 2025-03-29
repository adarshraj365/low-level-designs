import flipmed.enums.Speciality;
import flipmed.model.Doctor;
import flipmed.model.Patient;
import flipmed.model.Slot;
import flipmed.repository.DoctorRepository;
import flipmed.repository.PatientRepository;
import flipmed.service.BookingService;
import flipmed.service.DoctorService;
import flipmed.service.PatientService;

public class Main {
    public static void main(String[] args) {
        PatientRepository patientRepository = new PatientRepository();
        DoctorRepository doctorRepository = new DoctorRepository();
        DoctorService doctorService = new DoctorService(doctorRepository);
        PatientService patientService = new PatientService(patientRepository);
        BookingService bookingService = new BookingService(patientRepository, doctorRepository);

        int patientId = 1;
        int doctorId = 1;

        // Doctors
        Doctor doctorCurious = new Doctor(1, "curious", Speciality.Cardiologist);
        Doctor doctorDreadful = new Doctor(2, "Dreadful", Speciality.Dermatologist);
        Doctor doctorDaring = new Doctor(3, "Daring", Speciality.Dermatologist);

        // Patients
        Patient patientA = new Patient(1, "PatientA");
        Patient patientB = new Patient(2, "PatientB");
        Patient patientC = new Patient(3, "PatientC");
        patientService.registerPatient(patientA);
        patientService.registerPatient(patientB);
        patientService.registerPatient(patientC);

        // Register Doctor.
        doctorService.registerDoctor(doctorCurious);
        doctorService.addAvailability(1, new Slot("9:30", "10:00"));
        doctorService.addAvailability(1, new Slot("12:30", "13:00"));
        doctorService.addAvailability(1, new Slot("16:00", "16:30"));
        doctorService.registerDoctor(doctorDreadful);
        doctorService.addAvailability(2, new Slot("9:30", "10:00"));
        doctorService.addAvailability(2, new Slot("12:30", "13:00"));
        doctorService.addAvailability(2, new Slot("16:00", "16:30"));
        doctorService.getAvailableSlotsForDoctorsBySpeciality(Speciality.Cardiologist);
        bookingService.addBooking(patientA, doctorCurious, new Slot("12:30", "13:00"));
        doctorService.getAvailableSlotsForDoctorsBySpeciality(Speciality.Cardiologist);
        bookingService.cancelBooking(1);
        bookingService.addBooking(patientB, doctorCurious, new Slot("12:30", "13:00"));
        doctorService.registerDoctor(doctorDaring);
        doctorService.addAvailability(2, new Slot("11:30", "12:00"));
        doctorService.addAvailability(2, new Slot("14:00", "14:30"));
        doctorService.getAvailableSlotsForDoctorsBySpeciality(Speciality.Dermatologist);
    }
}