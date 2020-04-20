package com.teamwest.parkshark.service.parkinglot;

import com.teamwest.parkshark.domain.parkinglot.ParkinglotCategory;

public class ParkinglotDto {
    private int id;
    private String name;
    private ParkinglotCategory parkinglotCategory;
    private int capacity;
    private int person_id;
    private String streetName;
    private int houseNumber;
    private int postCode;
    private String city;
    private double amountInEuro;

    public ParkinglotDto(int id, String name, ParkinglotCategory parkinglotCategory, int capacity, int person_id, String streetName, int houseNumber, int postCode, String city, double amountInEuro) {
        this.id = id;
        this.name = name;
        this.parkinglotCategory = parkinglotCategory;
        this.capacity = capacity;
        this.person_id = person_id;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.postCode = postCode;
        this.city = city;
        this.amountInEuro = amountInEuro;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ParkinglotCategory getParkinglotCategory() {
        return parkinglotCategory;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPerson_id() {
        return person_id;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }

    public double getAmountInEuro() {
        return amountInEuro;
    }


}
