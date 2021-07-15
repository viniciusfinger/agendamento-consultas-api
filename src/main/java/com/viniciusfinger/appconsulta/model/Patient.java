package com.viniciusfinger.appconsulta.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {


    @Id
    private String username;

    private String password;
    private ZonedDateTime dateCreated;
    private Integer totalAppointment;
    private Boolean enabled;

    @OneToOne
    private Status status;

}
