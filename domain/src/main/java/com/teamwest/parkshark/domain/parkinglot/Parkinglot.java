package com.teamwest.parkshark.domain.parkinglot;

import com.teamwest.parkshark.domain.Price;
import com.teamwest.parkshark.domain.member.Address;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "parkinglot")
public class Parkinglot {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "PARKINGLOT_SEQ" )
    @SequenceGenerator(name = "PARKINGLOT_SEQ", sequenceName = "parkinglot_seq", allocationSize = 1)
    private int id;

    @Column(name = "name")
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private ParkinglotCategory parkinglotCategory;

    @Column(name = "capacity")
    private int capacity;

    @JoinColumn(name = "fk_person_id")
    @ManyToOne
    private Employee contactPerson;

    @Embedded
    private Address address;

    @Embedded
    private Price pricePerHour;
//    TODO private Division division


    public Parkinglot() {
    }

    public Parkinglot(String name, ParkinglotCategory parkinglotCategory, int capacity, Employee contactPerson, Address address, Price pricePerHour) {
        this.name = name;
        this.parkinglotCategory = parkinglotCategory;
        this.capacity = capacity;
        this.contactPerson = contactPerson;
        this.address = address;
        this.pricePerHour = pricePerHour;
    }
}
