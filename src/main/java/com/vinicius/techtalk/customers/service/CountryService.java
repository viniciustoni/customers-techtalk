package com.vinicius.techtalk.customers.service;

import com.vinicius.techtalk.customers.dto.CountryDto;

public interface CountryService {

    CountryDto findByNameAndCountryCode(String name, String countryCode);
    
}
