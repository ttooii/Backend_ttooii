package com.toyproject.Backend_ttooii.repository;

import com.toyproject.Backend_ttooii.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findByuserId(String userId);
}