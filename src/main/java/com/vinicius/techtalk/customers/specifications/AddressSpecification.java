package com.vinicius.techtalk.customers.specifications;

import static org.apache.commons.lang3.StringUtils.upperCase;

import org.springframework.data.jpa.domain.Specification;

import com.vinicius.techtalk.customers.entity.Address;
import com.vinicius.techtalk.customers.entity.QAddress;
import com.vinicius.techtalk.customers.entity.ennumerated.AddressType;

public final class AddressSpecification extends AbstractSpecification {

    private final QAddress qAddress = QAddress.address1;

    private AddressSpecification() {
    }

    public static AddressSpecification getInstance() {
        return new AddressSpecification();
    }

    public AddressSpecification countryName(final String name) {
        where().and(qAddress.country.name.equalsIgnoreCase(name));
        return this;
    }

    public AddressSpecification adressType(final AddressType adressType) {
        where().and(qAddress.type.eq(adressType));
        return this;
    }

    public static Specification<Address> findByAddressType(final AddressType addressType) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("type"), addressType);
        };
    }

    public static Specification<Address> findByCountryName(final String countryName) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(criteriaBuilder.upper(root.join("country").get("name")),
                    upperCase(countryName));
        };
    }
}
