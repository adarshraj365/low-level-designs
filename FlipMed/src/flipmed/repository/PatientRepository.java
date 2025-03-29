package flipmed.repository;

import flipmed.exception.PatientAlreadyRegistered;
import flipmed.model.Patient;

import java.util.HashMap;
import java.util.Map;

public class PatientRepository {
    Map<Integer, Patient> patients = new HashMap<>();

    public void registerPatient(Patient patient) {
        if(patients.containsKey(patient.getId())) {
            throw new PatientAlreadyRegistered();
        }
        patients.put(patient.getId(), patient);
    }

    public boolean isPatientRegistered(Integer patientId) {
        return patients.containsKey(patientId);
    }
}
