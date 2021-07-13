package com.viniciusfinger.appconsulta.model;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Builder
@Data
public class MedicalConsultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private HealthcareProfessional healthcareProfessional;

    @OneToOne
    private Patient patient;

    private ZonedDateTime consultationDate;

    private ZonedDateTime dateCreated;

    public MedicalConsultation() {

    }

    public MedicalConsultation(Long id, HealthcareProfessional healthcareProfessional, Patient patient, ZonedDateTime consultationDate, ZonedDateTime dateCreated) {
        this.id = id;
        this.healthcareProfessional = healthcareProfessional;
        this.patient = patient;
        this.consultationDate = consultationDate;
        this.dateCreated = dateCreated;
    }
}
