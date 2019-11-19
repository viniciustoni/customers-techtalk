package com.vinicius.techtalk.customers.api;

import static org.springframework.http.HttpStatus.FOUND;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.techtalk.customers.dto.CountryDto;
import com.vinicius.techtalk.customers.service.CountryService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/country")
public class CountryRest {

    private final CountryService countryService;

    public CountryRest(final CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping(method = GET, path = "/name/{name}/countryCode/{countryCode}", produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get countries by name and country code")
    public ResponseEntity<CountryDto> findByNameAndCountryCode(@PathVariable("name") final String name,
            @PathVariable("countryCode") final String countryCode) {
        return new ResponseEntity<>(countryService.findByNameAndCountryCode(name, countryCode), FOUND);
    }

}
