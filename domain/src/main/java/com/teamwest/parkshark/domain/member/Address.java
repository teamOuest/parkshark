package com.teamwest.parkshark.domain.member;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Id;

@Embeddable
@JsonAutoDetect
public class Address {

    @Column(name="streetName")
    private String streetName;
    @Column(name="houseNumber")
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
