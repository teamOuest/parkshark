package com.teamwest.parkshark.domain.member;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public abstract class Person {

    @Id
    private int id;
    @Column(name="name")
    private String name;
    @Embedded
    private PhoneNumber mobilePhoneNumber;
    @Embedded
    private PhoneNumber landlinePhoneNumber;
    @Column(name="email")
    private String email;
    @Embedded
    private Address adress;

    public Person() {

    }

    public String getName() {
        return name;
    }

    public PhoneNumber getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public PhoneNumber getLandlinePhoneNumber() {
        return landlinePhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Address getAdress() {
        return adress;
    }
}
