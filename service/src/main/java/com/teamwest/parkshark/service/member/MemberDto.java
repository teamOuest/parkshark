package com.teamwest.parkshark.service.member;

import com.teamwest.parkshark.domain.member.Address;
import com.teamwest.parkshark.domain.member.PhoneNumber;

import java.time.LocalDate;

public class MemberDto {

    private int id;
    private String name;
    private PhoneNumber mobileNumber;
    private PhoneNumber landlineNumber;
    private Address address;
    private String email;
    private String licensePlate;
    private LocalDate registrationDate;

    public MemberDto(int id, String name, PhoneNumber mobileNumber, PhoneNumber landlineNumber, Address address, String email, String licensePlate, LocalDate registrationDate) {
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.landlineNumber = landlineNumber;
        this.address = address;
        this.email = email;
        this.licensePlate = licensePlate;
        this.registrationDate = registrationDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PhoneNumber getMobileNumber() {
        return mobileNumber;
    }

    public PhoneNumber getLandlineNumber() {
        return landlineNumber;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
}
