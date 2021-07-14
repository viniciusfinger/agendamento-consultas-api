package com.viniciusfinger.appconsulta.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private Boolean done;
}
