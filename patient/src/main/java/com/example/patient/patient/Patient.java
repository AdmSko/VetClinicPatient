package com.example.patient.patient;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
@Getter
@Setter

public class Patient {
    @Id
    @SequenceGenerator(
            name = "patient_sequence",
            sequenceName = "patient_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patient_sequence"
    )
    private Long id;
    private String petName;
    private String petType;
    private LocalDate petDoB;
    private String owner;
    private String telNumber;
    @Transient
    private Integer petAge;

    public Patient() {
    }

    public Patient(Long id,
                   String petName,
                   String petType,
                   LocalDate petDoB,
                   String owner,
                   String telNumber) {
        this.id = id;
        this.petName = petName;
        this.petType = petType;
        this.petDoB = petDoB;
        this.owner = owner;
        this.telNumber = telNumber;
    }
    public Patient(String petName,
                   String petType,
                   LocalDate petDoB,
                   String owner,
                   String telNumber) {
        this.petName = petName;
        this.petType = petType;
        this.petDoB = petDoB;
        this.owner = owner;
        this.telNumber = telNumber;
    }

    public Integer getPetAge(){
        return Period.between(this.petDoB, LocalDate.now()).getYears();
    }


}
