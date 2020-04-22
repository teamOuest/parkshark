package com.teamwest.parkshark.domain.parkingspot;

import com.teamwest.parkshark.domain.member.Member;
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

    @JoinColumn(name = "member_id")
    @ManyToOne
    private Member member;

    @Column(name = "licenseplate")
    private String licensePlate;

    @JoinColumn(name="parkinglot_id")
    @ManyToOne
    private Parkinglot parkinglot;

    @Column(name = "starttime")
    private LocalDateTime startTime;

    @Column(name = "endtime")
    private LocalDateTime endTime;

    @Column(name = "status_is_active")
    private boolean statusIsActive;

    public ParkingSpotAllocation() {
    }
}
