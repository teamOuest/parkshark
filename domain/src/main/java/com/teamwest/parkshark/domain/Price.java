package com.teamwest.parkshark.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Price {

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "unit")
    private String unit;

    public Price() {
    }

    public Price(BigDecimal amount, String unit) {
        this.amount = amount;
        this.unit = unit;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
