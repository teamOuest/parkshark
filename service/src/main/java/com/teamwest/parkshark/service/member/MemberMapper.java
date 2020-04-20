package com.teamwest.parkshark.service.member;

import com.teamwest.parkshark.domain.member.Address;
import com.teamwest.parkshark.domain.member.Member;
import com.teamwest.parkshark.domain.member.PhoneNumber;
import com.teamwest.parkshark.domain.member.PostCode;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public Member createMemberDtoToMember(CreateMemberDto createMemberDto) {
        PhoneNumber mobileNumber = new PhoneNumber(createMemberDto.getCountryCodeMobile(), createMemberDto.getLocalNumberMobile());
        PhoneNumber landlineNumber = new PhoneNumber(createMemberDto.getCountryCodeLandline(), createMemberDto.getLocalNumberLandline());
        PostCode postCode = new PostCode(createMemberDto.getPostCode(), createMemberDto.getCity());
        Address address = new Address(createMemberDto.getStreetName(), createMemberDto.getHouseNumber(), postCode);
        return new Member(createMemberDto.getName(), mobileNumber, landlineNumber, createMemberDto.getEmail(), address, createMemberDto.getLicensePlate(), createMemberDto.getRegistrationDate());
    }



    public MemberDto memberToMemberDto(Member savedMember) {
        return new MemberDto(savedMember.getId(),
                savedMember.getName(),
                savedMember.getMobilePhoneNumber(),
                savedMember.getLandlinePhoneNumber(),
                savedMember.getAddress(),
                savedMember.getEmail(),
                savedMember.getLicensePlate(),
                savedMember.getRegistrationDate());
    }
}
