package com.viniciusfinger.appconsulta.resource;

import com.viniciusfinger.appconsulta.model.HealthcareProfessional;
import com.viniciusfinger.appconsulta.model.MedicalConsultation;
import com.viniciusfinger.appconsulta.model.Patient;
import com.viniciusfinger.appconsulta.model.dto.MedicalConsultationDTO;
import com.viniciusfinger.appconsulta.service.MedicalConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/medicalConsultations")
public class MedicalConsultationResource {

    @Autowired
    private MedicalConsultationService service;

    @GetMapping
    public ResponseEntity<List<MedicalConsultation>> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalConsultation> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<MedicalConsultation> scheduleMedicalConsultation(@RequestBody MedicalConsultationDTO medicalConsultationDTO){
        return service.scheduleMedicalConsultation(medicalConsultationDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> unscheduleMedicalConsultation(@PathVariable Long id){
        return service.unscheduleMedicalConsultation(id);
    }
}
