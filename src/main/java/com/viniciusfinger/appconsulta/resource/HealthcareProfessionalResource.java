package com.viniciusfinger.appconsulta.resource;

import com.viniciusfinger.appconsulta.model.HealthcareProfessional;
import com.viniciusfinger.appconsulta.model.dto.HealthcareProfessionalDTO;
import com.viniciusfinger.appconsulta.service.HealthcareProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/healthcareProfessionals")
public class HealthcareProfessionalResource {

    @Autowired
    private HealthcareProfessionalService service;

    @GetMapping
    public ResponseEntity<List<HealthcareProfessional>> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthcareProfessional> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<HealthcareProfessional> save(@RequestBody HealthcareProfessionalDTO healthcareProfessionalDTO) {
        return service.save(healthcareProfessionalDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HealthcareProfessional> update(@RequestBody HealthcareProfessionalDTO updatedHealthcareProfessionalDTO, @PathVariable  Long id){
        return service.update(updatedHealthcareProfessionalDTO, id);
    }

    @GetMapping("/byPatient/{patientId}")
    public ResponseEntity<List<HealthcareProfessional>> findHealthcareProfessionalByPatient(@PathVariable Long patientId){
        return service.findHealthcareProfessionalByPatient(patientId);
    }
}
