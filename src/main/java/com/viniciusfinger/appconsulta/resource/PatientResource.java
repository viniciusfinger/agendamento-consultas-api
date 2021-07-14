package com.viniciusfinger.appconsulta.resource;

import com.viniciusfinger.appconsulta.model.Patient;
import com.viniciusfinger.appconsulta.model.dto.PatientDTO;
import com.viniciusfinger.appconsulta.service.PatientService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "Return a list of Patients")
    public ResponseEntity<List<Patient>> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Return a Patient by Id")
    public ResponseEntity<Patient> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/online")
    @ApiOperation(value = "Return a list of all online Patients")
    public ResponseEntity<List<Patient>> findAllOnline(){
        return service.findAllOnline();
    }

    @GetMapping("/busy")
    @ApiOperation(value = "Return a list of all busy Patients")
    public ResponseEntity<List<Patient>> FindAllBusy(){
        return service.findAllBusy();
    }

    @GetMapping("/offline")
    @ApiOperation(value = "Return a list of all offline Patients")
    public ResponseEntity<List<Patient>> FindAllOffline(){
        return service.findAllOffline();
    }

    @GetMapping("/username/{username}")
    @ApiOperation(value = "Return a Patient by username")
    public ResponseEntity<Patient> findByUsername(@PathVariable String username){
        return service.findByUsername(username);
    }

    @GetMapping("/crmProfessional/{crmProfessional}")
    @ApiOperation(value = "Return a Patient by crm of Healthcare Professional")
    public ResponseEntity<List<Patient>> findByCrmProfessional(@PathVariable String crmProfessional){
        return service.findByCrmProfessional(crmProfessional);
    }

    @PostMapping
    @ApiOperation(value = "Save a new Patient")
    public ResponseEntity<Patient> save(@RequestBody PatientDTO patientDTO) {
        return service.save(patientDTO);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update a Patient by Id")
    public ResponseEntity<Patient> update(@RequestBody PatientDTO updatedPatientDTO, @PathVariable  Long id){
        return service.update(updatedPatientDTO, id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a Patient by Id")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service.delete(id);
    }
}
