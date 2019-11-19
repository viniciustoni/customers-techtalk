package com.vinicius.techtalk.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.vinicius.techtalk.customers.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>, QuerydslPredicateExecutor<Client> {

}
