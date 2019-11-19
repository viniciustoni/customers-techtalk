package com.vinicius.techtalk.customers.specifications;

import com.vinicius.techtalk.customers.entity.QCountry;

public final class CountrySpecification extends AbstractSpecification {

    private final QCountry qCountry = QCountry.country;

    private CountrySpecification() {
    }

    public static CountrySpecification getInstance() {
        return new CountrySpecification();
    }

    public CountrySpecification name(final String name) {
        where().and(qCountry.name.equalsIgnoreCase(name));
        return this;
    }

    public CountrySpecification countryCode(final String countryCode) {
        where().and(qCountry.countryCode.eq(countryCode));
        return this;
    }
}