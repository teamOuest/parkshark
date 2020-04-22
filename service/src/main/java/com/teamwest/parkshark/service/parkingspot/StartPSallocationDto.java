package com.teamwest.parkshark.service.parkingspot;

public class StartPSallocationDto {

    private int memberID;
    private String licensePlate;


    public StartPSallocationDto(int memberID, String licensePlate, int parkinglotID) {
        this.memberID = memberID;
        this.licensePlate = licensePlate;
    }

    public int getMemberID() {
        return memberID;
    }

    public String getLicensePlate() {
        return licensePlate;
    }


}
