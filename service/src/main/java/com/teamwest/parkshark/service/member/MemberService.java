package com.teamwest.parkshark.service.member;

import com.teamwest.parkshark.infrastructure.member.MemberRepository;
import com.teamwest.parkshark.domain.member.Member;
import com.teamwest.parkshark.service.member.Exceptions.NoPhoneNumberException;
import com.teamwest.parkshark.service.member.dtos.CreateMemberDto;
import com.teamwest.parkshark.service.member.dtos.GetAllMemberDto;
import com.teamwest.parkshark.service.member.dtos.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        if(createMemberDto.getLocalNumberMobile()==0 && createMemberDto.getLocalNumberLandline()==0){
            throw new NoPhoneNumberException("No phone number specified.");
        }
        Member newMember = memberMapper.createMemberDtoToMember(createMemberDto);
        Member savedMember = memberRepository.save(newMember);
        return memberMapper.memberToMemberDto(savedMember);
    }

    public List<GetAllMemberDto> getAllMembers(){
        List<Member> memberList = new ArrayList<>();
        memberRepository.findAll().forEach(memberList::add);
        return memberList.stream().map(member -> memberMapper.memberToGetAllMemberDto(member)).collect(Collectors.toList());
    }


}
