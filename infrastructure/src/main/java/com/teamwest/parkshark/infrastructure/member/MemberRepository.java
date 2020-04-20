package com.teamwest.parkshark.infrastructure.member;

import org.springframework.data.repository.CrudRepository;

import com.teamwest.parkshark.domain.member.Member;


public interface MemberRepository extends CrudRepository<Member, Integer> {
}
