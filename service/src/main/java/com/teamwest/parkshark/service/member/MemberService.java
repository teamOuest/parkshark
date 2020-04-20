package com.teamwest.parkshark.service.member;

import com.teamwest.parkshark.infrastructure.member.MemberRepository;
import com.teamwest.parkshark.domain.member.Member;

public class MemberService {

    MemberRepository memberRepository;
    MemberMapper memberMapper;

    public MemberService(MemberRepository memberRepository, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberMapper = memberMapper;
    }

    public MemberDto RegisterMember(CreateMemberDto createMemberDto){
        Member newMember = memberMapper.createMemberDtoToMember(createMemberDto);
        Member savedMember = memberRepository.save(newMember);
        return memberMapper.memberToMemberDto(savedMember);
    }

}
