package com.viniciusfinger.appconsulta.service;

import com.viniciusfinger.appconsulta.model.HealthInsurance;
import com.viniciusfinger.appconsulta.model.HealthcareProfessional;
import com.viniciusfinger.appconsulta.model.MedicalConsultation;
import com.viniciusfinger.appconsulta.model.Patient;
import com.viniciusfinger.appconsulta.model.dto.MedicalConsultationDTO;
import com.viniciusfinger.appconsulta.model.exception.ProfessionalAlreadyInUseException;
import com.viniciusfinger.appconsulta.model.exception.UnsupportedHealthInsuranceException;
import com.viniciusfinger.appconsulta.repository.HealthInsuranceRepository;
import com.viniciusfinger.appconsulta.repository.HealthcareProfessionalRepository;
import com.viniciusfinger.appconsulta.repository.MedicalConsultationRepository;
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

    @Autowired
    private HealthcareProfessionalRepository healthcareProfessionalRepository;

    @Autowired
    private HealthInsuranceRepository healthInsuranceRepository;

    public ResponseEntity<MedicalConsultation> scheduleMedicalConsultation(MedicalConsultationDTO medicalConsultationDTO) throws ProfessionalAlreadyInUseException, UnsupportedHealthInsuranceException {
        Patient patient = Patient.builder().username(medicalConsultationDTO.getUsernamePatient()).build();
        HealthInsurance healthInsuranceOfPatient = healthInsuranceRepository.findById(medicalConsultationDTO.getIdHealthInsurance()).get();

        HealthcareProfessional healthcareProfessional = healthcareProfessionalRepository.findById(medicalConsultationDTO.getIdHealthcareProfessional()).get();
        List<HealthInsurance> professionalHealthInsuranceList = healthcareProfessional.getHealthInsurance();

        if (!professionalHealthInsuranceList.contains(healthInsuranceOfPatient)){
            throw new UnsupportedHealthInsuranceException();
        }

        List<MedicalConsultation> medicalConsultationList = repository.findByHealthcareProfessionalAndDoneIsFalse(healthcareProfessional);

        if (medicalConsultationList.isEmpty()){
            MedicalConsultation medicalConsultation = MedicalConsultation.builder()
                    .consultationDate(medicalConsultationDTO.getDateDTO().toZonedDateTime())
                    .dateCreated(ZonedDateTime.now())
                    .patient(patient)
                    .done(false)
                    .healthcareProfessional(healthcareProfessional)
                    .build();

            medicalConsultation = repository.save(medicalConsultation);

            return ResponseEntity.ok(medicalConsultation);
        } else {
            throw new ProfessionalAlreadyInUseException();
        }
    }

    public ResponseEntity<?> unscheduleMedicalConsultation(Long id){
        Optional<MedicalConsultation> medicalConsultationOptional = repository.findById(id);
        if(medicalConsultationOptional.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            repository.delete(medicalConsultationOptional.get());
            return ResponseEntity.ok().build();
        }
    }

    public ResponseEntity<MedicalConsultation> finish(Long id){
        Optional<MedicalConsultation> medicalConsultationOptional = repository.findById(id);
        if(medicalConsultationOptional.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            MedicalConsultation medicalConsultation = medicalConsultationOptional.get();
            medicalConsultation.setDone(true);
            repository.save(medicalConsultation);
            return ResponseEntity.ok(medicalConsultation);
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