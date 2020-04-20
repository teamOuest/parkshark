package com.teamwest.parkshark.domain.member;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class Address {

    @Column(name="streetName")
    private String streetName;
    @Column(name="houseNumber")
    private int houseNumber;
    @Column(name="postCode")
    private int postCode;
    @Column(name="city")
    private String city;

    public Address() {
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
}
