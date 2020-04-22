package com.teamwest.parkshark.domain.parkingspot;

import com.teamwest.parkshark.domain.parkinglot.Parkinglot;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "parkingspot_allocation")
public class ParkingSpotAllocation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = SEQUENCE, generator = "PARKINGSPOT_SEQ" )
    @SequenceGenerator(name = "PARKINGSPOT_SEQ", sequenceName = "parkingspot_allocation_seq", allocationSize = 1)
    private int id;

    @Column(name = "member_id")
    private int memberID;

    @Column(name = "licenseplate")
    private String licensePlate;

    @Column(name = "parkinglot_id")
    private int parkinglotID;

    @Column(name = "starttime")
    private LocalDateTime startTime;

    @Column(name = "endtime")
    private LocalDateTime endTime;

    @Column(name = "status_is_active")
    private boolean statusIsActive;

    public ParkingSpotAllocation() {
    }

    public ParkingSpotAllocation(int memberID, String licensePlate, int parkinglotID, LocalDateTime starttime, LocalDateTime endtime, boolean statusIsActve) {
        this.memberID = memberID;
        this.licensePlate = licensePlate;
        this.parkinglotID = parkinglotID;
        this.startTime = starttime;
        this.endTime = endtime;
        this.statusIsActive = statusIsActve;
    }

    public int getId() {
        return id;
    }

    public int getMemberID() {
        return memberID;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getParkinglotID() {
        return parkinglotID;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public boolean isStatusIsActive() {
        return statusIsActive;
    }
}
