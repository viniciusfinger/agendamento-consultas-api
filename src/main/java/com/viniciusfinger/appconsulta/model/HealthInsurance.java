package com.viniciusfinger.appconsulta.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Entity
@Data
@Builder
public class HealthInsurance {

    public HealthInsurance(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ZonedDateTime dateCreated;
    private String name;
    private String cnpj;
    private Float price;

    public HealthInsurance(Long id, ZonedDateTime dateCreated, String name, String cnpj, Float price) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.name = name;
        this.cnpj = cnpj;
        this.price = price;
    }
}
