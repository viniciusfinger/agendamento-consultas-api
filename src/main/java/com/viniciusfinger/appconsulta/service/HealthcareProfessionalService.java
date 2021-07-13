package com.viniciusfinger.appconsulta.service;

import com.viniciusfinger.appconsulta.model.HealthcareProfessional;
import com.viniciusfinger.appconsulta.model.Patient;
import com.viniciusfinger.appconsulta.model.dto.HealthcareProfessionalDTO;
import com.viniciusfinger.appconsulta.model.dto.PatientDTO;
import com.viniciusfinger.appconsulta.repository.HealthcareProfessionalRepository;
import com.viniciusfinger.appconsulta.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HealthcareProfessionalService {

    @Autowired
    private HealthcareProfessionalRepository repository;

    public ResponseEntity<List<HealthcareProfessional>> findAll(){
        List<HealthcareProfessional> healthcareProfessionalList = repository.findAll();

        if (healthcareProfessionalList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(healthcareProfessionalList);
        }
    }

    public ResponseEntity<HealthcareProfessional> findById(Long id){
        Optional<HealthcareProfessional> healthcareProfessionalOptional = repository.findById(id);

        if (healthcareProfessionalOptional.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(healthcareProfessionalOptional.get());
        }
    }

    public ResponseEntity<HealthcareProfessional> save(HealthcareProfessionalDTO healthcareProfessionalDTO) {
        HealthcareProfessional healthcareProfessional = healthcareProfessionalDTO.toHealthcareProfessional();
        healthcareProfessional.setDateCreated(ZonedDateTime.now());

        HealthcareProfessional newHealthcareProfessional = repository.save(healthcareProfessional);

        return ResponseEntity.ok(newHealthcareProfessional);
    }

    public ResponseEntity<?> delete(Long id){
        Optional<HealthcareProfessional> healthcareProfessionalOptional = repository.findById(id);
        if(healthcareProfessionalOptional.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            repository.delete(healthcareProfessionalOptional.get());
            return ResponseEntity.ok().build();
        }
    }

    public ResponseEntity<HealthcareProfessional> update(HealthcareProfessionalDTO healthcareProfessionalDTO, Long id){
        Optional<HealthcareProfessional> healthcareProfessionalOptional = repository.findById(id);

        if(healthcareProfessionalOptional.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            HealthcareProfessional healthcareProfessional = healthcareProfessionalOptional.get();
            healthcareProfessional.setName(healthcareProfessionalDTO.getName());
            healthcareProfessional.setCrm(healthcareProfessionalDTO.getCrm());
            healthcareProfessional.setRating(healthcareProfessionalDTO.getRating());
            healthcareProfessional.setStatus(healthcareProfessionalDTO.getStatus());

            repository.save(healthcareProfessional);
            return ResponseEntity.ok(healthcareProfessional);
        }
    }
}
