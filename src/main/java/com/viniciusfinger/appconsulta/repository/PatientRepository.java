package com.viniciusfinger.appconsulta.repository;

import com.viniciusfinger.appconsulta.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
