package com.vinicius.techtalk.customers.specifications;

import org.springframework.data.jpa.domain.Specification;

public abstract class AbstractSpecification<T> {

    private final Class<T> entity;
    
    public AbstractSpecification(final Class<T> entity) {
        this.entity = entity;
    }
   
    public Specification<T> build() {
        return (root, query, criteriaBuilder) -> {
            root.as(entity);
            return null;
        };
    }
}
