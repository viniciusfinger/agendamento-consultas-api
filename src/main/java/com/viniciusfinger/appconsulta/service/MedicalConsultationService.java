package com.viniciusfinger.appconsulta.service;

import com.viniciusfinger.appconsulta.model.HealthcareProfessional;
import com.viniciusfinger.appconsulta.model.MedicalConsultation;
import com.viniciusfinger.appconsulta.model.Patient;
import com.viniciusfinger.appconsulta.model.dto.MedicalConsultationDTO;
import com.viniciusfinger.appconsulta.repository.MedicalConsultationRepository;
import com.viniciusfinger.appconsulta.repository.PatientRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MedicalConsultationService {
    @Autowired
    private MedicalConsultationRepository repository;

    public ResponseEntity<MedicalConsultation> scheduleMedicalConsultation(MedicalConsultationDTO medicalConsultationDTO) {
        Patient patient = Patient.builder().id(medicalConsultationDTO.getIdPatient()).build();

        HealthcareProfessional healthcareProfessional = HealthcareProfessional.builder()
                                                        .id(medicalConsultationDTO.getIdHealthcareProfessional())
                                                        .build();

        MedicalConsultation medicalConsultation = MedicalConsultation.builder()
                                                .consultationDate(ZonedDateTime.now())
                                                .dateCreated(ZonedDateTime.now())
                                                .patient(patient)
                                                .healthcareProfessional(healthcareProfessional)
                                                .build();

        medicalConsultation = repository.save(medicalConsultation);

        return ResponseEntity.ok(medicalConsultation);
    }

    public ResponseEntity<?> delete(Long id){
        Optional<MedicalConsultation> medicalConsultationOptional = repository.findById(id);
        if(medicalConsultationOptional.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            repository.delete(medicalConsultationOptional.get());
            return ResponseEntity.ok().build();
        }
    }

    public ResponseEntity<List<MedicalConsultation>> findAll(){
        List<MedicalConsultation> medicalConsultationList = repository.findAll();
        return ResponseEntity.ok(medicalConsultationList);
    }

    public ResponseEntity<MedicalConsultation> findById(Long id) {
        Optional<MedicalConsultation> medicalConsultationOptional = repository.findById(id);
        if(medicalConsultationOptional.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(medicalConsultationOptional.get());
        }
    }
}

