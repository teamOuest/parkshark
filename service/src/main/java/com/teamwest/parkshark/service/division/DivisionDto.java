package com.teamwest.parkshark.service.division;

import com.teamwest.parkshark.domain.division.Division;
import com.teamwest.parkshark.domain.member.Employee;
import com.teamwest.parkshark.service.member.EmployeeDto;

import javax.persistence.*;

import java.util.Objects;

import static javax.persistence.GenerationType.SEQUENCE;

public class DivisionDto {

    private int id;
    private String name;
    private String originalName;
    private DivisionDto parentDivision;
    private EmployeeDto director;

    public DivisionDto(int id, String name, String originalName, DivisionDto parentDivision, EmployeeDto director) {
        this.id = id;
        this.name = name;
        this.originalName = originalName;
        this.parentDivision = parentDivision;
        this.director = director;
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

    public DivisionDto getParentDivision() {
        return parentDivision;
    }

    public EmployeeDto getDirector() {
        return director;
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
}
