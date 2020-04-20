package com.teamwest.parkshark.domain.member;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="member")
public class Member{

    @Id
    @Column(name="id")
    @SequenceGenerator(allocationSize = 1, name = "MEMBER_SEQ", sequenceName="member_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ")
    private int id;
    @Column(name = "name")
    private String name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "countryCode", column = @Column(name = "countrycodemobile")),
            @AttributeOverride(name = "localNumber", column = @Column(name = "localnumbermobile"))
    })
    private PhoneNumber mobilePhoneNumber;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "countryCode", column = @Column(name = "countrycodelandline")),
            @AttributeOverride(name = "localNumber", column = @Column(name = "localnumberlandline"))
    })
    private PhoneNumber landlinePhoneNumber;
    @Column(name = "email")
    private String email;
    @Embedded
    private Address address;

    @Column(name="licenseplate")
    private String licensePlate;
    @Column(name="registrationdate")
    private LocalDate registrationDate;

    public Member(){}

    public Member(String name, PhoneNumber mobilePhoneNumber, PhoneNumber landlinePhoneNumber, String email, Address address, String licensePlate, LocalDate registrationDate) {
        this.id = id;
        this.name = name;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.landlinePhoneNumber = landlinePhoneNumber;
        this.email = email;
        this.address = address;
        this.licensePlate = licensePlate;
        this.registrationDate = registrationDate;
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



    public String getLicensePlate() {
        return licensePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }


}
