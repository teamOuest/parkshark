package com.teamwest.parkshark.domain.member;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseNumber == address.houseNumber &&
                Objects.equals(streetName, address.streetName) &&
                Objects.equals(postCode, address.postCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetName, houseNumber, postCode);
    }


    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", houseNumber=" + houseNumber +
                ", postCode=" + postCode +
                '}';
    }
}
