package com.teamwest.parkshark.service.parkinglot.dtos;

import com.teamwest.parkshark.domain.parkinglot.ParkinglotCategory;

import java.util.Objects;

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
    private int availableCapacity;

    public ParkinglotDto(int id, String name, ParkinglotCategory parkinglotCategory, int capacity, int person_id, String streetName, int houseNumber, int postCode, String city, double amountInEuro, int availableCapacity) {
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
        this.availableCapacity = availableCapacity;
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

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkinglotDto that = (ParkinglotDto) o;
        return id == that.id &&
                capacity == that.capacity &&
                person_id == that.person_id &&
                houseNumber == that.houseNumber &&
                postCode == that.postCode &&
                Double.compare(that.amountInEuro, amountInEuro) == 0 &&
                Objects.equals(name, that.name) &&
                parkinglotCategory == that.parkinglotCategory &&
                Objects.equals(streetName, that.streetName) &&
                Objects.equals(city, that.city) &&
                Objects.equals(availableCapacity, that.availableCapacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, parkinglotCategory, capacity, person_id, streetName, houseNumber, postCode, city, amountInEuro, availableCapacity);
    }

    @Override
    public String toString() {
        return "ParkinglotDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parkinglotCategory=" + parkinglotCategory +
                ", capacity=" + capacity +
                ", person_id=" + person_id +
                ", streetName='" + streetName + '\'' +
                ", houseNumber=" + houseNumber +
                ", postCode=" + postCode +
                ", city='" + city + '\'' +
                ", amountInEuro=" + amountInEuro +
                ", availableCapacity" + availableCapacity +
                '}';
    }
}
