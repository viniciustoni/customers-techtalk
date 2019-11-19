package com.vinicius.techtalk.customers.dto;

import com.vinicius.techtalk.customers.entity.ennumerated.ContactType;

import lombok.Data;

@Data
public class ContactDto {
    private Long id;
    private ContactType type;
    private String contactValue;
    private CountryDto countryDto;
    private String phoneNumber;
    private String extension;
    private ClientDto clientDto;
}
