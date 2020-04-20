package com.teamwest.parkshark.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Price {

    @Column(name = "amount")
    private double amount;

    @Column(name = "unit")
    private String unit;

    public Price() {
    }

    public Price(double amount, String unit) {
        this.amount = amount;
        this.unit = unit;
    }
}
