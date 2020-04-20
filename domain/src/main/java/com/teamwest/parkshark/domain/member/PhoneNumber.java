package com.teamwest.parkshark.domain.member;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PhoneNumber {

    @Column(name="countryCode")
    private int countryCode;
    @Column(name="localNumber")
    private int localNumber;

    public PhoneNumber() {
    }

    public int getCountryCode() {
        return countryCode;
    }

    public int getLocalNumber() {
        return localNumber;
    }
}
