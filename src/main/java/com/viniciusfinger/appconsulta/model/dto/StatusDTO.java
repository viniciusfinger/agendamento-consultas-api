package com.viniciusfinger.appconsulta.model.dto;

import com.viniciusfinger.appconsulta.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatusDTO {
    private Long id;

    public Status toStatus(){
        return Status.builder().id(id).build();
    }
}
