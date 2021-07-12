package com.viniciusfinger.appconsulta.service;

import com.viniciusfinger.appconsulta.model.Patient;
import com.viniciusfinger.appconsulta.model.dto.PatientDTO;
import com.viniciusfinger.appconsulta.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public ResponseEntity<List<Patient>> findAll(){
        List<Patient> patientList = repository.findAll();

        if (patientList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(patientList);
        }
    }

    public ResponseEntity<Patient> findById(Long id){
        Optional<Patient> patientOptional = repository.findById(id);

        if (patientOptional.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(patientOptional.get());
        }
    }

    public ResponseEntity<Patient> save(PatientDTO patientDTO) {
        Patient patient = patientDTO.toPatient();
        patient.setDateCreated(ZonedDateTime.now());

        Patient newPatient = repository.save(patient);

        return ResponseEntity.ok(newPatient);
    }

    public ResponseEntity<?> delete(Long id){
        Optional<Patient> patientOptional = repository.findById(id);
        if(patientOptional.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            repository.delete(patientOptional.get());
            return ResponseEntity.ok().build();
        }
    }

    public ResponseEntity<Patient> update(PatientDTO patientDTO, Long id){
        Optional<Patient> patientOptional = repository.findById(id);

        if(patientOptional.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            Patient patient = patientOptional.get();
            patient.setUsername(patientDTO.getUsername());
            patient.setPassword(patientDTO.getPassword());
            patient.setOnlineStatus(patientDTO.getOnlineStatus());
            patient.setTotalAppointment(patientDTO.getTotalAppointment());

            repository.save(patient);
            return ResponseEntity.ok(patient);
        }
    }
}
