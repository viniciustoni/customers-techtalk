package com.vinicius.techtalk.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.vinicius.techtalk.customers.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>, QuerydslPredicateExecutor<Contact> {

}
