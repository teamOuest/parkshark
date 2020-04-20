package com.teamwest.parkshark.domain.member;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@JsonAutoDetect
public class PostCode {

    @Column(name="postcode")
    private int postCode;
    @Column(name="city")
    private String city;

    public PostCode() {
    }

    public PostCode(int postCode, String city) {
        this.postCode = postCode;
        this.city = city;
    }

    public int getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostCode postCode1 = (PostCode) o;
        return postCode == postCode1.postCode &&
                Objects.equals(city, postCode1.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postCode, city);
    }
}
