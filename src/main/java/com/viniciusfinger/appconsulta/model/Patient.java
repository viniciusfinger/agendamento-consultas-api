package com.viniciusfinger.appconsulta.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {


    @Id
    @Getter @Setter private String username;

    @JsonIgnore
    private String password;

    @Getter @Setter private ZonedDateTime dateCreated;
    @Getter @Setter private Integer totalAppointment;
    @Getter @Setter private Boolean enabled;

    @OneToOne
    @Getter @Setter private Status status;

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }
}
