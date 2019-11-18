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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.vinicius.techtalk.customers.entity.ennumerated.ContactType;

import lombok.Data;

@Entity
@Table(name = "CONTACT")
@SequenceGenerator(name = "CONTACT_SEQ", sequenceName = "CONTACT_SEQ", allocationSize = 1)
@Data
public class Contact {

    @Id
    @GeneratedValue(generator = "CONTACT_SEQ", strategy = SEQUENCE)
    @Column(name = "ID", nullable = false)
    private Long id;
    
    @Enumerated(STRING)
    @Column(name = "TYPE", nullable = false)
    private ContactType type;
    
    @Column(name = "CONTACT_VALUE")
    private String contactValue;
    
    @OneToMany(fetch = LAZY)
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID", updatable = false, insertable = false)
    private Country country;
    
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    
    @Column(name = "EXTENSION")
    private String extension;
    
    @OneToMany(fetch = LAZY)
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID", updatable = false, insertable = false, nullable = false)
    private Client client;
}
