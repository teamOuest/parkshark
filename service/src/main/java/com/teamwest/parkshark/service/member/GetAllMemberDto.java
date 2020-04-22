package com.teamwest.parkshark.service.member;

import com.teamwest.parkshark.domain.member.PhoneNumber;

import java.time.LocalDate;
import java.util.Objects;

public class GetAllMemberDto {
    private int id;
    private String name;
    private PhoneNumber mobileNumber;
    private PhoneNumber landlineNumber;
    private String email;
    private String licensePlate;
    private LocalDate registrationDate;

    public GetAllMemberDto(int id, String name, PhoneNumber mobileNumber, PhoneNumber landlineNumber, String email, String licensePlate, LocalDate registrationDate) {
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.landlineNumber = landlineNumber;
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

    public String getEmail() {
        return email;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetAllMemberDto that = (GetAllMemberDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(mobileNumber, that.mobileNumber) &&
                Objects.equals(landlineNumber, that.landlineNumber) &&
                Objects.equals(email, that.email) &&
                Objects.equals(licensePlate, that.licensePlate) &&
                Objects.equals(registrationDate, that.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mobileNumber, landlineNumber, email, licensePlate, registrationDate);
    }
}