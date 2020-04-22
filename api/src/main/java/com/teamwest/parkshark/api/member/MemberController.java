package com.teamwest.parkshark.api.member;

import com.teamwest.parkshark.service.member.CreateMemberDto;
import com.teamwest.parkshark.service.member.GetAllMemberDto;
import com.teamwest.parkshark.service.member.MemberDto;
import com.teamwest.parkshark.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path="members")
public class MemberController {

    MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllMemberDto> getAllMembers() {
       return memberService.getAllMembers();
    }


    @PostMapping(consumes="application/json", produces="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public MemberDto registerMember(@RequestBody CreateMemberDto createMemberDto){
            return memberService.registerMember(createMemberDto);
    }






}
