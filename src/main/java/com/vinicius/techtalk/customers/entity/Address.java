package com.vinicius.techtalk.customers.entity;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.vinicius.techtalk.customers.entity.ennumerated.AdressType;

import lombok.Data;

@Entity
@Table(name = "ADDRESS")
@SequenceGenerator(name = "ADDRESS_SEQ", sequenceName = "ADDRESS_SEQ", allocationSize = 1)
@Data
public class Address {

    @Id
    @GeneratedValue(generator = "ADDRESS_SEQ", strategy = SEQUENCE)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Enumerated(STRING)
    @Column(name = "TYPE", nullable = false)
    private AdressType type;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "NUMBER")
    private String number;

    @Column(name = "COMPLEMENT")
    private String complement;

    @Column(name = "CITY")
    private String city;

    @Column(name = "ZIPCODE")
    private String zipcode;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID", updatable = false, insertable = false)
    private Country country;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID", updatable = false, insertable = false, nullable = false)
    private Client client;

}
