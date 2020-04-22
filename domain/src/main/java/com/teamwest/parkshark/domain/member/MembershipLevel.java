package com.teamwest.parkshark.domain.member;

public enum MembershipLevel {
    BRONZE(0,0, 240),
    SILVER(10,20,360),
    GOLD(40, 30, 1440);


    private double monthlyCost;
    private double reductionPct;
    private int allocationTimeInMinutes;

    MembershipLevel(double monthlyCost, double reduction, int allocationTime) {
        this.monthlyCost = monthlyCost;
        this.reductionPct = reduction;
        this.allocationTimeInMinutes = allocationTime;
    }




}
