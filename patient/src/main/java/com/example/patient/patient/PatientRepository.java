package com.example.patient.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository
        extends JpaRepository<Patient,Long> {

    Optional<Patient> findPatientByTelNumber(String telNumber);

}
