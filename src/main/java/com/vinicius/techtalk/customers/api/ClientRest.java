package com.vinicius.techtalk.customers.api;

import static org.springframework.http.HttpStatus.FOUND;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.techtalk.customers.dto.ClientDto;
import com.vinicius.techtalk.customers.service.ClientService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/client")
public class ClientRest {

    private final ClientService clientService;

    public ClientRest(final ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(method = GET, path = "/active/countryname/{countryName}", produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all actives clients by country name")
    public ResponseEntity<List<ClientDto>> findActivesByCountryName(@PathVariable("countryName") final String countryName) {
        return new ResponseEntity<>(clientService.findAllByCountryName(countryName), FOUND);
    }

    @RequestMapping(method = GET, path = "/active/birt/grather/{startDate}", produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all actives clients that was birthed after date.")
    public ResponseEntity<List<ClientDto>> findActiveGratherThanBirthDate(
            @PathVariable("startDate") @DateTimeFormat(iso = ISO.DATE) final LocalDate startDate) {
        return new ResponseEntity<>(clientService.findActiveGratherThanBirthDate(startDate), FOUND);
    }

    @RequestMapping(method = GET, path = "/active/birt/between/{startDate}/{endDate}", produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get all actives clients that was birthed during these dates.")
    public ResponseEntity<List<ClientDto>> findActiveBetweenBirthDate(
            @PathVariable("startDate") @DateTimeFormat(iso = ISO.DATE) final LocalDate startBirthDate,
            @PathVariable("endDate") @DateTimeFormat(iso = ISO.DATE) final LocalDate finishBirthDate) {
        return new ResponseEntity<>(clientService.findActiveBetweenBirthDate(startBirthDate, finishBirthDate), FOUND);
    }

    @RequestMapping(method = GET, path = "/birt/grather/{startDate}", produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get clients that was birthed during these dates.")
    public ResponseEntity<List<ClientDto>> findAllBetweenBirthDate(
            @PathVariable("startDate") @DateTimeFormat(iso = ISO.DATE) final LocalDate startBirthDate,
            @PathVariable("endDate") @DateTimeFormat(iso = ISO.DATE) final LocalDate finishBirthDate) {
        return new ResponseEntity<>(clientService.findAllBetweenBirthDate(startBirthDate, finishBirthDate), FOUND);
    }
}
