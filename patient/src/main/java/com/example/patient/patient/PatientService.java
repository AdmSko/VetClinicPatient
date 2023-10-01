package com.example.patient.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatient(){
        return patientRepository.findAll();
    }
    public void addNewPatient(Patient patient){
        Optional<Patient> patientOptional = patientRepository
                .findPatientByTelNumber(patient.getTelNumber());
        if(patientOptional.isPresent()){
            throw new IllegalStateException("Phone Number taken");
        }
        patientRepository.save(patient);
    }
    public void deletePatient(Long patientId){
        boolean exists = patientRepository.existsById(patientId);
        if(!exists){
            throw new IllegalStateException("Patient with id" + patientId + "does not exist");
        }
        patientRepository.deleteById(patientId);
    }
    public void updatePatient(Long patientId,
                              String patientPetName,
                              String patientPetType,
                              String patientOwner,
                              String patientTelNumber){
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalStateException(
                        "Patient with id" + patientId + "does not exist"));

        if(patientPetName != null &&
                patientPetName.length() > 0 &&
                !Objects.equals(patient.getPetName(), patientPetName)) {
            patient.setPetName(patientPetName);
        }

        if(patientPetType != null &&
                patientPetType.length() > 0 &&
                !Objects.equals(patient.getPetType(), patientPetType)){
            patient.setPetType(patientPetType);
        }

        if(patientOwner != null &&
                patientOwner.length() > 0 &&
                !Objects.equals(patient.getOwner(), patientOwner)){
            patient.setOwner(patientOwner);
        }
        if(patientTelNumber != null &&
                patientTelNumber.length() > 0 &&
                !Objects.equals(patient.getOwner(), patientTelNumber)){
            patient.setTelNumber(patientTelNumber);
        }


    }
}
