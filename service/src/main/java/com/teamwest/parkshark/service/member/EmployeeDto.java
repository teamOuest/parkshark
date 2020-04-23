package com.teamwest.parkshark.service.member;

import com.teamwest.parkshark.domain.member.Address;
import com.teamwest.parkshark.domain.member.PhoneNumber;

import java.util.Objects;


public class EmployeeDto {

    private int id;
    private String name;
    private PhoneNumber mobilePhoneNumber;
    private PhoneNumber landlinePhoneNumber;
    private String email;
    private Address address;

    public EmployeeDto(int id, String name, PhoneNumber mobilePhoneNumber, PhoneNumber landlinePhoneNumber, String email, Address address) {
        this.id = id;
        this.name = name;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.landlinePhoneNumber = landlinePhoneNumber;
        this.email = email;
        this.address = address;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDto that = (EmployeeDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(mobilePhoneNumber, that.mobilePhoneNumber) &&
                Objects.equals(landlinePhoneNumber, that.landlinePhoneNumber) &&
                Objects.equals(email, that.email) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mobilePhoneNumber, landlinePhoneNumber, email, address);
    }


    @Override
    public String toString() {
        return "EmployeeDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobilePhoneNumber=" + mobilePhoneNumber +
                ", landlinePhoneNumber=" + landlinePhoneNumber +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
