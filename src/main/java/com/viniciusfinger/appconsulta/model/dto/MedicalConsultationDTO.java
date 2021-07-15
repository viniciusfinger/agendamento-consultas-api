package com.viniciusfinger.appconsulta.model.dto;

import lombok.Data;


@Data
public class MedicalConsultationDTO {
    private Long id;
    private Long idHealthcareProfessional;
    private String usernamePatient;
    private Long idHealthInsurance;
    private DateDTO dateDTO;
}
