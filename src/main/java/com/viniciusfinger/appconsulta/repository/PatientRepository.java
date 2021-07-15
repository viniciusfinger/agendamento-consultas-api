package com.viniciusfinger.appconsulta.repository;

import com.viniciusfinger.appconsulta.model.Patient;
import com.viniciusfinger.appconsulta.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, String> {
    List<Patient> findAllByStatus(Status status);

    Optional<Patient> findByUsername(String username);

    @Query(
            value="SELECT PT.* FROM PATIENT PT " +
                    "JOIN MEDICAL_CONSULTATION MC ON MC.PATIENT_ID = PT.ID " +
                    "JOIN HEALTHCARE_PROFESSIONAL HP ON MC.HEALTHCARE_PROFESSIONAL_ID = HP.ID " +
                    "WHERE HP.CRM = ?1 ",
            nativeQuery = true
    )
    List<Patient> findByCrmProfessional(String crmProfessional);
}
