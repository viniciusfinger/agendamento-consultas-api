package com.viniciusfinger.appconsulta.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Entity
@Data
@Builder
public class HealthcareProfessional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ZonedDateTime dateCreated;
    private String name;
    private String status;
    private Integer rating;
    private String crm;

    public HealthcareProfessional(){

    }

    public HealthcareProfessional(Long id, ZonedDateTime dateCreated, String name, String status, Integer rating, String crm) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.name = name;
        this.status = status;
        this.rating = rating;
        this.crm = crm;
    }


}
