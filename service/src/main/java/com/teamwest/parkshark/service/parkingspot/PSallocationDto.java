package com.teamwest.parkshark.service.parkingspot;

import java.time.LocalDateTime;

public class PSallocationDto {
    private int id;
    private int memberID;
    private String licensePlate;
    private int parkingLotID;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean active;


    public PSallocationDto(int id,int memberID, String licensePlate, int parkinglotID, LocalDateTime startTime, LocalDateTime endTime, boolean active) {
        this.id = id;
        this.memberID = memberID;
        this.licensePlate = licensePlate;
        this.parkingLotID = parkinglotID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.active = active;
    }

    public int getMemberID() {
        return memberID;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getParkingLotID() {
        return parkingLotID;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public boolean isActive() {
        return active;
    }

    public int getId() {
        return id;
    }
}
