package com.teamwest.parkshark.service.member;

import com.teamwest.parkshark.domain.member.Address;
import com.teamwest.parkshark.domain.member.Member;
import com.teamwest.parkshark.domain.member.PhoneNumber;
import com.teamwest.parkshark.domain.member.PostCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MemberMapperTest {
    @Test
    void givenACreateMemberDto_ShouldReturnRightMember() {
        CreateMemberDto createMemberDto = new CreateMemberDto("Test",
                32,
                489354392,
                32,
                23568463,
                "tombellens@hotmail.com",
                "Diestsestraat",
                15,
                3000,
                "Leuven",
                "ABC123",
                LocalDate.parse("2020-04-20"));
        Member member = new Member("Test",
                new PhoneNumber(32,
                        489354392),
                new PhoneNumber(32,
                        23568463),
                "tombellens@hotmail.com",
                new Address("Diestsestraat",
                        15,
                        new PostCode(3000,
                                "Leuven")),
                "ABC123",
                LocalDate.parse("2020-04-20"));
        MemberMapper memberMapper = new MemberMapper();
        Assertions.assertEquals(member, (memberMapper.createMemberDtoToMember(createMemberDto)));
    }

    @Test
    void memberToMemberDto_returnsCorrectDto() {
        Member member = new Member("Test",
                new PhoneNumber(32,
                        489354392),
                new PhoneNumber(32,
                        23568463),
                "tombellens@hotmail.com",
                new Address("Diestsestraat",
                        15,
                        new PostCode(3000,
                                "Leuven")),
                "ABC123",
                LocalDate.parse("2020-04-20"));
        MemberDto memberDto = new MemberDto(1,
                "Test",
                new PhoneNumber(32, 489354392),
                new PhoneNumber(32, 23568463),
                new Address("Diestsestraat", 15, new PostCode(3000, "Leuven")),
                "tombellens@hotmail.com",
                "ABC123",
                LocalDate.parse("2020-04-20"));
        MemberMapper mapper = new MemberMapper();
        Assertions.assertEquals(memberDto, mapper.memberToMemberDto(member));
    }
}