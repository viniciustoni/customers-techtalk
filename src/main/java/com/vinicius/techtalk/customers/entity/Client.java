package com.vinicius.techtalk.customers.entity;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CLIENT")
@SequenceGenerator(name = "CLIENT_SEQ", sequenceName = "CLIENT_SEQ", allocationSize = 1)
@Data
public class Client {

    @Id
    @GeneratedValue(generator = "CLIENT_SEQ", strategy = SEQUENCE)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "BIRTHDAY", columnDefinition = "DATE", nullable = false)
    private LocalDate birthday;

    @OneToMany(fetch = LAZY)
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID", updatable = false, insertable = false)
    private Country country;

}
