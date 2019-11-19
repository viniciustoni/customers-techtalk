package com.vinicius.techtalk.customers.service.impl;

import org.springframework.stereotype.Service;

import com.vinicius.techtalk.customers.dto.CountryDto;
import com.vinicius.techtalk.customers.mapper.CountryMapper;
import com.vinicius.techtalk.customers.repository.CountryRepository;
import com.vinicius.techtalk.customers.service.CountryService;
import com.vinicius.techtalk.customers.specifications.CountrySpecification;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public CountryServiceImpl(
            final CountryRepository countryRepository,
            final CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public CountryDto findByNameAndCountryCode(String name, String countryCode) {

        final CountrySpecification countrySpecification = CountrySpecification
                .getInstance()
                .name(name)
                .countryCode(countryCode);

        return countryRepository.findOne(countrySpecification.build())
                .map(countryMapper::countryToCountryDto)
                .orElse(null);
    }
}
