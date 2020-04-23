package com.teamwest.parkshark.api.division;

import com.teamwest.parkshark.service.division.CreateDivisionDto;
import com.teamwest.parkshark.service.division.DivisionDto;
import com.teamwest.parkshark.service.division.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "divisions")
public class DivisionController {

    DivisionService divisionService;

    @Autowired
    DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public DivisionDto createDivision(@RequestBody CreateDivisionDto createDivisionDto) {
        return divisionService.createDivision(createDivisionDto);
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<DivisionDto> getAllDivisions() {
        return divisionService.getAllDivisions();
    }

}
