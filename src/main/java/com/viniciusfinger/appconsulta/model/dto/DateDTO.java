package com.viniciusfinger.appconsulta.model.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Builder
@Data
public class DateDTO {

    private Integer year;
    private Integer month;
    private Integer day;
    private Integer hour;
    private Integer minute;
    private String zoneId;

    public DateDTO(){

    }

    public DateDTO(Integer year, Integer month, Integer day, Integer hour, Integer minute, String zoneId) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.zoneId = zoneId;
    }

    public ZonedDateTime toZonedDateTime(){
        LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of(zoneId));
        return zonedDateTime;
    }
}
