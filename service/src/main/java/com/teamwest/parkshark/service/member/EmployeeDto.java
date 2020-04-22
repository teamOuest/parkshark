package com.teamwest.parkshark.service.member;

import com.teamwest.parkshark.domain.member.Address;
import com.teamwest.parkshark.domain.member.Employee;
import com.teamwest.parkshark.domain.member.PhoneNumber;


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
}
