package com.teamwest.parkshark.service.parkinglot;

import com.teamwest.parkshark.domain.Price;
import com.teamwest.parkshark.domain.member.Address;
import com.teamwest.parkshark.domain.member.Employee;
import com.teamwest.parkshark.domain.member.PostCode;
import com.teamwest.parkshark.domain.parkinglot.Parkinglot;
import com.teamwest.parkshark.infrastructure.employee.EmployeeRepository;
import com.teamwest.parkshark.service.parkinglot.Exceptions.IDnotFoundException;
import com.teamwest.parkshark.service.parkinglot.dtos.CreateParkinglotDto;
import com.teamwest.parkshark.service.parkinglot.dtos.ParkinglotDto;
import com.teamwest.parkshark.service.parkinglot.dtos.ParkinglotMinimalDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkinglotMapper {

   private EmployeeRepository employeeRepository;

    public ParkinglotMapper(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Parkinglot toParkinglot(CreateParkinglotDto createParkinglotDto){
        int contactPersonID = createParkinglotDto.getPerson_id();
        Employee employee = employeeRepository.findById(contactPersonID).orElseThrow(()->new IDnotFoundException(contactPersonID));
        PostCode postCode = new PostCode(createParkinglotDto.getPostCode(), createParkinglotDto.getCity());
        Address address = new Address(createParkinglotDto.getStreetName(), createParkinglotDto.getHouseNumber(), postCode);

        return new Parkinglot(
                createParkinglotDto.getName(),
                createParkinglotDto.getParkinglotCategory(),
                createParkinglotDto.getCapacity(),
                employee,
                address,
               new Price(createParkinglotDto.getAmountInEuro(), "EURO")
        , createParkinglotDto.getCapacity()
        );
    }

    public List<ParkinglotMinimalDto> toParkinglotMinimalDto(List<Parkinglot> parkinglotList){
        return parkinglotList.stream()
                            .map(parkingLot -> toParkinglotMinimalDto(parkingLot))
                            .collect(Collectors.toList());
    }

    public ParkinglotDto toParkinglotDto(Parkinglot parkinglot){
        return new ParkinglotDto(
                parkinglot.getId(),
                parkinglot.getName(),
                parkinglot.getParkinglotCategory(),
                parkinglot.getCapacity(),
                parkinglot.getContactPerson().getId(),
                parkinglot.getStreetName(),
                parkinglot.getHouseNumber(),
                parkinglot.getPostCode(),
                parkinglot.getCity(),
                parkinglot.getPricePerHour().getAmount(),
                parkinglot.getAvailableCapacity()
        );
    }

    public ParkinglotMinimalDto toParkinglotMinimalDto(Parkinglot parkinglot){
        return new ParkinglotMinimalDto(
                parkinglot.getId(),
                parkinglot.getName(),
                parkinglot.getCapacity(),
                parkinglot.getContactPerson().getEmail(),
                "" + parkinglot.getContactPerson().getMobilePhoneNumber());
    }
}
