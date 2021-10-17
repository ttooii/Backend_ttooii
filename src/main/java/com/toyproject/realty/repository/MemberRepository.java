package com.toyproject.realty.repository;

import com.toyproject.realty.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findByuserId(String userId);
}