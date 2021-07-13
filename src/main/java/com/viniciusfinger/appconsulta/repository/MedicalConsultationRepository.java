package com.viniciusfinger.appconsulta.repository;

import com.viniciusfinger.appconsulta.model.MedicalConsultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalConsultationRepository extends JpaRepository<MedicalConsultation, Long> {
}
