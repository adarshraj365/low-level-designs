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

    }
}