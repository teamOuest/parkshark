package com.teamwest.parkshark.domain.member;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@JsonAutoDetect
public class PhoneNumber {

    @Column(name="countryCode")
    private int countryCode;
    @Column(name="localNumber")
    private int localNumber;

    public PhoneNumber() {
    }

    public PhoneNumber(int countryCode, int localNumber) {
        this.countryCode = countryCode;
        this.localNumber = localNumber;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public int getLocalNumber() {
        return localNumber;
    }
}
