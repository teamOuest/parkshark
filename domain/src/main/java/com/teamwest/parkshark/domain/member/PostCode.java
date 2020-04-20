package com.teamwest.parkshark.domain.member;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@JsonAutoDetect
public class PostCode {

    @Column(name="postCode")
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
}
