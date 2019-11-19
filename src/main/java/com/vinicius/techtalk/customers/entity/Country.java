package com.vinicius.techtalk.customers.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "COUNTRY")
@SequenceGenerator(name = "COUNTRY_SEQ", sequenceName = "COUNTRY_SEQ", allocationSize = 1)
@Data
public class Country {

    @Id
    @GeneratedValue(generator = "COUNTRY_SEQ", strategy = SEQUENCE)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "COUNTRY_CODE", nullable = false, unique = true)
    private String countryCode;

}
