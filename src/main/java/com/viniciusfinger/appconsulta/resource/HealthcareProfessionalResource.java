package com.viniciusfinger.appconsulta.resource;

import com.viniciusfinger.appconsulta.model.HealthcareProfessional;
import com.viniciusfinger.appconsulta.model.dto.HealthcareProfessionalDTO;
import com.viniciusfinger.appconsulta.service.HealthcareProfessionalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/healthcareProfessionals")
@Api(value = "Healthcare Professionals")
@CrossOrigin(origins = "*")
public class HealthcareProfessionalResource {

    @Autowired
    private HealthcareProfessionalService service;

    @GetMapping
    @ApiOperation(value = "Returns a list of Healthcare Professionals")
    public ResponseEntity<List<HealthcareProfessional>> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Return Healthcare Professional by Id")
    public ResponseEntity<HealthcareProfessional> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ApiOperation(value = "Insert a new HealthcareProfessional")
    public ResponseEntity<HealthcareProfessional> save(@RequestBody HealthcareProfessionalDTO healthcareProfessionalDTO) {
        return service.save(healthcareProfessionalDTO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a Healthcare Professional")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return service.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Healthcare Professional")
    public ResponseEntity<HealthcareProfessional> update(@RequestBody HealthcareProfessionalDTO updatedHealthcareProfessionalDTO, @PathVariable  Long id){
        return service.update(updatedHealthcareProfessionalDTO, id);
    }

    @GetMapping("/byPatient/{patientUseranme}")
    @ApiOperation(value = "Return Healthcare Professionals by Patient username")
    public ResponseEntity<List<HealthcareProfessional>> findHealthcareProfessionalByPatient(@PathVariable String username){
        return service.findHealthcareProfessionalByPatient(username);
    }
}
