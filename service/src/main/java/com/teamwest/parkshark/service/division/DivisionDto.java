package com.teamwest.parkshark.service.division;

import com.teamwest.parkshark.service.member.EmployeeDto;

import java.util.Objects;

public class DivisionDto {

    private int id;
    private String name;
    private String originalName;
    private EmployeeDto director;
    private DivisionDto parentDivision;

    public DivisionDto(int id, String name, String originalName, DivisionDto parentDivision, EmployeeDto director) {
        this.id = id;
        this.name = name;
        this.originalName = originalName;
        this.director = director;
        this.parentDivision = parentDivision;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public EmployeeDto getDirector() {
        return director;
    }

    public DivisionDto getParentDivision() {
        return parentDivision;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DivisionDto that = (DivisionDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(originalName, that.originalName) &&
                Objects.equals(parentDivision, that.parentDivision) &&
                Objects.equals(director, that.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, originalName, parentDivision, director);
    }

    @Override
    public String toString() {
        return "DivisionDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", originalName='" + originalName + '\'' +
                ", parentDivision=" + parentDivision +
                ", director=" + director +
                '}';
    }
}
