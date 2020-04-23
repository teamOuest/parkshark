package com.teamwest.parkshark.service.division;

public class CreateDivisionDto {

    private String name;
    private String originalName;
    private int parentDivisionId;
    private int directorId;

    public CreateDivisionDto(String name, String originalName, int parentDivisionId, int directorId) {
        this.name = name;
        this.originalName = originalName;
        this.parentDivisionId = parentDivisionId;
        this.directorId = directorId;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public int getParentDivisionId() {
        return parentDivisionId;
    }

    public int getDirectorId() {
        return directorId;
    }
}
