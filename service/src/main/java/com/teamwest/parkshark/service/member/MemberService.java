package com.teamwest.parkshark.service.member;

import com.teamwest.parkshark.domain.member.PostCode;
import com.teamwest.parkshark.infrastructure.member.MemberRepository;
import com.teamwest.parkshark.domain.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@Service
public class MemberService {

    MemberRepository memberRepository;
    MemberMapper memberMapper;

    @Autowired
    public MemberService(MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    public MemberDto registerMember(CreateMemberDto createMemberDto) {
        Member newMember = memberMapper.createMemberDtoToMember(createMemberDto);
        Member savedMember = memberRepository.save(newMember);
        return memberMapper.memberToMemberDto(savedMember);
    }


}
