package com.teamwest.parkshark.service.member;

import com.teamwest.parkshark.domain.member.*;
import com.teamwest.parkshark.infrastructure.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    MemberRepository memberRepository;

    MemberMapper memberMapper = new MemberMapper();

    @Test
    void registerMember_whenMemberIsValid_returnsMember() {
        //given
        CreateMemberDto createMemberDto = new CreateMemberDto(
                "Test",
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
                LocalDate.now(),
                MembershipLevel.BRONZE);
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
                LocalDate.now(),
                MembershipLevel.BRONZE);
        MemberDto expectedMemberDto = new MemberDto(
                0,
                "Test",
                new PhoneNumber(32,
                        489354392),
                new PhoneNumber(32,
                        23568463),

                new Address("Diestsestraat",
                        15,
                        new PostCode(3000,
                                "Leuven")),
                "tombellens@hotmail.com",
                "ABC123",
                LocalDate.now(),
                MembershipLevel.BRONZE);

        when(memberRepository.save(member)).thenReturn(member);

        MemberService memberService = new MemberService(memberRepository, memberMapper);

        //when
        MemberDto resultMemberDto = memberService.registerMember(createMemberDto);

        //then
        Assertions.assertThat(resultMemberDto).isEqualTo(expectedMemberDto);
    }


    @Test
    void registerMember_whenEmailNotValid_throwException() {
        //given
        CreateMemberDto createMemberDto = new CreateMemberDto(
                "Test",
                32,
                489354392,
                32,
                23568463,
                "tombellenshotmail.com",
                "Diestsestraat",
                15,
                3000,
                "Leuven",
                "ABC123",
                LocalDate.now(),
                MembershipLevel.BRONZE);
        Member member = new Member("Test",
                new PhoneNumber(32,
                        489354392),
                new PhoneNumber(32,
                        23568463),
                "tombellenshotmail.com",
                new Address("Diestsestraat",
                        15,
                        new PostCode(3000,
                                "Leuven")),
                "ABC123",
                LocalDate.now(),
                MembershipLevel.BRONZE);

        when(memberRepository.save(member)).thenThrow(ConstraintViolationException.class);

        MemberService memberService = new MemberService(memberRepository, memberMapper);

        //when
        ThrowingCallable registerMember = () -> memberService.registerMember(createMemberDto);

        //then
        Assertions.assertThatThrownBy(registerMember).isInstanceOf(ConstraintViolationException.class);
    }


    @Test
    void registerMember_whenNoNameSpecified_throwException() {
        //given
        CreateMemberDto createMemberDto = new CreateMemberDto(
                "",
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
                LocalDate.now(),
                MembershipLevel.BRONZE);
        Member member = new Member("",
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
                LocalDate.now(),
        MembershipLevel.BRONZE);

        when(memberRepository.save(member)).thenThrow(ConstraintViolationException.class);

        MemberService memberService = new MemberService(memberRepository, memberMapper);

        //when
        ThrowingCallable registerMember = () -> memberService.registerMember(createMemberDto);

        //then
        Assertions.assertThatThrownBy(registerMember).isInstanceOf(ConstraintViolationException.class);

    }

    @Test
    void createMember_ifNoPhoneNumberSpecified_throwException() {
//given
        CreateMemberDto createMemberDto = new CreateMemberDto(
                "Bram",
                32,
                0,
                32,
                0,
                "tombellens@hotmail.com",
                "Diestsestraat",
                15,
                3000,
                "Leuven",
                "ABC123",
                LocalDate.now(),
                MembershipLevel.BRONZE);

        MemberService memberService = new MemberService(memberRepository, memberMapper);

        //when
        ThrowingCallable registerMember = () -> memberService.registerMember(createMemberDto);

        //then
        Assertions.assertThatThrownBy(registerMember).isInstanceOf(NoPhoneNumberException.class);
    }

    @Test
    void getAllMemberDto_ReturnsListOfAllMemberDto() {
        //given
        MemberService memberService = new MemberService(memberRepository,memberMapper);
        Member member1 = new Member("Test",
                new PhoneNumber(32, 489354392),
                new PhoneNumber(32, 23568463),
                "tombellens@hotmail.com",
                new Address("Diestsestraat", 15, new PostCode(3000, "Leuven")),
                "ABC123",
                LocalDate.now(), MembershipLevel.BRONZE);
        Member member2 = new Member("Tom Waes",
                new PhoneNumber(32, 489354392),
                new PhoneNumber(32, 23568463),
                "tomwaes@hotmail.com",
                new Address("Diestsestraat", 15, new PostCode(3000, "Leuven")),
                "ABC123",
                LocalDate.now(), MembershipLevel.BRONZE);
        Iterable<Member> iterable = Arrays.asList(member1,member2);
        when(memberRepository.findAll()).thenReturn(iterable);
        GetAllMemberDto getAllMemberDto1 = memberMapper.memberToGetAllMemberDto(member1);
        GetAllMemberDto getAllMemberDto2 = memberMapper.memberToGetAllMemberDto(member2);
        //when
        List<GetAllMemberDto> allMembers = memberService.getAllMembers();
        //then
        Assertions.assertThat(allMembers).containsExactlyInAnyOrder(getAllMemberDto1,getAllMemberDto2);

    }




}