package com.viniciusfinger.appconsulta.model.dto;

import com.viniciusfinger.appconsulta.model.HealthcareProfessional;
import com.viniciusfinger.appconsulta.model.Patient;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class MedicalConsultationDTO {
    private Long id;
    private Long idHealthcareProfessional;
    private Long idPatient;
    private ZonedDateTime consultationDate;
}
