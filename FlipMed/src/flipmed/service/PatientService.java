package flipmed.service;

import flipmed.model.Patient;
import flipmed.repository.PatientRepository;

public class PatientService {
    PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void registerPatient(Patient patient) {
        patientRepository.registerPatient(patient);
        System.out.println(patient.getName() + " registered successfully !");
    }
}
