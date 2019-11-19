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


@RestController
@RequestMapping("/country")
public class CountryRest {

    private final CountryService countryService;

    public CountryRest(final CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping(method = GET, path = "/{name}/{countryCode}", produces = APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "Post one new message", nickname = "post")
    public ResponseEntity<CountryDto> findByNameAndCountryCode(@PathVariable("name") String name,
            @PathVariable("countryCode") String countryCode) {
        return new ResponseEntity<>(countryService.findByNameAndCountryCode(name, countryCode), FOUND);
    }

}
