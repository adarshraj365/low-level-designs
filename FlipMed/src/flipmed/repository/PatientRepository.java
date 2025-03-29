package flipmed.repository;

import flipmed.exception.PatientAlreadyRegistered;
import flipmed.exception.PatientNotExist;
import flipmed.model.Booking;
import flipmed.model.Patient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientRepository {
    Map<Integer, Patient> patients = new HashMap<>();
    Map<Patient, List<Booking>> bookingsForPatient = new HashMap<>();

    public void registerPatient(Patient patient) {
        if(patients.containsKey(patient.getId())) {
            throw new PatientAlreadyRegistered();
        }
        patients.put(patient.getId(), patient);
    }

    public void addBookingsForPatient(Integer patientId, Booking booking) {
        if(!patients.containsKey(patientId)) {
            throw new PatientNotExist();
        }
        Patient patient = patients.get(patientId);
        if(!bookingsForPatient.containsKey(patient)) {
            bookingsForPatient.put(patient, new ArrayList<>());
        }
        bookingsForPatient.get(patient).add(booking);
    }
}
