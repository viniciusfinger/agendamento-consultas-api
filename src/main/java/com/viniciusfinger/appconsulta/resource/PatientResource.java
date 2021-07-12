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

    @PostMapping
    public ResponseEntity<Patient> save(@RequestBody PatientDTO patientDTO) {
        return service.save(patientDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> update(@RequestBody PatientDTO updatedPatientDTO, @PathVariable  Long id){
        return service.update(updatedPatientDTO, id);
    }
}
