package com.vinicius.techtalk.customers.service.impl;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vinicius.techtalk.customers.dto.ClientDto;
import com.vinicius.techtalk.customers.entity.Client;
import com.vinicius.techtalk.customers.mapper.ClientMapper;
import com.vinicius.techtalk.customers.repository.ClientRepository;
import com.vinicius.techtalk.customers.service.ClientService;
import com.vinicius.techtalk.customers.specifications.ClientSpecification;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(final ClientRepository clientRepository, final ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public List<ClientDto> findActiveGratherThanBirthDate(final LocalDate startBirthDate) {

        final ClientSpecification clientSpecification = ClientSpecification.getInstance()
                .gratherThanEqualsBirth(startBirthDate);

        final Iterable<Client> clients = clientRepository.findAll(clientSpecification.buildActiveClient());

        return converterClientToClientDto(clients);
    }

    @Override
    public List<ClientDto> findActiveBetweenBirthDate(final LocalDate startBirthDate, final LocalDate finishBirthDate) {

        final ClientSpecification clientSpecification = ClientSpecification.getInstance()
                .birthBetween(startBirthDate, finishBirthDate);

        final Iterable<Client> clients = clientRepository.findAll(clientSpecification.buildActiveClient());

        return converterClientToClientDto(clients);
    }

    @Override
    public List<ClientDto> findAllBetweenBirthDate(final LocalDate startBirthDate, final LocalDate finishBirthDate) {

        final ClientSpecification clientSpecification = ClientSpecification.getInstance()
                .birthBetween(startBirthDate, finishBirthDate);

        final Iterable<Client> clients = clientRepository.findAll(clientSpecification.build());

        return converterClientToClientDto(clients);
    }

    @Override
    public List<ClientDto> findAllByCountryName(final String countryName) {
        
        final ClientSpecification clientSpecification = ClientSpecification.getInstance().countryName(countryName);

        final Iterable<Client> clients = clientRepository.findAll(clientSpecification.build());

        return converterClientToClientDto(clients);
    }

    private List<ClientDto> converterClientToClientDto(final Iterable<Client> clients) {
        return stream(clients.spliterator(), false).map(clientMapper::clientToClientDto).collect(toList());
    }
}
