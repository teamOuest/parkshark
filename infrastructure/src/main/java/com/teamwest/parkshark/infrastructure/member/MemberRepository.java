package com.teamwest.parkshark.infrastructure.member;

import org.springframework.data.repository.CrudRepository;

import com.teamwest.parkshark.domain.member.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface MemberRepository extends CrudRepository<Member, Integer> {
}
