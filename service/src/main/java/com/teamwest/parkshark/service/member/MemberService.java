package com.teamwest.parkshark.service.member;

import com.teamwest.parkshark.infrastructure.member.MemberRepository;
import com.teamwest.parkshark.domain.member.Member;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    MemberRepository memberRepository;
    MemberMapper memberMapper;

    public MemberService(MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    public MemberDto registerMember(CreateMemberDto createMemberDto){
        Member newMember = memberMapper.createMemberDtoToMember(createMemberDto);
        Member savedMember = memberRepository.save(newMember);
        return memberMapper.memberToMemberDto(savedMember);
    }

}
