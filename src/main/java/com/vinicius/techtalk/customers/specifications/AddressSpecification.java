package com.vinicius.techtalk.customers.specifications;

import com.vinicius.techtalk.customers.entity.QAddress;

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
}
