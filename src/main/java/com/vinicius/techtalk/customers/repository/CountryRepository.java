package com.vinicius.techtalk.customers.repository;

import java.util.Optional;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.vinicius.techtalk.customers.dao.CountryDao;
import com.vinicius.techtalk.customers.entity.Country;

@Repository
public interface CountryRepository extends QuerydslPredicateExecutor<Country>, CountryDao {

    Optional<Country> findByNameIgnoreCase(String name);

}
