package com.viniciusfinger.appconsulta.resource;

import com.viniciusfinger.appconsulta.model.Patient;
import com.viniciusfinger.appconsulta.model.dto.PatientDTO;
import com.viniciusfinger.appconsulta.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientResource {

    @Autowired
    private PatientService service;

    @GetMapping
    public ResponseEntity<List<Patient>> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/online")
    public ResponseEntity<List<Patient>> findAllOnline(){
        return service.findAllOnline();
    }

    @GetMapping("/busy")
    public ResponseEntity<List<Patient>> FindAllBusy(){
        return service.findAllBusy();
    }

    @GetMapping("/offline")
    public ResponseEntity<List<Patient>> FindAllOffline(){
        return service.findAllOffline();
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Patient> findByUsername(@PathVariable String username){
        return service.findByUsername(username);
    }

    @GetMapping("/crmProfessional/{crmProfessional}")
    public ResponseEntity<List<Patient>> findByCrmProfessional(@PathVariable String crmProfessional){
        return service.findByCrmProfessional(crmProfessional);
    }

    @PostMapping
    public ResponseEntity<Patient> save(@RequestBody PatientDTO patientDTO) {
        return service.save(patientDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> update(@RequestBody PatientDTO updatedPatientDTO, @PathVariable  Long id){
        return service.update(updatedPatientDTO, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service.delete(id);
    }
}
