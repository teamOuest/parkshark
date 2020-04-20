package com.teamwest.parkshark.domain.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Member extends Person{

    @Column(name="licensePlate")
    private String licensePlate;
    @Column(name="registrationDate")
    private LocalDate registrationDate;

    public Member(){}

    public Member(String name, PhoneNumber mobileNumber, PhoneNumber landlineNumber, String email, Address address , String licensePlate, LocalDate registrationDate) {
        super(name, mobileNumber, landlineNumber, email, address);
        this.licensePlate = licensePlate;
        this.registrationDate = registrationDate;
    }


    public String getLicensePlate() {
        return licensePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
}
