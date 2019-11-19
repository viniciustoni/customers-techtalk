package com.vinicius.techtalk.customers.service.impl;

import org.springframework.stereotype.Service;

import com.vinicius.techtalk.customers.dto.CountryDto;
import com.vinicius.techtalk.customers.entity.Country;
import com.vinicius.techtalk.customers.repository.CountryRepository;
import com.vinicius.techtalk.customers.service.CountryService;
import com.vinicius.techtalk.customers.specifications.CountrySpecification;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(final CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public CountryDto findByNameAndCountryCode(String name, String countryCode) {

        final CountrySpecification countrySpecification = CountrySpecification
                .getInstance()
                .name(name)
                .countryCode(countryCode);

        return countryRepository.findOne(countrySpecification.build())
                .map(this::converterFromCountryToCountryDto)
                .orElse(null);
    }

    private CountryDto converterFromCountryToCountryDto(final Country country) {
        final CountryDto countryDto = new CountryDto();
        countryDto.setId(country.getId());
        countryDto.setName(country.getName());
        countryDto.setCountryCode(country.getCountryCode());
        return countryDto;
    }
}
