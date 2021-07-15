package com.viniciusfinger.appconsulta.model.dto;

import com.viniciusfinger.appconsulta.model.Patient;
import lombok.Data;

@Data
public class PatientDTO {
    private String username;
    private String password;
    private Integer totalAppointment;
    private StatusDTO statusDTO;
    private Boolean enabled;

    public Patient toPatient(){
        return Patient.builder()
                .username(this.getUsername())
                .password(this.getPassword())
                .totalAppointment(this.getTotalAppointment())
                .status(this.statusDTO.toStatus())
                .enabled(this.getEnabled())
                .build();
    }
}
