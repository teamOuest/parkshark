package com.teamwest.parkshark.service.member.dtos;

import com.teamwest.parkshark.domain.member.Address;
import com.teamwest.parkshark.domain.member.MembershipLevel;
import com.teamwest.parkshark.domain.member.PhoneNumber;

import java.time.LocalDate;
import java.util.Objects;

public class MemberDto {

    private int id;
    private String name;
    private PhoneNumber mobileNumber;
    private PhoneNumber landlineNumber;
    private Address address;
    private String email;
    private String licensePlate;
    private LocalDate registrationDate;
    private MembershipLevel membershipLevel;

    public MemberDto(int id, String name, PhoneNumber mobileNumber, PhoneNumber landlineNumber, Address address, String email, String licensePlate, LocalDate registrationDate, MembershipLevel membershipLevel) {
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.landlineNumber = landlineNumber;
        this.address = address;
        this.email = email;
        this.licensePlate = licensePlate;
        this.registrationDate = registrationDate;
        this.membershipLevel = membershipLevel;
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

    public MembershipLevel getMembershipLevel() {
        return membershipLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberDto memberDto = (MemberDto) o;
        return Objects.equals(name, memberDto.name) &&
                Objects.equals(mobileNumber, memberDto.mobileNumber) &&
                Objects.equals(landlineNumber, memberDto.landlineNumber) &&
                Objects.equals(address, memberDto.address) &&
                Objects.equals(email, memberDto.email) &&
                Objects.equals(licensePlate, memberDto.licensePlate) &&
                Objects.equals(registrationDate, memberDto.registrationDate) &&
                Objects.equals(membershipLevel, memberDto.membershipLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mobileNumber, landlineNumber, address, email, licensePlate, registrationDate, membershipLevel);
    }
}
