package com.teamwest.parkshark.domain.member;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return countryCode == that.countryCode &&
                localNumber == that.localNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, localNumber);
    }

    @Override
    public String toString() {
        return "+" + countryCode + "/" + localNumber;
    }
}
