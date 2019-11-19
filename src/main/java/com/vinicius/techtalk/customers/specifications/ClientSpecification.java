package com.vinicius.techtalk.customers.specifications;

import java.time.LocalDate;

import com.querydsl.core.types.Predicate;
import com.vinicius.techtalk.customers.entity.QClient;


public final class ClientSpecification extends AbstractSpecification {

    private final QClient qClient = QClient.client;

    private ClientSpecification() {
    }

    public static ClientSpecification getInstance() {
        return new ClientSpecification();
    }

    public ClientSpecification countryName(final String name) {
        where().and(qClient.country.name.equalsIgnoreCase(name));
        return this;
    }

    public ClientSpecification gratherThanEqualsBirth(final LocalDate birth) {
        where().and(qClient.birth.goe(birth));
        return this;
    }
    
    public ClientSpecification birthBetween(final LocalDate startDate, final LocalDate endDate) {
        where().and(qClient.birth.between(startDate, endDate));
        return this;
    }
    
    public ClientSpecification active(final Boolean active) {
        where().and(qClient.active.eq(active));
        return this;
    }
    
    public Predicate buildActiveClient() {
        active(true);
        return super.build();
    }
}
