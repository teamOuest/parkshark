package com.teamwest.parkshark.domain.member;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Id;

public class Person {

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

    public Person(String name, PhoneNumber mobilePhoneNumber, PhoneNumber landlinePhoneNumber, String email, Address adress) {
        this.name = name;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.landlinePhoneNumber = landlinePhoneNumber;
        this.email = email;
        this.adress = adress;
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
