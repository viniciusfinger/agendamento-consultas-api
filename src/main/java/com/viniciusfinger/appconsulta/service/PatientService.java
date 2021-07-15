package com.viniciusfinger.appconsulta.service;

import com.viniciusfinger.appconsulta.model.Patient;
import com.viniciusfinger.appconsulta.model.Status;
import com.viniciusfinger.appconsulta.model.dto.PatientDTO;
import com.viniciusfinger.appconsulta.repository.PatientRepository;
import com.viniciusfinger.appconsulta.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<List<Patient>> findAll(){
        List<Patient> patientList = patientRepository.findAll();

        if (patientList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(patientList);
        }
    }

    public ResponseEntity<Patient> findById(String  username){
        Optional<Patient> patientOptional = patientRepository.findByUsername(username);

        if (patientOptional.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(patientOptional.get());
        }
    }

    public ResponseEntity<Patient> save(PatientDTO patientDTO) {
        patientDTO.setPassword(passwordEncoder.encode(patientDTO.getPassword()));
        Patient patient = patientDTO.toPatient();
        patient.setDateCreated(ZonedDateTime.now());
        patient.setEnabled(true);
        Patient newPatient = patientRepository.save(patient);
        return ResponseEntity.ok(newPatient);
    }

    public ResponseEntity<?> delete(String username){
        Optional<Patient> patientOptional = patientRepository.findByUsername(username);
        if(patientOptional.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            patientRepository.delete(patientOptional.get());
            return ResponseEntity.ok().build();
        }
    }

    public ResponseEntity<Patient> update(PatientDTO patientDTO){
        Optional<Patient> patientOptional = patientRepository.findByUsername(patientDTO.getUsername());

        if(patientOptional.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            Patient patient = patientOptional.get();
            patient.setUsername(patientDTO.getUsername());
            patient.setPassword(passwordEncoder.encode(patientDTO.getPassword()));
            patient.setStatus(patientDTO.getStatusDTO().toStatus());
            patient.setTotalAppointment(patientDTO.getTotalAppointment());

            patientRepository.save(patient);
            return ResponseEntity.ok(patient);
        }
    }

    public ResponseEntity<List<Patient>> findAllOnline() {
        Status status = statusRepository.findByName("Online");
        List<Patient> patients = patientRepository.findAllByStatus(status);
        return ResponseEntity.ok(patients);
    }

    public ResponseEntity<List<Patient>> findAllBusy() {
        Status status = statusRepository.findByName("Busy");
        List<Patient> patients = patientRepository.findAllByStatus(status);
        return ResponseEntity.ok(patients);
    }

    public ResponseEntity<List<Patient>> findAllOffline() {
        Status status = statusRepository.findByName("Offline");
        List<Patient> patients = patientRepository.findAllByStatus(status);
        return ResponseEntity.ok(patients);
    }

    public ResponseEntity<Patient> findByUsername(String username) {
        Optional<Patient> patientOptional = patientRepository.findByUsername(username);
        if(patientOptional.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            Patient patient = patientOptional.get();
            return ResponseEntity.ok(patient);
        }
    }

    public ResponseEntity<List<Patient>> findByCrmProfessional(String crmProfessional) {
        List<Patient> patientList = patientRepository.findByCrmProfessional(crmProfessional);
        return ResponseEntity.ok(patientList);
    }
}
