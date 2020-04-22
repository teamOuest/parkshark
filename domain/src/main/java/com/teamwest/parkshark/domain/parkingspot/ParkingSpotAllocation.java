package com.teamwest.parkshark.domain.parkingspot;

import com.teamwest.parkshark.domain.member.Member;
import com.teamwest.parkshark.domain.parkinglot.Parkinglot;

import java.time.LocalDateTime;

public class ParkingSpotAllocation {

    private Member member;

    private String licensePlate;

    private Parkinglot parkinglot;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private boolean status;


}
