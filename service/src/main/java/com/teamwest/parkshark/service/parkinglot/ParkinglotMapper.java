package com.teamwest.parkshark.service.parkinglot;

import com.teamwest.parkshark.domain.Price;
import com.teamwest.parkshark.domain.member.Address;
import com.teamwest.parkshark.domain.member.Employee;
import com.teamwest.parkshark.domain.member.PostCode;
import com.teamwest.parkshark.domain.parkinglot.Parkinglot;
import com.teamwest.parkshark.infrastructure.employee.EmployeeRepository;
import org.springframework.stereotype.Component;

@Component
public class ParkinglotMapper {

   private EmployeeRepository employeeRepository;

    public ParkinglotMapper(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Parkinglot createParkinglotDtoToParkinglot(CreateParkinglotDto createParkinglotDto){
        Employee employee = employeeRepository.findById(createParkinglotDto.getPerson_id()).orElse(null); //TODO implement exception
        PostCode postCode = new PostCode(createParkinglotDto.getPostCode(), createParkinglotDto.getCity());
        Address address = new Address(createParkinglotDto.getStreetName(), createParkinglotDto.getHouseNumber(), postCode);

        return new Parkinglot(
                createParkinglotDto.getName(),
                createParkinglotDto.getParkinglotCategory(),
                createParkinglotDto.getCapacity(),
                employee,
                address,
               new Price(createParkinglotDto.getAmountInEuro(), "EURO")
        );
    }

    public ParkinglotDto parkinglotToParkinglotDto(Parkinglot parkinglot){
        return new ParkinglotDto(parkinglot.getId(),
                parkinglot.getName(),
                parkinglot.getParkinglotCategory(),
                parkinglot.getCapacity(),
                parkinglot.getContactPerson().getId(),
                parkinglot.getStreetName(),
                parkinglot.getHouseNumber(),
                parkinglot.getPostCode(),
                parkinglot.getCity(),
                parkinglot.getPricePerHour().getAmount()
        );
    }
}
