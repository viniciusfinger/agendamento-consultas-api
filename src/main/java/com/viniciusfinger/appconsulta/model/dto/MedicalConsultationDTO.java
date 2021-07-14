package com.viniciusfinger.appconsulta.model.dto;

import lombok.Data;


@Data
public class MedicalConsultationDTO {
    private Long id;
    private Long idHealthcareProfessional;
    private Long idPatient;
    private Long idHealthInsurance;
    private DateDTO dateDTO;
}
