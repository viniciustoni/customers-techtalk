package com.vinicius.techtalk.customers.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vinicius.techtalk.customers.dto.AddressDto;
import com.vinicius.techtalk.customers.entity.Address;
import com.vinicius.techtalk.customers.entity.ennumerated.AddressType;
import com.vinicius.techtalk.customers.mapper.AddressMapper;
import com.vinicius.techtalk.customers.repository.AddressJpaSpecificationRepository;
import com.vinicius.techtalk.customers.service.AddressService;
import com.vinicius.techtalk.customers.specifications.AddressSpecification;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressJpaSpecificationRepository addressJpaSpecificationRepository;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(final AddressJpaSpecificationRepository addressJpaSpecificationRepository,
            final AddressMapper addressMapper) {
        this.addressJpaSpecificationRepository = addressJpaSpecificationRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public List<AddressDto> findByTypeAndCountryName(
            final AddressType addressType, 
            final String countryName) {
        
        final Specification<Address> specification = AddressSpecification.findByAddressType(addressType)
                .and(AddressSpecification.findByCountryName(countryName));
        
        return addressJpaSpecificationRepository
                .findAll(specification)
                .stream()
                .map(addressMapper::addressToAddressDto)
                .collect(toList());
    }
}
