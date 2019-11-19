package com.vinicius.techtalk.customers.service;

import java.time.LocalDate;
import java.util.List;

import com.vinicius.techtalk.customers.dto.ClientDto;

public interface ClientService {

    List<ClientDto> findActiveGratherThanBirthDate(LocalDate startBirthDate);

    List<ClientDto> findActiveBetweenBirthDate(LocalDate startBirthDate, LocalDate finishBirthDate);

    List<ClientDto> findAllBetweenBirthDate(LocalDate startBirthDate, LocalDate finishBirthDate);

    List<ClientDto> findAllByCountryName(String countryName);

}
