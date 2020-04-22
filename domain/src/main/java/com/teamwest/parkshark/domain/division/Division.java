package com.teamwest.parkshark.domain.division;

import com.teamwest.parkshark.domain.member.Employee;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

public class Division {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "DIVISION_SEQ" )
    @SequenceGenerator(name = "DIVISION_SEQ", sequenceName = "division_seq", allocationSize = 1)
    private int id;

    @Column(name="name")
    private String name;
    @Column(name="originalname")
    private String originalName;
    @ManyToOne
    @JoinColumn(name="parentdivision")
    private Division parentDivision;
    @ManyToOne
    @JoinColumn(name="fk_employee_id")
    private Employee director;

    public Division(){}

    public Division(String name, String originalName, Division parentDivision, Employee director) {
        this.name = name;
        this.originalName = originalName;
        this.parentDivision = parentDivision;
        this.director = director;
    }


    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public Division getParentDivision() {
        return parentDivision;
    }

    public Employee getDirector() {
        return director;
    }
}
