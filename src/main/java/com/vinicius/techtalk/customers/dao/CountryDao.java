package com.vinicius.techtalk.customers.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.techtalk.customers.entity.Country;

public interface CountryDao extends JpaRepository<Country, Long> {

    Optional<Country> findByNameJPAQuery(String name);
}
