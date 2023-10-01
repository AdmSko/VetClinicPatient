package com.example.patient.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/patient")
public class PatientController {
    private final PatientService patientService;
    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping
    public List<Patient> getPatient(){
        return patientService.getPatient();
    }
    @PostMapping
    public void registerNewPatient(@RequestBody Patient patient){
        patientService.addNewPatient(patient);
    }
    @DeleteMapping(path = "{patientId}")
    public void deletePatient(@PathVariable("patientId") Long patientId){
        patientService.deletePatient(patientId);
    }
    @PutMapping(path = "{patientId}")
    public void updatePatient(@PathVariable("patientId") Long patientId,
                              @RequestParam(required = false) String patientPetName,
                              @RequestParam(required = false) String patientPetType,
                              @RequestParam(required = false) String patientOwner,
                              @RequestParam(required = false) String patientTelNumber
                              )
    {
        patientService.updatePatient(patientId,
                patientPetName,
                patientPetType,
                patientOwner,
                patientTelNumber);

    }
}
