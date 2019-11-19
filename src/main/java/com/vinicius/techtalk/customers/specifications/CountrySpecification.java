package com.vinicius.techtalk.customers.specifications;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.vinicius.techtalk.customers.entity.QCountry;

public final class CountrySpecification {

    private final QCountry qCountry = QCountry.country;
    private final BooleanBuilder booleanBuilder = new BooleanBuilder();

    private CountrySpecification() {
    }

    public static CountrySpecification getInstance() {
        return new CountrySpecification();
    }

    public CountrySpecification name(final String name) {
        booleanBuilder.and(qCountry.name.equalsIgnoreCase(name));
        return this;
    }
    
    public CountrySpecification countryCode(final String countryCode) {
        booleanBuilder.and(qCountry.countryCode.eq(countryCode));
        return this;
    }
    
    public Predicate build() {
        return booleanBuilder;
    }
}
