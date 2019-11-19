package com.vinicius.techtalk.customers.mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vinicius.techtalk.customers.dto.ClientDto;
import com.vinicius.techtalk.customers.entity.Client;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE, unmappedSourcePolicy = IGNORE)
public interface ClientMapper {

    @Mapping(source = "countryDto", target = "country")
    Client clientDtoToClient(ClientDto clientDto);

    @Mapping(source = "country", target = "countryDto")
    ClientDto clientToClientDto(Client client);

}
