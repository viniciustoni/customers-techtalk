package com.vinicius.techtalk.customers.mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.vinicius.techtalk.customers.dto.ContactDto;
import com.vinicius.techtalk.customers.entity.Contact;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE, unmappedSourcePolicy = IGNORE)
public interface ContactMapper {

    @Mappings({ 
        @Mapping(source = "country", target = "countryDto"), 
        @Mapping(source = "client", target = "clientDto"),
        @Mapping(source = "client.country", target = "clientDto.countryDto") 
    })
    ContactDto contactToContactDto(Contact contact);

    @Mappings({ 
        @Mapping(source = "countryDto", target = "country"), 
        @Mapping(source = "clientDto", target = "client"),
        @Mapping(source = "clientDto.countryDto", target = "client.country") 
    })
    Contact contactDtoToContact(ContactDto contactDto);
}
