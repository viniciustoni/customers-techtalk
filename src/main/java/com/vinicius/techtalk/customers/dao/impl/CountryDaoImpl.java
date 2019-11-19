package com.vinicius.techtalk.customers.dao.impl;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import com.vinicius.techtalk.customers.dao.CountryDao;
import com.vinicius.techtalk.customers.entity.Country;

@Repository
public class CountryDaoImpl extends SimpleJpaRepository<Country, Long> implements CountryDao {

    private EntityManager entityManager;

    @Autowired
    public CountryDaoImpl(final EntityManager em) {
        super(Country.class, em);
        this.entityManager = em;
    }

    /**
     * Only for TechTalk proposal
     */
    public Optional<Country> findByNameJPAQuery(final String name) {

        final StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("FROM Country ");
        sqlBuilder.append(" where upper(name) = :name ");

        return this.entityManager
                .createQuery(sqlBuilder.toString(), Country.class)
                .setParameter("name", name)
                .getResultList()
                .stream()
                .findFirst();
    }    
}
