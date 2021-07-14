package com.viniciusfinger.appconsulta.resource;

import com.viniciusfinger.appconsulta.model.HealthcareProfessional;
import com.viniciusfinger.appconsulta.model.MedicalConsultation;
import com.viniciusfinger.appconsulta.model.Patient;
import com.viniciusfinger.appconsulta.model.dto.MedicalConsultationDTO;
import com.viniciusfinger.appconsulta.service.MedicalConsultationService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "Return a list of Medical Consultation")
    public ResponseEntity<List<MedicalConsultation>> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Return a Medical Consultation by Id")
    public ResponseEntity<MedicalConsultation> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    @ApiOperation(value = "Schedule a new Medical Consultation")
    public ResponseEntity<MedicalConsultation> scheduleMedicalConsultation(@RequestBody MedicalConsultationDTO medicalConsultationDTO) throws Exception {
        return service.scheduleMedicalConsultation(medicalConsultationDTO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Unschedule a Medical Consultation by Id")
    public ResponseEntity<?> unscheduleMedicalConsultation(@PathVariable Long id){
        return service.unscheduleMedicalConsultation(id);
    }

    @PostMapping("/finish/{id}")
    @ApiOperation(value = "Finish a Medical Consultation by Id")
    public ResponseEntity<MedicalConsultation> finish(@PathVariable Long id){
        return service.finish(id);
    }
}
