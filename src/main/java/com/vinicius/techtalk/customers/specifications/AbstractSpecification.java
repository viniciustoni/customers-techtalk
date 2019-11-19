package com.vinicius.techtalk.customers.specifications;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public abstract class AbstractSpecification {

    private final BooleanBuilder booleanBuilder = new BooleanBuilder();

    protected BooleanBuilder where() {
        return booleanBuilder;
    }

    public Predicate build() {
        return booleanBuilder;
    }
}
