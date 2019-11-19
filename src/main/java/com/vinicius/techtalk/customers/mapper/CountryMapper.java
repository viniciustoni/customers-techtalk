package com.vinicius.techtalk.customers.mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

import org.mapstruct.Mapper;

import com.vinicius.techtalk.customers.dto.CountryDto;
import com.vinicius.techtalk.customers.entity.Country;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE, unmappedSourcePolicy = IGNORE)
public interface CountryMapper {

    CountryDto countryToCountryDto(Country country);

}
