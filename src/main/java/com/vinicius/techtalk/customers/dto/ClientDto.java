package com.vinicius.techtalk.customers.dto;

import java.time.LocalDate;

import com.vinicius.techtalk.customers.entity.Country;

import lombok.Data;

@Data
public class ClientDto {
    private Long id;
    private String name;
    private Boolean active;
    private LocalDate birthday;
    private Country countryDto;
}
