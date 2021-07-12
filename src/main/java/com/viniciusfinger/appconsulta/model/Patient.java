package com.viniciusfinger.appconsulta.model;

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
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ZonedDateTime dateCreated;
    private String username;
    private String password;
    private Integer totalAppointment;
    private Boolean onlineStatus;

    public Patient() {
    }

    public Patient(Long id, ZonedDateTime dateCreated, String username, String password, Integer totalAppointment, Boolean onlineStatus) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.username = username;
        this.password = password;
        this.totalAppointment = totalAppointment;
        this.onlineStatus = onlineStatus;
    }
}
