package com.teamwest.parkshark.service.member;

import com.teamwest.parkshark.domain.member.Address;
import com.teamwest.parkshark.domain.member.PhoneNumber;

import javax.persistence.*;
import java.time.LocalDate;

public class CreateMemberDto {

    private String name;
    private int countryCodeMobile;
    private int localNumberMobile;
    private int countryCodeLandline;
    private int localNumberLandline;
    private String email;
    private String streetName;
    private int houseNumber;
    private int postCode;
    private String city;
    private String licensePlate;
    private LocalDate registrationDate;

    public CreateMemberDto(String name, int countryCodeMobile, int localNumberMobile, int countryCodeLandline, int localNumberLandline, String email, String streetName, int houseNumber, int postCode, String city, String licensePlate, LocalDate registrationDate) {
        this.name = name;
        this.countryCodeMobile = countryCodeMobile;
        this.localNumberMobile = localNumberMobile;
        this.countryCodeLandline = countryCodeLandline;
        this.localNumberLandline = localNumberLandline;
        this.email = email;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.postCode = postCode;
        this.city = city;
        this.licensePlate = licensePlate;
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public int getCountryCodeMobile() {
        return countryCodeMobile;
    }

    public int getLocalNumberMobile() {
        return localNumberMobile;
    }

    public int getCountryCodeLandline() {
        return countryCodeLandline;
    }

    public int getLocalNumberLandline() {
        return localNumberLandline;
    }

    public String getEmail() {
        return email;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
}
