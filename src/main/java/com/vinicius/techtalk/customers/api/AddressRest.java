package com.vinicius.techtalk.customers.api;

import static org.springframework.http.HttpStatus.FOUND;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.techtalk.customers.dto.AddressDto;
import com.vinicius.techtalk.customers.entity.ennumerated.AddressType;
import com.vinicius.techtalk.customers.service.AddressService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/address")
public class AddressRest {

    private final AddressService addressService;

    public AddressRest(final AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(method = GET, path = "/type/{type}/countryname/{countryName}", produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all address by type and country")
    public ResponseEntity<List<AddressDto>> findActivesByCountryName(
            @PathVariable("type") final AddressType type,
            @PathVariable("countryName") final String countryName) {
        return new ResponseEntity<>(addressService.findByTypeAndCountryName(type, countryName), FOUND);
    }
}
