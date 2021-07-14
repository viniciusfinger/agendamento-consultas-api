package com.viniciusfinger.appconsulta.repository;

import com.viniciusfinger.appconsulta.model.HealthcareProfessional;
import com.viniciusfinger.appconsulta.model.MedicalConsultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalConsultationRepository extends JpaRepository<MedicalConsultation, Long> {

    List<MedicalConsultation> findByHealthcareProfessionalAndDoneIsFalse(HealthcareProfessional healthcareProfessional);
}
