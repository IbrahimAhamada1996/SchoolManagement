package com.saraya.schoolmanagement.mappers;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
public class DateFormat {
    public String formatString(LocalDate localDate){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                .withZone(ZoneId.systemDefault());
        return format.format(localDate);
    }
    public String formatString(LocalDateTime localDateTime){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                .withZone(ZoneId.systemDefault());
        return format.format(localDateTime);
    }

    public LocalDate formatLocalDate(String dateString){

        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public LocalDateTime formatLocalDateTime(String dateString){

        return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
