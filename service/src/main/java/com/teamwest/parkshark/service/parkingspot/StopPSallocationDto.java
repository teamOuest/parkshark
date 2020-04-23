package com.teamwest.parkshark.service.parkingspot;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

public class StopPSallocationDto {
    private int id;

    public StopPSallocationDto(int id) {
        this.id = id;
    }

    public StopPSallocationDto() {
    }

    public int getId() {
        return id;
    }
}
