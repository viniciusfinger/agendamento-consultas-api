package com.viniciusfinger.appconsulta.model.dto;

import com.viniciusfinger.appconsulta.model.HealthcareProfessional;
import lombok.Data;

@Data
public class HealthcareProfessionalDTO {
    private Long id;
    private String name;
    private String status;
    private Integer rating;
    private String crm;

    public HealthcareProfessional toHealthcareProfessional(){
        return HealthcareProfessional.builder()
                .id(this.getId())
                .name(this.getName())
                .status(this.getStatus())
                .rating(this.getRating())
                .crm(this.getCrm())
                .build();
    }
}
