package com.teamwest.parkshark.domain.member;

import javax.persistence.Column;
import java.time.LocalDate;

public class MemberOld extends Person{

    @Column(name="licenseplate")
    private String licensePlate;
    @Column(name="registrationdate")
    private LocalDate registrationDate;

    public MemberOld(){}

    public MemberOld(String name, PhoneNumber mobileNumber, PhoneNumber landlineNumber, String email, Address address , String licensePlate, LocalDate registrationDate) {
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
