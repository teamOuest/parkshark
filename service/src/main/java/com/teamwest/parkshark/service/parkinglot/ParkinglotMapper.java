package com.teamwest.parkshark.service.parkinglot;

import com.teamwest.parkshark.domain.member.Person;
import com.teamwest.parkshark.domain.parkinglot.Parkinglot;
import com.teamwest.parkshark.infrastructure.member.MemberRepository;

public class ParkinglotMapper {

    private MemberRepository memberRepository;

    public ParkinglotMapper(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Parkinglot createParkinglotDtoToParkinglot(CreateParkinglotDto createParkinglotDto){
        Person person = memberRepository.findById(createParkinglotDto.getPerson_id());
        Parkinglot parkinglot = new Parkinglot(
                createParkinglotDto.getName(),
                createParkinglotDto.getParkinglotCategory(),
                createParkinglotDto.getCapacity(),
                person,
        )
    }
}
