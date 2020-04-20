package com.teamwest.parkshark.domain.parkinglots;

import com.teamwest.parkshark.domain.Price;
import com.teamwest.parkshark.domain.member.Address;
import com.teamwest.parkshark.domain.member.Person;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "parkinglot")
public class Parkinglot {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "PARKINGLOT_SEQ" )
    @SequenceGenerator(name = "PARKINGLOT_SEQ", sequenceName = "parkinglot_seq", allocationSize = 1)
    private long id;

    @Column(name = "name")
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private ParkinglotCategory parkinglotCategory;

    @Column(name = "capacity")
    private long capacity;

    @JoinColumn(name = "fk_person_id")
    private Person contactPerson;

    @JoinColumn(name = "fk_address_id")
    private Address address;

    @Embedded
    private Price pricePerHour;
//    TODO private Division division


    public Parkinglot() {
    }

    public Parkinglot(String name, ParkinglotCategory parkinglotCategory, long capacity, Person contactPerson, Address address, Price pricePerHour) {
        this.name = name;
        this.parkinglotCategory = parkinglotCategory;
        this.capacity = capacity;
        this.contactPerson = contactPerson;
        this.address = address;
        this.pricePerHour = pricePerHour;
    }
}
