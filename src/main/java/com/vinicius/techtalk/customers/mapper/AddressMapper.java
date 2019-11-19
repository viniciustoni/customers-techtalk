package com.vinicius.techtalk.customers.mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.vinicius.techtalk.customers.dto.AddressDto;
import com.vinicius.techtalk.customers.entity.Address;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE, unmappedSourcePolicy = IGNORE)
public interface AddressMapper {

    @Mappings({ 
        @Mapping(source = "country", target = "countryDto"), 
        @Mapping(source = "client", target = "clientDto"),
        @Mapping(source = "client.country", target = "clientDto.countryDto") 
    })
    AddressDto addressToAddressDto(Address address);
    
    @Mappings({ 
        @Mapping(source = "countryDto", target = "country"), 
        @Mapping(source = "clientDto", target = "client"),
        @Mapping(source = "clientDto.countryDto", target = "client.country") 
    })
    Address addressDtoToAddress(AddressDto address);
}
