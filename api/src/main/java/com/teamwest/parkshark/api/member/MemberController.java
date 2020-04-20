package com.teamwest.parkshark.api.member;

import com.teamwest.parkshark.service.member.CreateMemberDto;
import com.teamwest.parkshark.service.member.MemberDto;
import com.teamwest.parkshark.service.member.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="members")
public class MemberController {

    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(consumes="application/json", produces="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberDto registerMember(@RequestBody CreateMemberDto createMemberDto){
        return memberService.registerMember(createMemberDto);
    }


}