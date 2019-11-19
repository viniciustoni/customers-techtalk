package com.vinicius.techtalk.customers.service;

import java.util.List;

import com.vinicius.techtalk.customers.dto.AddressDto;
import com.vinicius.techtalk.customers.entity.ennumerated.AddressType;

public interface AddressService {

    List<AddressDto> findByTypeAndCountryName(AddressType addressType, String countryName);

}
