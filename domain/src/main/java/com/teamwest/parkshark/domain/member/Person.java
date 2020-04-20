package com.teamwest.parkshark.domain.member;


import javax.persistence.*;

@Entity
public abstract class Person {

    @Id
    @SequenceGenerator(allocationSize = 1, name = "PERSON_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_SEQ")
    private int id;
    @Column(name = "name")
    private String name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "countryCode", column = @Column(name = "countryCodeMobile")),
            @AttributeOverride(name = "localNumber", column = @Column(name = "localNumberMobile"))
    })
    private PhoneNumber mobilePhoneNumber;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "countryCode", column = @Column(name = "countryCodeLandline")),
            @AttributeOverride(name = "localNumber", column = @Column(name = "localNumberLandline"))
    })
    private PhoneNumber landlinePhoneNumber;
    @Column(name = "email")
    private String email;
    @Embedded
    private Address address;

    public Person() {

    }

    public Person(String name, PhoneNumber mobilePhoneNumber, PhoneNumber landlinePhoneNumber, String email, Address adress) {
        this.name = name;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.landlinePhoneNumber = landlinePhoneNumber;
        this.email = email;
        this.address = adress;
    }

    public int getId() {
        return id;
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

    public Address getAddress() {
        return address;
    }
}
