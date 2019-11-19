package com.vinicius.techtalk.customers.dto;

import com.vinicius.techtalk.customers.entity.ennumerated.AdressType;

import lombok.Data;

@Data
public class AddressDto {
    private Long id;
    private AdressType type;
    private String address;
    private String number;
    private String complement;
    private String city;
    private String zipcode;
    private CountryDto countryDto;
    private ClientDto clientDto;
}
