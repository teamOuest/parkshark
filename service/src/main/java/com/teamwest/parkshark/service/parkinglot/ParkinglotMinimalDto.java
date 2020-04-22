package com.teamwest.parkshark.service.parkinglot;

import com.teamwest.parkshark.domain.member.Employee;
import com.teamwest.parkshark.domain.parkinglot.ParkinglotCategory;

public class ParkinglotMinimalDto {
    private int id;
    private String name;
    private int capacity;
    private String contactEmail;
    private String contactPhoneNumber;

    public ParkinglotMinimalDto(int id, String name, int capacity, String contactEmail, String contactPhoneNumber) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.contactEmail = contactEmail;
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }
}
