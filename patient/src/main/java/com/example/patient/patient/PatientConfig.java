package com.example.patient.patient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class PatientConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            PatientRepository repository){
        return args -> {
             Patient woods = new Patient("Woods",
                    "dog",
                    LocalDate.of(2013, JANUARY,15),
                    "Aaron Switz",
                    "111222333"
            );

            Patient bobby = new Patient("Bobby",
                    "cat",
                    LocalDate.of(2015, MARCH,1),
                    "Marry Brown",
                    "123123123"
            );

            repository.saveAll(
                    List.of(woods,bobby)
            );
        };
    }
}
