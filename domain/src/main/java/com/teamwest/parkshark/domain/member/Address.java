package com.teamwest.parkshark.domain.member;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;

@Embeddable
@Table(name="member")
@JsonAutoDetect
public class Address {

    @Column(name="streetname")
    private String streetName;
    @Column(name="housenumber")
    private int houseNumber;
    @Embedded
    private PostCode postCode;


    public Address() {
    }

    public Address(String streetName, int houseNumber, PostCode postCode) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.postCode = postCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public PostCode getPostCode() {
        return postCode;
    }

}
