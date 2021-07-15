package com.viniciusfinger.appconsulta.repository;

import com.viniciusfinger.appconsulta.model.HealthcareProfessional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HealthcareProfessionalRepository extends JpaRepository<HealthcareProfessional, Long> {

    @Query(
            value = "SELECT HP.* FROM HEALTHCARE_PROFESSIONAL HP " +
                    "JOIN MEDICAL_CONSULTATION MC ON MC.HEALTHCARE_PROFESSIONAL_ID = HP.ID " +
                    "JOIN PATIENT P ON MC.PATIENT_USERNAME = P.USERNAME " +
                    "WHERE P.USERNAME=?1 ",
            nativeQuery = true)
    List<HealthcareProfessional> findHealthcareProfessionalByPatient(String patientUsername);
}
